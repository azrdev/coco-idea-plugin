package de.qrdn.coco_idea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import de.qrdn.coco_idea.psi.CocoInstrumentationCode;
import org.jetbrains.annotations.NotNull;

public abstract class CocoAttrDeclImpl
        extends ASTWrapperPsiElement
        implements CocoInstrumentationCode {


    public CocoAttrDeclImpl(@NotNull ASTNode node) {
        super(node);
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
    public TextRange getRelevantTextRange() {
        return TextRange.from(2, getTextLength() -2); //FIXME: may be <. .> or < >
    }

    @NotNull
    @Override
    public LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
        return new SimpleLiteralTextEscaper<PsiLanguageInjectionHost>(this) {
            @NotNull
            @Override
            public TextRange getRelevantTextRange() {
                return CocoAttrDeclImpl.this.getRelevantTextRange();
            }
        };
    }
}
