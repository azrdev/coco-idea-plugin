package de.qrdn.coco_idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import de.qrdn.coco_idea.CocoFileType;
import de.qrdn.coco_idea.CocoLanguage;
import org.jetbrains.annotations.NotNull;

public class CocoFile extends PsiFileBase {
    public CocoFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CocoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CocoFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Coco File";
    }
}
