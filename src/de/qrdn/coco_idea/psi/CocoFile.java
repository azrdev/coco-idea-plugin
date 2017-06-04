package de.qrdn.coco_idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.util.containers.ContainerUtil;
import de.qrdn.coco_idea.CocoFileType;
import de.qrdn.coco_idea.CocoLanguage;
import de.qrdn.coco_idea.CocoUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CocoFile extends PsiFileBase {

    private final Map<String, CocoSetDecl> characterClasses;
    // TODO: also track implicitly defined tokens, i.e. literal strings in the productions
    private final Map<String, CocoTokenDecl> tokens;
    private final Map<String, CocoProduction> productions;


    public CocoFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CocoLanguage.INSTANCE);
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
        return result;
    }

    private Map<String, CocoTokenDecl> calcTokens() {
        Map<String, CocoTokenDecl> result = ContainerUtil.newLinkedHashMap();
        for (CocoTokenDecl o : CocoUtil.cocoTraverser(this).filter(CocoTokenDecl.class)) {
            if (!result.containsKey(o.getName())) {
                result.put(o.getName(), o);
            }
        }
        return result;
    }

    private Map<String, CocoProduction> calcProductions() {
        Map<String, CocoProduction> result = ContainerUtil.newLinkedHashMap();
        for (CocoProduction o : CocoUtil.cocoTraverser(this).filter(CocoProduction.class)) {
            if (!result.containsKey(o.getName())) {
                result.put(o.getName(), o);
            }
        }
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
}
