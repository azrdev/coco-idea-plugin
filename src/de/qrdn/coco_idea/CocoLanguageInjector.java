package de.qrdn.coco_idea;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import de.qrdn.coco_idea.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class CocoLanguageInjector implements MultiHostInjector {

    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement context) {
        if (!(context instanceof CocoInstrumentationCodeRule))
            return;
        //TODO: offer selecting instrumentation language from context menu like ConfigurableTemplateLanguageFileViewProvider (the template lang settings work already)
        final Language language = TemplateDataLanguageMappings.getInstance(context.getProject())
                .getMapping(context.getContainingFile().getVirtualFile());
        if (language == null)
            return;
        //TODO: glue should be language-dependent
        final String prefix, suffix;
        if (context instanceof CocoIncludeHeader) {
            prefix = "";
            suffix = "public class Parser {";
        } else if (context instanceof CocoGlobalDecls) {
            prefix = suffix = "";
        } else if (context instanceof CocoProduction) {
            prefix = "public void " + ((CocoProduction) context).getName() + "(";
            suffix = ") {";
        } else if (context instanceof CocoSemText) {
            prefix = suffix = "";
        } else if (context instanceof CocoSymRef) {
            prefix = ((CocoSymRef) context).getName() + "(";
            suffix = ");";
        } else {
            prefix = suffix = null;
        }
        registrar
                .startInjecting(language)
                .addPlace(prefix, suffix, (PsiLanguageInjectionHost) context,
                          TextRange.from(1, context.getTextLength() -1))
                .doneInjecting();
    }

    @NotNull
    @Override
    public List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return Collections.singletonList(CocoInstrumentationCodeRule.class);
    }
}
