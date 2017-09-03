package de.qrdn.coco_idea;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.psi.CocoResolverRule;
import de.qrdn.coco_idea.psi.CocoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CocoBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(CocoTypes.LPAREN, CocoTypes.RPAREN, true),
            new BracePair(CocoTypes.LAPAREN, CocoTypes.RAPAREN, false),
            new BracePair(CocoTypes.LSPAREN, CocoTypes.RSPAREN, false),
            new BracePair(CocoTypes.ANGLE_L, CocoTypes.ANGLE_R, false),
            new BracePair(CocoTypes.ANGLEDOT_L, CocoTypes.ANGLEDOT_R, false),
            new BracePair(CocoTypes.PARENDOT_L, CocoTypes.PARENDOT_R, false),
    };

    @NotNull
    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int openingBraceOffset) {
        final PsiElement psiElement = psiFile.findElementAt(openingBraceOffset);
        if(psiElement instanceof CocoResolverRule)
            return psiElement.getTextOffset();
        //TODO: ANGLE(DOT) belong to the production/ident name
        return openingBraceOffset;
    }
}
