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
/* TODO: trying to test JFlex standalone broken: only prints "null" for EOF token. Should be fixed, see <https://github.com/JetBrains/Grammar-Kit/issues/149>
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
//TODO: resolve escapes & remove quotes in string & char
string = \" ( {string_ch} | \\ {printable} )* \"
char = \' ( {char_ch} | \\ {printable} {hex}* ) \'

/* comments */
Comment = {TraditionalComment}|{EndOfLineComment}
//TODO: nested TraditionalComment
TraditionalComment   = "/*"[^*]~"*/"|"/*""*"+"/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//"[^\r\n]*(\n|\r|\r\n)?

%s compiler_decl global_decl coco instrumentation_paren_dot instrumentation_angle instrumentation_angle_dot

%%

//TODO: coco pragmas (^$[A-Z]$)

/* includes */
<YYINITIAL> {
    "COMPILER"          { yybegin(compiler_decl); return CocoTypes.COMPILER_KEYWORD; }
    [^]                 { return CocoTypes.INSTRUMENTATION_CODE; }
}

<compiler_decl> {
    {ident}             { yybegin(global_decl); return CocoTypes.IDENT; }
}

/* global declaration section */
<global_decl> {
    "IGNORECASE"        { yybegin(coco); return CocoTypes.IGNORECASE_KEYWORD; }
    "CHARACTERS"        { yybegin(coco); return CocoTypes.CHARACTERS_KEYWORD; }
    [^]                 { return CocoTypes.INSTRUMENTATION_CODE; }
}

/* coco grammar */
<coco> {

    // base types
    //TODO unused: {number}    { return CocoTypes.NUMBER; }
    {string}            { return CocoTypes.STRING; }
    {char}              { return CocoTypes.CHARACTER; }
    //TODO: pragmas
    {white_space}       { return TokenType.WHITE_SPACE; }
    {Comment}           { return CocoTypes.COMMENT; }

    // keywords
    "COMPILER"          { return CocoTypes.COMPILER_KEYWORD; }
    "IGNORECASE"        { return CocoTypes.IGNORECASE_KEYWORD; }
    "CHARACTERS"        { return CocoTypes.CHARACTERS_KEYWORD; }
    "TOKENS"            { return CocoTypes.TOKENS_KEYWORD; }
    "PRAGMAS"           { return CocoTypes.PRAGMAS_KEYWORD; }
    "COMMENTS"          { return CocoTypes.COMMENTS_KEYWORD; }
    "FROM"              { return CocoTypes.FROM_KEYWORD; }
    "TO"                { return CocoTypes.TO_KEYWORD; }
    "NESTED"            { return CocoTypes.NESTED_KEYWORD; }
    "IGNORE"            { return CocoTypes.IGNORE_KEYWORD; }
    "PRODUCTIONS"       { return CocoTypes.PRODUCTIONS_KEYWORD; }
    "END"               { return CocoTypes.END_KEYWORD; }
    "="                 { return CocoTypes.EQUALS; }
    "."                 { return CocoTypes.DOT; }
    "+"                 { return CocoTypes.PLUS; }
    "-"                 { return CocoTypes.MINUS; }
    ".."                { return CocoTypes.DOTDOT; }
    "|"                 { return CocoTypes.OR; }
    "ANY"               { return CocoTypes.ANY_KEYWORD; }
    "WEAK"              { return CocoTypes.WEAK_KEYWORD; }
    "("                 { return CocoTypes.LPAREN; }
    ")"                 { return CocoTypes.RPAREN; }
    "["                 { return CocoTypes.LSPAREN; }
    "]"                 { return CocoTypes.RSPAREN; }
    "{"                 { return CocoTypes.LAPAREN; }
    "}"                 { return CocoTypes.RAPAREN; }
    "SYNC"              { return CocoTypes.SYNC_KEYWORD; }
    "IF"                { return CocoTypes.IF_KEYWORD; }
    "CONTEXT"           { return CocoTypes.CONTEXT_KEYWORD; }

    // identifier
    {ident}             { return CocoTypes.IDENT; }
    // instrumentation code start markers
    "<"                 { yybegin(instrumentation_angle); }
    "<."                { yybegin(instrumentation_angle_dot); }
    "(."                { yybegin(instrumentation_paren_dot); }
}

// instrumentation, delimited by (. .)
<instrumentation_paren_dot> {
    ".)"                { yybegin(coco); }
    [^]                 { return CocoTypes.INSTRUMENTATION_CODE; }
}

// instrumentation, delimited by < >
<instrumentation_angle> {
    ">"                 { yybegin(coco); }
    [^]                 { return CocoTypes.INSTRUMENTATION_CODE; }
}

// instrumentation, delimited by <. .>
<instrumentation_angle_dot> {
    ".>"                { yybegin(coco); }
    [^]                 { return CocoTypes.INSTRUMENTATION_CODE; }
}

// error fallback
[^] { return TokenType.BAD_CHARACTER; }
