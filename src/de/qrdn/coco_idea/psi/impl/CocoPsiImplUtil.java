package de.qrdn.coco_idea.psi.impl;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import de.qrdn.coco_idea.psi.CocoCharacters;
import de.qrdn.coco_idea.psi.CocoNamedElement;
import de.qrdn.coco_idea.psi.CocoProductions;
import de.qrdn.coco_idea.psi.CocoTokens;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

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
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                // return element.getContainingFile() == null? null : element.getContainingFile().getName();
                //TODO: showing containing file name for every element is not that useful
                return null;
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

    // delegates for CocoFileSection

    public static List<? extends CocoNamedElement> getDeclarations(final CocoCharacters element) {
        return element.getSetDeclList();
    }

    public static List<? extends CocoNamedElement> getDeclarations(final CocoTokens element) {
        return element.getTokenDeclList();
    }

    public static List<? extends CocoNamedElement> getDeclarations(final CocoProductions element) {
        return element.getProductionList();
    }

    public static ItemPresentation getPresentation(final CocoCharacters element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return "Character Set definitions";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return null;
            }
        };
    }

    public static ItemPresentation getPresentation(final CocoTokens element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return "Token definitions";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return null;
            }
        };
    }

    public static ItemPresentation getPresentation(final CocoProductions element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return "Production rules";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return null;
            }
        };
    }
}
