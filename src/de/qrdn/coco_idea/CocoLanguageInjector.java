package de.qrdn.coco_idea;

import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import de.qrdn.coco_idea.psi.CocoInstrumentationCodeRule;
import org.jetbrains.annotations.NotNull;

public class CocoLanguageInjector implements LanguageInjector {
    @Override
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host, @NotNull InjectedLanguagePlaces injectionPlacesRegistrar) {
        //TODO: distinguish injection types / contexts
        if(host instanceof CocoInstrumentationCodeRule) {
            //TODO: configure instrumentation language
            LanguageFileType maybeJavaType = (LanguageFileType) FileTypeManager.getInstance().getStdFileType("JAVA");
            injectionPlacesRegistrar.addPlace(maybeJavaType.getLanguage(), host.getTextRange(),"{", "}");
        }
    }
}
