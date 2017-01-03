package de.qrdn.coco_idea.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public interface CocoTokenTypeSets {

    TokenSet KEYWORDS = TokenSet.create(
            CocoTypes.COMPILER_KEYWORD,
            CocoTypes.IGNORECASE_KEYWORD,
            CocoTypes.CHARACTERS_KEYWORD,
            CocoTypes.TOKENS_KEYWORD,
            CocoTypes.PRAGMAS_KEYWORD,
            CocoTypes.COMMENTS_KEYWORD,
            CocoTypes.FROM_KEYWORD,
            CocoTypes.TO_KEYWORD,
            CocoTypes.NESTED_KEYWORD,
            CocoTypes.IGNORE_KEYWORD,
            CocoTypes.PRODUCTIONS_KEYWORD,
            CocoTypes.END_KEYWORD,
            CocoTypes.ANY_KEYWORD,
            CocoTypes.WEAK_KEYWORD,
            CocoTypes.SYNC_KEYWORD,
            CocoTypes.IF_KEYWORD,
            CocoTypes.CONTEXT_KEYWORD);

    TokenSet IDENTIFIER = TokenSet.create(CocoTypes.IDENT);

    TokenSet BAD_CHARACTER = TokenSet.create(TokenType.BAD_CHARACTER);

    TokenSet COMMENT = TokenSet.create(CocoTypes.COMMENT);

    TokenSet PARENTHESES = TokenSet.create(
            CocoTypes.LPAREN,
            CocoTypes.RPAREN,
            CocoTypes.LAPAREN,
            CocoTypes.RAPAREN,
            CocoTypes.LSPAREN,
            CocoTypes.RSPAREN);

    TokenSet OPERATORS = TokenSet.create(
            CocoTypes.DOT,
            CocoTypes.DOTDOT,
            CocoTypes.EQUALS,
            CocoTypes.OR,
            CocoTypes.MINUS,
            CocoTypes.PLUS);

    TokenSet STRING = TokenSet.create(CocoTypes.STRING, CocoTypes.CHARACTER);

    TokenSet INSTRUMENTATION_CODE = TokenSet.create(CocoTypes.INSTRUMENTATION_CODE);
}
