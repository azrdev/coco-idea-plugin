/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package de.qrdn.coco_idea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import de.qrdn.coco_idea.psi.CocoTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>Coco.flex</tt>
 */
class CocoLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int compiler_decl = 2;
  public static final int global_decl = 4;
  public static final int coco = 6;
  public static final int instrumentation_paren_dot = 8;
  public static final int instrumentation_angle = 10;
  public static final int instrumentation_angle_dot = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6, 6
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1040 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\177\200");

  /* The ZZ_CMAP_A table has 256 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\11\1\15\2\0\1\5\22\0\1\12\1\6\1\3\4\6\1\4\1\46\1\51\1\14\1\42\1\6"+
    "\1\43\1\41\1\13\12\2\2\6\1\45\1\40\1\57\2\6\1\30\1\1\1\16\1\36\1\24\1\35\1"+
    "\26\1\32\1\22\1\1\1\34\1\23\1\20\1\27\1\17\1\21\1\1\1\25\1\31\1\33\1\37\1"+
    "\1\1\50\1\56\1\44\1\1\1\52\1\7\1\53\1\6\1\1\1\6\6\10\24\1\1\54\1\47\1\55\1"+
    "\6\201\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\2\1\1\2\1\3\2\1\1\4\2\2\1\5"+
    "\1\2\11\4\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\4\1\15\1\16\1\17\1\20\1\21\1\1"+
    "\1\22\1\1\4\0\1\23\3\0\1\24\1\0\4\4"+
    "\1\25\4\4\1\26\1\4\1\27\1\30\1\31\1\4"+
    "\3\0\1\32\1\0\2\24\2\0\6\4\1\33\1\4"+
    "\1\34\4\4\4\0\10\4\1\35\1\4\1\36\1\37"+
    "\3\0\11\4\3\0\6\4\1\40\1\41\1\42\3\0"+
    "\2\4\1\43\2\4\1\44\1\4\1\45\2\0\1\46"+
    "\1\47\3\4\2\0\3\4\1\50\1\51\1\52\1\4"+
    "\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[159];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u0150\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0"+
    "\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420"+
    "\0\u0450\0\u0480\0\u04b0\0\u0150\0\u04e0\0\u0150\0\u0150\0\u0510"+
    "\0\u0540\0\u0240\0\u0570\0\u0150\0\u0150\0\u0150\0\u0150\0\u0150"+
    "\0\u05a0\0\u0150\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0270\0\u0150"+
    "\0\u0690\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0780\0\u07b0\0\u07e0"+
    "\0\u0810\0\u0240\0\u0840\0\u0870\0\u08a0\0\u08d0\0\u0900\0\u0930"+
    "\0\u0150\0\u0150\0\u0150\0\u0960\0\u0990\0\u09c0\0\u09f0\0\u0150"+
    "\0\u0a20\0\u0a50\0\u0150\0\u0a80\0\u0ab0\0\u0ae0\0\u0b10\0\u0b40"+
    "\0\u0b70\0\u0ba0\0\u0bd0\0\u0240\0\u0c00\0\u0240\0\u0c30\0\u0c60"+
    "\0\u0c90\0\u0cc0\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\u0db0\0\u0de0"+
    "\0\u0e10\0\u0e40\0\u0e70\0\u0ea0\0\u0ed0\0\u0f00\0\u0240\0\u0f30"+
    "\0\u0240\0\u0240\0\u0f60\0\u0f90\0\u0fc0\0\u0ff0\0\u1020\0\u1050"+
    "\0\u1080\0\u10b0\0\u10e0\0\u1110\0\u1140\0\u1170\0\u11a0\0\u11d0"+
    "\0\u1200\0\u1230\0\u1260\0\u1290\0\u12c0\0\u12f0\0\u1320\0\u1350"+
    "\0\u0240\0\u0240\0\u1380\0\u13b0\0\u13e0\0\u1410\0\u1440\0\u0240"+
    "\0\u1470\0\u14a0\0\u0240\0\u14d0\0\u0150\0\u1500\0\u1530\0\u0240"+
    "\0\u0240\0\u1560\0\u1590\0\u15c0\0\u15f0\0\u1620\0\u1650\0\u1680"+
    "\0\u16b0\0\u0150\0\u0150\0\u0240\0\u16e0\0\u0240\0\u0240";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[159];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\16\10\1\11\41\10\1\12\1\13\6\12\1\13\5\12"+
    "\22\13\4\12\1\13\2\12\2\13\5\12\1\13\1\12"+
    "\16\10\1\14\3\10\1\15\35\10\1\12\1\16\1\12"+
    "\1\17\1\20\1\21\2\12\1\16\2\21\1\22\1\12"+
    "\1\21\1\23\2\16\1\24\1\25\1\16\1\26\2\16"+
    "\1\27\1\30\1\31\1\16\1\32\1\16\1\33\2\16"+
    "\1\34\1\35\1\36\1\37\1\16\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\16\1\12"+
    "\41\10\1\51\75\10\1\52\41\10\1\53\16\10\77\0"+
    "\1\54\41\0\2\13\5\0\1\13\5\0\22\13\4\0"+
    "\1\13\2\0\2\13\5\0\1\13\33\0\1\55\53\0"+
    "\1\56\32\0\2\16\5\0\1\16\5\0\22\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\1\0\3\57\1\60"+
    "\1\57\1\0\1\57\1\61\5\57\1\0\42\57\4\62"+
    "\2\0\1\62\1\63\5\62\1\0\42\62\5\0\1\21"+
    "\3\0\2\21\2\0\1\21\55\0\1\64\1\65\44\0"+
    "\2\16\5\0\1\16\5\0\1\16\1\66\12\16\1\67"+
    "\5\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\7\16\1\70\12\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\10\16\1\71\6\16\1\72\2\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\11\16\1\73\10\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\6\16\1\74\13\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\11\16\1\75"+
    "\10\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\22\16\4\0\1\76\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\1\16\1\77\20\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\7\16\1\100"+
    "\12\16\4\0\1\16\2\0\2\16\5\0\1\16\42\0"+
    "\1\101\57\0\1\102\57\0\1\103\17\0\2\16\5\0"+
    "\1\16\5\0\6\16\1\104\13\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\52\0\1\52\65\0\1\52\20\0"+
    "\1\105\67\0\1\106\56\0\1\107\31\0\4\57\1\0"+
    "\3\57\1\0\3\57\1\0\42\57\4\0\1\110\54\0"+
    "\4\111\1\0\3\111\1\0\3\111\1\0\42\111\5\64"+
    "\1\112\7\64\1\113\42\64\14\114\1\115\43\114\1\0"+
    "\2\16\5\0\1\16\5\0\2\16\1\116\6\16\1\117"+
    "\10\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\12\16\1\120\7\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\1\16\1\121\10\16\1\122\7\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\11\16\1\123\10\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\20\16\1\124\1\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\13\16\1\125"+
    "\6\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\22\16\4\0\1\126\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\11\16\1\127\10\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\16\16\1\130"+
    "\3\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\1\16\1\131\20\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\12\16\1\132\7\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\22\0\1\133\63\0\1\134\51\0"+
    "\1\135\42\0\1\111\1\0\1\110\3\0\1\111\64\0"+
    "\1\113\42\0\14\114\1\136\43\114\13\0\1\113\1\115"+
    "\44\0\2\16\5\0\1\16\5\0\2\16\1\137\1\140"+
    "\16\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\15\16\1\141\4\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\7\16\1\142\12\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\20\16\1\143\1\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\10\16\1\144"+
    "\11\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\1\16\1\145\20\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\15\16\1\146\4\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\1\147\21\16\4\0\1\16\2\0\2\16\5\0\1\16"+
    "\2\0\2\16\5\0\1\16\5\0\6\16\1\150\13\16"+
    "\4\0\1\16\2\0\2\16\5\0\1\16\2\0\2\16"+
    "\5\0\1\16\5\0\2\16\1\151\17\16\4\0\1\16"+
    "\2\0\2\16\5\0\1\16\2\0\2\16\5\0\1\16"+
    "\5\0\16\16\1\152\3\16\4\0\1\16\2\0\2\16"+
    "\5\0\1\16\23\0\1\153\65\0\1\154\54\0\1\155"+
    "\32\0\13\114\1\113\1\136\43\114\1\0\2\16\5\0"+
    "\1\16\5\0\6\16\1\156\13\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\4\16\1\157\15\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\6\16\1\160"+
    "\13\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\12\16\1\161\7\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\21\16\1\162\4\0\1\16\2\0\2\16"+
    "\5\0\1\16\2\0\2\16\5\0\1\16\5\0\2\16"+
    "\1\163\17\16\4\0\1\16\2\0\2\16\5\0\1\16"+
    "\2\0\2\16\5\0\1\16\5\0\7\16\1\164\12\16"+
    "\4\0\1\16\2\0\2\16\5\0\1\16\2\0\2\16"+
    "\5\0\1\16\5\0\6\16\1\165\13\16\4\0\1\16"+
    "\2\0\2\16\5\0\1\16\2\0\2\16\5\0\1\16"+
    "\5\0\11\16\1\166\10\16\4\0\1\16\2\0\2\16"+
    "\5\0\1\16\24\0\1\167\52\0\1\170\65\0\1\171"+
    "\34\0\2\16\5\0\1\16\5\0\11\16\1\172\10\16"+
    "\4\0\1\16\2\0\2\16\5\0\1\16\2\0\2\16"+
    "\5\0\1\16\5\0\5\16\1\173\14\16\4\0\1\16"+
    "\2\0\2\16\5\0\1\16\2\0\2\16\5\0\1\16"+
    "\5\0\22\16\4\0\1\16\2\0\2\16\5\0\1\174"+
    "\2\0\2\16\5\0\1\16\5\0\1\175\21\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\1\176\21\16\4\0\1\16\2\0\2\16"+
    "\5\0\1\16\2\0\2\16\5\0\1\16\5\0\12\16"+
    "\1\177\7\16\4\0\1\16\2\0\2\16\5\0\1\16"+
    "\2\0\2\16\5\0\1\16\5\0\6\16\1\200\13\16"+
    "\4\0\1\16\2\0\2\16\5\0\1\16\2\0\2\16"+
    "\5\0\1\16\5\0\20\16\1\201\1\16\4\0\1\16"+
    "\2\0\2\16\5\0\1\16\2\0\2\16\5\0\1\16"+
    "\5\0\13\16\1\202\6\16\4\0\1\16\2\0\2\16"+
    "\5\0\1\16\25\0\1\203\66\0\1\204\42\0\1\205"+
    "\42\0\2\16\5\0\1\16\5\0\15\16\1\206\4\16"+
    "\4\0\1\16\2\0\2\16\5\0\1\16\2\0\2\16"+
    "\5\0\1\16\5\0\6\16\1\207\13\16\4\0\1\16"+
    "\2\0\2\16\5\0\1\16\2\0\2\16\5\0\1\16"+
    "\5\0\15\16\1\210\4\16\4\0\1\16\2\0\2\16"+
    "\5\0\1\16\2\0\2\16\5\0\1\16\5\0\15\16"+
    "\1\211\4\16\4\0\1\16\2\0\2\16\5\0\1\16"+
    "\2\0\2\16\5\0\1\16\5\0\15\16\1\212\4\16"+
    "\4\0\1\16\2\0\2\16\5\0\1\16\2\0\2\16"+
    "\5\0\1\16\5\0\13\16\1\213\6\16\4\0\1\16"+
    "\2\0\2\16\5\0\1\16\2\0\2\16\5\0\1\16"+
    "\5\0\1\214\21\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\26\0\1\215\56\0\1\216\63\0\1\217\30\0"+
    "\2\16\5\0\1\16\5\0\13\16\1\220\6\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\7\16\1\221\12\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\6\16\1\222\13\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\4\16\1\223"+
    "\15\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\12\16\1\224\7\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\26\0\1\225\63\0"+
    "\1\226\27\0\2\16\5\0\1\16\5\0\7\16\1\227"+
    "\12\16\4\0\1\16\2\0\2\16\5\0\1\16\2\0"+
    "\2\16\5\0\1\16\5\0\1\16\1\230\20\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\13\16\1\231\6\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\32\0\1\232\52\0\1\233\34\0"+
    "\2\16\5\0\1\16\5\0\13\16\1\234\6\16\4\0"+
    "\1\16\2\0\2\16\5\0\1\16\2\0\2\16\5\0"+
    "\1\16\5\0\11\16\1\235\10\16\4\0\1\16\2\0"+
    "\2\16\5\0\1\16\2\0\2\16\5\0\1\16\5\0"+
    "\6\16\1\236\13\16\4\0\1\16\2\0\2\16\5\0"+
    "\1\16\2\0\2\16\5\0\1\16\5\0\13\16\1\237"+
    "\6\16\4\0\1\16\2\0\2\16\5\0\1\16\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5904];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\7\0\1\11\1\1\1\11\21\1\1\11\1\1\2\11"+
    "\4\1\5\11\1\1\1\11\1\1\4\0\1\11\3\0"+
    "\1\1\1\0\13\1\3\11\1\1\3\0\1\11\1\0"+
    "\1\1\1\11\2\0\15\1\4\0\14\1\3\0\11\1"+
    "\3\0\11\1\3\0\7\1\1\11\2\0\5\1\2\0"+
    "\3\1\2\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[159];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  CocoLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return CocoTypes.INSTRUMENTATION_CODE;
            }
          case 45: break;
          case 2: 
            { return TokenType.BAD_CHARACTER;
            }
          case 46: break;
          case 3: 
            { yybegin(global_decl); return CocoTypes.IDENT;
            }
          case 47: break;
          case 4: 
            { return CocoTypes.IDENT;
            }
          case 48: break;
          case 5: 
            { return TokenType.WHITE_SPACE;
            }
          case 49: break;
          case 6: 
            { return CocoTypes.EQUALS;
            }
          case 50: break;
          case 7: 
            { return CocoTypes.DOT;
            }
          case 51: break;
          case 8: 
            { return CocoTypes.PLUS;
            }
          case 52: break;
          case 9: 
            { return CocoTypes.MINUS;
            }
          case 53: break;
          case 10: 
            { yybegin(instrumentation_angle);
            }
          case 54: break;
          case 11: 
            { return CocoTypes.LPAREN;
            }
          case 55: break;
          case 12: 
            { return CocoTypes.OR;
            }
          case 56: break;
          case 13: 
            { return CocoTypes.RPAREN;
            }
          case 57: break;
          case 14: 
            { return CocoTypes.LSPAREN;
            }
          case 58: break;
          case 15: 
            { return CocoTypes.RSPAREN;
            }
          case 59: break;
          case 16: 
            { return CocoTypes.LAPAREN;
            }
          case 60: break;
          case 17: 
            { return CocoTypes.RAPAREN;
            }
          case 61: break;
          case 18: 
            { yybegin(coco);
            }
          case 62: break;
          case 19: 
            { return CocoTypes.STRING;
            }
          case 63: break;
          case 20: 
            { return CocoTypes.COMMENT;
            }
          case 64: break;
          case 21: 
            { return CocoTypes.IF_KEYWORD;
            }
          case 65: break;
          case 22: 
            { return CocoTypes.TO_KEYWORD;
            }
          case 66: break;
          case 23: 
            { return CocoTypes.DOTDOT;
            }
          case 67: break;
          case 24: 
            { yybegin(instrumentation_angle_dot);
            }
          case 68: break;
          case 25: 
            { yybegin(instrumentation_paren_dot);
            }
          case 69: break;
          case 26: 
            { return CocoTypes.CHARACTER;
            }
          case 70: break;
          case 27: 
            { return CocoTypes.END_KEYWORD;
            }
          case 71: break;
          case 28: 
            { return CocoTypes.ANY_KEYWORD;
            }
          case 72: break;
          case 29: 
            { return CocoTypes.SYNC_KEYWORD;
            }
          case 73: break;
          case 30: 
            { return CocoTypes.FROM_KEYWORD;
            }
          case 74: break;
          case 31: 
            { return CocoTypes.WEAK_KEYWORD;
            }
          case 75: break;
          case 32: 
            { return CocoTypes.IGNORE_KEYWORD;
            }
          case 76: break;
          case 33: 
            { return CocoTypes.NESTED_KEYWORD;
            }
          case 77: break;
          case 34: 
            { return CocoTypes.TOKENS_KEYWORD;
            }
          case 78: break;
          case 35: 
            { return CocoTypes.CONTEXT_KEYWORD;
            }
          case 79: break;
          case 36: 
            { return CocoTypes.PRAGMAS_KEYWORD;
            }
          case 80: break;
          case 37: 
            { yybegin(compiler_decl); return CocoTypes.COMPILER_KEYWORD;
            }
          case 81: break;
          case 38: 
            { return CocoTypes.COMMENTS_KEYWORD;
            }
          case 82: break;
          case 39: 
            { return CocoTypes.COMPILER_KEYWORD;
            }
          case 83: break;
          case 40: 
            { yybegin(coco); return CocoTypes.CHARACTERS_KEYWORD;
            }
          case 84: break;
          case 41: 
            { yybegin(coco); return CocoTypes.IGNORECASE_KEYWORD;
            }
          case 85: break;
          case 42: 
            { return CocoTypes.CHARACTERS_KEYWORD;
            }
          case 86: break;
          case 43: 
            { return CocoTypes.IGNORECASE_KEYWORD;
            }
          case 87: break;
          case 44: 
            { return CocoTypes.PRODUCTIONS_KEYWORD;
            }
          case 88: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
