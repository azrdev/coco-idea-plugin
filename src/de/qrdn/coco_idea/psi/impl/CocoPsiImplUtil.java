package de.qrdn.coco_idea.psi.impl;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import de.qrdn.coco_idea.psi.CocoNamedElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CocoPsiImplUtil {

    // delegates for CocoNamedElement

    /**
     * From set_decl, token_decl or production in the Coco AST, get the naming identifier
     * @return The PsiElement which is the actual name defined by (the whole definition) "element"
     */
    public static PsiElement getNameIdentifier(CocoNamedElement element) {
        if(element instanceof CocoSetDeclImpl) {
            return ((CocoSetDeclImpl) element).getIdentRule();
        } else if(element instanceof CocoProductionImpl) {
            return ((CocoProductionImpl) element).getIdentRule();
        } else if(element instanceof CocoTokenDeclImpl) {
            return ((CocoTokenDeclImpl) element).getSym().getFirstChild();
        }

        return null;
    }

    public static String getName(CocoNamedElement element) {
        if(element instanceof CocoSetDeclImpl) {
            return ((CocoSetDeclImpl) element).getIdentRule().getIdent().getText();
        } else if(element instanceof CocoProductionImpl) {
            return ((CocoProductionImpl) element).getIdentRule().getIdent().getText();
        } else if(element instanceof CocoTokenDeclImpl) {
            return ((CocoTokenDeclImpl) element).getSym().getText();
        }
        return null;
    }

    //TODO: use getPresentation
    public static ItemPresentation getPresentation(final CocoNamedElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName(); //TODO
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile() == null? null : element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return null;
            }
        };
    }

    //FIXME: setName() implementations
    public static PsiElement setName(CocoNamedElement element, @NonNls @NotNull String s)
            throws IncorrectOperationException {
        return null;
    }
}
