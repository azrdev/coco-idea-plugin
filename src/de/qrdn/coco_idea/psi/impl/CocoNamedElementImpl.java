package de.qrdn.coco_idea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import de.qrdn.coco_idea.psi.CocoNamedElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class CocoNamedElementImpl extends ASTWrapperPsiElement implements CocoNamedElement {
    public CocoNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
