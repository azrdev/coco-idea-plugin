package de.qrdn.coco_idea;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.psi.CocoTokenTypeSets;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class CocoSyntaxHighlighter extends SyntaxHighlighterBase {
    private static Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        fillMap(ATTRIBUTES, CocoTokenTypeSets.KEYWORDS, CocoHighlighterColors.KEYWORD);
        fillMap(ATTRIBUTES, CocoTokenTypeSets.IDENTIFIER, CocoHighlighterColors.IDENT);
        fillMap(ATTRIBUTES, CocoTokenTypeSets.BAD_CHARACTER, CocoHighlighterColors.BAD_CHARACTER);
        fillMap(ATTRIBUTES, CocoTokenTypeSets.COMMENT, CocoHighlighterColors.COMMENT);
        fillMap(ATTRIBUTES, CocoTokenTypeSets.PARENTHESES, CocoHighlighterColors.PARENTHESES);
        fillMap(ATTRIBUTES, CocoTokenTypeSets.OPERATORS, CocoHighlighterColors.OPERATORS);
        fillMap(ATTRIBUTES, CocoTokenTypeSets.STRING, CocoHighlighterColors.STRING);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CocoLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}
