package de.qrdn.coco_idea.psi.impl;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

/**
 * A subclass replacing {@link com.intellij.psi.LiteralTextEscaper#createSimple(PsiLanguageInjectionHost)} to be able to override some methods
 */
public class SimpleLiteralTextEscaper<E extends PsiLanguageInjectionHost>
        extends LiteralTextEscaper<E> {

    protected SimpleLiteralTextEscaper(@NotNull E host) {
        super(host);
    }

    @Override
    public boolean decode(@NotNull TextRange rangeInsideHost, @NotNull StringBuilder outChars) {
        outChars.append(rangeInsideHost.substring(myHost.getText()));
        return true;
    }

    @Override
    public int getOffsetInHost(int offsetInDecoded, @NotNull TextRange rangeInsideHost) {
        return rangeInsideHost.getStartOffset() + offsetInDecoded;
    }

    @Override
    public boolean isOneLine() {
        return true;
    }
}
