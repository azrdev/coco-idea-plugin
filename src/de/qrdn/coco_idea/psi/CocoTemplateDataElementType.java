package de.qrdn.coco_idea.psi;

import com.intellij.lang.Language;
import com.intellij.lexer.Lexer;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.CocoLanguage;
import de.qrdn.coco_idea.CocoLexer;
import org.jetbrains.annotations.NotNull;

public class CocoTemplateDataElementType extends TemplateDataElementType {
    public CocoTemplateDataElementType() {
        super("COCO_INSTRUMENTATION_LANGUAGE",
                CocoLanguage.INSTANCE,
                CocoTypes.INSTRUMENTATION_CODE, /* the elements from Coco Psi to handle */
                new CocoElementType("COCO_FRAGMENT") /* the elements to insert into instrumentation Psi instead of non-instr. Coco elements */);
    }

    @Override
    protected CharSequence createTemplateText(@NotNull CharSequence sourceCode,
                                              @NotNull Lexer baseLexer,
                                              @NotNull RangesCollector outerRangesCollector) {
        return super.createTemplateText(sourceCode, baseLexer, outerRangesCollector);
    }

    /**
     * @see <a href="https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000084870-How-Can-I-prevent-FragmentElementType-from-affect-native-HTML-parsing-">Forum</a>
     * @see <a href="https://github.com/AbnerZheng/RegularPlugin/blob/master/src/com/netease/regular/lang/file/RegularTemplateDataElementType.java">Regular</a>
     * @see <a href="https://github.com/mutant-industries/oxy-template-support-plugin/blob/master/src/ool/intellij/plugin/psi/OxyTemplateInnerJsElementType.java">Oxy</a>
     */
    @Override
    protected void appendCurrentTemplateToken(StringBuilder result, CharSequence buf, Lexer lexer) {
        //FIXME: make language-dependent
        switch (lexer.getState()) {
            case CocoLexer.YYINITIAL:
                break;
            case CocoLexer.global_decl:
                result.append("public class Parser {"); //FIXME: closing }
                break;
            //FIXME: each `production` (and `token_decl`) ought to be a function, `attr_decl` (if present) the arguments
            //FIXME: each sym call ought to be a function call, with `attribs` the parameters
            case CocoLexer.instrumentation_angle:
            case CocoLexer.instrumentation_angledot:
                result.append("(");
                break;
            case CocoLexer.instrumentation_parendot:
                result.append("{"); //workaround
                break;
            case CocoLexer.resolver:
                result.append("if(");
                break;
        }

        super.appendCurrentTemplateToken(result, buf, lexer);

        switch (lexer.getState()) {
            case CocoLexer.instrumentation_angle:
            case CocoLexer.instrumentation_angledot:
                result.append(")");
                break;
            case CocoLexer.instrumentation_parendot:
                result.append("}"); //workaround
                break;
            case CocoLexer.resolver:
                result.append(")");
                break;
        }
    }
}
