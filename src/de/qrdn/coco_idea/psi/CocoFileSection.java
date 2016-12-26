package de.qrdn.coco_idea.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CocoFileSection extends PsiElement {

    @NotNull
    List<? extends CocoNamedElement> getDeclarations();

    @Nullable
    ItemPresentation getPresentation();
}
