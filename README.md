Plugin for [Jetbrains](https://www.jetbrains.com/) IDEs
to support grammar files (\*.atg) of the [Coco/R](http://ssw.jku.at/Coco/) compiler generator.

## Implementation

Following the [Custom Language Support Tutorial](http://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support_tutorial.html), the lexer is generated from Coco.flex using JFlex, and the parser from Coco.bnf using [Grammar-Kit](https://github.com/JetBrains/Grammar-Kit).

# TODOs
- customizable syntax highlighting: [Color Settings Page](http://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/syntax_highlighter_and_color_settings_page.html)

# Tutorial deficits
- "register" occurs in plugin.xml
- for references: methods from .bnf are delegated to psiImplUtilClass, *if signature fits*
- bnf: methods(nonterminals)=[] are not resolved correctly in "attributes" header
