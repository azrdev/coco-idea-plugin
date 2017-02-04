package de.qrdn.coco_idea.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

public interface CocoInstrumentationCode extends PsiLanguageInjectionHost {
    @NotNull
    TextRange getRelevantTextRange();
}
