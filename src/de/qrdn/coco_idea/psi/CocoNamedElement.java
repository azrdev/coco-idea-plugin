package de.qrdn.coco_idea.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;

/**
 * A {@link PsiElement} which declares a coco name: set_decl, token_decl, or production.
 */
public interface CocoNamedElement extends PsiNameIdentifierOwner {
}
