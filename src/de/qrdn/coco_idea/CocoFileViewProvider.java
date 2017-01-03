package de.qrdn.coco_idea;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.StdLanguages;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import com.intellij.util.containers.ContainerUtil;
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
        implements FileViewProvider, TemplateLanguageFileViewProvider {

    /** Language of the grammar instrumentation code */
    private Language instrumentedLanguage;

    public CocoFileViewProvider(PsiManager manager, VirtualFile file, boolean physical) {
        super(manager, file, physical);
        Language dataLang = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if(dataLang == null) {
            //TODO: set instrumentation lang dependent on IDE, e.g. C++ for CLion
            //TODO: let user select instrumentation lang
            dataLang = StdLanguages.JAVA;
        }
        // some magic?
        if(dataLang instanceof TemplateLanguage) {
            instrumentedLanguage = PlainTextLanguage.INSTANCE;
        } else {
            instrumentedLanguage = LanguageSubstitutors.INSTANCE.substituteLanguage(dataLang, file, manager.getProject());
        }
    }

    /** ctor to be used by self */
    public CocoFileViewProvider(PsiManager manager, VirtualFile file, boolean physical, Language instrumentedLanguage) {
        super(manager, file, physical);
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
            // create Psi for instrumentation lang
            PsiFileImpl psiFile = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
            psiFile.setContentElementType(CocoTypes.INSTRUMENTATION_CODE);
            return psiFile;

        } else if(lang == CocoLanguage.INSTANCE) {
            // create Psi for Coco
            return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
        }
        return null;
    }
}
