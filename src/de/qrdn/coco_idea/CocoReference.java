package de.qrdn.coco_idea;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.ArrayUtil;
import de.qrdn.coco_idea.psi.CocoFile;
import de.qrdn.coco_idea.psi.CocoIdentRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class CocoReference extends PsiReferenceBase<CocoIdentRule> {

    public CocoReference(CocoIdentRule element) {
        super(element);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiFile containingFile = myElement.getContainingFile();
        String referenceName = getRangeInElement().substring(myElement.getText());
        if(containingFile instanceof CocoFile) {
            return resolve((CocoFile)containingFile, referenceName);
        }
        return null;
    }

    @Nullable
    public abstract PsiElement resolve(@NotNull CocoFile containingFile, String referenceName);

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    @Override
    public TextRange getRangeInElement() {
        return TextRange.from(0, getElement().getTextLength());
    }
}
