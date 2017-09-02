package de.qrdn.coco_idea.psi;

import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.CocoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CocoTokenType extends IElementType {
    public CocoTokenType(@NotNull @NonNls String debugName) {
        super(debugName, CocoLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "CocoTokenType." + super.toString();
    }
}
