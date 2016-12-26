package de.qrdn.coco_idea;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import de.qrdn.coco_idea.psi.CocoNamedElement;
import org.jetbrains.annotations.NotNull;

public class CocoStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

    public CocoStructureViewModel(PsiFile psiFile) {
        super(psiFile, new CocoStructureViewElement(psiFile));
    }

    @NotNull
    @Override
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    // StructureViewModel.ElementInfoProvider

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement structureViewTreeElement) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement structureViewTreeElement) {
        return structureViewTreeElement.getValue() instanceof CocoNamedElement;
    }
}
