package de.qrdn.coco_idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.util.PlatformUtils;
import com.intellij.util.containers.ContainerUtil;
import de.qrdn.coco_idea.CocoFileType;
import de.qrdn.coco_idea.CocoLanguage;
import de.qrdn.coco_idea.CocoUtil;
import org.apache.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class CocoFile extends PsiFileBase {

    private final Map<String, CocoSetDecl> characterClasses;
    // TODO: also track implicitly defined tokens, i.e. literal strings in the productions
    private final Map<String, CocoTokenDecl> tokens;
    private final Map<String, CocoProduction> productions;

    private final Logger logger = Logger.getInstance("Coco");
    @Nullable
    private Language instrumentationLanguage;


    public CocoFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CocoLanguage.INSTANCE);
        logger.setLevel(Level.DEBUG);
        characterClasses = calcCharacterClasses();
        tokens = calcTokens();
        productions = calcProductions();
    }

    private Map<String, CocoSetDecl> calcCharacterClasses() {
        Map<String, CocoSetDecl> result = ContainerUtil.newLinkedHashMap();
        for (CocoSetDecl o : CocoUtil.cocoTraverser(this).filter(CocoSetDecl.class)) {
            if (!result.containsKey(o.getName())) {
                result.put(o.getName(), o);
            }
        }
        logger.debug("Scanned for CharacterClasses: found " + result.size());
        return result;
    }

    private Map<String, CocoTokenDecl> calcTokens() {
        Map<String, CocoTokenDecl> result = ContainerUtil.newLinkedHashMap();
        for (CocoTokenDecl o : CocoUtil.cocoTraverser(this).filter(CocoTokenDecl.class)) {
            if (!result.containsKey(o.getName())) {
                result.put(o.getName(), o);
            }
        }
        logger.debug("Scanned for Tokens: found " + result.size());
        return result;
    }

    private Map<String, CocoProduction> calcProductions() {
        Map<String, CocoProduction> result = ContainerUtil.newLinkedHashMap();
        for (CocoProduction o : CocoUtil.cocoTraverser(this).filter(CocoProduction.class)) {
            if (!result.containsKey(o.getName())) {
                result.put(o.getName(), o);
            }
        }
        logger.debug("Scanned for Productions: found " + result.size());
        return result;
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CocoFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Coco File";
    }

    public PsiElement getTokenOrProduction(String referenceName) {
        if(productions.containsKey(referenceName)) {
            return productions.get(referenceName);
        } else if(tokens.containsKey(referenceName)) {
            return tokens.get(referenceName);
        }
        return null;
    }

    public PsiElement getCharacterClass(String referenceName) {
        if(characterClasses.containsKey(referenceName)) {
            return characterClasses.get(referenceName);
        }
        return null;
    }

    public final Map<String, CocoSetDecl> getCharacterClasses() {
        return characterClasses;
    }

    public final Map<String, CocoTokenDecl> getTokens() {
        return tokens;
    }

    public final Map<String, CocoProduction> getProductions() {
        return productions;
    }

    @Nullable
    public Language getInstrumentationLanguage() {
        if(instrumentationLanguage == null) {
            //TODO: configure instrumentation language
            for (FileTypeRegistry.FileTypeDetector detector :
                    Extensions.getExtensions(FileTypeRegistry.FileTypeDetector.EP_NAME)) {
                final FileType fileType = null; //XXX detector.detect();
                if(fileType instanceof LanguageFileType) {
                    instrumentationLanguage = ((LanguageFileType) fileType).getLanguage();
                    break;
                }
            }

            // FIXME: language IDs are mostly wild guesses
            if(PlatformUtils.isIntelliJ())
                instrumentationLanguage = Language.findLanguageByID("JAVA");
            else if(PlatformUtils.isRubyMine())
                instrumentationLanguage = Language.findLanguageByID("RUBY");
            else if(PlatformUtils.isAppCode())
                instrumentationLanguage = Language.findLanguageByID("SWIFT");
            else if(PlatformUtils.isCLion())
                instrumentationLanguage = Language.findLanguageByID("CPP");
            else if(PlatformUtils.isPyCharm())
                instrumentationLanguage = Language.findLanguageByID("PYTHON");
            else if(PlatformUtils.isPhpStorm())
                instrumentationLanguage = Language.findLanguageByID("PHP");
            else if(PlatformUtils.isWebStorm())
                instrumentationLanguage = Language.findLanguageByID("JAVASCRIPT");
            else if(PlatformUtils.isRider())
                instrumentationLanguage = Language.findLanguageByID("CSHARP");
            else if(PlatformUtils.isGoIde())
                instrumentationLanguage = Language.findLanguageByID("GO");
        }
        return instrumentationLanguage;
    }
}
