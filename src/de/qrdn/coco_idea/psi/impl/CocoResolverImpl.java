package de.qrdn.coco_idea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import de.qrdn.coco_idea.psi.CocoInstrumentationCode;
import org.jetbrains.annotations.NotNull;

public class CocoResolverImpl
        extends ASTWrapperPsiElement
        implements CocoInstrumentationCode {

    public CocoResolverImpl(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public TextRange getRelevantTextRange() {
        //FIXME: weird errors like  "rangeInsideHost must lie within host text range. rangeInsideHost:(343930,343964); host textRange:(343927,343965)"
        final int bracePosition = getText().indexOf("(");
        return getTextRange().cutOut(TextRange.create(
                bracePosition +1,
                getTextLength() -bracePosition -2));
    }

    @Override
    public boolean isValidHost() {
        return true;
    }

    @Override
    public PsiLanguageInjectionHost updateText(@NotNull String text) {
        //TODO: implement updateText
        return null;
    }

    @NotNull
    @Override
    public LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
        return new SimpleLiteralTextEscaper<PsiLanguageInjectionHost>(this) {
            @NotNull
            @Override
            public TextRange getRelevantTextRange() {
                return CocoResolverImpl.this.getRelevantTextRange();
            }
        };
    }
}
