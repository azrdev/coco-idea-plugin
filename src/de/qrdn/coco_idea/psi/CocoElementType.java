package de.qrdn.coco_idea.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.CocoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CocoElementType extends IElementType {
    public CocoElementType(@NotNull @NonNls String debugName) {
        super(debugName, CocoLanguage.INSTANCE);
    }
}
