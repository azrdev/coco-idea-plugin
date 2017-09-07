package de.qrdn.coco_idea;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.containers.ContainerUtil;
import de.qrdn.coco_idea.psi.CocoFile;
import de.qrdn.coco_idea.psi.CocoNamedElement;
import de.qrdn.coco_idea.psi.CocoSetDecl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CocoFoldingBuilder extends FoldingBuilderEx {

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        final PsiFile rootFile = root.getContainingFile();
        if( !(rootFile instanceof CocoFile))
            return new FoldingDescriptor[0];
        final CocoFile cocoFile = (CocoFile) rootFile;

        ArrayList<FoldingDescriptor> descriptors = ContainerUtil.newArrayListWithCapacity(
                cocoFile.getCharacterClasses().size()
                        + cocoFile.getTokens().size()
                        + cocoFile.getProductions().size());

        for (Map<String, ? extends CocoNamedElement> declarations :
                Arrays.asList(cocoFile.getCharacterClasses(), cocoFile.getTokens(), cocoFile.getProductions())) {
            for (CocoNamedElement element : declarations.values()) {
                final TextRange textRange = element.getTextRange();
                if(document.getLineNumber(textRange.getStartOffset())
                        != document.getLineNumber(textRange.getEndOffset())) {
                    descriptors.add(new FoldingDescriptor(element.getNode(), textRange));
                }
            }
        }
        //TODO: fold comments

        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        if(node.getPsi() instanceof CocoNamedElement)
            return ((CocoNamedElement) node.getPsi()).getName() + " = ...";
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
