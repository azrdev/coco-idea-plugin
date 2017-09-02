package de.qrdn.coco_idea;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.StdLanguages;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
import de.qrdn.coco_idea.psi.CocoElementType;
import de.qrdn.coco_idea.psi.CocoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Unification of Coco + instrumentation language in one file. Copied from
 * <a href="https://github.com/juzna/intellij-latte/blob/master/src/cz/juzna/latte/file/LatteFileViewProvider.java">Latte</a>.
 */
public class CocoFileViewProvider
        extends MultiplePsiFilesPerDocumentFileViewProvider
        implements FileViewProvider, ConfigurableTemplateLanguageFileViewProvider {

    /** Language of the grammar instrumentation code */
    private Language instrumentedLanguage;

    public CocoFileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled) {
        super(manager, file, eventSystemEnabled);
        instrumentedLanguage = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if(instrumentedLanguage == null) {
            instrumentedLanguage = PlainTextLanguage.INSTANCE;
        }
        //TODO: set instrumentation lang dependend on IDE, e.g. C++ for CLion
        //TODO: let user select instrumentation lang
        // some magic?
        Language substituteLanguage = LanguageSubstitutors.INSTANCE.substituteLanguage(instrumentedLanguage, file, manager.getProject());
        if(TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLanguage))
            instrumentedLanguage = substituteLanguage;
    }

    /** ctor to be used by self */
    private CocoFileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled,
                                 Language instrumentedLanguage) {
        super(manager, file, eventSystemEnabled);
        this.instrumentedLanguage = instrumentedLanguage;
    }


    @NotNull
    @Override
    public Language getBaseLanguage() {
        return CocoLanguage.INSTANCE;
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return instrumentedLanguage;
    }

    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return ContainerUtil.newHashSet(CocoLanguage.INSTANCE, instrumentedLanguage);
    }

    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile virtualFile) {
        return new CocoFileViewProvider(getManager(), virtualFile, false, instrumentedLanguage);
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Language lang) {
        if(lang == instrumentedLanguage) {
            // create Psi for instrumentation language
            PsiFileImpl psiFile = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
            // see <https://github.com/bjansen/pebble-intellij/blob/master/src/main/kotlin/com/github/bjansen/intellij/pebble/lang/PebbleFileViewProviderFactory.kt#L52>
            //TODO: cache per lang.id
            final IElementType COCO_FRAGMENT = new CocoElementType("COCO_FRAGMENT");
            final TemplateDataElementType templateDataElementType = new TemplateDataElementType(
                    "COCO_INSTRUMENTATION_LANGUAGE", CocoLanguage.INSTANCE,
                    CocoTypes.INSTRUMENTATION_CODE, /* the elements from Coco Psi to handle */
                    COCO_FRAGMENT /* the elements to insert into instrumentation Psi instead of non-instr. Coco elements */);
            psiFile.setContentElementType(templateDataElementType);
            return psiFile;
        } else if(lang == CocoLanguage.INSTANCE) {
            // create Psi for Coco
            return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
        }
        return null;
    }
}
