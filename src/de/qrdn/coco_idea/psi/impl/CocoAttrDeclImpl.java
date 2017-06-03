package de.qrdn.coco_idea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import de.qrdn.coco_idea.psi.CocoInstrumentationCode;
import de.qrdn.coco_idea.psi.CocoTypes;
import org.jetbrains.annotations.NotNull;

public abstract class CocoAttrDeclImpl
        extends ASTWrapperPsiElement
        implements CocoInstrumentationCode {

    private IElementType instrumentationTokenType;

    private void setInstrumentationTokenType() {
        instrumentationTokenType = getNode()
                .findChildByType(TokenSet.create(CocoTypes.INSTRUMENTATION_CODE_ANGLE,
                        CocoTypes.INSTRUMENTATION_CODE_ANGLEDOT))
                .getElementType();
    };

    public CocoAttrDeclImpl(@NotNull ASTNode node) {
        super(node);
        setInstrumentationTokenType();
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
        final int delimiter_length = (instrumentationTokenType == CocoTypes.INSTRUMENTATION_CODE_ANGLE)? 1 : 2;
        return TextRange.create(delimiter_length, getTextLength() -delimiter_length);
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
