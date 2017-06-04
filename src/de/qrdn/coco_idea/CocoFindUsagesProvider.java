package de.qrdn.coco_idea;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import de.qrdn.coco_idea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: only usages found, not definitions
public class CocoFindUsagesProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(
                new CocoLexerAdapter(),
                CocoTokenTypeSets.IDENTIFIER,
                CocoTokenTypeSets.COMMENT,
                TokenSet.create(CocoTypes.STRING));
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        //TODO: never hit, all results are "unclassified usage"
        if(element instanceof CocoProduction)
            return "production";
        else if(element instanceof CocoSetDecl)
            return "character set declaration";
        else if(element instanceof CocoTokenDecl)
            return "token declaration";
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        return getNodeText(element, true);
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if(element instanceof CocoNamedElement) {
            final String name = ((CocoNamedElement) element).getName();
            if(name != null)
                return name;
        }
        return "";
    }
}
