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
  public static final int pre_resolver = 8;
  public static final int resolver = 10;
  public static final int instrumentation_angle = 12;
  public static final int instrumentation_angledot = 14;
  public static final int instrumentation_parendot = 16;
  public static final int post_instrumentation_angle = 18;
  public static final int post_instrumentation_angledot = 20;
  public static final int post_instrumentation_parendot = 22;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11
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
    "\11\0\1\11\1\15\2\0\1\5\22\0\1\12\1\6\1\3\4\6\1\4\1\47\1\50\1\14\1\42\1\6"+
    "\1\43\1\41\1\13\12\2\2\6\1\56\1\40\1\57\2\6\1\30\1\1\1\16\1\36\1\24\1\35\1"+
    "\26\1\32\1\22\1\1\1\34\1\23\1\20\1\27\1\17\1\21\1\1\1\25\1\31\1\33\1\37\1"+
    "\1\1\46\1\55\1\45\1\1\1\51\1\7\1\52\1\6\1\1\1\6\6\10\24\1\1\53\1\44\1\54\1"+
    "\6\201\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\14\0\2\1\1\2\1\3\1\4\1\3\2\1\1\5"+
    "\3\2\11\5\1\6\1\7\1\10\1\11\1\12\1\5"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\2\1\1\26\2\2\1\0\1\3"+
    "\3\0\1\27\3\0\1\30\1\0\4\5\1\31\4\5"+
    "\1\32\1\5\1\33\1\5\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\0\1\3\2\0\1\42\1\0\2\30"+
    "\1\0\6\5\1\43\1\5\1\44\4\5\1\0\1\3"+
    "\2\0\10\5\1\45\1\5\1\46\1\47\1\0\1\3"+
    "\2\0\11\5\1\0\1\3\2\0\6\5\1\50\1\51"+
    "\1\52\1\0\1\3\2\0\2\5\1\53\2\5\1\54"+
    "\1\5\1\55\1\56\2\0\1\57\1\56\3\5\2\0"+
    "\3\5\1\60\1\61\1\5\1\62\1\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[179];
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
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u0240\0\u02a0"+
    "\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420"+
    "\0\u0450\0\u0480\0\u04b0\0\u04e0\0\u0510\0\u0540\0\u0570\0\u05a0"+
    "\0\u05d0\0\u0240\0\u0600\0\u0240\0\u0240\0\u0390\0\u0630\0\u0660"+
    "\0\u0240\0\u0240\0\u0240\0\u0240\0\u0240\0\u0690\0\u0240\0\u0240"+
    "\0\u0240\0\u0240\0\u06c0\0\u06f0\0\u0240\0\u0720\0\u0750\0\u0780"+
    "\0\u07b0\0\u07e0\0\u0810\0\u03c0\0\u0240\0\u0840\0\u0870\0\u08a0"+
    "\0\u08d0\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0\0\u0390\0\u09f0"+
    "\0\u0a20\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\u0240\0\u0b10\0\u0240"+
    "\0\u0240\0\u0240\0\u0240\0\u0240\0\u0240\0\u0b40\0\u0b70\0\u0ba0"+
    "\0\u0bd0\0\u0240\0\u0c00\0\u0c30\0\u0240\0\u0c60\0\u0c90\0\u0cc0"+
    "\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\u0390\0\u0db0\0\u0390\0\u0de0"+
    "\0\u0e10\0\u0e40\0\u0e70\0\u0ea0\0\u0ed0\0\u0f00\0\u0f30\0\u0f60"+
    "\0\u0f90\0\u0fc0\0\u0ff0\0\u1020\0\u1050\0\u1080\0\u10b0\0\u0390"+
    "\0\u10e0\0\u0390\0\u0390\0\u1110\0\u1140\0\u1170\0\u11a0\0\u11d0"+
    "\0\u1200\0\u1230\0\u1260\0\u1290\0\u12c0\0\u12f0\0\u1320\0\u1350"+
    "\0\u1380\0\u13b0\0\u13e0\0\u1410\0\u1440\0\u1470\0\u14a0\0\u14d0"+
    "\0\u1500\0\u1530\0\u1560\0\u0390\0\u0390\0\u1590\0\u15c0\0\u15f0"+
    "\0\u1620\0\u1650\0\u1680\0\u0390\0\u16b0\0\u16e0\0\u0390\0\u1710"+
    "\0\u0240\0\u02a0\0\u1740\0\u1770\0\u0390\0\u0390\0\u17a0\0\u17d0"+
    "\0\u1800\0\u1830\0\u1860\0\u1890\0\u18c0\0\u18f0\0\u0240\0\u0390"+
    "\0\u1920\0\u0390\0\u0390";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[179];
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
    "\16\15\1\16\41\15\1\17\1\20\3\17\1\21\2\17"+
    "\1\20\2\21\2\17\1\21\1\22\21\20\4\17\3\20"+
    "\6\17\1\20\2\17\16\15\1\23\3\15\1\24\35\15"+
    "\1\17\1\25\1\17\1\26\1\27\1\21\2\17\1\25"+
    "\2\21\1\30\1\17\1\21\1\31\2\25\1\32\1\33"+
    "\1\25\1\34\2\25\1\35\1\36\1\37\1\25\1\40"+
    "\1\25\1\41\2\25\1\42\1\43\1\44\1\45\1\46"+
    "\1\25\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
    "\1\25\1\56\6\17\1\21\3\17\2\21\2\17\1\21"+
    "\31\17\1\57\10\17\47\15\1\60\1\61\66\15\1\62"+
    "\41\15\1\63\57\15\1\64\16\15\57\17\1\65\41\17"+
    "\1\66\57\17\1\67\16\17\77\0\1\70\41\0\2\20"+
    "\5\0\1\20\5\0\22\20\4\0\3\20\6\0\1\20"+
    "\7\0\1\21\3\0\2\21\2\0\1\21\43\0\2\20"+
    "\5\0\1\20\5\0\1\20\1\71\20\20\4\0\3\20"+
    "\6\0\1\20\34\0\1\72\53\0\1\73\32\0\2\25"+
    "\5\0\1\25\5\0\22\25\4\0\3\25\6\0\1\25"+
    "\2\0\3\74\1\75\1\74\1\0\1\74\1\76\5\74"+
    "\1\0\42\74\4\77\2\0\1\77\1\100\5\77\1\0"+
    "\42\77\13\0\1\101\1\102\44\0\2\25\5\0\1\25"+
    "\5\0\1\25\1\103\12\25\1\104\5\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\7\25"+
    "\1\105\12\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\10\25\1\106\6\25\1\107\2\25"+
    "\4\0\3\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\11\25\1\110\10\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\6\25\1\111\13\25"+
    "\4\0\3\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\11\25\1\112\10\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\22\25\4\0\1\25"+
    "\1\113\1\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\1\25\1\114\20\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\7\25\1\115\12\25"+
    "\4\0\3\25\6\0\1\25\43\0\1\116\17\0\2\25"+
    "\5\0\1\25\5\0\6\25\1\117\13\25\4\0\3\25"+
    "\6\0\1\25\43\0\1\120\57\0\1\121\75\0\1\122"+
    "\50\0\1\123\66\0\1\124\50\0\1\125\27\0\1\126"+
    "\40\0\2\20\5\0\1\20\5\0\2\20\1\127\17\20"+
    "\4\0\3\20\6\0\1\20\32\0\1\130\56\0\1\131"+
    "\31\0\4\74\1\0\3\74\1\0\3\74\1\0\42\74"+
    "\4\0\1\132\54\0\4\133\1\0\3\133\1\0\3\133"+
    "\1\0\42\133\5\101\1\134\7\101\1\135\42\101\14\102"+
    "\1\136\43\102\1\0\2\25\5\0\1\25\5\0\2\25"+
    "\1\137\6\25\1\140\10\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\12\25\1\141\7\25"+
    "\4\0\3\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\1\25\1\142\10\25\1\143\7\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\11\25"+
    "\1\144\10\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\20\25\1\145\1\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\13\25"+
    "\1\146\6\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\22\25\4\0\1\25\1\147\1\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\11\25"+
    "\1\150\10\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\16\25\1\151\3\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\1\25"+
    "\1\152\20\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\12\25\1\153\7\25\4\0\3\25"+
    "\6\0\1\25\23\0\1\154\37\0\2\20\5\0\1\20"+
    "\5\0\3\20\1\155\16\20\4\0\3\20\6\0\1\20"+
    "\27\0\1\156\51\0\1\157\42\0\1\133\1\0\1\132"+
    "\3\0\1\133\64\0\1\135\42\0\13\102\1\135\1\136"+
    "\43\102\1\0\2\25\5\0\1\25\5\0\2\25\1\160"+
    "\1\161\16\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\15\25\1\162\4\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\7\25"+
    "\1\163\12\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\20\25\1\164\1\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\10\25"+
    "\1\165\11\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\1\25\1\166\20\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\15\25"+
    "\1\167\4\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\1\170\21\25\4\0\3\25\6\0"+
    "\1\25\3\0\2\25\5\0\1\25\5\0\6\25\1\171"+
    "\13\25\4\0\3\25\6\0\1\25\3\0\2\25\5\0"+
    "\1\25\5\0\2\25\1\172\17\25\4\0\3\25\6\0"+
    "\1\25\3\0\2\25\5\0\1\25\5\0\16\25\1\173"+
    "\3\25\4\0\3\25\6\0\1\25\24\0\1\174\36\0"+
    "\2\20\5\0\1\20\5\0\4\20\1\175\15\20\4\0"+
    "\3\20\6\0\1\20\32\0\1\176\54\0\1\177\33\0"+
    "\2\25\5\0\1\25\5\0\6\25\1\200\13\25\4\0"+
    "\3\25\6\0\1\25\3\0\2\25\5\0\1\25\5\0"+
    "\4\25\1\201\15\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\6\25\1\202\13\25\4\0"+
    "\3\25\6\0\1\25\3\0\2\25\5\0\1\25\5\0"+
    "\12\25\1\203\7\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\21\25\1\204\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\2\25"+
    "\1\205\17\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\7\25\1\206\12\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\6\25"+
    "\1\207\13\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\11\25\1\210\10\25\4\0\3\25"+
    "\6\0\1\25\25\0\1\211\35\0\2\20\5\0\1\20"+
    "\5\0\5\20\1\212\14\20\4\0\3\20\6\0\1\20"+
    "\20\0\1\213\65\0\1\214\34\0\2\25\5\0\1\25"+
    "\5\0\11\25\1\215\10\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\5\25\1\216\14\25"+
    "\4\0\3\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\22\25\4\0\3\25\6\0\1\217\3\0\2\25"+
    "\5\0\1\25\5\0\1\220\21\25\4\0\3\25\6\0"+
    "\1\25\3\0\2\25\5\0\1\25\5\0\1\221\21\25"+
    "\4\0\3\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\12\25\1\222\7\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\6\25\1\223\13\25"+
    "\4\0\3\25\6\0\1\25\3\0\2\25\5\0\1\25"+
    "\5\0\20\25\1\224\1\25\4\0\3\25\6\0\1\25"+
    "\3\0\2\25\5\0\1\25\5\0\13\25\1\225\6\25"+
    "\4\0\3\25\6\0\1\25\26\0\1\226\34\0\2\20"+
    "\5\0\1\20\5\0\6\20\1\227\13\20\4\0\3\20"+
    "\6\0\1\20\35\0\1\230\42\0\1\231\42\0\2\25"+
    "\5\0\1\25\5\0\15\25\1\232\4\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\6\25"+
    "\1\233\13\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\15\25\1\234\4\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\15\25"+
    "\1\235\4\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\15\25\1\236\4\25\4\0\3\25"+
    "\6\0\1\25\3\0\2\25\5\0\1\25\5\0\13\25"+
    "\1\237\6\25\4\0\3\25\6\0\1\25\3\0\2\25"+
    "\5\0\1\25\5\0\1\240\21\25\4\0\3\25\6\0"+
    "\1\25\27\0\1\241\33\0\2\20\5\0\1\20\5\0"+
    "\7\20\1\242\12\20\4\0\3\20\6\0\1\20\26\0"+
    "\1\243\63\0\1\244\30\0\2\25\5\0\1\25\5\0"+
    "\13\25\1\245\6\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\7\25\1\246\12\25\4\0"+
    "\3\25\6\0\1\25\3\0\2\25\5\0\1\25\5\0"+
    "\6\25\1\247\13\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\4\25\1\250\15\25\4\0"+
    "\3\25\6\0\1\25\3\0\2\25\5\0\1\25\5\0"+
    "\12\25\1\251\7\25\4\0\3\25\6\0\1\25\27\0"+
    "\1\252\63\0\1\253\27\0\2\25\5\0\1\25\5\0"+
    "\7\25\1\254\12\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\1\25\1\255\20\25\4\0"+
    "\3\25\6\0\1\25\3\0\2\25\5\0\1\25\5\0"+
    "\13\25\1\256\6\25\4\0\3\25\6\0\1\25\33\0"+
    "\1\257\52\0\1\257\34\0\2\25\5\0\1\25\5\0"+
    "\13\25\1\260\6\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\11\25\1\261\10\25\4\0"+
    "\3\25\6\0\1\25\3\0\2\25\5\0\1\25\5\0"+
    "\6\25\1\262\13\25\4\0\3\25\6\0\1\25\3\0"+
    "\2\25\5\0\1\25\5\0\13\25\1\263\6\25\4\0"+
    "\3\25\6\0\1\25\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6480];
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
    "\14\0\1\11\1\1\1\11\22\1\1\11\1\1\2\11"+
    "\3\1\5\11\1\1\4\11\2\1\1\11\2\1\1\0"+
    "\1\1\3\0\1\11\3\0\1\1\1\0\13\1\1\11"+
    "\1\1\6\11\1\0\1\1\2\0\1\11\1\0\1\1"+
    "\1\11\1\0\15\1\1\0\1\1\2\0\14\1\1\0"+
    "\1\1\2\0\11\1\1\0\1\1\2\0\11\1\1\0"+
    "\1\1\2\0\7\1\1\11\1\1\2\0\5\1\2\0"+
    "\3\1\1\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[179];
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

  /* user code: */
