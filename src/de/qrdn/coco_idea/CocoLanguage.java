package de.qrdn.coco_idea;

import com.intellij.lang.Language;

public class CocoLanguage extends Language {
  public static final CocoLanguage INSTANCE = new CocoLanguage();

  private CocoLanguage() {
    super("Coco");
  }
}
