package de.qrdn.coco_idea.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public interface CocoTokenTypeSets {

    TokenSet KEYWORDS = TokenSet.create(
            CocoTypes.COMPILER,
            CocoTypes.IGNORECASE,
            CocoTypes.CHARACTERS,
            CocoTypes.TOKENS,
            CocoTypes.PRAGMAS,
            CocoTypes.COMMENTS,
            CocoTypes.FROM,
            CocoTypes.TO,
            CocoTypes.NESTED,
            CocoTypes.IGNORE,
            CocoTypes.PRODUCTIONS,
            CocoTypes.END,
            CocoTypes.ANY,
            CocoTypes.WEAK,
            CocoTypes.SYNC,
            CocoTypes.IF,
            CocoTypes.CONTEXT);

    TokenSet IDENTIFIER = TokenSet.create(CocoTypes.IDENT);

    TokenSet BAD_CHARACTER = TokenSet.create(TokenType.BAD_CHARACTER);

    TokenSet COMMENT = TokenSet.create(CocoTypes.COMMENT);

    TokenSet PARENTHESES = TokenSet.create(
            CocoTypes.LPAREN,
            CocoTypes.RPAREN,
            CocoTypes.LAPAREN,
            CocoTypes.RAPAREN,
            CocoTypes.LSPAREN,
            CocoTypes.RSPAREN,
            CocoTypes.LESS,
            CocoTypes.GREATER,
            CocoTypes.LESSDOT,
            CocoTypes.GREATERDOT,
            CocoTypes.INSTR_START,
            CocoTypes.INSTR_END);

    TokenSet OPERATORS = TokenSet.create(
            CocoTypes.DOT,
            CocoTypes.DOTDOT,
            CocoTypes.EQUALS,
            CocoTypes.OR,
            CocoTypes.MINUS,
            CocoTypes.PLUS);

    TokenSet STRING = TokenSet.create(CocoTypes.STRING, CocoTypes.CHARACTER);
}