/** in state "resolver", count the level of nested braces that we're in */
int resolver_brace_depth = 0;


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
            { 
            }
          case 52: break;
          case 2: 
            { return TokenType.BAD_CHARACTER;
            }
          case 53: break;
          case 3: 
            { yybegin(global_decl); return CocoTypes.IDENT;
            }
          case 54: break;
          case 4: 
            { return TokenType.WHITE_SPACE;
            }
          case 55: break;
          case 5: 
            { return CocoTypes.IDENT;
            }
          case 56: break;
          case 6: 
            { return CocoTypes.EQUALS;
            }
          case 57: break;
          case 7: 
            { return CocoTypes.DOT;
            }
          case 58: break;
          case 8: 
            { return CocoTypes.PLUS;
            }
          case 59: break;
          case 9: 
            { return CocoTypes.MINUS;
            }
          case 60: break;
          case 10: 
            { return CocoTypes.OR;
            }
          case 61: break;
          case 11: 
            { return CocoTypes.LPAREN;
            }
          case 62: break;
          case 12: 
            { return CocoTypes.RPAREN;
            }
          case 63: break;
          case 13: 
            { return CocoTypes.LSPAREN;
            }
          case 64: break;
          case 14: 
            { return CocoTypes.RSPAREN;
            }
          case 65: break;
          case 15: 
            { return CocoTypes.LAPAREN;
            }
          case 66: break;
          case 16: 
            { return CocoTypes.RAPAREN;
            }
          case 67: break;
          case 17: 
            { yybegin(instrumentation_angle); return CocoTypes.ANGLE_L;
            }
          case 68: break;
          case 18: 
            { yybegin(resolver);
            }
          case 69: break;
          case 19: 
            { ++resolver_brace_depth;
            }
          case 70: break;
          case 20: 
            { if(resolver_brace_depth <= 0) { yybegin(coco); return CocoTypes.RESOLVER; }
                          --resolver_brace_depth;
            }
          case 71: break;
          case 21: 
            { yypushback(yylength());
                          yybegin(post_instrumentation_angle);
                          return CocoTypes.INSTRUMENTATION_CODE;
            }
          case 72: break;
          case 22: 
            { yybegin(coco); return CocoTypes.ANGLE_R;
            }
          case 73: break;
          case 23: 
            { return CocoTypes.STRING;
            }
          case 74: break;
          case 24: 
            { return CocoTypes.COMMENT;
            }
          case 75: break;
          case 25: 
            { yybegin(pre_resolver); resolver_brace_depth = 0;
            }
          case 76: break;
          case 26: 
            { return CocoTypes.TO_KEYWORD;
            }
          case 77: break;
          case 27: 
            { return CocoTypes.DOTDOT;
            }
          case 78: break;
          case 28: 
            { yybegin(instrumentation_parendot); return CocoTypes.PARENDOT_L;
            }
          case 79: break;
          case 29: 
            { yybegin(instrumentation_angledot); return CocoTypes.ANGLEDOT_L;
            }
          case 80: break;
          case 30: 
            { yypushback(yylength());
                          yybegin(post_instrumentation_angledot);
                          return CocoTypes.INSTRUMENTATION_CODE;
            }
          case 81: break;
          case 31: 
            { yypushback(yylength());
                          yybegin(post_instrumentation_parendot);
                          return CocoTypes.INSTRUMENTATION_CODE;
            }
          case 82: break;
          case 32: 
            { yybegin(coco); return CocoTypes.ANGLEDOT_R;
            }
          case 83: break;
          case 33: 
            { yybegin(coco); return CocoTypes.PARENDOT_R;
            }
          case 84: break;
          case 34: 
            { return CocoTypes.CHARACTER;
            }
          case 85: break;
          case 35: 
            { return CocoTypes.END_KEYWORD;
            }
          case 86: break;
          case 36: 
            { return CocoTypes.ANY_KEYWORD;
            }
          case 87: break;
          case 37: 
            { return CocoTypes.SYNC_KEYWORD;
            }
          case 88: break;
          case 38: 
            { return CocoTypes.FROM_KEYWORD;
            }
          case 89: break;
          case 39: 
            { return CocoTypes.WEAK_KEYWORD;
            }
          case 90: break;
          case 40: 
            { return CocoTypes.IGNORE_KEYWORD;
            }
          case 91: break;
          case 41: 
            { return CocoTypes.NESTED_KEYWORD;
            }
          case 92: break;
          case 42: 
            { return CocoTypes.TOKENS_KEYWORD;
            }
          case 93: break;
          case 43: 
            { return CocoTypes.CONTEXT_KEYWORD;
            }
          case 94: break;
          case 44: 
            { return CocoTypes.PRAGMAS_KEYWORD;
            }
          case 95: break;
          case 45: 
            { yypushback(yylength()); yybegin(compiler_decl); return CocoTypes.INSTRUMENTATION_CODE;
            }
          case 96: break;
          case 46: 
            { return CocoTypes.COMPILER_KEYWORD;
            }
          case 97: break;
          case 47: 
            { return CocoTypes.COMMENTS_KEYWORD;
            }
          case 98: break;
          case 48: 
            { yypushback(yylength()); yybegin(coco); return CocoTypes.INSTRUMENTATION_CODE;
            }
          case 99: break;
          case 49: 
            { return CocoTypes.CHARACTERS_KEYWORD;
            }
          case 100: break;
          case 50: 
            { return CocoTypes.IGNORECASE_KEYWORD;
            }
          case 101: break;
          case 51: 
            { return CocoTypes.PRODUCTIONS_KEYWORD;
            }
          case 102: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
