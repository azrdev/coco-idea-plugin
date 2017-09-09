package de.qrdn.coco_idea;

import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import de.qrdn.coco_idea.psi.*;
import org.jetbrains.annotations.NotNull;

public class CocoLanguageInjector implements LanguageInjector {
    @Override
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host,
                                     @NotNull InjectedLanguagePlaces injectionPlacesRegistrar) {
        if (!(host instanceof CocoInstrumentationCodeRule))
            return;
        //TODO: offer selecting instrumentation language from context menu like ConfigurableTemplateLanguageFileViewProvider (the template lang settings work already)
        final Language language = TemplateDataLanguageMappings.getInstance(host.getProject())
                .getMapping(host.getContainingFile().getVirtualFile());
        if (language == null)
            return;
        //FIXME: injection places should know about each other, e.g. for name resolution
        //TODO: glue should be language-dependent
        String prefix = "", suffix = "";
        if (host instanceof CocoIncludeHeader) {
            prefix = "";
            suffix = "public class Parser {";
        } else if (host instanceof CocoGlobalDecls) {
            prefix = suffix = "";
        } else if (host instanceof CocoProduction) {
            prefix = "public void " + ((CocoProduction) host).getName() + "(";
            suffix = ") {";
        } else if (host instanceof CocoSemText) {
            prefix = suffix = "";
        } else if (host instanceof CocoSymRef) {
            prefix = ((CocoSymRef) host).getName() + "(";
            suffix = ");";
        }
        injectionPlacesRegistrar.addPlace(language,
                TextRange.from(1, host.getTextLength() -1), prefix, suffix);
    }
}
