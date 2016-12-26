package de.qrdn.coco_idea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import de.qrdn.coco_idea.psi.CocoFileSection;
import org.jetbrains.annotations.NotNull;

public abstract class CocoFileSectionImpl extends ASTWrapperPsiElement implements CocoFileSection {
    public CocoFileSectionImpl(@NotNull ASTNode node) {
        super(node);
    }
}
