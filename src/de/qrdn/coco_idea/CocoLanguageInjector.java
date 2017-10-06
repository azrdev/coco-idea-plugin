package de.qrdn.coco_idea;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.util.PsiTreeUtil;
import de.qrdn.coco_idea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CocoLanguageInjector implements MultiHostInjector {

    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement context) {
        if (!(context instanceof CocoWholeFile))
            return;
        //TODO: offer selecting instrumentation language from context menu like ConfigurableTemplateLanguageFileViewProvider (the template lang settings work already)
        final Language language = TemplateDataLanguageMappings.getInstance(context.getProject())
                .getMapping(context.getContainingFile().getVirtualFile());
        if (language == null)
            return;
        CocoWholeFile file = (CocoWholeFile) context;

        registrar.startInjecting(language);
        //TODO: glue should be language-dependent
        inject(registrar, null, "public class Parser {", file.getIncludeHeader().getInstrumentationCodeRule());
        inject(registrar, null, null, file.getGlobalDecls().getInstrumentationCodeRule());
        for (CocoProduction production : file.getProductions().getProductionList()) {
            final String prefix = "public void " + production.getName() + "(" +
                    ((production.getAttrSpec() == null) ? "" :
                            production.getAttrSpec().getInstrumentationCodeRule().getText()) +
                    ") {";
            inject(registrar, prefix, "}", production);

            for (CocoSemText semText : PsiTreeUtil.findChildrenOfType(production, CocoSemText.class)) {
                assert semText.getInstrumentationCodeRule() != null;
                inject(registrar, null, null, semText.getInstrumentationCodeRule());
            }

            for (CocoAttrSpec attrSpec : PsiTreeUtil.findChildrenOfType(production.getExpression(), CocoAttrSpec.class)) {
                if(! (attrSpec.getParent() instanceof CocoSymRef))
                    continue;
                final CocoSymRef parent = (CocoSymRef) attrSpec.getParent();
                inject(registrar, parent.getName() + "(", ");", attrSpec.getInstrumentationCodeRule());
            }

        }
        registrar.doneInjecting();
    }

    private static void inject(@NotNull MultiHostRegistrar registrar,
                               @Nullable String prefix, @Nullable String suffix,
                               @NotNull PsiLanguageInjectionHost host) {
        if(host.getTextLength() < 1)
            return;
        registrar.addPlace(prefix, suffix, host, TextRange.from(1, host.getTextLength() -1));
    }

    @NotNull
    @Override
    public List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return Collections.singletonList(CocoWholeFile.class);
    }
}
