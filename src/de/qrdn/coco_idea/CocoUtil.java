package de.qrdn.coco_idea;

import com.intellij.psi.PsiElement;
import com.intellij.psi.SyntaxTraverser;

public class CocoUtil {

    public static SyntaxTraverser<PsiElement> cocoTraverser(PsiElement root) {
        return SyntaxTraverser.psiTraverser(root);
    }
}
