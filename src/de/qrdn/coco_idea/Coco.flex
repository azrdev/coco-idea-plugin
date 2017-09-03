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
TraditionalComment   = "/*" ~"*/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//"[^\r\n]*(\n|\r|\r\n)?

%s compiler_decl global_decl coco pre_resolver resolver
%s instrumentation_angle instrumentation_angledot instrumentation_parendot
%s post_instrumentation_angle post_instrumentation_angledot post_instrumentation_parendot

%{
/** in state "resolver", count the level of nested braces that we're in */
int resolver_brace_depth = 0;
%}

%%

//TODO: coco pragmas (^$[A-Z]$)

/* includes */
<YYINITIAL> {
    // this pushback-construct ensures the whole instrumentation_code block is returned as a single token
    "COMPILER"          { yypushback(yylength()); yybegin(compiler_decl); return CocoTypes.INSTRUMENTATION_CODE; }
    [^]                 { }
}

<compiler_decl> {
    "COMPILER"          { return CocoTypes.COMPILER_KEYWORD; }
    {ident}             { yybegin(global_decl); return CocoTypes.IDENT; }
    {white_space}       { return TokenType.WHITE_SPACE; }
}

/* global declaration section */
<global_decl> {
    // this pushback-construct ensures the whole instrumentation_code block is returned as a single token
    "IGNORECASE"        { yypushback(yylength()); yybegin(coco); return CocoTypes.INSTRUMENTATION_CODE; }
    "CHARACTERS"        { yypushback(yylength()); yybegin(coco); return CocoTypes.INSTRUMENTATION_CODE; }
    [^]                 { }
}

/* coco grammar */
<coco> {

    // base types
    //TODO unused: {number}    { return CocoTypes.NUMBER; }
    {string}            { return CocoTypes.STRING; }
    {char}              { return CocoTypes.CHARACTER; }
    //TODO: pragmas
    {white_space}       { return TokenType.WHITE_SPACE; }
    //TODO: Coco lexer finds comments in instrumentation code, too, but this way it's simpler for us here
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
    "IF"                { yybegin(pre_resolver); resolver_brace_depth = 0; }
    "CONTEXT"           { return CocoTypes.CONTEXT_KEYWORD; }
    // actually, these are already found in <global_decl>, but then pushed back
    "IGNORECASE"        { return CocoTypes.IGNORECASE_KEYWORD; }
    "CHARACTERS"        { return CocoTypes.CHARACTERS_KEYWORD; }

    // identifier
    {ident}             { return CocoTypes.IDENT; }

    // instrumentation code
    "<"                 { yybegin(instrumentation_angle); return CocoTypes.ANGLE_L; }
    "<."                { yybegin(instrumentation_angledot); return CocoTypes.ANGLEDOT_L; }
    "(."                { yybegin(instrumentation_parendot); return CocoTypes.PARENDOT_L; }
}

<instrumentation_angle> {
    ">"                 {
                          yypushback(yylength());
                          yybegin(post_instrumentation_angle);
                          return CocoTypes.INSTRUMENTATION_CODE;
                        }
    [^]                 { }
}

<post_instrumentation_angle> {
    ">"                 { yybegin(coco); return CocoTypes.ANGLE_R; }
}

<instrumentation_angledot> {
    ".>"                {
                          yypushback(yylength());
                          yybegin(post_instrumentation_angledot);
                          return CocoTypes.INSTRUMENTATION_CODE;
                        }
    [^]                 { }
}

<post_instrumentation_angledot> {
    ".>"                { yybegin(coco); return CocoTypes.ANGLEDOT_R; }
}

<instrumentation_parendot> {
    ".)"                {
                          yypushback(yylength());
                          yybegin(post_instrumentation_parendot);
                          return CocoTypes.INSTRUMENTATION_CODE;
                        }
    [^]                 { }
}

<post_instrumentation_parendot> {
    ".)"                { yybegin(coco); return CocoTypes.PARENDOT_R; }
}

<pre_resolver> {
    {white_space}       { return TokenType.WHITE_SPACE; }
    "("                 { yybegin(resolver); }
}

<resolver> {
    "("                 { ++resolver_brace_depth; }
    ")"                 {
                          if(resolver_brace_depth <= 0) { yybegin(coco); return CocoTypes.RESOLVER; }
                          --resolver_brace_depth;
                        }
    [^]                 { }
}

// error fallback
[^] { return TokenType.BAD_CHARACTER; }
