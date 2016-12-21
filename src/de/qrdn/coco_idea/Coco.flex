package de.qrdn.coco_idea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.psi.CocoTypes;
import com.intellij.psi.TokenType;

%%

%class CocoLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
/* TODO: trying to test JFlex standalone broken: only prints "null" for EOF token
%debug
%{

  private static String zzToPrintable(CharSequence cs) {
    return zzToPrintable(cs.toString());
  }
%}
// */

letter = [a-z|A-Z|_]
digit = [0-9]
string_ch = [^\"\r\n\\]
char_ch = [^'\r\n\\]
printable = [\ -~]
hex = [0-9a-f]

white_space = [ \r\n\t]+
ident = {letter}({letter}|{digit})*
// number = {digit}{digit}* //TODO in coco.atg, but unused
string = \" ( {string_ch} | \\ {printable} )* \"
char = \' ( {char_ch} | \\ {printable} {hex}* ) \'

/* comments */
Comment = {TraditionalComment}|{EndOfLineComment}
//TODO: nested TraditionalComment
TraditionalComment   = "/*"[^*]~"*/"|"/*""*"+"/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//"[^\r\n]*(\n|\r|\r\n)?

%%

<YYINITIAL> {
    //TODO: instrumentation_code

    // base types
    //TODO unused: {number}    { return CocoTypes.NUMBER; }
    {string}            { return CocoTypes.STRING; }
    {char}              { return CocoTypes.CHARACTER; }
    //TODO: pragmas
    {white_space}       { return TokenType.WHITE_SPACE; }
    {Comment}           { return CocoTypes.COMMENT; }

    // keywords
    "COMPILER"          { return CocoTypes.COMPILER; }
    "IGNORECASE"        { return CocoTypes.IGNORECASE; }
    "CHARACTERS"        { return CocoTypes.CHARACTERS; }
    "TOKENS"            { return CocoTypes.TOKENS; }
    "PRAGMAS"           { return CocoTypes.PRAGMAS; }
    "COMMENTS"          { return CocoTypes.COMMENTS; }
    "FROM"              { return CocoTypes.FROM; }
    "TO"                { return CocoTypes.TO; }
    "NESTED"            { return CocoTypes.NESTED; }
    "IGNORE"            { return CocoTypes.IGNORE; }
    "PRODUCTIONS"       { return CocoTypes.PRODUCTIONS; }
    "="                 { return CocoTypes.EQUALS; }
    "END"               { return CocoTypes.END; }
    "."                 { return CocoTypes.DOT; }
    "+"                 { return CocoTypes.PLUS; }
    "-"                 { return CocoTypes.MINUS; }
    ".."                { return CocoTypes.DOTDOT; }
    "ANY"               { return CocoTypes.ANY; }
    "<"                 { return CocoTypes.LESS; }
    ">"                 { return CocoTypes.GREATER; }
    "<."                { return CocoTypes.LESSDOT; }
    ".>"                { return CocoTypes.GREATERDOT; }
    "(."                { return CocoTypes.INSTR_START; }
    ".)"                { return CocoTypes.INSTR_END; }
    "|"                 { return CocoTypes.OR; }
    "WEAK"              { return CocoTypes.WEAK; }
    "("                 { return CocoTypes.LPAREN; }
    ")"                 { return CocoTypes.RPAREN; }
    "["                 { return CocoTypes.LSPAREN; }
    "]"                 { return CocoTypes.RSPAREN; }
    "{"                 { return CocoTypes.LAPAREN; }
    "}"                 { return CocoTypes.RAPAREN; }
    "SYNC"              { return CocoTypes.SYNC; }
    "IF"                { return CocoTypes.IF; }
    "CONTEXT"           { return CocoTypes.CONTEXT; }

    // identifier
    {ident}             { return CocoTypes.IDENT; }
}

// error fallback
[^] { return TokenType.BAD_CHARACTER; }
