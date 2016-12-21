package de.qrdn.coco_idea;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public class CocoLexerAdapter extends FlexAdapter {
    public CocoLexerAdapter() {
        super(new CocoLexer((Reader) null));
    }
}
