package de.qrdn.coco_idea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CocoFileType extends LanguageFileType {
    public static final CocoFileType INSTANCE = new CocoFileType();

    private CocoFileType() {
        super(CocoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Coco file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Coco Grammar file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "atg";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}
