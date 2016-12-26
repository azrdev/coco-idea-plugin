package de.qrdn.coco_idea;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import de.qrdn.coco_idea.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CocoStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    final PsiElement element;

    public CocoStructureViewElement(PsiElement element) {
        this.element = element;
    }

    // StructureViewTreeElement

    @Override
    public Object getValue() {
        return element;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        if(element instanceof NavigationItem) {
            ItemPresentation presentation = ((NavigationItem) element).getPresentation();
            if (presentation != null)
                return presentation;
        }
        if(element instanceof CocoFileSection)
            return ((CocoFileSection) element).getPresentation();
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                if(element instanceof CocoNamedElement)
                    return ((CocoNamedElement) element).getName();
                if(element != null)
                    return element.getText();
                return null;
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

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if(element instanceof CocoFile) {
            return new TreeElement[] {
                    new CocoStructureViewElement(PsiTreeUtil.getChildOfType(element, CocoCharacters.class)),
                    new CocoStructureViewElement(PsiTreeUtil.getChildOfType(element, CocoTokens.class)),
                    new CocoStructureViewElement(PsiTreeUtil.getChildOfType(element, CocoProductions.class))
            };
        } else if(element instanceof CocoFileSection) {
            final List<? extends CocoNamedElement> declarations = ((CocoFileSection) element).getDeclarations();
            List<TreeElement> treeElements = new ArrayList<>(declarations.size());
            for (CocoNamedElement decl : declarations) {
                treeElements.add(new CocoStructureViewElement(decl));
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        }
        return EMPTY_ARRAY;
    }

    @Override
    public void navigate(boolean requestFocus) {
        if(element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return (element instanceof NavigationItem) &&
                ((NavigationItem) element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return (element instanceof NavigationItem) &&
                ((NavigationItem) element).canNavigateToSource();
    }

    // SortableTreeElement

    @NotNull
    @Override
    public String getAlphaSortKey() {
        if (element instanceof PsiNamedElement) {
            final String name = ((PsiNamedElement) element).getName();
            if(name != null)
                return name;
        }
        return "";
    }
}
