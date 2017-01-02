package de.qrdn.coco_idea;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.psi.CocoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CocoBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(CocoTypes.LPAREN, CocoTypes.RPAREN, false),
            new BracePair(CocoTypes.LAPAREN, CocoTypes.RAPAREN, false),
            new BracePair(CocoTypes.LSPAREN, CocoTypes.RSPAREN, false),
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
