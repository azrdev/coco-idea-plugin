package de.qrdn.coco_idea;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public interface CocoHighlighterColors {
    TextAttributesKey KEYWORD =
            createTextAttributesKey("COCO_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    TextAttributesKey IDENT =
            createTextAttributesKey("COCO_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    TextAttributesKey COMMENT =
            createTextAttributesKey("COCO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("COCO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    TextAttributesKey OPERATORS =
            createTextAttributesKey("COCO_OPERATORS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    TextAttributesKey PARENTHESES =
            createTextAttributesKey("COCO_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    TextAttributesKey STRING =
            createTextAttributesKey("COCO_STRING", DefaultLanguageHighlighterColors.STRING);
    TextAttributesKey INSTRUMENTATION_CODE =
            createTextAttributesKey("COCO_INSTRUMENTATION_CODE", DefaultLanguageHighlighterColors.MARKUP_TAG);
}
