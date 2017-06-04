package de.qrdn.coco_idea;

import com.intellij.psi.ElementDescriptionLocation;
import com.intellij.psi.ElementDescriptionProvider;
import com.intellij.psi.PsiElement;
import de.qrdn.coco_idea.psi.CocoNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * Name the element searched for in the "Find Usages" dialog
 */
public class CocoElementDescriptionProvider implements ElementDescriptionProvider {
    @Nullable
    @Override
    public String getElementDescription(@NotNull PsiElement element, @NotNull ElementDescriptionLocation location) {
        if(element instanceof CocoNamedElement)
            return ((CocoNamedElement) element).getName();
        return null;
    }
}
