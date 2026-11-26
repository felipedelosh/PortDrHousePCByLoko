import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.rms.RecordStore;

// $VF: renamed from: c
public class class_3 extends GameCanvas implements Runnable {
   // $VF: renamed from: a java.lang.String[]
   public static final String[] field_23 = new String[]{"pack", "personajes", "f", "fa", "carap", "carta"};
   // $VF: renamed from: a byte[]
   public static final byte[] field_24 = new byte[]{0, 0, 2, 0, 0, 0};
   // $VF: renamed from: B int
   private static int field_25;
   // $VF: renamed from: c java.lang.String[]
   private static String[] field_26;
   // $VF: renamed from: d java.lang.String[]
   private static String[] field_27;
   // $VF: renamed from: a Mapp
   public static Mapp field_28;
   // $VF: renamed from: a java.lang.Thread
   private static Thread field_29;
   // $VF: renamed from: a boolean
   public static volatile boolean field_30 = false;
   // $VF: renamed from: a int
   public static int field_31;
   // $VF: renamed from: b int
   public static int field_32;
   // $VF: renamed from: d boolean
   private static boolean field_33 = true;
   // $VF: renamed from: b boolean
   public static boolean field_34 = true;
   // $VF: renamed from: C int
   private static int field_35 = 0;
   // $VF: renamed from: b long
   private static long field_36 = 0L;
   // $VF: renamed from: a long
   public static long field_37 = 0L;
   // $VF: renamed from: c long
   private static long field_38 = 0L;
   // $VF: renamed from: a java.util.Random
   private static Random field_39;
   // $VF: renamed from: a javax.microedition.lcdui.Graphics
   public static Graphics field_40;
   // $VF: renamed from: b javax.microedition.lcdui.Graphics
   private static Graphics field_41;
   // $VF: renamed from: e boolean
   private static boolean field_42 = false;
   // $VF: renamed from: D int
   private static int field_43;
   // $VF: renamed from: E int
   private static int field_44 = 0;
   // $VF: renamed from: b byte[]
   public static byte[] field_45;
   // $VF: renamed from: c byte[]
   public static byte[] field_46;
   // $VF: renamed from: a int[]
   public static int[] field_47;
   // $VF: renamed from: a java.util.Vector
   private static Vector field_48 = new Vector(1, 1);
   // $VF: renamed from: c javax.microedition.lcdui.Graphics
   private static Graphics field_49 = null;
   private static int activeKeysMask;
   private static int justPressedKeysMask;
   private static volatile int heldKeysMask;
   private static volatile int newlyPressedKeysMask;
   private static volatile int pendingKeysMask;
   // $VF: renamed from: b int[]
   public static final int[] field_55 = new int[]{0, 90, 24576, 24666, 8192, 8282, 16384, 16474};
   // $VF: renamed from: c int[]
   public static final int[] field_56 = new int[]{0, 5, 3, 6, 2, 4, 1, 7};
   // $VF: renamed from: i int[]
   private static int[] field_57 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
   // $VF: renamed from: a javax.microedition.lcdui.Image
   private static Image field_58;
   // $VF: renamed from: a b[]
   public static SpriteData[] field_59;
   // $VF: renamed from: c int
   public static int field_60 = -1;
   // $VF: renamed from: d int
   public static int field_61 = 0;
   // $VF: renamed from: c boolean
   public static boolean field_62 = true;
   // $VF: renamed from: e java.lang.String[]
   private static final String[] field_63 = new String[]{"/s0.bin", "/s1.bin", "/s2.bin", "/s3.bin", "/s4.bin"};
   // $VF: renamed from: f java.lang.String[]
   private static final String[] field_64 = new String[]{"audio/midi", "audio/midi", "audio/midi", "audio/midi", "audio/midi"};
   // $VF: renamed from: f boolean
   private static boolean field_65;
   // $VF: renamed from: K int
   private static int field_66;
   // $VF: renamed from: L int
   private static int field_67;
   // $VF: renamed from: g boolean
   private static boolean field_68;
   // $VF: renamed from: a javax.microedition.media.Player
   private static Player field_69;
   // $VF: renamed from: a javax.microedition.rms.RecordStore
   public static RecordStore field_70;
   // $VF: renamed from: d byte[]
   public static byte[] field_71;
   // $VF: renamed from: d int[]
   public static final int[] field_72 = new int[]{0, 1, 1, 1, 0, -1, -1, -1, 0, 0};
   // $VF: renamed from: e int[]
   public static final int[] field_73 = new int[]{-1, -1, 0, 1, 1, 1, 0, -1, 0, 0};
   // $VF: renamed from: f int[]
   public static final int[] field_74 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, -1};
   // $VF: renamed from: e int
   public static int field_75;
   // $VF: renamed from: f int
   public static int field_76;
   // $VF: renamed from: M int
   private static int field_77;
   // $VF: renamed from: N int
   private static int field_78;
   // $VF: renamed from: h boolean
   private static boolean field_79;
   // $VF: renamed from: O int
   private static int field_80;
   // $VF: renamed from: g int
   public static int field_81;
   // $VF: renamed from: h int
   public static int field_82;
   // $VF: renamed from: i int
   public static int field_83;
   // $VF: renamed from: j int
   public static int field_84;
   // $VF: renamed from: k int
   public static int field_85;
   // $VF: renamed from: e byte[]
   public static byte[] field_86;
   // $VF: renamed from: l int
   public static int field_87 = -1;
   // $VF: renamed from: m int
   public static int field_88;
   // $VF: renamed from: n int
   public static int field_89;
   // $VF: renamed from: o int
   public static int field_90;
   // $VF: renamed from: p int
   public static int field_91;
   // $VF: renamed from: q int
   public static int field_92;
   // $VF: renamed from: r int
   public static int field_93;
   // $VF: renamed from: s int
   public static int field_94;
   // $VF: renamed from: t int
   public static int field_95;
   // $VF: renamed from: u int
   public static int field_96;
   // $VF: renamed from: v int
   public static int field_97;
   // $VF: renamed from: P int
   private static int field_98 = 0;
   // $VF: renamed from: Q int
   private static int field_99 = 0;
   // $VF: renamed from: f byte[]
   public static byte[] field_100;
   // $VF: renamed from: g byte[]
   public static byte[] field_101;
   // $VF: renamed from: h byte[]
   public static byte[] field_102;
   // $VF: renamed from: i byte[]
   public static byte[] field_103;
   // $VF: renamed from: j byte[]
   public static byte[] field_104;
   // $VF: renamed from: k byte[]
   public static byte[] field_105;
   // $VF: renamed from: l byte[]
   public static byte[] field_106;
   // $VF: renamed from: m byte[]
   public static byte[] field_107;
   // $VF: renamed from: n byte[]
   public static byte[] field_108;
   // $VF: renamed from: a short[]
   public static short[] field_109;
   // $VF: renamed from: b short[]
   public static short[] field_110;
   // $VF: renamed from: c short[]
   public static short[] field_111;
   // $VF: renamed from: a boolean[]
   public static boolean[] field_112;
   // $VF: renamed from: d short[]
   public static short[] field_113;
   // $VF: renamed from: e short[]
   public static short[] field_114;
   // $VF: renamed from: o byte[]
   public static byte[] field_115;
   // $VF: renamed from: p byte[]
   public static byte[] field_116;
   // $VF: renamed from: q byte[]
   public static byte[] field_117;
   // $VF: renamed from: r byte[]
   public static byte[] field_118;
   // $VF: renamed from: s byte[]
   private static byte[] field_119;
   // $VF: renamed from: f short[]
   private static short[] field_120;
   // $VF: renamed from: g short[]
   private static short[] field_121;
   // $VF: renamed from: h short[]
   private static short[] field_122;
   // $VF: renamed from: R int
   private static int field_123;
   // $VF: renamed from: S int
   private static int field_124;
   // $VF: renamed from: T int
   private static int field_125;
   // $VF: renamed from: U int
   private static int field_126;
   // $VF: renamed from: V int
   private static int field_127;
   // $VF: renamed from: W int
   private static int field_128;
   // $VF: renamed from: i boolean
   private static boolean field_129;
   // $VF: renamed from: X int
   private static int field_130;
   // $VF: renamed from: Y int
   private static int field_131;
   // $VF: renamed from: Z int
   private static int field_132;
   // $VF: renamed from: aa int
   private static int field_133;
   // $VF: renamed from: ab int
   private static int field_134;
   // $VF: renamed from: ac int
   private static int field_135;
   // $VF: renamed from: ad int
   private static int field_136;
   // $VF: renamed from: ae int
   private static int field_137;
   // $VF: renamed from: af int
   private static int field_138;
   // $VF: renamed from: ag int
   private static int field_139;
   // $VF: renamed from: ah int
   private static int field_140;
   // $VF: renamed from: ai int
   private static int field_141;
   // $VF: renamed from: aj int
   private static int field_142;
   // $VF: renamed from: ak int
   private static int field_143;
   // $VF: renamed from: al int
   private static int field_144;
   // $VF: renamed from: j boolean
   private static boolean field_145;
   // $VF: renamed from: k boolean
   private static boolean field_146;
   // $VF: renamed from: l boolean
   private static boolean field_147;
   // $VF: renamed from: am int
   private static int field_148;
   // $VF: renamed from: an int
   private static int field_149;
   // $VF: renamed from: ao int
   private static int field_150;
   // $VF: renamed from: ap int
   private static int field_151;
   // $VF: renamed from: m boolean
   private static boolean field_152;
   // $VF: renamed from: b javax.microedition.lcdui.Image
   private static Image field_153;
   // $VF: renamed from: d javax.microedition.lcdui.Graphics
   private static Graphics field_154;
   // $VF: renamed from: n boolean
   private static boolean field_155;
   // $VF: renamed from: w int
   public static int field_156;
   // $VF: renamed from: x int
   public static int field_157;
   // $VF: renamed from: y int
   public static int field_158;
   // $VF: renamed from: z int
   public static int field_159;
   // $VF: renamed from: A int
   public static int field_160;
   // $VF: renamed from: g int[]
   public static int[] field_161 = new int[]{0, 0, 0, 0};
   // $VF: renamed from: aq int
   private static int field_162 = 0;
   // $VF: renamed from: ar int
   private static int field_163;
   // $VF: renamed from: as int
   private static int field_164;
   // $VF: renamed from: at int
   private static int field_165;
   // $VF: renamed from: au int
   private static int field_166;
   // $VF: renamed from: av int
   private static int field_167;
   // $VF: renamed from: aw int
   private static int field_168;
   // $VF: renamed from: b java.lang.String[]
   public static final String[] field_169 = new String[]{
      "house.png",
      "wilson.png",
      "cuddy.png",
      "foreman.png",
      "cameron.png",
      "chase.png",
      "farmaceutico.png",
      "isomap.bin",
      "cerrojo.png",
      "ganzua.png",
      "flechas.png",
      "script.bin",
      "anims.bin",
      "personajes.bin",
      "personajes.flh",
      "pack.bin",
      "pack.flh",
      "carap.bin",
      "carta.bin",
      "f.bin",
      "fa.bin",
      "cara.png",
      "logo.png",
      "madera.png",
      "madera2.png",
      "madera3.png",
      "mano.png",
      "barras.png",
      "fox.png",
      "logocom2.png"
   };
   // $VF: renamed from: a a
   private static class_2 field_170;
   // $VF: renamed from: t byte[]
   private static byte[] field_171;
   // $VF: renamed from: u byte[]
   private static byte[] field_172;
   // $VF: renamed from: i short[]
   private static short[] field_173;
   // $VF: renamed from: v byte[]
   private static byte[] field_174;
   // $VF: renamed from: j short[]
   private static short[] field_175;
   // $VF: renamed from: w byte[]
   private static byte[] field_176;
   // $VF: renamed from: x byte[]
   private static byte[] field_177;
   // $VF: renamed from: y byte[]
   private static byte[] field_178;
   // $VF: renamed from: b boolean[]
   private static boolean[] field_179;
   // $VF: renamed from: z byte[]
   private static final byte[] field_180 = new byte[]{
      7,
      0,
      -2,
      3,
      0,
      -2,
      5,
      0,
      1,
      1,
      -2,
      1,
      0,
      5,
      1,
      -2,
      6,
      0,
      2,
      1,
      5,
      0,
      1,
      1,
      -2,
      0,
      0,
      6,
      1,
      1,
      0,
      5,
      1,
      -2,
      4,
      0,
      2,
      1,
      5,
      0,
      1,
      1,
      -2,
      2,
      0,
      4,
      1,
      1,
      0,
      5,
      1,
      -2,
      -1
   };
   // $VF: renamed from: ax int
   private static int field_181;
   // $VF: renamed from: ay int
   private static int field_182;
   // $VF: renamed from: az int
   private static int field_183;
   // $VF: renamed from: aA int
   private static int field_184;
   // $VF: renamed from: aB int
   private static int field_185;
   // $VF: renamed from: aC int
   private static int field_186;
   // $VF: renamed from: aD int
   private static int field_187;
   // $VF: renamed from: A byte[]
   private static byte[] field_188;
   // $VF: renamed from: aE int
   private static int field_189;
   // $VF: renamed from: j int[]
   private static int[] field_190;
   // $VF: renamed from: aF int
   private static int field_191;
   // $VF: renamed from: aG int
   private static int field_192;
   // $VF: renamed from: k int[]
   private static int[] field_193;
   // $VF: renamed from: aH int
   private static int field_194;
   // $VF: renamed from: l int[]
   private static int[] field_195;
   // $VF: renamed from: m int[]
   private static int[] field_196;
   // $VF: renamed from: aI int
   private static int field_197;
   // $VF: renamed from: aJ int
   private static int field_198;
   // $VF: renamed from: aK int
   private static int field_199;
   // $VF: renamed from: aL int
   private static int field_200;
   // $VF: renamed from: aM int
   private static int field_201;
   // $VF: renamed from: aN int
   private static int field_202;
   // $VF: renamed from: B byte[]
   private static byte[] field_203;
   // $VF: renamed from: n int[]
   private static int[] field_204;
   // $VF: renamed from: aO int
   private static int field_205;
   // $VF: renamed from: o int[]
   private static int[] field_206;
   // $VF: renamed from: p int[]
   private static int[] field_207;
   // $VF: renamed from: q int[]
   private static int[] field_208;
   // $VF: renamed from: C byte[]
   private static byte[] field_209;
   // $VF: renamed from: r int[]
   private static int[] field_210;
   // $VF: renamed from: s int[]
   private static int[] field_211;
   // $VF: renamed from: t int[]
   private static int[] field_212;
   // $VF: renamed from: u int[]
   private static int[] field_213;
   // $VF: renamed from: v int[]
   private static int[] field_214;
   // $VF: renamed from: w int[]
   private static int[] field_215;
   // $VF: renamed from: D byte[]
   private static byte[] field_216;
   // $VF: renamed from: k short[]
   private static short[] field_217;
   // $VF: renamed from: l short[]
   private static short[] field_218;
   // $VF: renamed from: E byte[]
   private static byte[] field_219;
   // $VF: renamed from: F byte[]
   private static byte[] field_220;
   // $VF: renamed from: aP int
   private static int field_221 = -1;
   // $VF: renamed from: aQ int
   private static int field_222;
   // $VF: renamed from: aR int
   private static int field_223;
   // $VF: renamed from: aS int
   private static int field_224;
   // $VF: renamed from: aT int
   private static int field_225;
   // $VF: renamed from: aU int
   private static int field_226;
   // $VF: renamed from: aV int
   private static int field_227 = 1;
   // $VF: renamed from: e javax.microedition.lcdui.Graphics
   private static Graphics field_228;
   // $VF: renamed from: o boolean
   private static boolean field_229;
   // $VF: renamed from: aW int
   private static int field_230 = -1;
   // $VF: renamed from: x int[]
   private static int[] field_231 = new int[]{28, 29};
   // $VF: renamed from: y int[]
   private static int[] field_232 = new int[]{16777215, 16777215};
   // $VF: renamed from: aX int
   private static int field_233;
   // $VF: renamed from: aY int
   private static int field_234;
   // $VF: renamed from: c javax.microedition.lcdui.Image
   private static Image field_235;
   // $VF: renamed from: d javax.microedition.lcdui.Image
   private static Image field_236;
   // $VF: renamed from: aZ int
   private static int field_237;
   // $VF: renamed from: ba int
   private static int field_238;
   // $VF: renamed from: bb int
   private static int field_239;
   // $VF: renamed from: bc int
   private static int field_240;
   // $VF: renamed from: bd int
   private static int field_241;
   // $VF: renamed from: a java.lang.Object[]
   private static Object[] field_242;
   // $VF: renamed from: p boolean
   private static boolean field_243;
   // $VF: renamed from: be int
   private static int field_244;
   // $VF: renamed from: bf int
   private static int field_245;
   // $VF: renamed from: b java.lang.Object[]
   private static Object[] field_246 = new Object[8];
   // $VF: renamed from: z int[]
   private static int[] field_247 = new int[8];
   // $VF: renamed from: A int[]
   private static int[] field_248 = new int[8];
   // $VF: renamed from: B int[]
   private static int[] field_249 = new int[8];
   // $VF: renamed from: C int[]
   private static int[] field_250 = new int[8];
   // $VF: renamed from: D int[]
   private static int[] field_251 = new int[8];
   // $VF: renamed from: E int[]
   private static int[] field_252 = new int[8];
   // $VF: renamed from: F int[]
   private static int[] field_253 = new int[8];
   // $VF: renamed from: G byte[]
   private static byte[] field_254 = new byte[8];
   // $VF: renamed from: bg int
   private static int field_255;
   // $VF: renamed from: G int[]
   private static int[] field_256 = new int[8];
   // $VF: renamed from: H int[]
   private static int[] field_257 = new int[8];
   // $VF: renamed from: bh int
   private static int field_258;
   // $VF: renamed from: bi int
   private static int field_259;
   // $VF: renamed from: bj int
   private static int field_260;
   // $VF: renamed from: bk int
   private static int field_261;
   // $VF: renamed from: bl int
   private static int field_262;
   // $VF: renamed from: bm int
   private static int field_263;
   // $VF: renamed from: bn int
   private static int field_264;
   // $VF: renamed from: bo int
   private static int field_265;
   // $VF: renamed from: bp int
   private static int field_266;
   // $VF: renamed from: q boolean
   private static boolean field_267;
   // $VF: renamed from: bq int
   private static int field_268 = 0;
   // $VF: renamed from: I int[]
   private static int[] field_269 = new int[8];
   // $VF: renamed from: br int
   private static int field_270;
   // $VF: renamed from: bs int
   private static int field_271;
   // $VF: renamed from: bt int
   private static int field_272;
   // $VF: renamed from: bu int
   private static int field_273;
   // $VF: renamed from: bv int
   private static int field_274;
   // $VF: renamed from: bw int
   private static int field_275;
   // $VF: renamed from: bx int
   private static int field_276;
   // $VF: renamed from: by int
   private static int field_277;
   // $VF: renamed from: bz int
   private static int field_278 = 20;
   // $VF: renamed from: bA int
   private static int field_279 = 21;
   // $VF: renamed from: bB int
   private static int field_280;
   // $VF: renamed from: bC int
   private static int field_281;
   // $VF: renamed from: bD int
   private static int field_282;
   // $VF: renamed from: bE int
   private static int field_283;
   // $VF: renamed from: bF int
   private static int field_284;
   // $VF: renamed from: bG int
   private static int field_285;
   // $VF: renamed from: J int[]
   private static int[] field_286 = new int[]{0, 16, -4, 2, 4, 3, -4, 2, 4, 1};
   // $VF: renamed from: e javax.microedition.lcdui.Image
   private static Image field_287;
   // $VF: renamed from: bH int
   private static int field_288;
   // $VF: renamed from: bI int
   private static int field_289;
   // $VF: renamed from: bJ int
   private static int field_290;
   // $VF: renamed from: bK int
   private static int field_291;
   // $VF: renamed from: bL int
   private static int field_292;
   // $VF: renamed from: bM int
   private static int field_293;
   // $VF: renamed from: bN int
   private static int field_294;
   // $VF: renamed from: bO int
   private static int field_295;
   // $VF: renamed from: bP int
   private static int field_296;
   // $VF: renamed from: bQ int
   private static int field_297;
   // $VF: renamed from: b java.lang.Thread
   private static Thread field_298;
   // $VF: renamed from: bR int
   private static int field_299;
   // $VF: renamed from: bS int
   private static int field_300;
   // $VF: renamed from: bT int
   private static int field_301;
   // $VF: renamed from: bU int
   private static int field_302;
   // $VF: renamed from: bV int
   private static int field_303;
   // $VF: renamed from: bW int
   private static int field_304 = -1;
   // $VF: renamed from: bX int
   private static int field_305;
   // $VF: renamed from: bY int
   private static int field_306 = -1;
   // $VF: renamed from: bZ int
   private static int field_307;
   // $VF: renamed from: ca int
   private static int field_308;
   // $VF: renamed from: cb int
   private static int field_309;
   // $VF: renamed from: cc int
   private static int field_310;
   // $VF: renamed from: cd int
   private static int field_311;
   // $VF: renamed from: ce int
   private static int field_312;
   // $VF: renamed from: cf int
   private static int field_313;
   // $VF: renamed from: cg int
   private static int field_314;
   // $VF: renamed from: ch int
   private static int field_315;
   // $VF: renamed from: ci int
   private static int field_316;
   // $VF: renamed from: cj int
   private static int field_317;
   // $VF: renamed from: ck int
   private static int field_318;
   // $VF: renamed from: cl int
   private static int field_319;
   // $VF: renamed from: cm int
   private static int field_320;
   // $VF: renamed from: r boolean
   private static boolean field_321;
   // $VF: renamed from: cn int
   private static int field_322;
   // $VF: renamed from: co int
   private static int field_323;
   // $VF: renamed from: cp int
   private static int field_324;
   // $VF: renamed from: cq int
   private static int field_325;
   // $VF: renamed from: cr int
   private static int field_326;
   // $VF: renamed from: cs int
   private static int field_327;
   // $VF: renamed from: ct int
   private static int field_328;
   // $VF: renamed from: cu int
   private static int field_329;
   // $VF: renamed from: cv int
   private static int field_330;
   // $VF: renamed from: cw int
   private static int field_331;
   // $VF: renamed from: cx int
   private static int field_332;
   // $VF: renamed from: cy int
   private static int field_333;
   // $VF: renamed from: cz int
   private static int field_334;
   // $VF: renamed from: cA int
   private static int field_335;
   // $VF: renamed from: cB int
   private static int field_336;
   // $VF: renamed from: cC int
   private static int field_337;
   // $VF: renamed from: cD int
   private static int field_338;
   // $VF: renamed from: cE int
   private static int field_339;
   // $VF: renamed from: K int[]
   private static int[] field_340 = new int[]{
      32, 32, 6, 128, 128, 0, 2048, 2048, 4, 8192, 8192, 2, 1, 4, 6, 1, 8, 0, 2, 4, 4, 2, 8, 2, 1, 1, 7, 4, 4, 5, 8, 8, 1, 2, 2, 3
   };
   // $VF: renamed from: s boolean
   private static boolean field_341;
   // $VF: renamed from: cF int
   private static int field_342 = 0;
   // $VF: renamed from: L int[]
   private static final int[] field_343 = new int[]{0, 1, 2, 3, 4, 5, 6};
   // $VF: renamed from: cG int
   private static int field_344;
   // $VF: renamed from: M int[]
   private static int[] field_345 = new int[16];
   // $VF: renamed from: cH int
   private static int field_346 = -1;
   // $VF: renamed from: cI int
   private static int field_347 = -1;
   // $VF: renamed from: cJ int
   private static int field_348;
   // $VF: renamed from: cK int
   private static int field_349;
   // $VF: renamed from: cL int
   private static int field_350;
   // $VF: renamed from: cM int
   private static int field_351;
   // $VF: renamed from: cN int
   private static int field_352;
   // $VF: renamed from: cO int
   private static int field_353;
   // $VF: renamed from: cP int
   private static int field_354;
   // $VF: renamed from: cQ int
   private static int field_355;
   // $VF: renamed from: cR int
   private static int field_356;
   // $VF: renamed from: cS int
   private static int field_357;
   // $VF: renamed from: cT int
   private static int field_358;
   // $VF: renamed from: cU int
   private static int field_359;
   // $VF: renamed from: cV int
   private static int field_360;
   // $VF: renamed from: cW int
   private static int field_361;
   // $VF: renamed from: cX int
   private static int field_362 = -1;
   // $VF: renamed from: f javax.microedition.lcdui.Image
   private static Image field_363;
   // $VF: renamed from: N int[]
   private static int[] field_364 = new int[]{0, 3, 4, 6, 7, 8, 20, 23, 91, 92, 96, 99, 101};
   // $VF: renamed from: t boolean
   private static boolean field_365 = false;
   // $VF: renamed from: u boolean
   private static boolean field_366 = false;
   // $VF: renamed from: cY int
   private static int field_367;
   // $VF: renamed from: cZ int
   private static int field_368;
   // $VF: renamed from: da int
   private static int field_369;
   // $VF: renamed from: db int
   private static int field_370;
   // $VF: renamed from: dc int
   private static int field_371;
   // $VF: renamed from: dd int
   private static int field_372;
   // $VF: renamed from: de int
   private static int field_373;
   // $VF: renamed from: df int
   private static int field_374;
   // $VF: renamed from: dg int
   private static int field_375;
   // $VF: renamed from: dh int
   private static int field_376;
   // $VF: renamed from: di int
   private static int field_377;
   // $VF: renamed from: v boolean
   private static boolean field_378;
   // $VF: renamed from: O int[]
   private static int[] field_379 = new int[]{1, 0, 0, 1, 1, 0, 0, 1};
   // $VF: renamed from: dj int
   private static int field_380;
   // $VF: renamed from: P int[]
   private static int[] field_381 = new int[16];
   // $VF: renamed from: Q int[]
   private static int[] field_382 = new int[]{-4, -2, 0, -2, 0, -1, 0, 0, 0, 0, 0, 0};
   // $VF: renamed from: R int[]
   private static int[] field_383 = new int[]{-1, -2, -3, -4, -3, -2, -1, 0};
   // $VF: renamed from: S int[]
   private static int[] field_384 = new int[4];
   // $VF: renamed from: dk int
   private static int field_385 = 0;
   // $VF: renamed from: dl int
   private static int field_386 = 0;
   // $VF: renamed from: dm int
   private static int field_387;
   // $VF: renamed from: dn int
   private static int field_388;
   // $VF: renamed from: T int[]
   private static int[] field_389 = new int[16];
   // $VF: renamed from: w boolean
   private static boolean field_390;
   // $VF: renamed from: do int
   private static int field_391;
   // $VF: renamed from: dp int
   private static int field_392;
   // $VF: renamed from: dq int
   private static int field_393;
   // $VF: renamed from: g javax.microedition.lcdui.Image
   private static Image field_394;
   // $VF: renamed from: h javax.microedition.lcdui.Image
   private static Image field_395;
   // $VF: renamed from: i javax.microedition.lcdui.Image
   private static Image field_396;
   // $VF: renamed from: dr int
   private static int field_397;
   // $VF: renamed from: ds int
   private static int field_398;
   // $VF: renamed from: dt int
   private static int field_399;
   // $VF: renamed from: du int
   private static int field_400;
   // $VF: renamed from: dv int
   private static int field_401;
   // $VF: renamed from: U int[]
   private static final int[] field_402 = new int[]{0, -6, 0, 6, -6, 0, 6, 0};
   // $VF: renamed from: V int[]
   private static final int[] field_403 = new int[]{0, 1, 2, 3, 2, 1};
   // $VF: renamed from: W int[]
   private static final int[] field_404 = new int[]{1, 0, 2, 1, 4, 2, 8, 3};
   // $VF: renamed from: X int[]
   private static int[] field_405 = new int[16];
   // $VF: renamed from: dw int
   private static int field_406;
   // $VF: renamed from: x boolean
   private static boolean field_407;
   // $VF: renamed from: dx int
   private static int field_408;
   // $VF: renamed from: a b
   private static SpriteData field_409;
   // $VF: renamed from: dy int
   private static int field_410;
   // $VF: renamed from: Y int[]
   private static int[] field_411;
   // $VF: renamed from: Z int[]
   private static int[] field_412;
   // $VF: renamed from: H byte[]
   private static byte[] field_413;
   // $VF: renamed from: aa int[]
   private static int[] field_414;
   // $VF: renamed from: ab int[]
   private static final int[] field_415 = new int[]{0, 0, 28, 0, 62, 0, 0, 15, 46, 28, 0, 21, 25, 51, 41, 51, 49, 43, 0, 61, 0, 75, 31, 76};
   // $VF: renamed from: ac int[]
   private static final int[] field_416 = new int[]{53, 1, 42, 0, 47, 24, 0, 0, 18, 24, 0, 1, 58, 54, 27, 49, 49, 61, 0, 50, 0, 61, 28, 76, 0, 78};
   // $VF: renamed from: ad int[]
   private static final int[] field_417 = new int[]{44, 0, 88, 0, 132, 0, 0, 52, 0, 104, 0, 156, 133, 52, 133, 104, 133, 156, 44, 160, 88, 160, 132, 160};
   // $VF: renamed from: dz int
   private static int field_418;
   // $VF: renamed from: dA int
   private static int field_419;
   // $VF: renamed from: dB int
   private static int field_420;
   // $VF: renamed from: dC int
   private static int field_421;
   // $VF: renamed from: j javax.microedition.lcdui.Image
   private static Image field_422;
   // $VF: renamed from: k javax.microedition.lcdui.Image
   private static Image field_423;
   // $VF: renamed from: dD int
   private static int field_424;
   // $VF: renamed from: dE int
   private static int field_425;
   // $VF: renamed from: dF int
   private static int field_426;
   // $VF: renamed from: dG int
   private static int field_427;
   // $VF: renamed from: h int[]
   public static final int[] field_428 = new int[]{15, 13, 19, 20, 17, 18};

   // $VF: renamed from: u () void
   private static void method_8() {
      String var0 = field_28.getAppProperty("Lang-Codes");
      String var1 = field_28.getAppProperty("Lang-Names");
      if (var0 != null) {
         field_26 = method_10(var0);
      }

      if (var1 != null) {
         field_27 = method_10(var1);
      }
   }

   // $VF: renamed from: p (int) void
   private static void method_9(int var0) {
      field_25 = var0;
   }

   // $VF: renamed from: a (java.lang.String) java.lang.String[]
   private static String[] method_10(String var0) {
      int var1 = 1;

      for (int var2 = 0; var2 < var0.length(); var2++) {
         if (var0.charAt(var2) == ',') {
            var1++;
         }
      }

      String[] var6 = new String[var1];
      int var3 = 0;
      int var4 = 0;

      for (int var5 = 0; var5 < var0.length(); var5++) {
         if (var0.charAt(var5) == ',') {
            var6[var3] = method_11(var0.substring(var4, var5));
            var3++;
            var4 = var5 + 1;
         }
      }

      if (var0.length() != var4) {
         var6[var3] = method_11(var0.substring(var4, var0.length()));
      }

      return var6;
   }

   // $VF: renamed from: a (java.lang.String) java.lang.String
   private static String method_11(String var0) {
      StringBuffer var1 = new StringBuffer();
      int var3 = 0;

      while (var3 < var0.length()) {
         if (var0.charAt(var3) == '0' && var0.length() - var3 >= 4) {
            int var4 = 0;

            for (int var5 = 0; var5 < 4; var3++) {
               var4 = var4 * 16 + Character.digit(var0.charAt(var3), 16);
               var5++;
            }

            var1.append((char)var4);
         } else {
            var1.append(var0.charAt(var3));
            var3++;
         }
      }

      return var1.toString();
   }

   public class_3(Mapp var1) {
      super(false);
      this.setFullScreenMode(true);
      field_28 = var1;
      this.method_12();
      method_80();
      field_39 = new Random(System.currentTimeMillis());
      this.method_31();
      method_78();
      method_8();
      method_222();
      field_36 = System.currentTimeMillis();
      method_91();
      field_29 = new Thread(this);
      if (field_29 != null) {
         field_30 = true;
         field_29.start();
      }
   }

   // $VF: renamed from: a () void
   public final void method_12() {
      field_31 = this.getWidth();
      field_32 = this.getHeight();
      method_18(0, 0, field_31, field_32);
   }

   public final void hideNotify() {
      field_48.addElement(Integer.valueOf(1));
   }

   // $VF: renamed from: v () void
   private static void method_13() {
      method_227(0);
      clearHeldKeys();
   }

   public final synchronized void showNotify() {
      field_48.addElement(Integer.valueOf(2));
   }

   // $VF: renamed from: w () void
   private static void method_14() {
      method_227(1);
   }

   // $VF: renamed from: run () void
   public final void run() {
      while (field_30) {
         while (field_48.size() > 0) {
            int var1 = (Integer)field_48.elementAt(0);
            field_48.removeElementAt(0);
            if (var1 == 1) {
               method_13();
            } else if (var1 == 2) {
               method_14();
            }
         }

         if (field_33) {
            this.method_12();
            if (System.currentTimeMillis() > field_36 + 2000L) {
               field_33 = false;
            }
         } else {
            if (!field_34) {
               method_15();
            }

            if (this.isShown()) {
               this.method_16();
               this.flushGraphics();
            }

            if (System.currentTimeMillis() - field_36 > 1000L) {
               field_36 = System.currentTimeMillis();
               field_35 = 0;
            } else {
               field_35++;
            }

            field_37 = System.currentTimeMillis() - field_38;
            if (field_37 > 186L) {
               field_37 = 186L;
            }

            if (field_37 < 62L) {
               try {
                  Thread.sleep(62L - field_37);
               } catch (InterruptedException var2) {
               }

               field_37 = 62L;
            }

            field_38 = System.currentTimeMillis();
         }
      }

      field_28.method_409();
   }

   // $VF: renamed from: x () void
   private static final void method_15() {
      updateInputState();
      method_228();
   }

   public Graphics getGraphics() {
      if (field_49 == null) {
         field_49 = super.getGraphics();
      }

      field_49.setColor(0);
      field_49.setStrokeStyle(0);
      field_49.translate(-field_49.getTranslateX(), -field_49.getTranslateY());
      field_49.setFont(Font.getDefaultFont());
      return field_49;
   }

   // $VF: renamed from: y () void
   private final void method_16() {
      if (field_40 == null) {
         if (field_34) {
            method_15();
         }

         field_40 = this.getGraphics();
         field_40.setClip(0, 0, field_31, field_32);
         method_229(field_40);
         field_40 = null;
      }
   }

   // $VF: renamed from: b () void
   public static final void method_17() {
      method_81();
      method_79();
   }

   // $VF: renamed from: a (int, int, int, int) void
   public static final void method_18(int var0, int var1, int var2, int var3) {
      if (field_40 != null) {
         field_40.setClip(var0, var1, var2, var3);
      }
   }

   private final int mapKeyToInputMask(int keyCode) {
      if (keyCode == -6) {
         return 131072;
      }

      if (keyCode == -7) {
         return 262144;
      }

      switch (this.getGameAction(keyCode)) {
         case 1:
            return 1;
         case 2:
            return 4;
         case 3:
         case 4:
         case 7:
         default:
            switch (keyCode) {
               case 35:
                  return 65536;
               case 36:
               case 37:
               case 38:
               case 39:
               case 40:
               case 41:
               case 43:
               case 44:
               case 45:
               case 46:
               case 47:
               default:
                  return 0;
               case 42:
                  return 32768;
               case 48:
                  return 16384;
               case 49:
                  return 32;
               case 50:
                  return 1;
               case 51:
                  return 128;
               case 52:
                  return 4;
               case 53:
                  return 16;
               case 54:
                  return 8;
               case 55:
                  return 2048;
               case 56:
                  return 2;
               case 57:
                  return 8192;
            }
         case 5:
            return 8;
         case 6:
            return 2;
         case 8:
            return 16;
      }
   }

   public void keyPressed(int keyCode) {
      if ((keyCode = this.mapKeyToInputMask(keyCode)) != 0) {
         if ((heldKeysMask & keyCode) == 0) {
            newlyPressedKeysMask |= keyCode;
         }

         pendingKeysMask |= keyCode;
         heldKeysMask |= keyCode;
      }
   }

   public void keyReleased(int keyCode) {
      if ((keyCode = this.mapKeyToInputMask(keyCode)) != 0) {
         heldKeysMask &= ~keyCode;
      }
   }

   private static void updateInputState() {
      activeKeysMask = pendingKeysMask;
      justPressedKeysMask = newlyPressedKeysMask;
      newlyPressedKeysMask = 0;
      pendingKeysMask = pendingKeysMask & heldKeysMask;
   }

   public static boolean isKeyActive(int keyCode) {
      return (activeKeysMask & keyCode) != 0;
   }

   public static boolean isKeyJustPressed(int keyCode) {
      return (justPressedKeysMask & keyCode) != 0;
   }

   public static boolean hasNewKeyPress() {
      return justPressedKeysMask != 0;
   }

   public static void clearHeldKeys() {
      heldKeysMask = 0;
   }

   // $VF: renamed from: A () void
   private static final void method_25() {
      field_40.drawRegion(field_58, field_57[2], field_57[3], field_57[4], field_57[5], field_57[8], field_57[0] - field_57[6], field_57[1] - field_57[7], 20);
      field_58 = null;
   }

   // $VF: renamed from: B () void
   private static final void method_26() {
      var var0 = field_59[field_60];
      field_58 = field_59[field_60].field_1[var0.field_2];
   }

   // $VF: renamed from: q (int) void
   private static final void method_27(int var0) {
      boolean var1 = false;
      int var2;
      if (((var2 = field_55[var0]) & 511) == 90) {
         int var4 = field_57[6];
         field_57[6] = field_57[5] - field_57[7];
         field_57[7] = var4;
         var4 = field_57[4];
         field_57[4] = field_57[5];
         field_57[5] = var4;
         var1 = true;
      }

      if ((var2 & 16384) == 16384) {
         field_57[7] = field_57[5] - field_57[7];
      }

      if ((var2 & 8192) == 8192) {
         field_57[6] = field_57[4] - field_57[6];
      }

      if (var1) {
         int var6 = field_57[4];
         field_57[4] = field_57[5];
         field_57[5] = var6;
      }
   }

   // $VF: renamed from: r (int) int
   private static final int method_28(int var0) {
      int var1;
      if ((var1 = var0 & 511) > 90) {
         int var4;
         var0 = ((var4 = var0 ^ 16384) ^ 8192) & 24576;
         var1 -= 180;
         var0 |= var1;
      }

      for (int var3 = 0; var3 < field_55.length; var3++) {
         if (var0 == field_55[var3]) {
            return var3;
         }
      }

      return 0;
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public static final void method_29(Graphics var0) {
      if (!field_42) {
         field_41 = field_40;
         field_42 = true;
      }

      field_40 = var0;
   }

   // $VF: renamed from: d () void
   public static final void method_30() {
      if (field_42) {
         field_40 = field_41;
         field_41 = null;
         field_42 = false;
      }
   }

   // $VF: renamed from: C () void
   private void method_31() {
      field_59 = new SpriteData[field_23.length];

      for (int var1 = 0; var1 < field_23.length; var1++) {
         field_59[var1] = new SpriteData();
      }
   }

   // $VF: renamed from: a (int) void
   public static final void method_32(int var0) {
      SpriteData var1;
      if (!(var1 = field_59[var0]).field_4) {
         if (var1.field_1 == null) {
            var1.field_1 = new Image[field_24[var0] + 1];
            var1.field_3 = 0;
         }

         var1.field_1[0] = method_36(var0, 0);
         var1.field_3++;
         if (!var1.field_4) {
            try {
               InputStream var2 = method_88(field_428[var0]);
               DataInputStream var3;
               short var4 = (var3 = new DataInputStream(var2)).readShort();
               short var5 = var3.readShort();
               short var6 = var3.readShort();
               var1.field_5 = var3.readShort();
               int var7 = 0;
               if ((var1.field_5 & '耀') > 0) {
                  var7 = var3.readShort() << 1;
               }

               if ((var1.field_5 & 1) > 0) {
                  var1.field_6 = method_85(var4, var3);
               }

               if ((var1.field_5 & 2) > 0) {
                  var1.field_7 = method_85(var4, var3);
               }

               if ((var1.field_5 & 4) > 0) {
                  var1.field_8 = method_85(var4, var3);
               }

               if ((var1.field_5 & 8) > 0) {
                  var1.field_9 = method_85(var4, var3);
               }

               if ((var1.field_5 & 16) > 0) {
                  var1.field_10 = method_85(var4, var3);
               }

               if ((var1.field_5 & 32) > 0) {
                  var1.field_11 = method_85(var4, var3);
               }

               if ((var1.field_5 & '耀') > 0) {
                  method_85(var4, var3);
               }

               if ((var1.field_5 & 64) > 0) {
                  var1.field_12 = method_85(var5, var3);
               }

               if ((var1.field_5 & 128) > 0) {
                  method_85(var5, var3);
               }

               if ((var1.field_5 & 256) > 0) {
                  method_85(var5, var3);
               }

               if ((var1.field_5 & 512) > 0) {
                  method_85(var5, var3);
               }

               if (var6 > 0) {
                  method_85(var6, var3);
               }

               if (var7 > 0) {
                  method_85(var7, var3);
               }

               var3.close();
               var1.field_4 = true;
            } catch (Exception var8) {
            }
         }
      }
   }

   // $VF: renamed from: b (int) void
   public static final void method_33(int var0) {
      SpriteData var1;
      if ((var1 = field_59[var0]).field_4) {
         for (int var2 = 0; var2 < var1.field_1.length; var2++) {
            var1.field_1[var2] = null;
         }

         var1.field_3 = 0;
         var1.field_1 = null;
         if (field_60 == var0) {
            field_60 = -1;
            field_61 = 0;
         }

         var1.field_6 = null;
         var1.field_7 = null;
         var1.field_8 = null;
         var1.field_9 = null;
         var1.field_10 = null;
         var1.field_11 = null;
         var1.field_12 = null;
         method_39(var0);
         var1.field_4 = false;
      }
   }

   // $VF: renamed from: a (int, int) void
   public static final void method_34(int var0, int var1) {
      SpriteData var2;
      if (!(var2 = field_59[var0]).field_4) {
         field_60 = -1;
      } else {
         if (var2.field_1 != null && var2.field_1[var1] == null) {
            method_37(var1, var0);
            if (var2.field_1[var1] == null) {
               var2.field_1[var1] = var2.field_1[0];
            }
         }

         field_60 = var0;
         var2.field_2 = (byte)var1;
      }
   }

   // $VF: renamed from: a (java.lang.String) javax.microedition.lcdui.Image
   private static Image method_35(String var0) {
      try {
         return Image.createImage(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   // $VF: renamed from: a (int, int) javax.microedition.lcdui.Image
   private static final Image method_36(int var0, int var1) {
      Image var2 = null;
      if (var1 == 0) {
         var2 = method_35("/" + field_23[var0] + ".png");
         method_91();
      } else {
         var1--;
         byte[] var3 = method_84("/" + field_23[var0] + ".png");
         byte[] var4 = method_84("/" + field_23[var0] + ".pal");
         if (var1 >= var4[0]) {
            return null;
         }

         int var5 = method_86(var4, 1);
         int var6 = method_86(var4, 5);
         int var7 = method_86(var4, 9 + var1 * 4);

         for (int var8 = 0; var8 < var5; var8++) {
            var3[var6 + var8] = var4[var7 + var8];
         }

         try {
            var2 = Image.createImage(var3, 0, var3.length);
         } catch (Exception var9) {
         }

         method_91();
      }

      return var2;
   }

   // $VF: renamed from: b (int, int) void
   public static final void method_37(int var0, int var1) {
      SpriteData var2;
      if ((var2 = field_59[var1]) != null) {
         if (var2.field_1[var0] == null) {
            var2.field_1[var0] = method_36(var1, var0);
            var2.field_3++;
         }
      }
   }

   // $VF: renamed from: c (int) boolean
   public static final boolean method_38(int var0) {
      SpriteData var1;
      if ((var1 = field_59[var0]).field_17 != null) {
         return false;
      }

      try {
         boolean var2 = false;
         InputStream var4 = method_88(field_428[var0] + 1);
         DataInputStream var5;
         (var5 = new DataInputStream(var4)).readShort();
         var1.field_13 = var5.readShort();
         var1.field_14 = new int[var1.field_13];

         for (int var12 = 0; var12 < var1.field_13; var12++) {
            int var7 = var5.readByte() << 16 & 16777215;
            int var8 = var5.readByte() << 8 & 65535;
            int var9 = var5.readByte() & 255;
            var1.field_14[var12] = var7 + var8 + var9 | 0xFF000000;
         }

         var1.field_15 = var5.readShort();
         var1.field_16 = new short[var1.field_15 + 1];
         var1.field_16[0] = 0;

         for (int var13 = 1; var13 <= var1.field_15; var13++) {
            var1.field_16[var13] = var5.readShort();
         }

         short var10 = var1.field_16[var1.field_15];
         var1.field_17 = new short[var10];

         for (int var14 = 0; var14 < var10; var14++) {
            var1.field_17[var14] = var5.readShort();
         }

         var1.field_4 = true;
         var5.close();
         return true;
      } catch (Exception var11) {
         return false;
      }
   }

   // $VF: renamed from: c (int) void
   public static final void method_39(int var0) {
      SpriteData var1;
      (var1 = field_59[var0]).field_13 = 0;
      var1.field_14 = null;
      var1.field_15 = 0;
      var1.field_16 = null;
      var1.field_17 = null;
   }

   // $VF: renamed from: b (int, int, int, int) void
   public static final void method_40(int var0, int var1, int var2, int var3) {
      var var4 = field_59[field_60];
      if (var2 < var4.field_15) {
         method_41(var0, var1, var3, var4.field_17, var4.field_16[var2], var4.field_16[var2 + 1]);
      }
   }

   // $VF: renamed from: a (int, int, int, short[], int, int) void
   public static final void method_41(int var0, int var1, int var2, short[] var3, int var4, int var5) {
      while (var4 < var5) {
         var4 += method_42(var0, var1, var3, var4, var2);
      }
   }

   // $VF: renamed from: a (int, int, short[], int, int) int
   private static final int method_42(int var0, int var1, short[] var2, int var3, int var4) {
      var var5 = field_59[field_60];
      int var8 = 0;
      int var9 = 0;
      int var7;
      if ((var7 = var2[var3] & 8191) >= 4096) {
         return 2;
      }

      int var6 = (var2[var3++] & '\ue000') >> 13;
      field_57[0] = var2[var3] >> 8;
      field_57[1] = var2[var3] & 255;
      if (field_57[1] > 127) {
         field_57[1] = field_57[1] - 256;
      }

      field_57[2] = var5.field_6[var7];
      field_57[3] = var5.field_7[var7];
      field_57[4] = var5.field_8[var7];
      field_57[5] = var5.field_9[var7];
      field_57[6] = 0;
      field_57[7] = 0;
      field_57[8] = var4;
      method_26();
      if (var4 != 0 || var6 != 0) {
         var8 = method_28(var4);
         method_43(var9 = field_55[var8]);
         int var12;
         method_27(var12 = method_47(var8, var6));
         field_57[8] = field_56[var12];
      }

      field_57[0] = field_57[0] + var0;
      field_57[1] = field_57[1] + var1;
      method_25();
      return 2;
   }

   // $VF: renamed from: r (int) void
   private static final void method_43(int var0) {
      int var1;
      if ((var1 = var0 & 511) == 90) {
         int var2 = field_57[1];
         field_57[1] = field_57[0];
         field_57[0] = -var2;
      }

      if ((var0 & 16384) > 0) {
         field_57[1] = -field_57[1];
      }

      if ((var0 & 8192) > 0) {
         field_57[0] = -field_57[0];
      }
   }

   // $VF: renamed from: a (int, int, int, int[]) void
   private static void method_44(int var0, int var1, int var2, int[] var3) {
      for (int var4 = 0; var4 < var3.length; var4++) {
         var3[var4] = 0;
      }

      SpriteData var17;
      short[] var5 = (var17 = field_59[var0]).field_17;
      int var6 = var17.field_16[var1];
      short var7 = var17.field_16[var1 + 1];

      while (var6 < var7) {
         short var9;
         int var10;
         if ((var10 = (var9 = var5[var6++]) & 8191) > 4095) {
            var6++;
         } else {
            int var11 = var9 >> 13 & 7;
            int var12 = var5[var6] >> 8;
            int var13;
            if ((var13 = var5[var6++] & 255) > 127) {
               var13 -= 256;
            }

            short var14 = var17.field_8[var10];
            short var15 = var17.field_9[var10];
            if ((var11 & 1) > 0) {
               short var16 = var14;
               var14 = var15;
               var15 = var16;
            }

            if (var11 == 1 || var11 == 2 || var11 == 4 || var11 == 7) {
               var12 -= var14;
            }

            if (var11 == 2 || var11 == 3 || var11 == 6 || var11 == 7) {
               var13 -= var15;
            }

            method_45(var3, var12, var13, var12 + var14, var13 + var15);
         }
      }

      var3[2] -= var3[0];
      var3[3] -= var3[1];
      method_46(var3, var2);
   }

   // $VF: renamed from: a (int[], int, int, int, int) void
   private static void method_45(int[] var0, int var1, int var2, int var3, int var4) {
      if (var0[0] != var0[2] && var0[1] != var0[3]) {
         if (var1 < var0[0]) {
            var0[0] = var1;
         }

         if (var2 < var0[1]) {
            var0[1] = var2;
         }

         if (var3 > var0[2]) {
            var0[2] = var3;
         }

         if (var4 > var0[3]) {
            var0[3] = var4;
         }
      } else {
         var0[0] = var1;
         var0[1] = var2;
         var0[2] = var3;
         var0[3] = var4;
      }
   }

   // $VF: renamed from: a (int[], int) void
   private static void method_46(int[] var0, int var1) {
      if (var1 != 0) {
         if (((var1 = field_55[method_28(var1)]) & 511) == 90) {
            int var2 = var0[1];
            var0[1] = var0[0];
            var0[0] = -var2;
            var2 = var0[2];
            var0[2] = var0[3];
            var0[3] = var2;
         }

         if ((var1 & 8192) == 8192) {
            var0[0] = -var0[0] - var0[2];
         }

         if ((var1 & 16384) == 16384) {
            var0[1] = -var0[1] - var0[3];
         }
      }
   }

   // $VF: renamed from: c (int, int) int
   private static final int method_47(int var0, int var1) {
      if (var1 == 0) {
         return var0;
      }

      int var2 = field_55[var0];
      int var3 = field_55[var1];
      int var4;
      if ((var4 = (var2 & 511) + (var3 & 511)) > 90) {
         int var5;
         var2 = (var5 = var2 ^ 16384) ^ 8192;
         var4 -= 180;
      }

      int var6;
      var2 = (var6 = var2 & 24576) | var4;
      if ((var3 & 16384) > 0) {
         var2 ^= 16384;
      }

      if ((var3 & 8192) > 0) {
         var2 ^= 8192;
      }

      return method_28(var2);
   }

   // $VF: renamed from: c (int, int) void
   public static final void method_48(int var0, int var1) {
      field_44 = var1;
      field_43 = var0;
   }

   // $VF: renamed from: c (int, int, int) int
   private static final int method_49(int var0, int var1, int var2) {
      if (var0 == -2) {
         return 0;
      }

      if (var0 == -1) {
         return 5;
      }

      SpriteData var3;
      short var4 = (var3 = field_59[field_43]).field_12[var0];
      field_57[0] = var1;
      field_57[1] = var2;
      field_57[2] = var3.field_6[var4];
      field_57[3] = var3.field_7[var4];
      field_57[4] = var3.field_8[var4];
      field_57[5] = var3.field_9[var4];
      field_57[6] = var3.field_10[var4];
      field_57[7] = var3.field_11[var4];
      field_57[8] = 0;
      int var5 = field_60;
      int var6 = field_61;
      method_34(field_43, field_44);
      method_26();
      method_25();
      if (var5 != -1) {
         method_34(var5, var6);
      }

      return field_57[4] - field_57[6];
   }

   // $VF: renamed from: a (int) byte[]
   public static final byte[] method_50(int var0) {
      int var2 = var0;

      while (field_45[var2] != -2) {
         var2++;
      }

      int var3;
      byte[] var1 = new byte[(var3 = var2 - var0) + 1];
      System.arraycopy(field_45, var0, var1, 0, var3);
      var1[var1.length - 1] = -2;
      return var1;
   }

   // $VF: renamed from: b (int) byte[]
   public static final byte[] method_51(int var0) {
      return method_50(field_47[var0]);
   }

   // $VF: renamed from: a (int, int, int, int, int) void
   public static final void method_52(int var0, int var1, int var2, int var3, int var4) {
      if (var2 != -1) {
         var2 += var0;
      }

      if (field_62) {
         var1 += 14;
      }

      for (int var5 = var3; var5 <= var4 || var4 == -1; var5++) {
         if (field_45[var5] == -1) {
            var0 += 5;
         } else {
            if (field_45[var5] == -2) {
               return;
            }

            if (field_45[var5] == -3) {
               return;
            }

            var0 += method_49(field_45[var5] & 255, var0, var1) + 1;
            if (var2 != -1 && var0 > var2) {
               method_49(8, var0, var1);
               return;
            }
         }
      }
   }

   // $VF: renamed from: c (int, int, int, int) void
   public static final void method_53(int var0, int var1, int var2, int var3) {
      method_52(var0, var1, -1, var2, var3);
   }

   // $VF: renamed from: a (int, int, int) void
   public static final void method_54(int var0, int var1, int var2) {
      method_53(var0, var1, field_47[var2], -1);
   }

   // $VF: renamed from: a (byte[]) int
   public static final int method_55(byte[] var0) {
      field_45 = var0;
      int var1 = method_66(0);
      field_45 = field_46;
      return var1;
   }

   // $VF: renamed from: a (byte[], int, int) void
   public static final void method_56(byte[] var0, int var1, int var2) {
      field_45 = var0;
      method_53(var1, var2, 0, var0.length - 1);
      field_45 = field_46;
   }

   // $VF: renamed from: a (java.lang.String) byte[]
   public static byte[] method_57(String var0) {
      char[] var1 = var0.toCharArray();
      char[] var2 = new char[]{
         'Á',
         'É',
         'Í',
         'Ó',
         'Ú',
         'á',
         'é',
         'í',
         'ó',
         'ú',
         'ü',
         'Ñ',
         'ñ',
         '*',
         '#',
         '¿',
         '¡',
         '"',
         '$',
         '&',
         ';',
         '=',
         '@',
         '[',
         '\\',
         ']',
         '^',
         '_',
         '`',
         '{',
         '|',
         '}',
         '~',
         '¢',
         '£',
         '¤',
         '¥',
         '¦',
         '§',
         '¨',
         '©',
         'ª',
         '«',
         '¬',
         '®',
         '°',
         '±',
         '²',
         '³',
         '´',
         'µ',
         '·',
         '¸',
         '¹',
         'º',
         '»',
         'À',
         'Â',
         'Ã',
         'Ä',
         'Å',
         'Æ',
         'Ç',
         'È',
         'Ê',
         'Ë',
         'Ì',
         'Î',
         'Ï',
         'Ð',
         'Ò',
         'Ô',
         'Õ',
         'Ö',
         '×',
         'Ø',
         'Ù',
         'Û',
         'Ü',
         'Ý',
         'ß',
         'à',
         'â',
         'ã',
         'ä',
         'å',
         'æ',
         'ç',
         'è',
         'ê',
         'ë',
         'ì',
         'î',
         'ï',
         'ð',
         'ò',
         'ô',
         'õ',
         'ö',
         '÷',
         'ø',
         'ù',
         'û',
         'ý',
         'Þ',
         'þ',
         'ÿ'
      };
      byte[] var3 = new byte[var1.length + 1];

      for (int var4 = 0; var4 < var1.length; var4++) {
         var3[var4] = -1;
         if (var1[var4] >= '0' && var1[var4] <= '9') {
            var3[var4] = (byte)(var1[var4] - '0' + 10);
         } else if (var1[var4] >= 'A' && var1[var4] <= 'Z') {
            var3[var4] = (byte)(var1[var4] - 'A' + 24);
         } else if (var1[var4] >= 'a' && var1[var4] <= 'z') {
            var3[var4] = (byte)(var1[var4] - 'a' + 50);
         } else if (var1[var4] >= '+' && var1[var4] <= ':') {
            var3[var4] = (byte)(var1[var4] - '0' + 10);
         } else {
            switch (var1[var4]) {
               case '!':
                  var3[var4] = 0;
                  break;
               case '%':
                  var3[var4] = 1;
                  break;
               case '\'':
               case '(':
               case ')':
                  var3[var4] = (byte)(var1[var4] - '\'' + 2);
                  break;
               case '<':
                  var3[var4] = 21;
                  break;
               case '>':
                  var3[var4] = 22;
                  break;
               case '?':
                  var3[var4] = 23;
                  break;
               default:
                  for (int var5 = 0; var5 < var2.length; var5++) {
                     if (var1[var4] == var2[var5]) {
                        var3[var4] = (byte)(76 + var5);
                     }
                  }
            }
         }
      }

      var3[var3.length - 1] = -2;
      return var3;
   }

   // $VF: renamed from: b (int, int, int, int, int, int, int, int) int
   private static int method_58(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var5 >= field_45.length) {
         var5 = field_45.length - 1;
      }

      int var8 = 0;
      int var9 = var4;
      int var10 = 0;
      var1 += 14;
      int var11 = var1;

      while (var4 <= var5 && var1 - var11 + 16 <= var3) {
         if (field_45[var4] == -1) {
            var10 += 5;

            while (field_45[var4] == -1) {
               var4++;
            }
         } else if (field_45[var4] == -2) {
            if (var8 >= var6) {
               method_59(var0, var1, var2, var10, var9, var4, var7);
               var1 += 16;
            }

            var8++;
            var9 = ++var4;
            var10 = 0;
         } else {
            int var12 = var4;

            while (field_45[var12] != -1 && field_45[var12] != -2) {
               var12++;
            }

            int var13 = method_65(var4, var12);
            if (var10 + var13 > var2) {
               if (var8 >= var6) {
                  method_59(var0, var1, var2, var10, var9, var4, var7);
                  var1 += 16;
               }

               var8++;
               var9 = var4;
               var10 = 0;
            }

            var10 += var13;
            var4 = var12;
         }
      }

      return var8 - var6;
   }

   // $VF: renamed from: a (int, int, int, int, int, int, int) void
   private static void method_59(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if ((var6 & 1) > 0) {
         method_60(var4, var5, var0 + (var2 - var3 >> 1), var1);
      } else if ((var6 & 4) > 0) {
         method_60(var4, var5, var0, var1);
      } else {
         if ((var6 & 8) > 0) {
            method_60(var4, var5, var0 + var2 - var3, var1);
         }
      }
   }

   // $VF: renamed from: j (int, int, int, int) void
   private static void method_60(int var0, int var1, int var2, int var3) {
      while (var0 < var1) {
         if (field_45[var0] == -1) {
            var2 += 5;

            while (field_45[var0] == -1) {
               var0++;
            }
         } else {
            while (field_45[var0] != -1 && field_45[var0] != -2) {
               var2 += method_49(field_45[var0] & 255, var2, var3);
               var2++;
               var0++;
            }
         }
      }
   }

   // $VF: renamed from: a (int, int, int, int) int
   public static int method_61(int var0, int var1, int var2, int var3) {
      return method_58(0, 0, var0, 1000, field_47[var1], field_47[var2], var3, 0);
   }

   // $VF: renamed from: a (int, int, int, int, int, int, int, int) int
   public static int method_62(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return method_58(var0, var1, var2, var3, field_47[var4], field_47[var5], var6, var7);
   }

   // $VF: renamed from: a (java.lang.String) void
   public static final void method_63(String var0) {
      field_46 = method_84("/" + field_26[field_25] + "_" + var0 + ".tx");
      int var1 = 0;

      for (int var2 = 0; var2 < field_46.length; var2++) {
         if (field_46[var2] == -2) {
            var1++;
         }
      }

      field_47 = new int[var1 + 1];
      field_47[0] = 0;
      var1 = 1;

      for (int var4 = 0; var4 < field_46.length; var4++) {
         if (field_46[var4] == -2) {
            field_47[var1++] = var4 + 1;
         }
      }

      field_45 = field_46;
   }

   // $VF: renamed from: e () void
   public static final void method_64() {
      field_45 = null;
      field_46 = null;
      field_47 = null;
   }

   // $VF: renamed from: a (int, int) int
   public static final int method_65(int var0, int var1) {
      var var2 = field_59[field_43];
      int var3 = 0;

      for (int var4 = var0; var4 < var1; var4++) {
         var3 += var2.field_8[field_45[var4] & 0xFF] - var2.field_10[field_45[var4] & 0xFF] + 1;
      }

      return var3;
   }

   // $VF: renamed from: a (int) int
   public static final int method_66(int var0) {
      var var1 = field_59[field_43];
      int var2 = 0;

      for (int var3 = var0; field_45[var3] != -2; var3++) {
         if (field_45[var3] == -1) {
            var2 += 5;
         } else {
            var2 += var1.field_8[field_45[var3] & 0xFF] - var1.field_10[field_45[var3] & 0xFF] + 1;
         }
      }

      return var2;
   }

   // $VF: renamed from: b (int) int
   public static int method_67(int var0) {
      return method_66(field_47[var0]);
   }

   // $VF: renamed from: s (int) void
   private static void method_68(int var0) {
      if (field_67 >= 0) {
         method_70();
      }

      try {
         field_69 = Manager.createPlayer(class_3.class.getResourceAsStream(field_63[var0]), field_64[var0]);
      } catch (Exception var2) {
      }
   }

   // $VF: renamed from: a (int, boolean) void
   public static void method_69(int var0, boolean var1) {
      if (var0 >= 0 && var0 < field_63.length && field_65) {
         method_68(var0);
         if (field_69 != null) {
            try {
               field_69.realize();
            } catch (Exception var8) {
            }

            try {
               field_69.setLoopCount(var1 ? -1 : 1);
            } catch (Exception var7) {
            }

            try {
               field_69.prefetch();
            } catch (Exception var6) {
               method_71(field_69);
               return;
            }

            try {
               field_69.setMediaTime(-1L);
            } catch (Exception var5) {
            }

            try {
               field_69.start();
            } catch (Exception var4) {
               method_71(field_69);
               return;
            }

            try {
               VolumeControl var2;
               if ((var2 = (VolumeControl)field_69.getControl("VolumeControl")) != null) {
                  var2.setLevel(field_66);
               }
            } catch (Exception var3) {
            }

            field_67 = var0;
            field_68 = var1;
            System.currentTimeMillis();
         }
      }
   }

   // $VF: renamed from: f () void
   public static void method_70() {
      if (field_67 >= 0) {
         method_71(field_69);
         field_67 = -1;
      }
   }

   // $VF: renamed from: a (javax.microedition.media.Player) void
   private static void method_71(Player var0) {
      if (var0 != null) {
         var0.close();
      }
   }

   // $VF: renamed from: a () int
   public static int method_72() {
      return field_67;
   }

   // $VF: renamed from: b () boolean
   public static boolean method_73() {
      return field_67 < 0 ? false : field_68;
   }

   // $VF: renamed from: d (int) boolean
   public static boolean method_74(int var0) {
      if (var0 >= 0 && var0 < field_63.length) {
         method_68(var0);
         if (field_69 == null) {
            return false;
         }

         try {
            field_69.realize();
            VolumeControl var1 = (VolumeControl)field_69.getControl("VolumeControl");
            method_71(field_69);
            return var1 != null;
         } catch (Exception var2) {
            method_71(field_69);
            return false;
         }
      } else {
         return false;
      }
   }

   // $VF: renamed from: d (int) void
   public static void method_75(int var0) {
      try {
         field_66 = Math.max(0, Math.min(var0, 100));
         VolumeControl var1;
         if (field_67 >= 0 && (var1 = (VolumeControl)field_69.getControl("VolumeControl")) != null) {
            var1.setLevel(field_66);
         }
      } catch (Exception var2) {
      }
   }

   // $VF: renamed from: c () boolean
   public static boolean method_76() {
      return field_65;
   }

   // $VF: renamed from: a (boolean) void
   public static void method_77(boolean var0) {
      field_65 = var0;
      if (!var0 && field_67 >= 0) {
         method_70();
      }
   }

   // $VF: renamed from: D () void
   private static void method_78() {
      field_67 = -1;
   }

   // $VF: renamed from: E () void
   private static void method_79() {
      method_70();
   }

   // $VF: renamed from: F () void
   private static final void method_80() {
      field_71 = new byte[512];
      field_71[0] = -1;

      try {
         field_70 = RecordStore.openRecordStore("House", true);
         if (field_70.getNumRecords() != 0) {
            method_82();
            return;
         }

         field_70.addRecord(field_71, 0, field_71.length);
      } catch (Exception var1) {
         field_70 = null;
      }
   }

   // $VF: renamed from: G () void
   private static void method_81() {
      try {
         method_83();
         field_70.closeRecordStore();
      } catch (Exception var1) {
      }

      field_71 = null;
   }

   // $VF: renamed from: g () void
   public static final void method_82() {
      try {
         field_71 = field_70.getRecord(1);
      } catch (Exception var1) {
      }
   }

   // $VF: renamed from: d () boolean
   public static final boolean method_83() {
      try {
         field_70.setRecord(1, field_71, 0, field_71.length);
         return true;
      } catch (Exception var1) {
         return false;
      }
   }

   // $VF: renamed from: b (java.lang.String) byte[]
   public static final byte[] method_84(String var0) {
      byte[] var3 = null;

      try {
         InputStream var2 = class_3.class.getResourceAsStream(var0);
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();

         for (int var4 = var2.read(); var4 >= 0; var4 = var2.read()) {
            var1.write(var4);
         }

         var3 = var1.toByteArray();
      } catch (Exception var5) {
      }

      return var3;
   }

   // $VF: renamed from: a (int, java.io.DataInputStream) short[]
   public static final short[] method_85(int var0, DataInputStream var1) {
      short[] var2 = null;

      try {
         var2 = new short[var0];

         for (int var3 = 0; var3 < var0; var3++) {
            var2[var3] = var1.readShort();
         }
      } catch (Exception var4) {
      }

      return var2;
   }

   // $VF: renamed from: a (byte[], int) int
   public static final int method_86(byte[] var0, int var1) {
      return var1 >= 0 && var1 + 3 < var0.length
         ? (var0[var1] & 0xFF) << 24 | (var0[var1 + 1] & 0xFF) << 16 | (var0[var1 + 2] & 0xFF) << 8 | var0[var1 + 3] & 0xFF
         : 0;
   }

   // $VF: renamed from: a (int, java.io.InputStream) void
   public static final void method_87(int var0, InputStream var1) {
      try {
         long var2 = 0L;
         long var4 = 0L;

         do {
            var2 = var1.skip(var0 - var4);
         } while ((var4 += var2) < var0);
      } catch (Exception var6) {
      }
   }

   // $VF: renamed from: a (int) java.io.InputStream
   public static final InputStream method_88(int var0) {
      try {
         return class_3.class.getResourceAsStream("/" + field_169[var0]);
      } catch (Exception var2) {
         return null;
      }
   }

   // $VF: renamed from: c (int) byte[]
   public static final byte[] method_89(int var0) {
      return method_84("/" + field_169[var0]);
   }

   // $VF: renamed from: a (int) javax.microedition.lcdui.Image
   public static final Image method_90(int var0) {
      try {
         return Image.createImage("/" + field_169[var0]);
      } catch (IOException var2) {
         return null;
      }
   }

   // $VF: renamed from: h () void
   public static final void method_91() {
      System.gc();
      Runtime.getRuntime().gc();
   }

   // $VF: renamed from: b (int, int) int
   public static final int method_92(int var0, int var1) {
      return (field_39.nextInt() >>> 1) % (var1 + 1 - var0) + var0;
   }

   // $VF: renamed from: d (int, int, int, int) void
   public static void method_93(int var0, int var1, int var2, int var3) {
      field_156 = var0 + field_72[var3];
      field_157 = var1 + field_73[var3];
      field_158 = var2 + field_74[var3];
   }

   // $VF: renamed from: b (int, int, int) void
   public static void method_94(int var0, int var1, int var2) {
      method_151(var0, var2 * field_72[var1], var2 * field_73[var1], var2 * field_74[var1]);
   }

   // $VF: renamed from: c (int) int
   public static final int method_95(int var0) {
      if (var0 == 8) {
         return 9;
      } else {
         return var0 == 9 ? 8 : var0 + 4 & 7;
      }
   }

   // $VF: renamed from: a (int, int, int, boolean) int
   public static final int method_96(int var0, int var1, int var2, boolean var3) {
      if (var2 == 0) {
         return 0;
      }

      int var4 = var2;
      if (var2 < 0) {
         var4 = -var2;
         var1 = method_95(var1);
      }

      int var5 = field_72[var1];
      int var6 = field_73[var1];
      int var7 = field_74[var1];
      int var8 = field_109[var0] - (field_113[var0] >> 1);
      int var9 = field_109[var0] + (field_113[var0] >> 1) + 1;
      int var10 = field_110[var0] - (field_114[var0] >> 1);
      int var11 = field_110[var0] + (field_114[var0] >> 1) + 1;
      short var12 = field_111[var0];
      int var13 = field_111[var0] + field_115[var0] * 64 - 1;
      int var14 = var5;
      int var15 = var6;
      int var16 = var7;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      if (var14 != 0) {
         var17 = method_141(var8 + var14) - 1;
         var18 = method_141(var9 + var14) - 1;
      }

      if (var15 != 0) {
         var19 = method_141(var10 + var15) - 1;
         var20 = method_141(var11 + var15) - 1;
      }

      if (var16 != 0) {
         var21 = method_141(var12 + var16) - 1;
         var22 = method_141(var13 + var16) - 1;
      }

      while (var4 > 0) {
         int var23 = method_141(var8 + var14);
         int var24 = method_141(var9 + var14);
         int var25 = method_141(var10 + var15);
         int var26 = method_141(var11 + var15);
         int var27 = method_141(var12 + var16);
         int var28 = method_141(var13 + var16);
         boolean var29 = false;
         if (var14 != 0 && (var17 != var23 || var18 != var24)) {
            var29 = true;
            var17 = var23;
            var18 = var24;
         }

         if (var15 != 0 && !var29 && (var19 != var25 || var20 != var26)) {
            var29 = true;
            var19 = var25;
            var20 = var26;
         }

         if (var16 != 0 && !var29 && (var21 != var27 || var22 != var28)) {
            var29 = true;
            var21 = var27;
            var22 = var28;
         }

         if (var29) {
            while (var27 <= var28) {
               for (int var30 = var25; var30 <= var26; var30++) {
                  for (int var31 = var23; var31 <= var24; var31++) {
                     if (method_155(var31, var30, var27)) {
                        return var2 > 0 ? var2 - var4 : var2 + var4;
                     }
                  }
               }

               var27++;
            }
         }

         if (var3) {
            for (int var32 = 0; var32 < field_108.length; var32++) {
               if (var32 != var0
                  && (field_108[var32] & 8) != 0
                  && field_112[var32]
                  && method_154(var8 + var14, var10 + var15, var12 + var16, var9 - var8, var11 - var10, var13 - var12, var32)) {
                  return var2 > 0 ? var2 - var4 : var2 + var4;
               }
            }
         }

         var14 += var5;
         var15 += var6;
         var16 += var7;
         var4--;
      }

      return var2 > 0 ? var2 - var4 : var2 + var4;
   }

   // $VF: renamed from: e (int, int, int, int) void
   public static void method_97(int var0, int var1, int var2, int var3) {
      int var4 = field_156;
      int var5 = field_157;
      int var6 = field_158;
      int var7;
      if ((var7 = method_96(var0, var1, var2, true)) > 0) {
         method_94(var0, var1, var7);
         field_156 = var4;
         field_157 = var5;
         field_158 = var6;
      } else {
         int var8 = (var1 & 1) > 0 ? 1 : 2;
         int var9 = var1 - var8 & 7;
         int var10 = var1 + var8 & 7;
         if ((var1 & 1) == 0) {
            int var11 = 0;
            int var12 = 0;
            int var13 = 0;
            if (var1 == 0) {
               var11 = field_109[var0] + (field_113[var0] >> 1) + 1;
               var12 = field_110[var0];
               var13 = var11 & 63;
            } else if (var1 == 4) {
               var11 = field_109[var0] - (field_113[var0] >> 1);
               var12 = field_110[var0];
               var13 = 64 - (var11 & 63);
            } else if (var1 == 2) {
               var11 = field_109[var0];
               var13 = (var12 = field_110[var0] + (field_114[var0] >> 1) + 1) & 63;
            } else if (var1 == 6) {
               var11 = field_109[var0];
               var12 = field_110[var0] - (field_114[var0] >> 1);
               var13 = 64 - (var12 & 63);
            }

            int var14 = 0;
            field_156 = method_141(var11);
            field_157 = method_141(var12);
            field_158 = method_141(field_111[var0]);
            method_93(field_156, field_157, field_158, var9);

            while (true) {
               if (method_155(field_156, field_157, 1)) {
                  var14 = -1;
                  break;
               }

               if (!method_155(field_156 + field_72[var1], field_157 + field_73[var1], 1)) {
                  break;
               }

               method_93(field_156, field_157, field_158, var9);
               var14++;
            }

            int var15 = 0;
            if (var1 == 0) {
               var11 = field_109[var0] - (field_113[var0] >> 1);
               var12 = field_110[var0];
               var15 = 64 - (var11 & 63);
            } else if (var1 == 4) {
               var11 = field_109[var0] + (field_113[var0] >> 1) + 1;
               var12 = field_110[var0];
               var15 = var11 & 63;
            } else if (var1 == 2) {
               var11 = field_109[var0];
               var12 = field_110[var0] - (field_114[var0] >> 1);
               var15 = 64 - (var12 & 63);
            } else if (var1 == 6) {
               var11 = field_109[var0];
               var15 = (var12 = field_110[var0] + (field_114[var0] >> 1) + 1) & 63;
            }

            int var16 = 0;
            field_156 = method_141(var11);
            field_157 = method_141(var12);
            field_158 = method_141(field_111[var0]);
            method_93(field_156, field_157, field_158, var10);

            while (true) {
               if (method_155(field_156, field_157, 1)) {
                  var16 = -1;
                  break;
               }

               if (!method_155(field_156 + field_72[var1], field_157 + field_73[var1], 1)) {
                  break;
               }

               method_93(field_156, field_157, field_158, var10);
               var16++;
            }

            label79:
            if (var14 != -1 || var16 != -1) {
               if (var14 != -1) {
                  if (var16 == -1) {
                     var1 = var9;
                     break label79;
                  }

                  if (var14 < var16) {
                     var1 = var9;
                     break label79;
                  }

                  if (var14 <= var16 && var13 < var15) {
                     var1 = var9;
                     break label79;
                  }
               }

               var1 = var10;
            }

            var7 = method_96(var0, var1, var3, true);
            method_94(var0, var1, var7);
         } else {
            var7 = method_96(var0, var9, var3, true);
            int var19 = method_96(var0, var10, var3, true);
            if (Math.abs(var7) > Math.abs(var19)) {
               method_94(var0, var9, var7);
            } else {
               method_94(var0, var10, var19);
            }
         }

         field_156 = var4;
         field_157 = var5;
         field_158 = var6;
      }
   }

   // $VF: renamed from: i () void
   public static void method_98() {
      field_105 = new byte[64];
      field_106 = new byte[64];
      field_107 = new byte[64];
      field_108 = new byte[64];
      field_109 = new short[64];
      field_110 = new short[64];
      field_111 = new short[64];
      field_112 = new boolean[64];
      field_113 = new short[64];
      field_114 = new short[64];
      field_115 = new byte[64];
      field_116 = new byte[64];
      field_117 = new byte[64];
      field_118 = new byte[64];
      field_119 = new byte[64];
      field_120 = new short[64];
      field_121 = new short[64];
      field_122 = new short[64];
      method_119();
      field_165 = 10;
      field_166 = 10;
      field_79 = true;
      field_150 = field_75;
      field_151 = field_76;
      method_99();
   }

   // $VF: renamed from: j () void
   public static void method_99() {
      for (int var0 = 0; var0 < 64; var0++) {
         field_108[var0] = 0;
      }
   }

   // $VF: renamed from: d (int, int) void
   public static void method_100(int var0, int var1) {
      field_165 = var0;
      field_166 = var1;
   }

   // $VF: renamed from: k () void
   public static void method_101() {
      field_75 = 0;
      field_76 = 0;
      field_77 = 0;
      field_78 = 0;
      field_150 = field_75;
      field_151 = field_76;
      if (field_153 == null) {
         field_153 = Image.createImage(field_165, field_166);
         field_154 = field_153.getGraphics();
         field_154.setColor(0, 0, 0);
      }
   }

   // $VF: renamed from: l () void
   public static void method_102() {
      field_153 = null;
      field_154 = null;
   }

   // $VF: renamed from: e (int) void
   public static void method_103(int var0) {
      field_80 = var0;
   }

   // $VF: renamed from: f (int) void
   public static void method_104(int var0) {
      field_99 = var0;
   }

   // $VF: renamed from: H () void
   private static void method_105() {
      field_228.clipRect(0, 0, field_167, field_168);
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics) void
   public static void method_106(Graphics var0) {
      if (field_153 != null) {
         int var1 = var0.getClipX();
         int var2 = var0.getClipY();
         int var3 = var0.getClipWidth();
         int var4 = var0.getClipHeight();
         field_167 = var3;
         field_168 = var4;
         int var5 = field_165;
         int var6 = field_166;
         method_111(var5, var6);
         if (field_155) {
            method_108();
         }

         method_29(field_154);
         method_110();
         int var7 = field_148;
         int var8 = field_149;
         if (field_129) {
            if (field_149 == 0) {
               method_129(field_154, field_124, field_125, field_128, 0, field_126, field_127);
            } else {
               method_129(field_154, field_124, var8, field_128, 0, field_126, var6 - var8);
               method_129(field_154, field_124, 0, field_128, var6 - var8, field_126, var8);
            }
         }

         if (field_145) {
            if (field_149 == 0) {
               method_129(field_154, field_130, field_131, field_134, 0, field_132, field_133);
            } else {
               method_129(field_154, field_130, var8, field_134, 0, field_132, var6 - var8);
               method_129(field_154, field_130, 0, field_134, var6 - var8, field_132, var8);
            }
         }

         if (field_146) {
            if (field_148 == 0) {
               method_129(field_154, field_135, field_136, 0, field_139, field_137, field_138);
            } else {
               method_129(field_154, var7, field_136, 0, field_139, var5 - var7, field_138);
               method_129(field_154, 0, field_136, var5 - var7, field_139, var7, field_138);
            }
         }

         if (field_147) {
            if (field_148 == 0) {
               method_129(field_154, field_140, field_141, 0, field_144, field_142, field_143);
            } else {
               method_129(field_154, var7, field_141, 0, field_144, var5 - var7, field_143);
               method_129(field_154, 0, field_141, var5 - var7, field_144, var7, field_143);
            }
         }

         if (field_155) {
            field_155 = false;
         }

         method_30();
         var0.translate(field_163, field_164);
         var0.setClip(0, 0, var5, var6);
         method_105();
         if (field_148 == 0) {
            if (field_149 == 0) {
               var0.drawImage(field_153, 0, 0, 20);
            } else {
               var0.drawImage(field_153, 0, -var8, 20);
               var0.drawImage(field_153, 0, var6 - var8, 20);
            }
         } else if (field_149 == 0) {
            var0.drawImage(field_153, -var7, 0, 20);
            var0.drawImage(field_153, var5 - var7, 0, 20);
         } else {
            var0.drawImage(field_153, -var7, -var8, 20);
            var0.setClip(var5 - var7, 0, var7, var6 - var8);
            method_105();
            var0.drawImage(field_153, var5 - var7, -var8, 20);
            var0.setClip(0, var6 - var8, var5 - var7, var8);
            method_105();
            var0.drawImage(field_153, -var7, var6 - var8, 20);
            var0.setClip(var5 - var7, var6 - var8, var7, var8);
            method_105();
            var0.drawImage(field_153, var5 - var7, var6 - var8, 20);
         }

         var0.setClip(0, 0, var5, var6);
         method_131();
         method_132(var0, var5, var6);
         method_110();
         var0.translate(-field_163, -field_164);
         var0.setClip(var1, var2, var3, var4);
      }
   }

   // $VF: renamed from: i (int, int) void
   private static void method_107(int var0, int var1) {
      int var2 = var0 < 0 ? -var0 : var0;
      int var3 = var1 < 0 ? -var1 : var1;
      int var4 = field_153.getWidth();
      int var5 = field_153.getHeight();
      int var6 = field_148;
      int var7 = field_149;
      field_129 = false;
      field_145 = false;
      field_146 = false;
      field_147 = false;
      if (var2 < var4 && var3 < var5) {
         if (var0 > 0) {
            if (var6 + var0 >= var4) {
               field_124 = var6;
               field_125 = 0;
               field_126 = var4 - var6;
               field_127 = var5;
               field_128 = var4 - var0;
               field_129 = true;
               if (var6 + var0 > var4) {
                  field_130 = 0;
                  field_131 = 0;
                  field_132 = var0 - field_126;
                  field_133 = var5;
                  field_145 = true;
                  field_134 = field_128 + field_126;
                  field_148 = field_132;
               } else {
                  field_148 = 0;
               }
            } else {
               field_124 = var6;
               field_125 = 0;
               field_126 = var0;
               field_127 = var5;
               field_129 = true;
               field_148 = var6 + var0;
               field_128 = var4 - var0;
            }
         } else if (var0 < 0) {
            if (var6 + var0 < 0) {
               field_132 = var2 - var6;
               field_130 = var4 - field_132;
               field_131 = 0;
               field_133 = var5;
               field_134 = 0;
               field_145 = true;
               if (var6 != 0) {
                  field_124 = 0;
                  field_125 = 0;
                  field_126 = var6;
                  field_127 = var5;
                  field_128 = field_132;
                  field_129 = true;
               }

               field_148 = field_130;
            } else {
               field_124 = var6 + var0;
               field_125 = 0;
               field_126 = var2;
               field_127 = var5;
               field_129 = true;
               field_128 = 0;
               field_148 = field_124;
            }
         }

         if (var1 > 0) {
            if (var7 + var1 >= var5) {
               field_135 = 0;
               field_136 = var7;
               field_137 = var4;
               field_138 = var5 - var7;
               field_139 = var5 - var1;
               field_146 = true;
               if (var7 + var1 > var5) {
                  field_140 = 0;
                  field_141 = 0;
                  field_142 = var4;
                  field_143 = var1 - field_138;
                  field_144 = field_139 + field_138;
                  field_147 = true;
                  field_149 = field_143;
               } else {
                  field_149 = 0;
               }
            } else {
               field_135 = 0;
               field_136 = var7;
               field_137 = var4;
               field_138 = var1;
               field_146 = true;
               field_139 = var5 - var1;
               field_149 = var7 + var1;
            }
         } else {
            if (var1 < 0) {
               if (var7 + var1 < 0) {
                  field_140 = 0;
                  field_143 = var3 - var7;
                  field_141 = var5 - field_143;
                  field_142 = var4;
                  field_144 = 0;
                  field_147 = true;
                  if (var7 != 0) {
                     field_135 = 0;
                     field_136 = 0;
                     field_137 = var4;
                     field_138 = var7;
                     field_139 = field_143;
                     field_146 = true;
                  }

                  field_149 = field_141;
                  return;
               }

               field_135 = 0;
               field_136 = var7 + var1;
               field_137 = var4;
               field_138 = var3;
               field_146 = true;
               field_139 = 0;
               field_149 = field_136;
            }
         }
      } else {
         field_148 = 0;
         field_149 = 0;
         field_125 = 0;
         field_124 = 0;
         field_126 = var4;
         field_127 = var5;
         field_128 = 0;
         field_129 = true;
      }
   }

   // $VF: renamed from: m () void
   public static void method_108() {
      field_124 = 0;
      field_126 = field_153.getWidth();
      field_125 = 0;
      field_127 = field_153.getHeight();
      field_128 = 0;
      field_129 = true;
      field_148 = 0;
      field_149 = 0;
      field_145 = false;
      field_146 = false;
      field_147 = false;
      field_150 = field_75;
      field_151 = field_76;
   }

   // $VF: renamed from: n () void
   public static void method_109() {
      field_155 = true;
   }

   // $VF: renamed from: I () void
   private static void method_110() {
      for (int var0 = 0; var0 < 64; var0++) {
         if ((field_108[var0] & 8) != 0 && (field_108[var0] & 64) != 0) {
            method_140(var0);
            if (method_146(field_156, field_157, field_158)) {
               int var1 = method_152(field_156, field_157, field_158);
               byte var2 = field_119[var0];
               field_119[var0] = field_86[var1];
               field_86[var1] = (byte)var2;
            }
         }
      }
   }

   // $VF: renamed from: j (int, int) void
   private static void method_111(int var0, int var1) {
      field_75 = -field_77 + (var0 >> 1);
      field_76 = -field_78 + (var1 >> 1);
      if (field_79) {
         if (var0 >= field_93 - field_94) {
            field_75 = (var0 - (field_93 - field_94) >> 1) - field_94;
         } else {
            int var2;
            if ((var2 = var0 - (field_75 + field_93)) > 0) {
               field_75 += var2;
            }

            if ((var2 = field_75 + field_94) > 0) {
               field_75 -= var2;
            }
         }

         if (var1 >= field_95 - field_96) {
            field_76 = (var1 - (field_95 - field_96) >> 1) - field_96;
         } else {
            int var5;
            if ((var5 = var1 - (field_76 + field_95)) > 0) {
               field_76 += var5;
            }

            if ((var5 = field_76 + field_96) > 0) {
               field_76 -= var5;
            }
         }
      }

      if (!field_152) {
         int var7 = field_75 - field_150;
         int var3 = field_76 - field_151;
         method_107(-var7, -var3);
         field_150 = field_75;
         field_151 = field_76;
      } else {
         method_108();
         field_152 = false;
      }
   }

   // $VF: renamed from: d (int) int
   public static int method_112(int var0) {
      return field_102[var0] & 7;
   }

   // $VF: renamed from: e (int) int
   public static int method_113(int var0) {
      return field_101[var0] & 0xFF;
   }

   // $VF: renamed from: e (int) boolean
   public static boolean method_114(int var0) {
      return (field_102[var0] & 32) > 0;
   }

   // $VF: renamed from: b (int, boolean) void
   public static void method_115(int var0, boolean var1) {
      if (var1) {
         field_108[var0] = (byte)(field_108[var0] | 1);
      } else {
         field_108[var0] = (byte)(field_108[var0] & -2);
      }
   }

   // $VF: renamed from: f (int) boolean
   public static boolean method_116(int var0) {
      return (field_108[var0] & 4) == 0;
   }

   // $VF: renamed from: c (int, boolean) void
   public static void method_117(int var0, boolean var1) {
      if (var1) {
         field_108[var0] = (byte)(field_108[var0] & -5);
      } else {
         field_108[var0] = (byte)(field_108[var0] | 4);
      }
   }

   // $VF: renamed from: a () java.io.DataInputStream
   public static DataInputStream method_118() {
      return new DataInputStream(method_88(7));
   }

   // $VF: renamed from: J () void
   private static void method_119() {
      try {
         DataInputStream var0 = method_118();
         method_87(2, var0);
         field_88 = var0.readUnsignedByte();
         field_89 = field_88 / 2;
         field_90 = field_89;
         field_91 = field_90 / 2;
         field_92 = var0.readUnsignedByte();
         field_80 = field_92 * 8;
         int var1;
         field_102 = new byte[var1 = var0.readUnsignedByte()];
         field_103 = new byte[var1];
         field_104 = new byte[var1];
         field_100 = new byte[var1];
         field_101 = new byte[var1];

         for (int var2 = 0; var2 < var1; var2++) {
            field_102[var2] = var0.readByte();
            field_103[var2] = var0.readByte();
            field_104[var2] = var0.readByte();
            field_100[var2] = var0.readByte();
            if (field_100[var2] != -1) {
               field_101[var2] = var0.readByte();
            }
         }

         var0.close();
      } catch (Exception var3) {
      }
   }

   // $VF: renamed from: o () void
   public static void method_120() {
      field_86 = null;
      field_87 = -1;
   }

   // $VF: renamed from: b (boolean) void
   public static void method_121(boolean var0) {
      int var1 = 0;
      if (var0) {
         var1 = field_89;
      }

      field_93 = ((field_81 >> 1) + 1) * field_88 - var1;
      field_94 = -(((field_82 >> 1) + 1) * field_88 - var1);
      field_95 = ((field_81 + field_82 - 1 >> 1) + 1) * field_90;
      field_97 = -field_92 * field_83;
      field_96 = field_97 - field_80;
   }

   // $VF: renamed from: c (boolean) void
   public static void method_122(boolean var0) {
      int var1 = 32767;
      int var2 = -32767;
      int var3 = 32767;
      int var4 = -32767;

      for (int var5 = 0; var5 < field_82; var5++) {
         int var6 = var5 * field_85;

         for (int var7 = 0; var7 < field_81; var7++) {
            int var8 = var6 + var7 * field_83;

            for (int var9 = 0; var9 < field_83; var9++) {
               int var10;
               if ((var10 = field_86[var8 + var9] & 255) < 253 && field_100[var10] != -1) {
                  method_139(var7, var5);
                  if (field_159 < var1) {
                     var1 = field_159;
                  }

                  if (field_159 > var2) {
                     var2 = field_159;
                  }

                  field_160 = field_160 + field_91 + field_92;
                  int var11;
                  if ((var11 = field_160 - (var9 + method_112(var10)) * field_92) < var3) {
                     var3 = var11;
                  }

                  if (field_160 > var4) {
                     var4 = field_160;
                  }
               }
            }
         }
      }

      if (!var0) {
         var2 += field_89;
         var1 -= field_89;
      }

      field_93 = var2;
      field_94 = var1;
      field_95 = var4;
      field_97 = var3;
      field_96 = var3 - field_80;
   }

   // $VF: renamed from: g (int) boolean
   public static boolean method_123(int var0) {
      try {
         DataInputStream var1;
         method_87((var1 = method_118()).readShort(), var1);
         boolean var2 = method_124(var0, var1);
         var1.close();
         return var2;
      } catch (Exception var3) {
         return false;
      }
   }

   // $VF: renamed from: a (int, java.io.DataInputStream) boolean
   public static boolean method_124(int var0, DataInputStream var1) {
      short var2;
      try {
         while ((var2 = var1.readShort()) != 0) {
            if (var1.readUnsignedByte() == var0) {
               field_87 = var0;
               byte var8;
               int var3 = (var8 = var1.readByte()) & 15;
               int var4 = var8 >> 4 & 15;
               var8 = (byte)(var1.readByte() >> 1);
               method_126(var3, var4, var8);
               if ((var8 & 3) != 0) {
                  var8 = (byte)((var8 >> 2) + 1);
               } else {
                  var8 >>= 2;
               }

               for (int var5 = 0; var5 < var4; var5++) {
                  for (int var6 = 0; var6 < var3; var6++) {
                     for (int var11 = 0; var11 < var8; var11++) {
                        method_125(var1, var6, var5, var11);
                     }
                  }
               }

               method_128();
               field_152 = true;
               return true;
            }

            method_87(var2 - 1, var1);
         }
      } catch (Exception var7) {
      }

      return false;
   }

   // $VF: renamed from: a (java.io.DataInput, int, int, int) void
   private static void method_125(DataInput var0, int var1, int var2, int var3) throws IOException {
      var1 <<= 3;
      var2 <<= 3;
      var3 <<= 2;

      for (int var4 = var0.readUnsignedByte(); var4 > 0; var4--) {
         int var5 = var0.readUnsignedByte();

         for (int var6 = var0.readUnsignedByte(); var6 > 0; var6--) {
            byte var7;
            int var8 = ((var7 = var0.readByte()) & 7) + var1;
            int var9 = (var7 >> 3 & 7) + var2;
            int var10 = (var7 >> 6 & 3) + var3;
            if ((field_102[var5] & 32) > 0) {
               method_350(var5, var8, var9, var10);
            } else {
               method_143(var5, var8, var9, var10);
            }
         }
      }
   }

   // $VF: renamed from: c (int, int, int) void
   public static void method_126(int var0, int var1, int var2) {
      field_81 = var0 << 3;
      field_82 = var1 << 3;
      field_83 = var2;
      field_84 = field_81 * field_82;
      field_85 = field_81 * field_83;
      field_86 = new byte[field_84 * field_83];
      method_127();
      method_121(false);
   }

   // $VF: renamed from: K () void
   private static void method_127() {
      for (int var0 = 0; var0 < field_86.length; var0++) {
         field_86[var0] = -1;
      }
   }

   // $VF: renamed from: L () void
   private static void method_128() {
      int var0 = 0;

      for (int var1 = 0; var1 < field_84; var0 += field_83) {
         boolean var2 = true;

         for (int var3 = 0; var3 < field_83; var3++) {
            if (field_86[var0 + var3] != -1) {
               var2 = false;
               break;
            }
         }

         if (var2) {
            for (int var4 = 0; var4 < field_83; var4++) {
               field_86[var0 + var4] = -3;
            }
         }

         var1++;
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int) void
   private static void method_129(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 255;
      var0.setClip(var1, var2, var5, var6);
      var0.setColor(field_162);
      var0.fillRect(var1, var2, var5, var6);
      method_138(var3 - field_75, var4 - field_76);
      int var8 = field_156 - field_98 - 2;
      int var9 = field_157 - field_98;
      int var10 = var5 / field_88 + 2 + 2;
      int var11 = (var6 + field_92 * field_83 + field_80) / field_91 + 3 + field_98;
      method_139(var8, var9);
      int var12 = field_159 + field_75 - (var3 - var1);
      int var13 = field_160 + field_91 + field_76 - (var4 - var2);
      boolean var14 = true;
      int var15 = var1 + var5;
      int var16 = var2 + var6;
      int var17 = var8;
      int var18 = var9;
      int var19 = var12;
      int var20 = var13;
      int var22 = field_83 - field_85;
      int var24 = var18 * field_85 + var17 * field_83;

      for (int var28 = 0; var28 < var11; var28++) {
         var8 = var17;
         var9 = var18;
         int var23 = var24;

         for (int var29 = 0; var29 < var10 && var18 >= 0 && var17 < field_81; var29++) {
            if (var17 >= 0 && var18 < field_82) {
               for (int var30 = 0; var30 < field_83; var30++) {
                  int var31;
                  if ((var31 = field_86[var24 + var30] & 255) < 253) {
                     int var32 = field_101[var31] & 255;
                     var7 = method_130(var0, var31, var32, var7, var30, var19, var20, var15, var16, var1, var2, var5, var6);
                  }
               }
            }

            var17++;
            var18--;
            var19 += field_88;
            var24 += var22;
         }

         var14 = !var14;
         var20 += field_91;
         var19 = var12;
         if (var14) {
            var17 = var8 + 1;
            var18 = var9;
            var24 = var23 + field_83;
         } else {
            var17 = var8;
            var18 = var9 + 1;
            var24 = var23 + field_85;
            var19 -= field_89;
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int, int, int, int, int, int, int) int
   private static int method_130(
      Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12
   ) {
      int var13;
      if ((var13 = field_100[var1] & 255) == 255) {
         return var3;
      }

      int var14 = var4 * field_92;
      int var15 = var5 + field_103[var1];
      int var16 = var6 + field_104[var1] - var14;
      byte var17 = field_102[var1];
      short var18 = 0;
      if ((var17 & 64) > 0) {
         var18 = 8192;
         var15 += 2;
      }

      if ((var17 & 128) > 0) {
         var18 |= 16384;
         var16++;
      }

      if (var3 != var13) {
         var3 = var13;
         method_34(var13, 0);
      }

      method_44(var13, var2, var18, field_161);
      int var19;
      if ((var19 = var15 + field_161[0]) >= var7) {
         return var3;
      }

      int var20;
      if ((var20 = var16 + field_161[1]) >= var8) {
         return var3;
      }

      if (var19 + field_161[2] <= var9) {
         return var3;
      }

      if (var20 + field_161[3] <= var10) {
         return var3;
      }

      var0.setClip(var9, var10, var11, var12);
      method_40(var15, var16, var2, var18);
      return var3;
   }

   // $VF: renamed from: M () void
   private static void method_131() {
      field_123 = 0;

      for (int var0 = 0; var0 < 64 && field_123 < 64; var0++) {
         if ((field_108[var0] & 8) != 0 && field_105[var0] != -1 && (field_108[var0] & 4) <= 0) {
            if ((field_108[var0] & 32) > 0) {
               method_140(var0);
               method_139(field_156, field_157);
               field_120[field_123] = (short)var0;
               field_121[field_123] = (short)field_159;
               field_122[field_123] = (short)field_160;
               field_123++;
            } else {
               method_135(field_109[var0], field_110[var0]);
               field_120[field_123] = (short)var0;
               field_121[field_123] = (short)field_159;
               field_122[field_123] = (short)field_160;
               field_123++;
            }
         }
      }

      for (int var8 = 0; var8 < field_123; var8++) {
         int var1 = var8;

         for (int var2 = var8 + 1; var2 < field_123; var2++) {
            byte var3 = field_118[field_120[var2]];
            byte var4 = field_118[field_120[var1]];
            if (var3 < var4) {
               var1 = var2;
            } else if (var3 == var4) {
               int var5;
               if (((var5 = field_122[var2] - field_122[var1]) < 0 ? -var5 : var5) < field_91) {
                  int var7;
                  if ((var7 = field_111[field_120[var2]] - field_111[field_120[var1]]) > 0) {
                     if (field_111[field_120[var1]] + field_115[field_120[var1]] * 64 > field_111[field_120[var2]]) {
                        var1 = var2;
                     }
                     continue;
                  }

                  if (var7 < 0) {
                     if (field_111[field_120[var2]] + field_115[field_120[var2]] * 64 <= field_111[field_120[var1]]) {
                        var1 = var2;
                     }
                     continue;
                  }
               }

               if (var5 < 0) {
                  var1 = var2;
               } else if (var5 == 0) {
                  if (field_122[var2] + field_111[field_120[var2]] < field_122[var1] + field_111[field_120[var1]]) {
                     var1 = var2;
                  } else if (field_122[var2] + field_111[field_120[var2]] == field_122[var1] + field_111[field_120[var1]] && field_120[var2] < field_120[var1]) {
                     var1 = var2;
                  }
               }
            }
         }

         if (var1 != var8) {
            short var11 = field_120[var8];
            field_120[var8] = field_120[var1];
            field_120[var1] = (short)var11;
            var11 = field_121[var8];
            field_121[var8] = field_121[var1];
            field_121[var1] = (short)var11;
            var11 = field_122[var8];
            field_122[var8] = field_122[var1];
            field_122[var1] = (short)var11;
         }
      }

      for (int var9 = 0; var9 < field_123; var9++) {
         short var10 = field_120[var9];
         if ((field_108[var10] & 32) > 0) {
            method_135(field_109[var10], field_110[var10]);
            field_121[var9] = (short)field_159;
            field_122[var9] = (short)field_160;
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int) void
   private static void method_132(Graphics var0, int var1, int var2) {
      for (int var3 = 0; var3 < field_123; var3++) {
         short var4 = field_120[var3];
         int var5;
         method_34(var5 = field_105[var4] & 255, field_106[var4]);
         int var6 = field_121[var3] + field_116[var4] + field_75;
         int var7 = field_122[var3] + field_117[var4] + field_76 - method_137(field_111[var4]);
         int var8 = field_108[var4];
         short var9 = 0;
         if ((var8 & 1) > 0) {
            var9 = 8192;
            var6 += 2;
         }

         if ((var8 & 2) > 0) {
            var9 |= 16384;
            var7++;
         }

         var8 = field_107[var4] & 255;
         method_44(var5, var8, var9, field_161);
         int var10 = var6 + field_161[0];
         int var11 = var7 + field_161[1];
         int var12 = field_161[2];
         int var13 = field_161[3];
         if (var10 < var1 && var11 < var2 && var10 + var12 > 0 && var11 + var13 > 0) {
            var0.setClip(0, 0, var1, var2);
            method_105();
            method_40(var6, var7, var8, var9);
            if ((field_108[var4] & 16) <= 0) {
               method_133(var0, var1, var2, var10, var11, var12, var13, var4);
            }
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int, int) void
   private static void method_133(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = 255;
      int var9 = field_109[var7] - (field_113[var7] >> 1);
      int var10 = field_110[var7] - (field_114[var7] >> 1);
      short var11 = field_111[var7];
      short var12 = field_113[var7];
      short var13 = field_114[var7];
      int var14 = field_115[var7] * 64;
      int var15 = method_141(var9) - 1;
      int var16 = method_141(var10) + 1;
      int var18 = field_99;
      method_139(var15, var16);
      int var19 = field_159 + field_75;
      int var20 = field_160 + field_91 + field_76;
      int var21 = var3 + var5;
      int var22 = var4 + var6;
      int var23 = var9 + var12;
      int var24 = var10 + var13;
      int var25 = var11 + var14;
      boolean var26 = false;
      int var27 = var15;
      int var28 = var16;
      int var29 = var19;
      int var31 = var28 * field_85 + var27 * field_83;
      int var32 = field_83 - field_85;

      for (int var36 = 0; var36 < var18; var36++) {
         var15 = var27;
         var16 = var28;
         int var30 = var31;

         for (int var37 = 0; var37 < 3 && var28 >= 0 && var27 < field_81; var37++) {
            if (var27 >= 0 && var28 < field_82) {
               for (int var38 = 0; var38 < field_83; var38++) {
                  int var39;
                  if ((var39 = field_86[var31 + var38] & 255) < 253) {
                     int var40 = field_101[var39] & 255;
                     var8 = method_134(
                        var0,
                        var39,
                        var40,
                        var8,
                        var38,
                        var9,
                        var10,
                        var11,
                        var23,
                        var24,
                        var25,
                        var29,
                        var20,
                        var1,
                        var2,
                        var27,
                        var28,
                        var3,
                        var4,
                        var21,
                        var22,
                        var5,
                        var6
                     );
                  }
               }
            }

            var27++;
            var28--;
            var29 += field_88;
            var31 += var32;
         }

         var26 = !var26;
         var20 += field_91;
         if (var26) {
            var27 = var15 + 1;
            var28 = var16;
            var29 = var19 + field_89;
            var31 = var30 + field_83;
         } else {
            var27 = var15;
            var28 = var16 + 1;
            var29 = var19;
            var31 = var30 + field_85;
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int) int
   private static int method_134(
      Graphics var0,
      int var1,
      int var2,
      int var3,
      int var4,
      int var5,
      int var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14,
      int var15,
      int var16,
      int var17,
      int var18,
      int var19,
      int var20,
      int var21,
      int var22
   ) {
      int var23;
      if ((var23 = field_100[var1] & 255) == 255) {
         return var3;
      }

      if ((field_102[var1] & 8) > 0) {
         return var3;
      }

      var15 *= 64;
      var16 *= 64;
      var4 *= 64;
      if (var7 < var4 + (field_102[var1] & 7) * 64 && var5 < var15 + 64 && var6 < var16 + 64 && (var15 >= var8 || var16 >= var9 || var4 >= var10)) {
         var5 = var11 + field_103[var1];
         var6 = var12 + field_104[var1] - method_137(var4);
         byte var33 = field_102[var1];
         short var24 = 0;
         if ((var33 & 64) > 0) {
            var24 = 8192;
            var5 += 2;
         }

         if ((var33 & 128) > 0) {
            var24 |= 16384;
            var6++;
         }

         if (var3 != var23) {
            var3 = var23;
            method_34(var23, 0);
         }

         method_44(var23, var2, var24, field_161);
         var11 = var5 + field_161[0];
         var12 = var6 + field_161[1];
         if (var11 >= var13 || var12 >= var14) {
            return var3;
         } else if ((var8 = var11 + field_161[2]) <= 0) {
            return var3;
         } else if ((var9 = var12 + field_161[3]) <= 0) {
            return var3;
         } else if (var17 < var8 && var11 < var19 && var18 < var9 && var12 < var20) {
            var0.setClip(var17, var18, var21, var22);
            method_105();
            method_40(var5, var6, var2, var24);
            return var3;
         } else {
            return var3;
         }
      } else {
         return var3;
      }
   }

   // $VF: renamed from: e (int, int) void
   public static void method_135(int var0, int var1) {
      int var2 = var0 & 63;
      int var3 = var1 & 63;
      var0 -= var2;
      var1 -= var3;
      field_159 = method_136((var2 << 1) - (var3 << 1) + (var0 << 1) - (var1 << 1));
      field_160 = method_136(var2 + var3 + var0 + var1);
   }

   // $VF: renamed from: s (int) int
   private static int method_136(int var0) {
      return var0 * field_91 >> 6;
   }

   // $VF: renamed from: f (int) int
   public static int method_137(int var0) {
      return var0 * field_92 >> 6;
   }

   // $VF: renamed from: f (int, int) void
   public static void method_138(int var0, int var1) {
      int var2 = var1 << 1;
      field_156 = (var0 + var2) / field_88;
      field_157 = (var0 - var2) / -field_88;
      if (field_156 <= 0 && var0 + var2 < 0) {
         field_156--;
      }

      if (field_157 <= 0 && var2 - var0 < 0) {
         field_157--;
      }
   }

   // $VF: renamed from: g (int, int) void
   public static void method_139(int var0, int var1) {
      field_159 = var0 * field_89 - var1 * field_89;
      field_160 = var0 * field_91 + var1 * field_91;
   }

   // $VF: renamed from: g (int) void
   public static void method_140(int var0) {
      field_156 = method_141(field_109[var0]);
      field_157 = method_141(field_110[var0]);
      field_158 = method_141(field_111[var0]);
   }

   // $VF: renamed from: g (int) int
   public static int method_141(int var0) {
      int var1 = var0 >> 6;
      if (var0 < 0) {
         var1--;
      }

      return var1;
   }

   // $VF: renamed from: h (int) int
   public static int method_142(int var0) {
      return var0 << 6;
   }

   // $VF: renamed from: f (int, int, int, int) void
   public static void method_143(int var0, int var1, int var2, int var3) {
      int var4 = method_152(var1, var2, var3);
      field_86[var4] = (byte)var0;
      byte var5;
      if (((var5 = field_102[var0]) & 16) != 0) {
         var5 &= 7;
         method_145(var1, var2, var3 + 1, var5 - 1, 254);
      }
   }

   // $VF: renamed from: b (int, int, int, int, int) void
   public static void method_144(int var0, int var1, int var2, int var3, int var4) {
      var0 = method_152(var0, var1, var2);
      var2 = field_83 - var2;
      if (var3 <= var2) {
         var2 = var3;
      }

      for (int var6 = var0; var6 < var0 + var2; var6++) {
         field_86[var6] = (byte)var4;
      }
   }

   // $VF: renamed from: c (int, int, int, int, int) void
   private static void method_145(int var0, int var1, int var2, int var3, int var4) {
      var0 = method_152(var0, var1, var2);
      var2 = field_83 - var2;
      if (var3 <= var2) {
         var2 = var3;
      }

      for (int var6 = var0; var6 < var0 + var2; var6++) {
         if ((field_86[var6] & 255) < 253) {
            return;
         }

         field_86[var6] = (byte)var4;
      }
   }

   // $VF: renamed from: b (int, int, int) boolean
   private static boolean method_146(int var0, int var1, int var2) {
      return var0 >= 0 && var0 < field_81 && var1 >= 0 && var1 < field_82 && var2 >= 0 && var2 < field_83;
   }

   // $VF: renamed from: b (int, int, int, int) int
   public static int method_147(int var0, int var1, int var2, int var3) {
      int var4 = method_149();
      field_105[var4] = field_100[var0];
      field_106[var4] = 0;
      field_107[var4] = field_101[var0];
      field_116[var4] = field_103[var0];
      field_117[var4] = field_104[var0];
      field_118[var4] = 0;
      method_148(var4, var1, var2, var3);
      field_113[var4] = 1;
      field_114[var4] = 1;
      field_112[var4] = false;
      byte var5 = field_102[var0];
      field_108[var4] = (byte)(8 | var5 >> 6 & 3);
      field_115[var4] = (byte)(var5 & 7);
      if ((var5 & 16) > 0) {
         method_144(var1, var2, var3, field_115[var4], 254);
      }

      return var4;
   }

   // $VF: renamed from: g (int, int, int, int) void
   public static void method_148(int var0, int var1, int var2, int var3) {
      field_109[var0] = (short)(var1 * 64 + 32);
      field_110[var0] = (short)(var2 * 64 + 32);
      field_111[var0] = (short)(var3 * 64);
   }

   // $VF: renamed from: b () int
   public static int method_149() {
      for (int var0 = 0; var0 < 64; var0++) {
         if ((field_108[var0] & 8) == 0) {
            return var0;
         }
      }

      return -1;
   }

   // $VF: renamed from: h (int) void
   public static void method_150(int var0) {
      field_108[var0] = 0;
   }

   // $VF: renamed from: h (int, int, int, int) void
   public static void method_151(int var0, int var1, int var2, int var3) {
      field_109[var0] = (short)(field_109[var0] + var1);
      field_110[var0] = (short)(field_110[var0] + var2);
      field_111[var0] = (short)(field_111[var0] + var3);
   }

   // $VF: renamed from: a (int, int, int) int
   public static int method_152(int var0, int var1, int var2) {
      return var1 * field_85 + var0 * field_83 + var2;
   }

   // $VF: renamed from: i (int) void
   public static void method_153(int var0) {
      field_158 = var0 % field_83;
      int var1;
      field_156 = (var1 = var0 / field_83) % field_81;
      field_157 = var1 / field_81;
   }

   // $VF: renamed from: a (int, int, int, int, int, int, int) boolean
   public static boolean method_154(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      return var0 < field_109[var6] + (field_113[var6] >> 1)
         && var0 + var3 > field_109[var6] - (field_113[var6] >> 1)
         && var1 < field_110[var6] + (field_114[var6] >> 1)
         && var1 + var4 > field_110[var6] - (field_114[var6] >> 1)
         && var2 + var5 > field_111[var6]
         && var2 < field_111[var6] + field_115[var6] * 64;
   }

   // $VF: renamed from: a (int, int, int) boolean
   public static boolean method_155(int var0, int var1, int var2) {
      if (var0 >= 0 && var1 >= 0 && var2 >= 0 && var0 < field_81 && var1 < field_82) {
         if (var2 >= field_83) {
            var2 = field_83 - 1;
         }

         int var3;
         return (var3 = field_86[method_152(var0, var1, var2)] & 255) != 254 && var3 != 253 ? var3 != 255 && (field_102[var3] & 16) > 0 : true;
      } else {
         return true;
      }
   }

   // $VF: renamed from: b (int, int, int) int
   public static int method_156(int var0, int var1, int var2) {
      return var0 >= 0 && var1 >= 0 && var2 >= 0 && var0 < field_81 && var1 < field_82 && var2 < field_83 ? field_86[method_152(var0, var1, var2)] & 0xFF : 253;
   }

   // $VF: renamed from: j (int) void
   public static void method_157(int var0) {
      method_135(field_109[var0], field_110[var0]);
      field_77 = field_159 + field_116[var0];
      field_78 = field_160 + field_117[var0] - method_137(field_111[var0]);
   }

   // $VF: renamed from: k (int) void
   public static final void method_158(int var0) {
      field_171 = method_89(12);
      field_172 = new byte[var0];
      field_173 = new short[var0];
      field_174 = new byte[var0];
      field_175 = new short[var0];
      field_176 = new byte[var0];
      field_177 = new byte[var0];
      field_178 = new byte[var0];
      field_179 = new boolean[var0];

      for (int var1 = 0; var1 < var0; var1++) {
         field_172[var1] = -1;
      }
   }

   // $VF: renamed from: p () void
   public static final void method_159() {
      for (int var0 = 0; var0 < field_172.length; var0++) {
         field_172[var0] = -1;
      }
   }

   // $VF: renamed from: i (int) int
   public static final int method_160(int var0) {
      for (int var1 = 0; var1 < field_172.length; var1++) {
         if (field_172[var1] == -1) {
            field_172[var1] = (byte)var0;
            field_173[var1] = -1;
            field_176[var1] = 0;
            field_174[var1] = 0;
            field_177[var1] = 0;
            field_178[var1] = 0;
            field_179[var1] = false;
            return var1;
         }
      }

      return -1;
   }

   // $VF: renamed from: l (int) void
   public static final void method_161(int var0) {
      field_172[var0] = -1;
   }

   // $VF: renamed from: a (int, int, int, int, boolean) void
   public static final void method_162(int var0, int var1, int var2, int var3, boolean var4) {
      field_173[var0] = (short)var1;
      field_176[var0] = 0;
      field_174[var0] = (byte)var2;
      field_177[var0] = (byte)var3;
      field_178[var0] = (byte)var3;
      field_179[var0] = var4;
      method_173(var0);
   }

   // $VF: renamed from: m (int) void
   public static final void method_163(int var0) {
      if (field_173[var0] != -1) {
         int var1 = method_170(var0);
         byte var2 = field_177[var0];
         int var3;
         if ((var3 = field_178[var0]) > 0) {
            var3--;
         }

         if (var3 <= 0 && var2 > 0) {
            if ((var1 = (var1 + 1) % method_169(var0)) == 0 && !field_179[var0]) {
               field_173[var0] = -1;
            } else {
               field_178[var0] = field_177[var0];
               field_176[var0] = (byte)var1;
               method_174(var0);
            }
         } else {
            field_178[var0] = (byte)var3;
            field_176[var0] = (byte)var1;
            method_174(var0);
         }
      }
   }

   // $VF: renamed from: h (int) boolean
   public static final boolean method_164(int var0) {
      return field_173[var0] != -1 && field_177[var0] != 0;
   }

   // $VF: renamed from: j (int) int
   public static final int method_165(int var0) {
      return field_174[var0];
   }

   // $VF: renamed from: h (int, int) void
   public static final void method_166(int var0, int var1) {
      field_174[var0] = (byte)var1;
      if (field_173[var0] >= 0) {
         method_173(var0);
      }
   }

   // $VF: renamed from: k (int) int
   public static final int method_167(int var0) {
      return field_177[var0];
   }

   // $VF: renamed from: l (int) int
   public static final int method_168(int var0) {
      return field_173[var0] == -1 ? -1 : field_175[var0] & 65535;
   }

   // $VF: renamed from: m (int) int
   public static final int method_169(int var0) {
      return field_173[var0] == -1 ? -1 : field_171[field_175[var0]] & 0xFF;
   }

   // $VF: renamed from: n (int) int
   public static final int method_170(int var0) {
      return field_173[var0] == -1 ? -1 : field_176[var0] & 0xFF;
   }

   // $VF: renamed from: o (int) int
   public static final int method_171(int var0) {
      return field_173[var0];
   }

   // $VF: renamed from: p (int) int
   public static final int method_172(int var0) {
      return field_172[var0] & 0xFF;
   }

   // $VF: renamed from: n (int) void
   public static final void method_173(int var0) {
      int var1 = method_171(var0);
      int var2 = method_172(var0);
      int var3 = method_165(var0);
      int var4 = field_171[var1++] & 255;
      int var5 = field_171[var1++] & 255;
      int var6 = var3;
      boolean var7 = false;
      boolean var8 = false;
      byte var9 = field_171[var1++];

      int var10;
      for (var10 = 0; field_180[var10] != -1 && field_180[var10] != var3; var10++) {
         while (field_180[var10] >= 0) {
            var10++;
         }
      }

      if (field_180[var10] >= 0) {
         while (field_180[var10] != -2) {
            var3 = field_180[var10];
            if ((1 << var3 & var9) > 0) {
               var8 = true;
               var7 = field_180[var10 + 1] == 1;
               break;
            }

            var10 += 2;
         }
      }

      if (var8) {
         var1 += method_177(var9, var3) * 2;
         field_175[var0] = (short)method_178(field_171, var1);
         method_174(var0);
         method_176(var2, var6, var4, var5);
         method_115(var2, var7);
      } else {
         field_173[var0] = -1;
      }
   }

   // $VF: renamed from: t (int) void
   private static void method_174(int var0) {
      field_107[method_172(var0)] = field_171[method_168(var0) + 1 + method_170(var0) % method_169(var0)];
   }

   // $VF: renamed from: q () void
   public static final void method_175() {
      for (int var0 = 0; var0 < field_172.length; var0++) {
         if (field_172[var0] != -1) {
            method_163(var0);
         }
      }
   }

   // $VF: renamed from: k (int, int, int, int) void
   private static void method_176(int var0, int var1, int var2, int var3) {
      if (var1 == 6 || var1 == 2) {
         int var4 = var2;
         var2 = var3;
         var3 = var4;
      }

      field_113[var0] = (short)var2;
      field_114[var0] = (short)var3;
   }

   // $VF: renamed from: d (int, int) int
   private static int method_177(int var0, int var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < var1; var3++) {
         if ((var0 & 1) > 0) {
            var2++;
         }

         var0 >>= 1;
      }

      return var2;
   }

   // $VF: renamed from: b (byte[], int) int
   private static int method_178(byte[] var0, int var1) {
      return (var0[var1] & 0xFF) << 8 | var0[var1 + 1] & 0xFF;
   }

   // $VF: renamed from: N () void
   private static void method_179() {
      if (field_188 == null) {
         field_188 = method_89(11);
      }
   }

   // $VF: renamed from: O () void
   private static void method_180() {
      field_188 = null;
   }

   // $VF: renamed from: P () void
   private static void method_181() {
      int var0 = 0;
      field_181 = method_220(0);
      var0 += 2;
      field_182 = method_220(2);
      var0 += 2;
      field_183 = method_220(4);
      var0 += 2;
      field_184 = method_220(6);
      var0 += 2;
      field_185 = method_220(8);
      var0 += 2;
      field_186 = method_220(10);
      var0 += 2;
      field_187 = method_220(12);
      var0 += 2;
      var0++;
      field_205 = method_218(14);
      if (field_205 > 0) {
         field_206 = new int[field_205];
         field_207 = new int[field_205];
         field_208 = new int[field_205];
         field_209 = new byte[field_205];
         field_210 = new int[field_205];
         field_211 = new int[field_205];
         field_212 = new int[field_205];
         field_213 = new int[field_205];
         field_214 = new int[field_205];
         field_215 = new int[field_205];
         field_216 = new byte[field_205];
         field_217 = new short[field_205];
         field_218 = new short[field_205];
         field_219 = new byte[field_205];
      }

      for (int var1 = 0; var1 < field_205; var1++) {
         field_206[var1] = 0;
         field_208[var1] = method_207(var1, 0);
         field_209[var1] = (byte)method_208(var1, 0);
         field_207[var1] = -1;
         field_210[var1] = -1;
         field_211[var1] = -1;
         field_214[var1] = -1;
         field_213[var1] = -1;
         field_215[var1] = -1;
      }

      var0++;
      int var16;
      if ((var16 = method_218(15)) > 0) {
         int var17;
         field_203 = new byte[var17 = (var16 >> 3) + ((var16 & 7) > 0 ? 1 : 0)];
         field_220 = new byte[var17];
      }

      var0++;
      int var2 = method_218(16);

      for (int var3 = 0; var3 < var2; var3++) {
         field_207[method_218(var0)] = method_218(var0 + 1);
         var0 += 2;
      }

      field_189 = -1;
      field_193 = new int[16];
      field_190 = new int[16];
      field_204 = new int[16];
      field_196 = new int[16];
      field_195 = new int[16];
      field_191 = 0;
      var0 = field_187;
      if (method_218(field_187) != 0) {
         field_221 = method_218(var0 + 1);
         var0 += 2;

         while (method_218(var0) != 255) {
            if (method_218(var0) == 0) {
               int var18 = method_218(var0 + 1);
               field_206[var18] = method_218(var0 + 2);
               field_208[var18] = method_207(var18, field_206[var18]);
               field_209[var18] = (byte)method_208(var18, field_206[var18]);
               var0 += 3;
            } else {
               method_193(method_218(var0 + 1), true);
               var0 += 2;
            }
         }
      } else {
         field_221 = -1;
      }

      method_191(4, 1);
      method_213();
   }

   // $VF: renamed from: u (int) void
   private static void method_182(int var0) {
      for (int var1 = 0; var1 < field_205; var1++) {
         field_206[var1] = field_71[var0++] & 255;
         field_215[var1] = field_71[var0++];
         field_214[var1] = method_221(field_71[var0], field_71[var0 + 1]);
         var0 += 2;
         field_213[var1] = method_221(field_71[var0], field_71[var0 + 1]);
         var0 += 2;
         field_208[var1] = method_207(var1, field_206[var1]);
         field_209[var1] = (byte)method_208(var1, field_206[var1]);
      }

      for (int var5 = 0; var5 < field_203.length; var5++) {
         field_203[var5] = field_71[var0++];
      }

      method_213();
   }

   // $VF: renamed from: v (int) void
   private static void method_183(int var0) {
      for (int var1 = 0; var1 < field_205; var1++) {
         field_71[var0++] = field_216[var1];
         field_71[var0++] = field_219[var1];
         field_71[var0++] = (byte)(field_218[var1] >> 8);
         field_71[var0++] = (byte)(field_218[var1] & 0xFF);
         field_71[var0++] = (byte)(field_217[var1] >> 8);
         field_71[var0++] = (byte)(field_217[var1] & 0xFF);
      }

      for (int var7 = 0; var7 < field_203.length; var7++) {
         field_71[var0++] = field_220[var7];
      }
   }

   // $VF: renamed from: Q () void
   private static void method_184() {
      for (int var0 = 0; var0 < field_205; var0++) {
         field_210[var0] = -1;
         field_211[var0] = -1;
         if (field_209[var0] == 3) {
            field_212[var0] = -1;
         }
      }

      int var6 = 0;

      for (int var1 = 0; var1 < field_86.length; var1++) {
         int var2 = field_86[var1] & 255;

         for (int var3 = 0; var3 < field_205; var3++) {
            if (var2 == field_207[var3]) {
               if (field_209[var3] == 3) {
                  if (field_212[var3] < 0) {
                     field_212[var3] = var1;
                     var6++;
                  } else if (method_92(0, 1) == 0) {
                     method_153(field_212[var3]);
                     method_144(field_156, field_157, field_158, method_112(var2), 255);
                     field_212[var3] = var1;
                  } else {
                     method_153(var1);
                     method_144(field_156, field_157, field_158, method_112(var2), 255);
                  }
               } else if (field_208[var3] == field_87) {
                  field_212[var3] = var1;
                  if (method_114(var2)) {
                     field_210[var3] = method_391(var2, var1);
                  }
               } else {
                  field_212[var3] = var1;
                  method_153(var1);
                  method_144(field_156, field_157, field_158, method_112(field_207[var3]), 255);
               }
            }
         }
      }

      int var7;
      int var8;
      if ((var8 = method_92((var7 = Math.min(8, var6)) >> 1, var7)) == 0 && var6 > 0) {
         var8 = 1;
      }

      int var9 = var6 - var8;

      while (var9 > 0) {
         int var4 = method_92(0, var6 - 1);

         for (int var5 = 0; var5 < field_205; var5++) {
            if (field_209[var5] == 3 && field_212[var5] >= 0) {
               if (--var4 <= 0) {
                  var6--;
                  var9--;
                  method_153(field_212[var5]);
                  method_144(field_156, field_157, field_158, method_112(field_207[var5]), 255);
                  field_208[var5] = -1;
                  field_212[var5] = -1;
                  break;
               }
            }
         }
      }

      field_387 = 0;

      for (int var10 = 0; var10 < field_205; var10++) {
         if (field_209[var10] == 3 && field_212[var10] >= 0) {
            field_208[var10] = field_87;
            field_210[var10] = method_391(field_207[var10], field_212[var10]);
            method_117(field_210[var10], false);
            method_153(field_212[var10]);
            method_144(field_156, field_157, field_158, 1, field_207[var10]);
            field_387++;
         }
      }

      method_191(1, field_87);
      field_362 = -1;
   }

   // $VF: renamed from: w (int) void
   private static void method_185(int var0) {
      method_186(var0, field_206[var0], 0, 0);
   }

   // $VF: renamed from: l (int, int, int, int) void
   private static void method_186(int var0, int var1, int var2, int var3) {
      int var4;
      if ((var4 = method_194(var0, var1)) >= 0) {
         if ((var4 = method_195(var4, var2)) >= 0) {
            if ((var4 = method_196(var4, var3)) >= 0) {
               field_200 = var0;
               field_201 = var1;
               field_202 = var2;
               field_189 = var4;
               field_191 = 0;
               method_187();
            }
         }
      }
   }

   // $VF: renamed from: R () void
   private static void method_187() {
      if (field_189 >= 0) {
         while (true) {
            switch (method_217(field_189++)) {
               case -10:
                  method_201("bW");
                  method_356(field_193[0], field_193[1]);
                  return;
               case -9:
                  if (method_200()) {
                     field_362 = -1;
                     field_189 = -1;
                     method_213();
                     return;
                  }

                  field_189 = method_199();
               case -8:
               case -7:
               case -6:
               case -5:
               case -4:
               case 6:
               case 23:
               default:
                  break;
               case -3:
                  method_201("W");
                  field_189 = method_216(field_193[0]);
                  break;
               case -2:
                  if (method_189()) {
                     field_189 += 2;
                  } else {
                     field_189 = method_216(method_220(field_189));
                  }
                  break;
               case -1:
                  method_201("W");
                  method_198(field_189);
                  field_189 = method_216(field_193[0]);
                  break;
               case 0:
                  method_201("BB");
                  int var3 = field_193[0];
                  boolean var2 = field_208[var3] == field_87;
                  field_206[var3] = field_193[1];
                  field_208[var3] = method_207(var3, field_193[1]);
                  field_209[var3] = (byte)method_208(var3, field_193[1]);
                  if (var2 && field_208[var3] != field_87) {
                     if (field_210[var3] >= 0) {
                        method_209(var3);
                     } else if (field_207[var3] >= 0) {
                        method_153(field_212[var3]);
                        method_144(field_156, field_157, field_158, method_112(field_207[var3]), 255);
                        method_109();
                     }

                     method_388(false);
                  } else if (!var2 && field_208[var3] == field_87) {
                     method_153(field_212[var3]);
                     method_143(field_207[var3], field_156, field_157, field_158);
                     if (method_114(field_207[var3])) {
                        field_210[var3] = method_391(field_207[var3], field_212[var3]);
                     }

                     method_109();
                     method_388(false);
                  }
                  break;
               case 1:
                  method_201("B");
                  method_193(field_193[0], true);
                  break;
               case 2:
                  method_201("B");
                  method_193(field_193[0], false);
                  break;
               case 3:
                  method_203();
                  method_367();
                  field_362 = -1;
                  field_189 = -1;
                  return;
               case 4:
                  method_201("B.B");
                  method_204();
                  method_366();
                  field_362 = -1;
                  field_189 = -1;
                  return;
               case 5:
                  method_201("Bw");
                  method_191(field_193[0], field_193[1]);
                  break;
               case 7:
                  method_327();
                  return;
               case 8:
                  method_326();
                  return;
               case 9:
                  method_162(field_339, field_328, 3, 0, false);
                  break;
               case 10:
                  method_201("BWb");
                  field_213[field_193[0]] = field_193[1];
                  field_215[field_193[0]] = field_193[2];
                  break;
               case 11:
                  method_201("BW");
                  field_214[field_193[0]] = field_193[1];
                  break;
               case 12:
                  method_201("BW");
                  field_300 = field_193[0];
                  field_299 = field_193[1];
                  return;
               case 13:
                  method_201("B");
                  method_320(field_193[0]);
                  break;
               case 14:
                  method_354();
                  return;
               case 15:
                  method_201("W.W");
                  int var1 = method_92(0, field_192 - 1);
                  method_356(0, field_193[var1]);
                  return;
               case 16:
                  method_201("BB.B");
                  method_394();
                  return;
               case 17:
                  method_201("B");
                  if (field_193[0] == 1) {
                     method_69(1, true);
                  } else if (field_193[0] == 2) {
                     method_69(2, true);
                  }
                  break;
               case 18:
                  method_201("B");
                  method_401(field_193[0]);
                  return;
               case 19:
                  method_201("BBB");
                  field_377 = -1;
                  field_376 = -1;
                  field_375 = field_193[0];
                  method_379();
                  field_109[field_338] = (short)(method_142(field_193[1]) + 32);
                  field_110[field_338] = (short)(method_142(field_193[2]) + 32);
                  method_157(field_338);
                  method_393();
                  field_378 = false;
                  break;
               case 20:
                  method_117(field_338, false);
                  break;
               case 21:
                  method_117(field_338, true);
                  break;
               case 22:
                  method_343();
                  return;
            }
         }
      }
   }

   // $VF: renamed from: e () boolean
   private static boolean method_188() {
      return field_189 >= 0;
   }

   // $VF: renamed from: f () boolean
   private static boolean method_189() {
      switch (method_217(field_189++)) {
         case -8:
            boolean var3 = method_189();
            boolean var4 = method_189();
            if (!var3 && !var4) {
               return false;
            }

            return true;
         case -7:
            boolean var1 = method_189();
            boolean var2 = method_189();
            if (var1 && var2) {
               return true;
            }

            return false;
         case -6:
            if (!method_189()) {
               return true;
            }

            return false;
         case -5:
            method_201("B");
            return method_192(field_193[0]);
         case -4:
            method_201("BB");
            if (field_206[field_193[0]] == field_193[1]) {
               return true;
            }

            return false;
         case -3:
         case -2:
         case -1:
         case 0:
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         default:
            System.out.println("vmEvalExpr fatal error");
            return false;
         case 6:
            method_201("Bw");
            return method_190(field_193[0]) == field_193[1];
      }
   }

   // $VF: renamed from: t (int) int
   private static int method_190(int var0) {
      return field_204[var0];
   }

   // $VF: renamed from: k (int, int) void
   private static void method_191(int var0, int var1) {
      field_204[var0] = var1;
   }

   // $VF: renamed from: i (int) boolean
   private static boolean method_192(int var0) {
      int var1 = var0 >> 3;
      int var2 = 1 << (var0 & 3);
      return (field_203[var1] & var2) > 0;
   }

   // $VF: renamed from: d (int, boolean) void
   private static void method_193(int var0, boolean var1) {
      int var2 = var0 >> 3;
      int var3 = 1 << (var0 & 7);
      if (var1) {
         field_203[var2] = (byte)(field_203[var2] | var3);
      } else {
         field_203[var2] = (byte)(field_203[var2] & ~var3);
      }
   }

   // $VF: renamed from: e (int, int) int
   private static int method_194(int var0, int var1) {
      for (int var2 = field_181; method_218(var2) != 255; var2 += 6) {
         if (method_218(var2) == var0 && method_218(var2 + 1) == var1) {
            return method_214(method_220(var2 + 4));
         }
      }

      return -1;
   }

   // $VF: renamed from: f (int, int) int
   private static int method_195(int var0, int var1) {
      while (method_218(var0) != 255) {
         if (method_218(var0) == var1) {
            return method_215(method_220(var0 + 3));
         }

         var0 += 5;
      }

      return -1;
   }

   // $VF: renamed from: g (int, int) int
   private static int method_196(int var0, int var1) {
      while (method_218(var0) != 255) {
         if (method_218(var0) == var1) {
            return method_216(method_220(var0 + 3));
         }

         var0 += 5;
      }

      return -1;
   }

   // $VF: renamed from: a (java.lang.String) int
   private static int method_197(String var0) {
      int var1 = field_185;
      char var2 = var0.charAt(0);
      char var3 = var0.charAt(1);
      char var4 = var0.charAt(2);

      for (char var5 = var0.charAt(3);
         method_218(var1) != var2 || method_218(var1 + 1) != var3 || method_218(var1 + 2) != var4 || method_218(var1 + 3) != var5;
         var1 += 6
      ) {
         if (method_218(var1) == 32) {
            return -1;
         }
      }

      return method_219(var1 + 4);
   }

   // $VF: renamed from: x (int) void
   private static void method_198(int var0) {
      if (field_191 == field_190.length) {
         System.out.println("* vm stack overflow");
      }

      field_190[field_191++] = var0;
   }

   // $VF: renamed from: c () int
   private static int method_199() {
      if (field_191 == 0) {
         System.out.println("* vm stack underflow");
      }

      return field_190[--field_191];
   }

   // $VF: renamed from: g () boolean
   private static boolean method_200() {
      return field_191 == 0;
   }

   // $VF: renamed from: b (java.lang.String) void
   private static void method_201(String var0) {
      int var1 = 0;
      int var2 = 0;

      for (var2 = 0; var2 < var0.length(); var2++) {
         char var3;
         if ((var3 = var0.charAt(var2)) == '.') {
            var1 = method_218(field_189++);
            break;
         }

         method_202(var3, var2);
      }

      if (var1 > 0) {
         char var5 = var0.charAt(var0.length() - 1);

         while (var1-- > 0) {
            method_202(var5, var2++);
         }
      }

      field_192 = var2;
   }

   // $VF: renamed from: a (char, int) void
   private static void method_202(char var0, int var1) {
      switch (var0) {
         case 'B':
            field_193[var1] = method_218(field_189++);
            return;
         case 'W':
            field_193[var1] = method_220(field_189);
            field_189 += 2;
            return;
         case 'b':
            field_193[var1] = method_217(field_189++);
            return;
         case 'w':
            field_193[var1] = method_219(field_189);
            field_189 += 2;
            return;
         default:
            System.out.println("error fatal vmArg(" + var0 + ")");
      }
   }

   // $VF: renamed from: S () void
   private static void method_203() {
      field_197 = field_200;
      field_198 = field_201;
      field_194 = 0;
      int var0;
      if ((var0 = method_194(field_200, field_201)) >= 0) {
         for (; method_218(var0) != 255; var0 += 5) {
            if (method_218(var0) != 0 && method_192(method_218(var0)) && method_219(var0 + 1) >= 0) {
               field_196[field_194] = method_218(var0);
               field_195[field_194] = method_220(var0 + 1);
               field_194++;
            }
         }
      }
   }

   // $VF: renamed from: T () void
   private static void method_204() {
      field_197 = field_200;
      field_198 = field_201;
      field_199 = field_202;
      field_194 = 0;
      int var0;
      if ((var0 = method_194(field_200, field_201)) >= 0) {
         if ((var0 = method_195(var0, field_202)) >= 0) {
            for (int var1 = 0; var1 < field_192; var1++) {
               int var2 = field_193[var1];
               int var3 = var0;

               while (method_218(var3) != 255 && method_218(var3) != var2) {
                  var3 += 5;
               }

               if (method_218(var3) != 255 && method_219(var3 + 1) != -1) {
                  field_196[field_194] = method_218(var3);
                  field_195[field_194] = method_220(var3 + 1);
                  field_194++;
               }
            }
         }
      }
   }

   // $VF: renamed from: y (int) void
   private static void method_205(int var0) {
      method_186(field_197, field_198, field_196[var0], 0);
   }

   // $VF: renamed from: z (int) void
   private static void method_206(int var0) {
      method_186(field_197, field_198, field_199, field_196[var0]);
   }

   // $VF: renamed from: h (int, int) int
   private static int method_207(int var0, int var1) {
      for (int var2 = field_181; method_218(var2) != 255; var2 += 6) {
         if (method_218(var2) == var0 && method_218(var2 + 1) == var1) {
            if (method_218(var2 + 1) == 255) {
               return -1;
            }

            return method_218(var2 + 2);
         }
      }

      return -1;
   }

   // $VF: renamed from: i (int, int) int
   private static int method_208(int var0, int var1) {
      for (int var2 = field_181; method_218(var2) != 255; var2 += 6) {
         if (method_218(var2) == var0 && method_218(var2 + 1) == var1) {
            return method_218(var2 + 3);
         }
      }

      return 0;
   }

   // $VF: renamed from: A (int) void
   private static void method_209(int var0) {
      if (field_211[var0] >= 0) {
         method_161(field_211[var0]);
         field_211[var0] = -1;
      }

      if (field_210[var0] >= 0) {
         method_150(field_210[var0]);
         field_210[var0] = -1;
      }
   }

   // $VF: renamed from: d (int, int, int) int
   private static int method_210(int var0, int var1, int var2) {
      int var3 = method_156(var0, var1, var2);

      for (int var4 = 0; var4 < field_205; var4++) {
         if (field_210[var4] < 0 && field_207[var4] == var3) {
            return var4;
         }
      }

      int var8 = field_156;
      int var5 = field_157;
      int var6 = field_158;

      for (int var7 = 0; var7 < field_205; var7++) {
         if (field_210[var7] >= 0) {
            method_140(field_210[var7]);
            if (field_156 == var0 && field_157 == var1 && field_158 == var2) {
               field_156 = var8;
               field_157 = var5;
               field_158 = var6;
               return var7;
            }

            field_156 = var8;
            field_157 = var5;
            field_158 = var6;
         }
      }

      return -1;
   }

   // $VF: renamed from: B (int) void
   private static void method_211(int var0) {
      field_200 = -1;
      field_201 = -1;
      field_202 = -1;
      field_189 = method_216(var0);
      field_191 = 0;
      method_187();
   }

   // $VF: renamed from: c (int, int, int, int) int
   private static int method_212(int var0, int var1, int var2, int var3) {
      int var4 = field_186;

      while (method_218(var4) != 255) {
         if (method_218(var4 + 1) != var0 || method_218(var4 + 2) != var1 || method_218(var4) != var2 && method_218(var4) != var3) {
            if (method_218(var4 + 4) != var0 || method_218(var4 + 5) != var1 || method_218(var4 + 3) != var2 && method_218(var4 + 3) != var3) {
               var4 += 6;
               continue;
            }

            return (method_218(var4) << 16) + (method_218(var4 + 1) << 8) + method_218(var4 + 2);
         }

         return (method_218(var4 + 3) << 16) + (method_218(var4 + 4) << 8) + method_218(var4 + 5);
      }

      return -1;
   }

   // $VF: renamed from: U () void
   private static void method_213() {
      for (int var0 = 0; var0 < field_206.length; var0++) {
         field_216[var0] = (byte)field_206[var0];
      }

      for (int var1 = 0; var1 < field_213.length; var1++) {
         field_217[var1] = (short)field_213[var1];
      }

      for (int var2 = 0; var2 < field_214.length; var2++) {
         field_218[var2] = (short)field_214[var2];
      }

      for (int var3 = 0; var3 < field_215.length; var3++) {
         field_219[var3] = (byte)field_215[var3];
      }

      for (int var4 = 0; var4 < field_203.length; var4++) {
         field_220[var4] = field_203[var4];
      }
   }

   // $VF: renamed from: u (int) int
   private static int method_214(int var0) {
      return field_182 + var0;
   }

   // $VF: renamed from: v (int) int
   private static int method_215(int var0) {
      return field_183 + var0;
   }

   // $VF: renamed from: w (int) int
   private static int method_216(int var0) {
      return field_184 + var0;
   }

   // $VF: renamed from: x (int) int
   private static int method_217(int var0) {
      return field_188[var0];
   }

   // $VF: renamed from: y (int) int
   private static int method_218(int var0) {
      return field_188[var0] & 0xFF;
   }

   // $VF: renamed from: z (int) int
   private static int method_219(int var0) {
      return method_221(field_188[var0], field_188[var0 + 1]);
   }

   // $VF: renamed from: A (int) int
   private static int method_220(int var0) {
      return (field_188[var0] & 0xFF) << 8 | field_188[var0 + 1] & 0xFF;
   }

   // $VF: renamed from: j (int, int) int
   private static int method_221(int var0, int var1) {
      int var2;
      if (((var2 = var0 << 8 | var1 & 0xFF) & 32768) != 0) {
         var2 |= -65536;
      }

      return var2;
   }

   // $VF: renamed from: r () void
   public static final void method_222() {
      field_226 = 0;
   }

   // $VF: renamed from: d (boolean) void
   private static void method_223(boolean var0) {
      if (method_76()) {
         if (var0) {
            if (field_230 >= 0) {
               method_69(field_230, true);
               return;
            }
         } else {
            if (method_72() >= 0 && method_73()) {
               field_230 = method_72();
            } else {
               field_230 = -1;
            }

            method_70();
         }
      }
   }

   // $VF: renamed from: V () void
   private static void method_224() {
      if (field_229) {
         method_226();
      } else {
         method_225();
      }
   }

   // $VF: renamed from: W () void
   private static void method_225() {
      if (method_76()) {
         method_77(false);
         method_70();
      } else {
         method_77(true);
         if (field_226 != 5 && field_226 != 6) {
            if (field_226 == 2 && !field_390) {
               method_69(1, true);
            }
         } else {
            method_69(0, true);
         }
      }
   }

   // $VF: renamed from: X () void
   private static void method_226() {
      if (method_76()) {
         if (field_71[3] == 33) {
            field_71[3] = 66;
            method_75(field_71[3]);
            return;
         }

         if (field_71[3] == 66) {
            field_71[3] = 100;
            method_75(field_71[3]);
            return;
         }

         if (field_71[3] == 100) {
            method_77(false);
            field_71[3] = 0;
            method_70();
            return;
         }
      } else {
         method_77(true);
         field_71[3] = 33;
         method_75(field_71[3]);
         if (field_226 == 5 || field_226 == 6) {
            method_69(0, true);
            return;
         }

         if (field_226 == 2 && !field_390) {
            method_69(1, true);
         }
      }
   }

   // $VF: renamed from: o (int) void
   public static void method_227(int var0) {
      if (var0 == 0) {
         if (field_226 == 2) {
            method_331();
         }

         method_223(false);
         field_227 = field_226;
         field_226 = 1;
      } else if (field_227 != 1) {
         field_226 = field_227;
         field_227 = 1;
         method_223(true);
         if (field_226 == 2) {
            method_307();
         }
      }
   }

   // $VF: renamed from: s () void
   public static final void method_228() {
      if (field_226 != 1) {
         switch (field_226) {
            case 0:
               method_230();
               return;
            case 2:
               method_306();
               return;
            case 3:
               method_232();
               return;
            case 4:
               method_235();
               return;
            case 5:
               method_279();
               return;
            case 6:
               method_298();
               return;
            case 7:
               method_241();
               return;
            case 8:
               method_302();
               return;
            case 9:
               method_303();
            case 1:
         }
      }
   }

   // $VF: renamed from: c (javax.microedition.lcdui.Graphics) void
   public static final void method_229(Graphics var0) {
      field_228 = var0;
      switch (field_226) {
         case 2:
            method_308();
            break;
         case 3:
            method_233();
            break;
         case 4:
            method_239();
            break;
         case 5:
            method_280();
            break;
         case 6:
            method_299();
            break;
         case 7:
            method_242();
            break;
         case 8:
            method_304();
            break;
         case 9:
            method_304();
      }

      field_228 = null;
   }

   // $VF: renamed from: Y () void
   private static void method_230() {
      field_222 = field_31;
      field_223 = field_32;
      field_224 = field_222 >> 1;
      field_225 = field_223 >> 1;
      if (field_71[0] == -1) {
         field_71[0] = 1;
         field_71[1] = -1;
         field_71[2] = 1;
         field_71[3] = 66;
         field_71[4] = 0;
      }

      if (field_71[1] != -1) {
         method_9(field_71[1]);
      }

      field_170 = new class_2(field_28);
      method_98();
      method_158(64);
      method_100(field_222, field_223);
      method_104(7);
      method_103(3 * field_92);
      field_229 = method_74(3);
      method_231();
   }

   // $VF: renamed from: Z () void
   private static void method_231() {
      field_233 = 0;
      field_235 = method_90(field_231[0]);
      field_234 = 32;
      field_226 = 3;
   }

   // $VF: renamed from: aa () void
   private static void method_232() {
      if (hasNewKeyPress() || --field_234 <= 0) {
         field_233++;
         if (field_233 == field_231.length) {
            field_235 = null;
            method_234();
         } else {
            field_235 = null;
            field_235 = method_90(field_231[field_233]);
            field_234 = 32;
         }
      }
   }

   // $VF: renamed from: ab () void
   private static void method_233() {
      field_228.setColor(field_232[field_233]);
      field_228.fillRect(0, 0, field_222, field_223);
      field_228.drawImage(field_235, field_222 >> 1, field_223 >> 1, 3);
   }

   // $VF: renamed from: ac () void
   private static void method_234() {
      field_287 = method_90(27);
      field_289 = 28;
      method_32(2);
      method_37(1, 2);
      method_48(2, 0);
      field_288 = 8;
      method_32(3);
      field_235 = method_90(21);
      field_236 = method_90(22);
      int var0;
      if ((var0 = (field_223 - (field_236.getHeight() + field_235.getHeight())) / 3) < 0) {
         var0 = 0;
      }

      field_241 = var0;
      field_239 = 16;
      field_240 = var0 * 2 + field_236.getHeight();
      field_238 = field_222 >> 1;
      field_237 = 0;
      field_226 = 4;
   }

   // $VF: renamed from: ad () void
   private static void method_235() {
      switch (field_237) {
         case 0:
            if (hasNewKeyPress() || --field_239 <= 0) {
               field_237++;
               return;
            }
            break;
         case 1:
            if (!method_236() && field_71[1] == -1) {
               method_238();
               return;
            }

            method_63("b");
            method_237();
            return;
         case 2:
            int var0;
            if ((var0 = method_269()) == 0) {
               method_77(true);
               if (field_71[3] == 0) {
                  field_71[3] = 66;
               }

               if (field_229) {
                  method_75(field_71[3]);
               }

               method_69(0, true);
               field_237++;
               return;
            }

            if (var0 == 1) {
               method_77(false);
               field_71[3] = 0;
               field_237++;
               return;
            }
            break;
         case 3:
            if (field_238 <= 0) {
               method_277();
               return;
            }

            if (hasNewKeyPress()) {
               field_238 = 0;
               return;
            }

            if (field_238 >> 2 == 0) {
               field_238--;
               return;
            }

            field_238 = field_238 - (field_238 >> 2);
            return;
         case 4:
            method_261();
      }
   }

   // $VF: renamed from: h () boolean
   private static boolean method_236() {
      return field_26 == null || field_26.length <= 1;
   }

   // $VF: renamed from: ae () void
   private static void method_237() {
      method_265(25, 26);
      method_266(20, 21);
      int var0 = field_236.getHeight();
      method_267(1, var0 + 20, field_223 - var0 - 40, 1);
      field_237 = 2;
   }

   // $VF: renamed from: af () void
   private static void method_238() {
      method_243();
      method_255();
      if (!field_243) {
         field_242 = new Object[field_27.length];

         for (int var0 = 0; var0 < field_27.length; var0++) {
            field_242[var0] = method_57(field_27[var0]);
         }

         field_243 = true;
      }

      for (int var1 = 0; var1 < field_242.length; var1++) {
         method_256(method_246((byte[])field_242[var1]), 32 + var1);
      }

      if (field_226 == 4) {
         method_258(field_222 >> 1, field_236.getHeight(), field_223 - field_236.getHeight(), 0);
         field_237 = 4;
      } else {
         method_292(0);
      }
   }

   // $VF: renamed from: ag () void
   private static void method_239() {
      if (field_237 == 2) {
         method_270();
      } else {
         method_242();
      }

      if (field_237 == 4) {
         method_262();
      }
   }

   // $VF: renamed from: ah () void
   private static void method_240() {
      field_244 = 0;

      for (int var0 = 0; var0 < field_245; var0++) {
         field_252[var0] = field_222 + (field_222 >> 1);
      }

      field_226 = 7;
   }

   // $VF: renamed from: ai () void
   private static void method_241() {
      method_249();
      boolean var0 = true;

      for (int var1 = 0; var1 < field_245; var1++) {
         var0 = var0 && field_247[var1] == field_252[var1];
      }

      if (field_238 + (field_235.getWidth() >> 1) >= 0) {
         field_244++;
         field_238 = field_238 - field_244;
      } else {
         if (var0) {
            method_301(0);
         }
      }
   }

   // $VF: renamed from: aj () void
   private static void method_242() {
      field_228.setColor(65793);
      field_228.fillRect(0, 0, field_222, field_223);
      field_228.drawImage(field_235, field_238, field_240, 17);
      field_228.drawImage(field_236, field_222 >> 1, field_241, 17);
   }

   // $VF: renamed from: ak () void
   private static void method_243() {
      field_245 = 0;
   }

   // $VF: renamed from: B (int) int
   private static int method_244(int var0) {
      return method_246(method_51(var0));
   }

   // $VF: renamed from: C (int) void
   private static void method_245(int var0) {
      field_248[var0] = -38;
   }

   // $VF: renamed from: b (byte[]) int
   private static int method_246(byte[] var0) {
      field_246[field_245] = var0;
      field_247[field_245] = 0;
      field_248[field_245] = 0;
      method_48(2, 0);
      field_249[field_245] = method_55(var0);
      method_48(3, 0);
      field_250[field_245] = method_55(var0);
      field_251[field_245] = method_247(field_245);
      field_253[field_245] = field_251[field_245];
      field_252[field_245] = 0;
      field_254[field_245] = 0;
      field_245++;
      return field_245 - 1;
   }

   // $VF: renamed from: C (int) int
   private static int method_247(int var0) {
      return Math.max(field_249[var0], field_250[var0]);
   }

   // $VF: renamed from: D (int) void
   private static void method_248(int var0) {
      int var1 = field_252[var0] - field_247[var0];
      field_247[var0] = field_247[var0] + (var1 >> 1);
      if (var1 >> 1 == 0) {
         field_247[var0] = field_252[var0];
      }

      var1 = field_253[var0] - field_251[var0];
      field_251[var0] = field_251[var0] + (var1 >> 1);
      if (var1 >> 1 == 0) {
         field_251[var0] = field_253[var0];
      }
   }

   // $VF: renamed from: al () void
   private static void method_249() {
      for (int var0 = 0; var0 < field_245; var0++) {
         method_248(var0);
      }
   }

   // $VF: renamed from: am () void
   private static void method_250() {
      for (int var0 = 0; var0 < field_245; var0++) {
         method_251(var0);
      }
   }

   // $VF: renamed from: E (int) void
   private static void method_251(int var0) {
      if (field_247[var0] >= -19) {
         method_252(field_247[var0], field_248[var0], field_251[var0], field_254[var0] != 0);
         int var1 = 0;
         if (field_254[var0] != 0) {
            method_48(2, 0);
            var1 = field_249[var0];
         } else {
            method_48(3, 0);
            var1 = field_250[var0];
         }

         method_56((byte[])field_246[var0], field_247[var0] - (var1 >> 1), field_248[var0] - field_288);
      }
   }

   // $VF: renamed from: a (int, int, int, boolean) void
   private static void method_252(int var0, int var1, int var2, boolean var3) {
      int var4 = var3 ? -19 : 0;
      var0 = var0 - (var2 >> 1) - 3;
      var1 -= 9;
      field_228.setClip(var0, var1, 3, 19);
      field_228.drawImage(field_287, var0, var1 + var4, 20);
      var0 += 3;

      for (int var5 = 0; var5 < var2; var5 += 16) {
         field_228.setClip(var0 + var5, var1, Math.min(16, var2 - var5), 19);
         field_228.drawImage(field_287, var0 + var5 - 3, var1 + var4, 20);
      }

      var0 += var2;
      field_228.setClip(var0, var1, 3, 19);
      field_228.drawImage(field_287, var0 - 19, var1 + var4, 20);
      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: l (int, int) void
   private static void method_253(int var0, int var1) {
      var0 -= 5;
      var1 -= 3;
      field_228.setClip(var0, var1, 11, 7);
      field_228.drawImage(field_287, var0, var1 - 38, 20);
      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: m (int, int) void
   private static void method_254(int var0, int var1) {
      var0 -= 5;
      var1 -= 3;
      field_228.setClip(var0, var1, 11, 7);
      field_228.drawImage(field_287, var0 - 11, var1 - 38, 20);
      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: an () void
   private static void method_255() {
      field_255 = 0;
   }

   // $VF: renamed from: n (int, int) void
   private static void method_256(int var0, int var1) {
      field_256[field_255] = var0;
      field_257[field_255] = var1;
      field_255++;
   }

   // $VF: renamed from: d () int
   private static int method_257() {
      return field_255;
   }

   // $VF: renamed from: m (int, int, int, int) void
   private static void method_258(int var0, int var1, int var2, int var3) {
      field_258 = var0;
      var2 = Math.max(var2, field_289 * 3);
      int var4 = Math.min(method_257(), var2 / field_289);
      field_259 = var1 + (var2 - var4 * field_289 >> 1);
      field_260 = var2 - (field_259 - var1);
      field_261 = var3;
      field_265 = -1;
      field_266 = -1;
      field_267 = false;
      field_262 = 0;

      for (int var5 = 0; var5 < field_255; var5++) {
         int var6;
         field_262 = Math.max(method_247(var6 = field_256[var5]), field_262);
      }

      field_262 += 16;

      for (int var9 = 0; var9 < field_255; var9++) {
         int var11;
         method_245(var11 = field_256[var9]);
         field_251[var11] = field_262;
         field_253[var11] = field_262;
      }

      method_260();
      var1 = field_259 + (field_289 >> 1);
      if (field_263 > 0) {
         var1 += field_289;
      }

      for (int var10 = field_263; var10 <= field_264; var10++) {
         int var12 = field_256[var10];
         field_247[var12] = field_222 + var10 * field_224;
         field_248[var12] = var1;
         field_252[var12] = field_258;
         var1 += field_289;
         if (var10 == field_261) {
            field_253[var12] = field_262 + 16;
            field_254[var12] = 1;
         } else {
            field_253[var12] = field_262;
            field_254[var12] = 0;
         }
      }
   }

   // $VF: renamed from: ao () void
   private static void method_259() {
      field_267 = true;

      for (int var0 = 0; var0 < field_255; var0++) {
         int var1;
         method_245(var1 = field_256[var0]);
         field_253[var1] = field_262;
      }

      method_260();
      int var3 = field_259 + (field_289 >> 1);
      if (field_263 > 0) {
         field_265 = var3;
         var3 += 32;
      } else {
         field_265 = -1;
      }

      for (int var4 = field_263; var4 <= field_264; var4++) {
         int var2 = field_256[var4];
         field_247[var2] = field_252[var2] = field_258;
         field_248[var2] = var3;
         var3 += field_289;
         if (var4 == field_261) {
            field_254[var2] = 1;
            field_253[var2] = field_262 + 16;
         } else {
            field_254[var2] = 0;
            field_253[var2] = field_262;
         }
      }

      if (field_264 < method_257() - 1) {
         field_266 = var3;
      } else {
         field_266 = -1;
      }
   }

   // $VF: renamed from: ap () void
   private static void method_260() {
      int var0;
      int var1 = Math.min(var0 = method_257(), field_260 / field_289);
      field_263 = 0;
      if (var1 < var0) {
         field_263 = field_261 - (var1 >> 1);
         if (field_263 < 0) {
            field_263 = 0;
         }

         if (field_263 + var1 > var0) {
            field_263 = var0 - var1;
         }
      }

      field_264 = field_263 + var1 - 1;
      if (field_264 >= var0) {
         field_263--;
         field_264--;
      }

      if (field_263 > 0) {
         field_263++;
      }

      if (field_264 < var0 - 1) {
         field_264--;
      }
   }

   // $VF: renamed from: aq () void
   private static void method_261() {
      boolean var0 = true;

      for (int var1 = 0; var1 < field_255; var1++) {
         int var2;
         method_248(var2 = field_256[var1]);
         var0 = var0 && field_247[var2] == field_252[var2];
      }

      if (var0 && !field_267) {
         field_267 = true;
         method_259();
      }

      if (isKeyJustPressed(1)) {
         if (field_261 == 0) {
            field_261 = method_257() - 1;
         } else {
            field_261--;
         }

         method_259();
      } else if (isKeyJustPressed(2)) {
         if (field_261 == method_257() - 1) {
            field_261 = 0;
         } else {
            field_261++;
         }

         method_259();
      } else {
         if (isKeyJustPressed(393232)) {
            if (!var0) {
               method_259();
            }

            method_293(field_261);
         }
      }
   }

   // $VF: renamed from: ar () void
   private static void method_262() {
      if (field_265 >= 0) {
         method_253(field_258, field_265);
      }

      method_250();
      if (field_266 >= 0) {
         method_254(field_258, field_266);
      }
   }

   // $VF: renamed from: as () void
   private static void method_263() {
      field_269[field_268++] = field_261;
   }

   // $VF: renamed from: e () int
   private static int method_264() {
      int var0 = 0;
      if (field_268 != 0) {
         var0 = field_269[--field_268];
      }

      return var0;
   }

   // $VF: renamed from: o (int, int) void
   private static void method_265(int var0, int var1) {
      field_270 = var0;
      field_271 = var1;
   }

   // $VF: renamed from: p (int, int) void
   private static void method_266(int var0, int var1) {
      field_278 = var0;
      field_279 = var1;
   }

   // $VF: renamed from: n (int, int, int, int) void
   private static void method_267(int var0, int var1, int var2, int var3) {
      field_272 = var0;
      method_48(2, 0);
      field_280 = method_61(field_222 - 16, field_270, field_271, 0);
      int var4 = field_280 * 16;
      field_274 = Math.min(var2, var4);
      field_275 = var1 + (field_223 - var1 - 20 - field_274 >> 1);
      field_273 = 0;
      field_281 = field_274 / 16;
      field_277 = 0;
      field_282 = var3;
      field_276 = 7;
      if (var0 == 1) {
         field_276 |= 8;
      }

      if (var0 == 1 && (var1 = field_275 + field_274 + 20 + 19 + 2) > field_223) {
         field_275 = field_275 - (var1 - field_223);
      }
   }

   // $VF: renamed from: F (int) void
   private static void method_268(int var0) {
      field_277 = var0;
      field_276 |= 8;
   }

   // $VF: renamed from: f () int
   private static int method_269() {
      if (isKeyActive(1) && field_273 > 0) {
         field_273--;
         if (field_273 == 0) {
            field_276 |= 1;
         } else if (field_273 + field_281 < field_280) {
            field_276 |= 4;
         }

         field_276 |= 2;
      } else if (isKeyActive(2) && field_273 + field_281 < field_280) {
         field_273++;
         if (field_273 == 1) {
            field_276 |= 1;
         } else if (field_273 + field_281 >= field_280) {
            field_276 |= 4;
         }

         field_276 |= 2;
      } else if (field_272 == 1 && field_277 == 1 && isKeyJustPressed(4)) {
         method_268(0);
      } else if (field_272 == 1 && field_277 == 0 && isKeyJustPressed(8)) {
         method_268(1);
      } else {
         if (field_272 == 1 && isKeyJustPressed(131072)) {
            field_277 = 0;
            return field_277;
         }

         if (field_272 == 1 && isKeyJustPressed(262144)) {
            field_277 = 1;
            return field_277;
         }

         if (isKeyJustPressed(393232)) {
            if (field_272 == 1) {
               return field_277;
            }

            return 0;
         }
      }

      return -1;
   }

   // $VF: renamed from: at () void
   private static void method_270() {
      if ((field_276 & 1) > 0) {
         if (field_273 > 0) {
            method_253(field_224, field_275 - 10);
         } else {
            method_272(field_275 - 20);
         }
      }

      if ((field_276 & 4) > 0) {
         method_273(field_275 + field_274);
         if (field_273 + field_281 < field_280) {
            method_254(field_224, field_275 + field_274 + 10);
         }
      }

      if ((field_276 & 2) > 0) {
         field_228.setColor(2442057);
         field_228.fillRect(0, field_275, field_222, field_274);
         method_48(2, 0);
         method_62(8, field_275, field_222 - 16, field_274, field_270, field_271, field_273, field_282);
      }

      if ((field_276 & 8) > 0) {
         field_228.setClip(0, 0, field_222, field_223);
         int var0 = field_275 + field_274 + 20 + 9 + 2;
         method_48(2, 0);
         int var1 = Math.max(method_67(field_278), method_67(field_279));
         method_271(field_278, var0, var1, true, field_277 == 0);
         method_271(field_279, var0, var1, false, field_277 == 1);
      }

      field_276 = 0;
   }

   // $VF: renamed from: a (int, int, int, boolean, boolean) void
   private static void method_271(int var0, int var1, int var2, boolean var3, boolean var4) {
      int var5 = var3 ? field_222 >> 2 : field_222 - (field_222 >> 2);
      if (var4) {
         method_252(var5, var1, var2 + 38, true);
         method_48(2, 0);
      } else {
         method_252(var5, var1, var2 + 38, false);
         method_48(3, 0);
      }

      var1 -= 8;
      method_54(var5 - (var2 >> 1), var1, var0);
   }

   // $VF: renamed from: G (int) void
   private static void method_272(int var0) {
      for (int var1 = 0; var1 < field_222; var1 += 3) {
         field_228.setClip(var1, var0, 3, 20);
         field_228.drawImage(field_287, var1 - 22, var0, 20);
      }

      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: H (int) void
   private static void method_273(int var0) {
      for (int var1 = 0; var1 < field_222; var1 += 3) {
         field_228.setClip(var1, var0, 3, 20);
         field_228.drawImage(field_287, var1 - 25, var0, 20);
      }

      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: I (int) void
   private static void method_274(int var0) {
      field_283 = 0;
      field_284 = var0;
      field_285 = 0;
   }

   // $VF: renamed from: au () void
   private static void method_275() {
      field_283++;
      if (field_283 > 24) {
         field_283 = 0;
      }
   }

   // $VF: renamed from: av () void
   private static void method_276() {
      int var0 = field_284 + (field_223 - field_284 - 20 - 32 >> 1);
      if (field_285 == 0) {
         method_272(var0 - 20);
         method_48(2, 0);
         method_54(field_222 - method_67(16) >> 1, var0 - 10 - field_288, 16);
         method_273(var0 + 32);
         field_285++;
      }

      int var1 = field_222 >> 2;
      field_228.setColor(2442057);
      field_228.fillRect(0, var0, field_222, 32);
      field_228.setClip(var1, var0, field_224, 32);
      int var2 = var1 * 3 - field_283;

      int var3;
      do {
         var3 = var2;
         int var4 = var0 + 16;

         for (int var5 = 0; var5 < field_286.length; var5 += 2) {
            int var6 = field_286[var5];
            int var7 = field_286[var5 + 1];
            int var8 = Math.abs(var1 - Math.abs(var2 - field_224));
            int var9 = 37 + var8 * 218 / var1;
            int var10 = 67 + var8 * 188 / var1;
            int var11 = 73 + var8 * 182 / var1;
            var9 = Math.max(0, Math.min(var9, 255));
            var10 = Math.max(0, Math.min(var10, 255));
            var11 = Math.max(0, Math.min(var11, 255));
            field_228.setColor(var9, var10, var11);
            field_228.drawLine(var2, var4, var2 + var7, var4 + var6 * var7);
            var2 += var7;
            var4 += var6 * var7;
         }
      } while ((var2 = var3 - 24) + 24 > var1);

      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: aw () void
   private static void method_277() {
      method_278();
   }

   // $VF: renamed from: ax () void
   private static void method_278() {
      method_283(0);
      field_226 = 5;
   }

   // $VF: renamed from: ay () void
   private static void method_279() {
      switch (field_290) {
         case 0:
            method_261();
            return;
         case 1:
            int var3;
            if ((var3 = method_269()) == 0) {
               method_70();
               field_30 = false;
               return;
            }

            if (var3 == 1) {
               field_290 = 0;
               return;
            }
            break;
         case 2:
            int var2;
            if ((var2 = method_269()) == 0) {
               field_71[4] = 0;
               method_240();
               return;
            }

            if (var2 == 1) {
               field_290 = 0;
               return;
            }
            break;
         case 3:
            field_290 = 2;
            return;
         case 4:
         default:
            break;
         case 5:
            int var1;
            if ((var1 = method_269()) == 0) {
               method_70();
               field_170.method_3();
               return;
            }

            if (var1 == 1) {
               field_290 = 0;
            }
            break;
         case 6:
            int var0;
            if ((var0 = method_269()) == 0) {
               field_290 = 0;
               field_170.method_5();
               return;
            }

            if (var0 == 1) {
               field_290 = 0;
               return;
            }
            break;
         case 7:
            field_290 = 1;
            return;
         case 8:
            if (method_328()) {
               method_329();
               return;
            }

            field_290 = 9;
            return;
         case 9:
            if (method_269() >= 0) {
               method_278();
               field_290 = 0;
               return;
            }
      }
   }

   // $VF: renamed from: az () void
   private static void method_280() {
      switch (field_290) {
         case 0:
            method_239();
            method_262();
            return;
         case 1:
         case 2:
         case 9:
            method_270();
            return;
         case 3:
         case 7:
            method_239();
         case 5:
            method_270();
         case 4:
         default:
            return;
         case 6:
            method_270();
            return;
         case 8:
            field_228.drawImage(field_236, field_222 >> 1, field_241, 17);
            field_276 = 7;
            method_270();
            method_330();
      }
   }

   // $VF: renamed from: aA () void
   private static void method_281() {
      method_265(26, 27);
      method_266(20, 21);
      int var0 = field_236.getHeight();
      method_267(1, var0 + 20, field_223 - var0 - 40, 1);
      field_290 = 7;
   }

   // $VF: renamed from: aB () void
   private static void method_282() {
      method_265(27, 28);
      method_266(20, 21);
      int var0 = field_236.getHeight();
      method_267(1, var0 + 20, field_223 - var0 - 40, 1);
      field_290 = 3;
   }

   // $VF: renamed from: J (int) void
   private static void method_283(int var0) {
      method_243();
      method_255();
      method_256(method_244(0), 0);
      method_256(method_244(3), 3);
      method_256(method_244(6), 6);
      if (field_170.method_1() | field_170.method_2()) {
         method_256(method_244(19), 14);
      }

      method_256(method_244(14), 7);
      method_292(var0);
   }

   // $VF: renamed from: K (int) void
   private static void method_284(int var0) {
      method_243();
      method_255();
      method_256(method_244(1), 1);
      method_256(method_244(2), 2);
      method_256(method_244(13), 8);
      method_292(var0);
   }

   // $VF: renamed from: aC () void
   private static void method_285() {
      method_243();
      method_255();
      method_256(method_244(4), 4);
      method_256(method_244(5), 5);
      method_256(method_244(13), 8);
      method_292(0);
   }

   // $VF: renamed from: aD () void
   private static void method_286() {
      method_243();
      method_255();
      if (field_170.method_1()) {
         method_256(method_244(19), 16);
      }

      if (field_170.method_2()) {
         method_256(method_244(18), 15);
      }

      method_256(method_244(13), 8);
      method_292(0);
   }

   // $VF: renamed from: aE () void
   private static void method_287() {
      method_265(28, 29);
      method_266(20, 21);
      int var0 = field_236.getHeight();
      method_267(1, var0 + 20, field_223 - var0 - 40, 1);
      field_290 = 6;
   }

   // $VF: renamed from: aF () void
   private static void method_288() {
      method_265(29, 30);
      method_266(20, 21);
      int var0 = field_236.getHeight();
      method_267(1, var0 + 20, field_223 - var0 - 40, 1);
      field_290 = 5;
   }

   // $VF: renamed from: L (int) void
   private static void method_289(int var0) {
      if (field_229) {
         method_291(var0);
      } else {
         method_290(var0);
      }
   }

   // $VF: renamed from: M (int) void
   private static void method_290(int var0) {
      boolean var1 = false;
      if (!method_236()) {
         var1 = true;
      }

      method_338(7, 8, 13, 8, var1);
      method_292(var0);
   }

   // $VF: renamed from: N (int) void
   private static void method_291(int var0) {
      boolean var1 = false;
      if (!method_236()) {
         var1 = true;
      }

      method_337(8, 11, 10, 9, 13, 8, var1);
      method_292(var0);
   }

   // $VF: renamed from: O (int) void
   private static void method_292(int var0) {
      int var1;
      var1 = (var1 = field_235.getWidth() >> 1) + (field_222 - var1 >> 1);
      int var2 = 0;

      for (int var3 = 0; var3 < field_255; var3++) {
         int var4;
         var2 = Math.max(method_247(var4 = field_256[var3]), var2);
      }

      var2 += 70;
      if (var1 + (var2 >> 1) > field_222) {
         var1 = field_224;
      }

      method_258(var1, field_236.getHeight(), field_223 - field_236.getHeight(), var0);
   }

   // $VF: renamed from: P (int) void
   private static void method_293(int var0) {
      int var1;
      switch (var1 = field_257[var0]) {
         case 0:
            if (method_349()) {
               method_263();
               method_284(0);
            } else {
               method_240();
            }
            break;
         case 1:
            method_264();
            method_240();
            break;
         case 2:
            method_264();
            method_282();
            break;
         case 3:
            method_263();
            method_285();
            break;
         case 4:
            method_263();
            method_297(30, 48);
            break;
         case 5:
            method_263();
            method_297(48, 55);
            break;
         case 6:
            method_263();
            method_289(0);
            break;
         case 7:
            method_281();
            break;
         case 8:
            method_283(method_264());
            break;
         case 9:
            method_294();
            break;
         case 10:
            field_321 = false;
            if (field_347 >= 0) {
               method_357();
            } else if (field_365 || field_366) {
               method_369();
            } else if (!method_188() && !method_328() && field_304 <= 0 && method_190(0) <= 0 && method_116(field_338) && field_335 >= 0) {
               method_211(field_335);
            }
            break;
         case 11:
            method_263();
            method_334();
            break;
         case 12:
            method_344();
            break;
         case 13:
            method_333(method_264());
            break;
         case 14:
            method_263();
            method_286();
            break;
         case 15:
            method_287();
            break;
         case 16:
            method_288();
            break;
         case 17:
            method_263();
            method_238();
      }

      if (var1 >= 32 && var1 < 32 + field_27.length) {
         field_71[1] = (byte)var0;
         method_9(var0);
         method_63("b");
         if (field_226 == 4) {
            method_237();
            return;
         }

         method_289(method_264());
      }
   }

   // $VF: renamed from: aG () void
   private static void method_294() {
      method_224();
      if (field_229) {
         method_296();
      } else {
         method_295();
      }
   }

   // $VF: renamed from: aH () void
   private static void method_295() {
      if (method_76()) {
         field_256[0] = field_291;
         field_251[field_291] = field_262;
         method_245(field_292);
         method_259();
      } else {
         field_256[0] = field_292;
         field_251[field_292] = field_262;
         method_245(field_291);
         method_259();
      }
   }

   // $VF: renamed from: aI () void
   private static void method_296() {
      if (method_76()) {
         if (field_71[3] == 33) {
            field_256[0] = field_295;
            field_251[field_295] = field_262;
            method_245(field_293);
            method_245(field_294);
         } else if (field_71[3] == 66) {
            field_256[0] = field_294;
            field_251[field_294] = field_262;
            method_245(field_293);
            method_245(field_295);
         } else {
            field_256[0] = field_293;
            field_251[field_293] = field_262;
            method_245(field_294);
            method_245(field_295);
         }

         method_245(field_292);
         method_259();
      } else {
         field_256[0] = field_292;
         field_251[field_292] = field_262;
         method_245(field_293);
         method_245(field_294);
         method_245(field_295);
         method_259();
      }
   }

   // $VF: renamed from: q (int, int) void
   private static void method_297(int var0, int var1) {
      method_243();
      method_265(var0, var1);
      int var2 = field_236.getHeight();
      method_267(0, var2 + 20, field_223 - var2 - 40, 4);
      field_226 = 6;
   }

   // $VF: renamed from: aJ () void
   private static void method_298() {
      if (method_269() >= 0) {
         int var1 = method_264();
         method_285();
         field_261 = var1;
         method_259();
         field_226 = 5;
      }
   }

   // $VF: renamed from: aK () void
   private static void method_299() {
      method_270();
   }

   // $VF: renamed from: aL () void
   private static void method_300() {
      if (field_298 != null && field_298.isAlive()) {
         Thread.yield();
      }
   }

   // $VF: renamed from: Q (int) void
   private static void method_301(int var0) {
      method_70();
      field_296 = var0;
      method_274(field_236.getHeight());
      field_226 = 8;
   }

   // $VF: renamed from: aM () void
   private static void method_302() {
      method_275();
      field_226 = 9;
      final int task = field_296;
      field_298 = new Thread(() -> { if (task == 0) class_3.method_408(); });
      field_298.setPriority(1);
      field_298.start();
   }

   // $VF: renamed from: aN () void
   private static void method_303() {
      if (!field_298.isAlive()) {
         field_298 = null;
         method_69(1, true);
         field_226 = field_297;
      } else {
         method_275();
      }
   }

   // $VF: renamed from: aO () void
   private static void method_304() {
      method_276();
   }

   // $VF: renamed from: aP () void
   private static void method_305() {
      field_236 = null;
      field_235 = null;
      field_321 = false;
      method_64();
      method_48(2, 0);
      method_91();
      method_300();
      method_32(0);
      method_300();
      method_32(1);
      method_300();
      method_38(0);
      method_300();
      method_38(1);
      method_300();
      method_63("a");
      method_300();
      method_179();
      method_300();
      method_181();
      field_326 = method_197("poid");
      field_327 = method_197("pwal");
      field_328 = method_197("pidl");
      field_329 = method_197("ptal");
      field_330 = method_197("ptak");
      field_331 = method_197("sroo");
      field_332 = method_197("eoid");
      field_333 = method_197("esal");
      field_334 = method_197("eent");
      field_335 = method_197("eobj");
      field_336 = method_197("excl");
      field_337 = method_197("flec");
      field_307 = method_197("s000");
      field_309 = method_197("s001");
      field_308 = method_197("s002");
      field_310 = method_197("s003");
      field_311 = method_197("s004");
      field_315 = method_197("s005");
      field_316 = method_197("s006");
      field_317 = method_197("s007");
      field_318 = method_197("s008");
      field_319 = method_197("s009");
      field_312 = method_197("s010");
      field_313 = method_197("s011");
      field_314 = method_197("s012");
      field_320 = method_197("s013");
      field_344 = 0;

      while (true) {
         int var0 = 0;
         if (field_344 <= 9) {
            var0 = method_197("sn0" + field_344);
         } else {
            var0 = method_197("sn" + field_344);
         }

         if (var0 == -1) {
            field_388 = 0;

            while (true) {
               if (field_388 <= 9) {
                  var0 = method_197("m00" + field_388);
               } else if (field_388 <= 99) {
                  var0 = method_197("m0" + field_388);
               } else {
                  var0 = method_197("m" + field_388);
               }

               if (var0 == -1) {
                  for (int var4 = 0; var4 < field_388; var4++) {
                     for (int var1 = 0; var1 < field_205; var1++) {
                        if (field_389[var4] == field_207[var1]) {
                           field_389[var4] = var1;
                           break;
                        }
                     }
                  }

                  field_399 = method_197("j000");
                  field_400 = method_197("j001");
                  field_401 = method_197("j002");
                  field_424 = method_197("j100");
                  field_425 = method_197("j101");
                  if (method_349()) {
                     method_347();
                     field_375 = field_323;
                  } else if (field_221 >= 0) {
                     field_375 = field_221;
                  } else {
                     field_375 = field_331;
                  }

                  field_376 = 3;
                  field_377 = -1;
                  field_347 = -1;
                  field_366 = false;
                  field_365 = false;
                  method_325();
                  field_362 = -1;
                  field_304 = -1;
                  field_341 = false;
                  method_191(0, 0);
                  field_390 = false;
                  field_407 = false;
                  method_379();
                  method_326();
                  method_388(false);
                  field_297 = 2;
                  return;
               }

               field_389[field_388++] = var0;
            }
         }

         field_345[field_344++] = var0;
      }
   }

   // $VF: renamed from: aQ () void
   private static void method_306() {
      if (field_321) {
         method_339();
      } else if (!isKeyJustPressed(131072) && (field_347 >= 0 && (field_347 < 0 || field_348 == 4) || !isKeyJustPressed(262144))) {
         if (method_328()) {
            method_329();
         } else {
            if (field_378) {
               field_378 = false;
               if (field_377 < 0) {
                  if (field_335 >= 0) {
                     method_211(field_335);
                     return;
                  }
               } else if (field_334 >= 0) {
                  method_211(field_334);
                  return;
               }
            }

            if (field_390) {
               method_395();
            }

            method_175();
            method_392();
            method_389();
            if (field_304 >= 0) {
               method_324();
            } else if (field_341) {
               method_355();
            } else {
               if (field_347 >= 0) {
                  method_360();
                  if (field_390) {
                     return;
                  }

                  if (field_347 >= 0) {
                     return;
                  }
               }

               if (field_365 || field_366) {
                  method_370();
               } else if (field_390) {
                  method_396();
               } else if (field_407) {
                  method_402();
               } else if (field_299 > 0) {
                  method_309();
               } else if (method_188()) {
                  method_187();
               } else {
                  if (method_76() && method_72() != 1) {
                     method_69(1, true);
                  }

                  if (method_190(0) > 0) {
                     method_191(0, 0);
                     method_379();
                     if (method_190(3) > 0) {
                        method_326();
                        method_388(false);
                     }
                  } else {
                     if (method_116(field_338)) {
                        method_352();
                     }
                  }
               }
            }
         }
      } else {
         method_331();
      }
   }

   // $VF: renamed from: aR () void
   private static void method_307() {
      if (field_321) {
         method_332();
      } else if (field_347 >= 0) {
         method_357();
      } else {
         if (field_365 || field_366) {
            method_369();
         }
      }
   }

   // $VF: renamed from: aS () void
   private static void method_308() {
      if (field_321) {
         if (field_322 != 4 && field_322 != 2) {
            if (field_390) {
               method_399();
            } else if (field_407) {
               method_407();
            } else {
               method_106(field_228);
            }

            method_330();
         }

         method_340();
      } else {
         if (field_347 >= 0) {
            field_228.setClip(0, 0, field_222, field_223 - field_358 - 20);
         }

         if (field_390) {
            method_399();
         } else if (field_407) {
            method_407();
         } else if ((field_365 || field_366) && field_372 == 0 || !field_365 && !field_366) {
            method_106(field_228);
         }

         if (field_347 >= 0) {
            method_362();
         }

         if (field_365 || field_366) {
            method_372();
         }

         method_330();
      }
   }

   // $VF: renamed from: aT () void
   private static void method_309() {
      byte var0 = 8;
      if ((field_300 & 1) > 0) {
         var0 = 4;
      }

      if (method_171(field_339) != field_327) {
         method_162(field_339, field_327, field_300, 2, true);
      } else {
         method_166(field_339, field_300);
      }

      method_94(field_338, field_300, Math.min(field_299, var0));
      field_299 = field_299 - Math.min(field_299, var0);
      if (field_299 == 0) {
         method_157(field_338);
      } else {
         method_353(field_338);
      }

      method_393();
   }

   // $VF: renamed from: R (int) void
   private static void method_310(int var0) {
      int var1;
      method_153(var1 = field_212[var0]);
      int var2 = field_156;
      int var3 = field_157;
      method_140(field_338);
      if (field_156 == var2 && field_157 == var3) {
         if ((field_109[field_338] & 63) >= (field_110[field_338] & 63)) {
            field_301 = method_142(var2) + 64 - 2;
            field_302 = method_142(var3) + 2;
            field_303 = 5;
         } else {
            field_301 = method_142(var2) + 2;
            field_302 = method_142(var3) + 64 - 2;
            field_303 = 1;
         }
      } else if (field_156 == var2 - 1 && field_157 == var3 - 1) {
         if (method_155(var2 - 1, var3, 1) && method_155(var2, var3 - 1, 1)) {
            field_301 = method_142(var2 - 1) + 64 - 2;
            field_302 = method_142(var3 - 1) + 64 - 2;
            field_303 = 1;
         } else if (method_155(var2, var3 - 1, 1)) {
            method_311(var2, var3);
         } else if (method_155(var2 - 1, var3, 1)) {
            method_312(var2, var3);
         } else if (method_155(var2 + 1, var3 - 1, 1)) {
            method_311(var2, var3);
         } else {
            method_312(var2, var3);
         }
      } else if (field_156 == var2 - 1 && field_157 == var3) {
         method_311(var2, var3);
      } else if (field_156 == var2 && field_157 == var3 - 1) {
         method_312(var2, var3);
      } else if (field_156 == var2 - 1 && field_157 == var3 + 1) {
         field_301 = method_142(var2 - 1) + 64 - 2;
         field_302 = method_142(var3 + 1) + 2;
         field_303 = 1;
      } else if (field_156 == var2 + 1 && field_157 == var3 - 1) {
         field_301 = method_142(var2 + 1) + 2;
         field_302 = method_142(var3 - 1) + 64 - 2;
         field_303 = 5;
      } else {
         label107: {
            if (field_156 == var2 + 1 && field_157 == var3 + 1) {
               if (method_155(var2, var3 + 1, 1) && method_155(var2 + 1, var3, 1)) {
                  field_301 = method_142(var2 + 1) + 2;
                  field_302 = method_142(var3 + 1) + 2;
                  field_303 = 5;
                  break label107;
               }

               if (method_155(var2 + 1, var3, 1)) {
                  method_313(var2, var3);
                  break label107;
               }

               if (!method_155(var2, var3 + 1, 1)) {
                  if (method_155(var2 + 1, var3 - 1, 1)) {
                     method_313(var2, var3);
                  } else {
                     method_314(var2, var3);
                  }
                  break label107;
               }
            } else if (field_156 == var2 && field_157 == var3 + 1) {
               method_313(var2, var3);
               break label107;
            }

            method_314(var2, var3);
         }
      }

      method_315(var0, method_95(field_303));
      method_162(field_339, field_327, method_165(field_339), 2, true);
      field_304 = var0;
   }

   // $VF: renamed from: r (int, int) void
   private static void method_311(int var0, int var1) {
      if (method_155(var0 - 1, var1 + 1, 1)) {
         field_301 = method_142(var0 - 1) + 64 - 2;
         field_302 = method_142(var1) + 64 - 2;
         field_303 = 1;
      } else {
         field_301 = method_142(var0 - 1) + 64 - 2;
         field_302 = method_142(var1 + 1) + 2;
         field_303 = 1;
      }
   }

   // $VF: renamed from: s (int, int) void
   private static void method_312(int var0, int var1) {
      if (method_155(var0 + 1, var1 - 1, 1)) {
         field_301 = method_142(var0) + 64 - 2;
         field_302 = method_142(var1 - 1) + 64 - 2;
         field_303 = 5;
      } else {
         field_301 = method_142(var0 + 1) + 2;
         field_302 = method_142(var1 - 1) + 64 - 2;
         field_303 = 5;
      }
   }

   // $VF: renamed from: t (int, int) void
   private static void method_313(int var0, int var1) {
      if (method_155(var0 - 1, var1 + 1, 1)) {
         field_301 = method_142(var0) + 2;
         field_302 = method_142(var1 + 1) + 2;
         field_303 = 1;
      } else {
         field_301 = method_142(var0 - 1) + 64 - 2;
         field_302 = method_142(var1 + 1) + 2;
         field_303 = 1;
      }
   }

   // $VF: renamed from: u (int, int) void
   private static void method_314(int var0, int var1) {
      if (method_155(var0 + 1, var1 - 1, 1)) {
         field_301 = method_142(var0 + 1) + 2;
         field_302 = method_142(var1) + 2;
         field_303 = 5;
      } else {
         field_301 = method_142(var0 + 1) + 2;
         field_302 = method_142(var1 - 1) + 64 - 2;
         field_303 = 5;
      }
   }

   // $VF: renamed from: v (int, int) void
   private static void method_315(int var0, int var1) {
      if (field_214[var0] >= 0 && field_209[var0] != 3 && field_210[var0] >= 0) {
         if (field_211[var0] < 0) {
            field_211[var0] = method_160(field_210[var0]);
         }

         method_162(field_211[var0], field_214[var0], var1, 16, true);
      }
   }

   // $VF: renamed from: aU () void
   private static void method_316() {
      method_162(field_339, field_329, method_165(field_339), 2, true);
   }

   // $VF: renamed from: S (int) void
   private static void method_317(int var0) {
      method_166(field_339, var0);
   }

   // $VF: renamed from: aV () void
   private static void method_318() {
      method_162(field_339, field_328, method_165(field_339), 0, false);
   }

   // $VF: renamed from: T (int) void
   private static void method_319(int var0) {
      byte var1 = 0;
      if (field_210[var0] >= 0) {
         method_135(field_109[field_338], field_110[field_338]);
         int var2 = field_159;
         method_135(field_109[field_210[var0]], field_110[field_210[var0]]);
         method_317(method_95(var1 = (byte)(var2 < field_159 ? 5 : 1)));
      }

      if (field_213[var0] >= 0 && field_210[var0] >= 0) {
         if (field_211[var0] < 0) {
            field_211[var0] = method_160(field_210[var0]);
         }

         method_162(field_211[var0], field_213[var0], var1, 2, true);
      }
   }

   // $VF: renamed from: U (int) void
   private static void method_320(int var0) {
      if (field_208[var0] == field_87) {
         method_135(field_109[field_338], field_110[field_338]);
         int var1 = field_159;
         if (field_210[var0] >= 0) {
            method_135(field_109[field_210[var0]], field_110[field_210[var0]]);
         } else {
            method_153(field_212[var0]);
            field_159 = method_142(field_156) + 32;
         }

         int var2;
         method_317(var2 = var1 < field_159 ? 1 : 5);
      }
   }

   // $VF: renamed from: V (int) void
   private static void method_321(int var0) {
      if (field_211[var0] >= 0) {
         method_315(var0, method_165(field_211[var0]));
      }
   }

   // $VF: renamed from: W (int) void
   private static void method_322(int var0) {
      if (var0 >= 0) {
         if (var0 == 0) {
            method_316();
         } else {
            for (int var1 = 0; var1 < field_205; var1++) {
               if (field_215[var1] == var0) {
                  method_319(var1);
                  return;
               }
            }
         }
      }
   }

   // $VF: renamed from: X (int) void
   private static void method_323(int var0) {
      if (var0 >= 0) {
         if (var0 == 0) {
            method_318();
         } else {
            for (int var1 = 0; var1 < field_205; var1++) {
               if (field_215[var1] == var0) {
                  method_321(var1);
                  return;
               }
            }
         }
      }
   }

   // $VF: renamed from: aW () void
   private static void method_324() {
      method_393();
      short var0 = field_109[field_338];
      short var1 = field_110[field_338];
      if (field_301 != var0) {
         int var4 = Math.min(8, Math.abs(field_301 - var0));
         if (field_301 < var0) {
            method_94(field_338, 6, var4);
            method_166(field_339, 6);
         } else {
            method_94(field_338, 2, var4);
            method_166(field_339, 2);
         }

         method_353(field_338);
      } else if (field_302 != var1) {
         int var3 = Math.min(8, Math.abs(field_302 - var1));
         if (field_302 < var1) {
            method_94(field_338, 0, var3);
            method_166(field_339, 0);
         } else {
            method_94(field_338, 4, var3);
            method_166(field_339, 4);
         }

         method_353(field_338);
      } else {
         method_162(field_339, field_328, field_303, 0, false);
         if (field_209[field_304] != 3) {
            field_209[field_304] = 0;
         }

         method_388(false);
         int var2 = field_304;
         field_304 = -1;
         method_185(var2);
      }
   }

   // $VF: renamed from: aX () void
   private static void method_325() {
      field_306 = -1;
   }

   // $VF: renamed from: aY () void
   private static void method_326() {
      field_305 = -22;
      field_306 = 359;
   }

   // $VF: renamed from: aZ () void
   private static void method_327() {
      field_305 = 22;
      field_306 = 1;
   }

   // $VF: renamed from: i () boolean
   private static boolean method_328() {
      return field_306 > 0 && field_306 < 360;
   }

   // $VF: renamed from: ba () void
   private static void method_329() {
      field_306 = field_306 + field_305;
      if (field_305 < 0 && field_306 < 0) {
         field_306 = 0;
      } else {
         if (field_305 > 0 && field_306 > 360) {
            field_306 = 360;
         }
      }
   }

   // $VF: renamed from: bb () void
   private static void method_330() {
      if (field_306 > 0) {
         field_228.setColor(0);
         field_228.fillArc(0 - field_224, 0 - field_225, field_222 + field_222, field_223 + field_223, 0, field_306);
      }
   }

   // $VF: renamed from: bc () void
   private static void method_331() {
      if (!field_321) {
         field_321 = true;
         method_333(0);
         field_322 = 0;
      }
   }

   // $VF: renamed from: bd () void
   private static void method_332() {
      if (field_322 == 4) {
         field_322 = 3;
         field_276 = 15;
      } else {
         if (field_322 == 2) {
            field_322 = 1;
            field_276 = 15;
         }
      }
   }

   // $VF: renamed from: Y (int) void
   private static void method_333(int var0) {
      method_243();
      method_255();
      method_256(method_244(field_307), 10);
      method_256(method_244(field_309), 11);
      method_256(method_244(field_308), 12);
      method_258(field_222 >> 1, 0, field_223, var0);
   }

   // $VF: renamed from: be () void
   private static void method_334() {
      if (field_229) {
         method_336();
      } else {
         method_335();
      }
   }

   // $VF: renamed from: bf () void
   private static void method_335() {
      method_338(field_310, field_311, field_315, 13, false);
      method_258(field_222 >> 1, 0, field_223, 0);
   }

   // $VF: renamed from: bg () void
   private static void method_336() {
      method_337(field_311, field_314, field_313, field_312, field_315, 13, false);
      method_258(field_222 >> 1, 0, field_223, 0);
   }

   // $VF: renamed from: a (int, int, int, int, int, int, boolean) void
   private static void method_337(int var0, int var1, int var2, int var3, int var4, int var5, boolean var6) {
      method_243();
      field_292 = method_244(var0);
      field_293 = method_244(var3);
      field_294 = method_244(var2);
      field_295 = method_244(var1);
      method_255();
      if (method_76()) {
         if (field_71[3] == 33) {
            method_256(field_295, 9);
            method_245(field_293);
            method_245(field_294);
         } else if (field_71[3] == 66) {
            method_256(field_294, 9);
            method_245(field_293);
            method_245(field_295);
         } else {
            method_256(field_293, 9);
            method_245(field_294);
            method_245(field_295);
         }

         method_245(field_292);
      } else {
         method_256(field_292, 9);
         method_245(field_293);
         method_245(field_294);
         method_245(field_295);
      }

      if (var6) {
         method_256(method_244(12), 17);
      }

      method_256(method_244(var4), var5);
   }

   // $VF: renamed from: b (int, int, int, int, boolean) void
   private static void method_338(int var0, int var1, int var2, int var3, boolean var4) {
      method_243();
      field_291 = method_244(var0);
      field_292 = method_244(var1);
      method_255();
      if (method_76()) {
         method_256(field_291, 9);
         method_245(field_292);
      } else {
         method_256(field_292, 9);
         method_245(field_291);
      }

      if (var4) {
         method_256(method_244(12), 17);
      }

      method_256(method_244(var2), var3);
   }

   // $VF: renamed from: bh () void
   private static void method_339() {
      switch (field_322) {
         case 0:
            method_261();
            return;
         case 1:
            field_322 = 2;
            return;
         case 2:
            int var1;
            if ((var1 = method_269()) == 0) {
               method_345();
               return;
            }

            if (var1 == 1) {
               field_322 = 0;
            }
            break;
         case 3:
            field_322 = 4;
            return;
         case 4:
            int var0;
            if ((var0 = method_269()) == 0) {
               method_346();
               method_342();
               return;
            }

            if (var0 == 1) {
               method_342();
               return;
            }
      }
   }

   // $VF: renamed from: bi () void
   private static void method_340() {
      switch (field_322) {
         case 0:
            method_262();
            return;
         case 1:
         case 2:
         case 3:
         case 4:
            method_270();
      }
   }

   // $VF: renamed from: bj () void
   private static void method_341() {
      method_398();
      method_403();
      field_363 = null;
      method_102();
      method_120();
      method_180();
      method_33(1);
      method_33(0);
      field_235 = method_90(21);
      field_236 = method_90(22);
      method_64();
      method_63("b");
      field_238 = 0;
   }

   // $VF: renamed from: bk () void
   private static void method_342() {
      method_341();
      method_278();
      method_69(0, true);
      field_290 = 0;
   }

   // $VF: renamed from: bl () void
   private static void method_343() {
      method_341();
      method_70();
      field_238 = 0;
      method_326();
      method_243();
      method_265(22, 23);
      int var0 = field_236.getHeight();
      method_267(0, var0 + 20, field_223 - var0 - 40, 1);
      field_290 = 8;
      field_226 = 5;
   }

   // $VF: renamed from: bm () void
   private static void method_344() {
      method_265(field_317, field_317 + 1);
      method_266(field_318, field_319);
      method_267(1, 20, field_223 - 40, 1);
      field_322 = 1;
   }

   // $VF: renamed from: bn () void
   private static void method_345() {
      method_265(field_316, field_316 + 1);
      method_266(field_318, field_319);
      method_267(1, 20, field_223 - 40, 1);
      field_322 = 3;
   }

   // $VF: renamed from: bo () void
   private static void method_346() {
      field_71[4] = 1;
      field_71[5] = (byte)field_323;
      field_71[6] = (byte)(field_324 >> 8);
      field_71[7] = (byte)(field_324 & 0xFF);
      field_71[8] = (byte)(field_325 >> 8);
      field_71[9] = (byte)(field_325 & 0xFF);
      method_183(10);
      method_83();
   }

   // $VF: renamed from: bp () void
   private static void method_347() {
      field_323 = field_71[5] & 255;
      field_324 = (field_71[6] & 255) << 8 | field_71[7] & 255;
      field_325 = (field_71[8] & 255) << 8 | field_71[9] & 255;
      method_182(10);
   }

   // $VF: renamed from: bq () void
   private static void method_348() {
      field_323 = field_87;
      field_324 = field_109[field_338];
      field_325 = field_110[field_338];
   }

   // $VF: renamed from: j () boolean
   private static boolean method_349() {
      return field_71[4] == 1;
   }

   // $VF: renamed from: i (int, int, int, int) void
   public static void method_350(int var0, int var1, int var2, int var3) {
      method_143(var0, var1, var2, var3);
   }

   // $VF: renamed from: Z (int) void
   private static void method_351(int var0) {
      if (method_165(field_339) != var0 || method_167(field_339) == 0) {
         method_162(field_339, field_327, var0, 2, true);
      }

      if ((var0 & 1) > 0) {
         method_383(var0, 4, 4);
      } else {
         method_383(var0, 8, 8);
      }

      method_393();
   }

   // $VF: renamed from: br () void
   private static void method_352() {
      method_348();
      boolean var0 = false;

      for (int var1 = 0; var1 < field_340.length; var1 += 3) {
         if (isKeyActive(field_340[var1]) && isKeyActive(field_340[var1 + 1])) {
            var0 = true;
            method_351(field_340[var1 + 2]);
            break;
         }
      }

      if (!var0) {
         method_162(field_339, field_328, method_165(field_339), 0, true);
         int var3;
         if (isKeyJustPressed(16) && (var3 = method_375(field_338)) >= 0) {
            method_310(var3);
         }
      }

      method_353(field_338);
   }

   // $VF: renamed from: aa (int) void
   private static void method_353(int var0) {
      method_157(var0);
   }

   // $VF: renamed from: bs () void
   private static void method_354() {
      field_341 = true;
      method_162(field_339, field_330, method_165(field_339), 2, false);
   }

   // $VF: renamed from: bt () void
   private static void method_355() {
      if (!method_164(field_339)) {
         field_341 = false;
         method_162(field_339, field_328, method_165(field_339), 0, true);
      }
   }

   // $VF: renamed from: w (int, int) void
   private static void method_356(int var0, int var1) {
      field_347 = var1;
      field_346 = var0;
      method_322(var0);
      field_350 = field_47[field_347];
      field_349 = field_350;
      field_351 = 0;
      field_352 = 14;
      field_358 = 48;
      field_357 = field_223 - field_358;
      field_354 = field_357 - 16;
      field_354 += 3;
      field_356 = 14 + field_358;
      field_348 = 0;
      field_353 = 4;
      field_355 = field_222 - 4;
      if (field_346 >= 0 && field_346 < field_344) {
         method_48(2, 0);
         field_361 = method_67(field_345[field_346]);
      }

      if (field_346 >= 0 && field_346 < field_343.length) {
         field_363 = method_90(field_343[field_346]);
      } else {
         field_363 = null;
      }

      if (field_363 != null) {
         if (field_346 == field_342) {
            field_359 = -field_363.getWidth();
            field_360 = 0;
         } else if (field_346 >= 0 && field_346 < field_343.length) {
            field_359 = field_222;
            field_360 = field_222 - field_363.getWidth();
         }
      }

      if (field_362 >= 0 && field_362 == field_346) {
         field_359 = field_360;
      }
   }

   // $VF: renamed from: bu () void
   private static void method_357() {
      field_348 = 7;
   }

   // $VF: renamed from: bv () void
   private static void method_358() {
      if (field_363 != null) {
         int var0;
         if ((var0 = field_360 - field_359 >> 1) == 0) {
            field_359 = field_360;
            return;
         }

         field_359 += var0;
      }
   }

   // $VF: renamed from: bw () void
   private static void method_359() {
      if (field_363 != null) {
         field_228.drawImage(field_363, field_359, field_357 - 20, 36);
      }
   }

   // $VF: renamed from: bx () void
   private static void method_360() {
      method_358();
      switch (field_348) {
         case 0:
            field_348 = 1;
            return;
         case 1:
            if (isKeyJustPressed(18)) {
               field_348 = 6;
               return;
            }

            if (field_45[field_350] == -1) {
               if (field_349 != field_350) {
                  field_351 += 5;
               }

               while (field_45[field_350] == -1) {
                  field_350++;
               }
            }

            if (field_45[field_350] == -2) {
               field_348 = 5;
               return;
            }

            int var0 = field_350;

            while (field_45[var0] != -1 && field_45[var0] != -2) {
               var0++;
            }

            int var1 = method_65(field_350, var0);
            if (field_351 + var1 > field_355) {
               field_351 = 0;
               field_352 += 16;
               if (field_352 + 16 > field_356) {
                  field_348 = 3;
                  return;
               }
            }

            if (field_349 == field_350) {
               field_348 = 2;
               return;
            }

            if (method_365(field_45[field_350] & 255) && !method_364()) {
               field_348 = 3;
               return;
            }

            field_348 = 2;
            return;
         case 2:
            if (isKeyJustPressed(18)) {
               field_348 = 6;
               return;
            }

            field_350++;
            if (field_45[field_350] != -2 && field_45[field_350] != -1) {
               break;
            }

            if (method_365(field_45[field_350 - 1] & 255) && !method_364()) {
               field_348 = 3;
               return;
            }

            field_348 = 1;
            return;
         case 3:
            field_348 = 4;
            return;
         case 4:
            if (isKeyJustPressed(262162)) {
               field_349 = field_350;
               field_351 = 0;
               field_352 = 14;
               field_348 = 0;
               return;
            }
            break;
         case 5:
            if (isKeyJustPressed(18)) {
               field_363 = null;
               method_323(field_346);
               field_362 = field_346;
               field_347 = -1;
            }
      }
   }

   // $VF: renamed from: by () void
   private static void method_361() {
      field_350 = field_349;
      field_351 = 0;
      field_352 = 14;

      while (true) {
         while (field_45[field_350] != -1) {
            if (field_45[field_350] == -2) {
               field_348 = 5;
               return;
            }

            int var0 = field_350;

            while (field_45[var0] != -1 && field_45[var0] != -2) {
               var0++;
            }

            int var1 = method_65(field_350, var0);
            if (field_351 + var1 > field_355) {
               field_351 = 0;
               field_352 += 16;
               if (field_352 + 16 > field_356) {
                  field_348 = 3;
                  return;
               }
            }

            if (field_350 != field_349 && method_365(field_45[field_350] & 255) && !method_364()) {
               field_348 = 3;
               return;
            }

            while (field_45[field_350] != -2 && field_45[field_350] != -1) {
               field_351 = field_351 + method_49(field_45[field_350] & 255, field_353 + field_351, field_354 + field_352);
               field_351++;
               field_350++;
            }

            if (method_365(field_45[field_350 - 1] & 255) && !method_364()) {
               field_348 = 3;
               return;
            }
         }

         if (field_349 != field_350) {
            field_351 += 5;
         }

         while (field_45[field_350] == -1) {
            field_350++;
         }
      }
   }

   // $VF: renamed from: bz () void
   private static void method_362() {
      label18: {
         field_228.setClip(0, 0, field_222, field_223);
         method_48(2, 0);
         switch (field_348) {
            case 0:
               field_228.setColor(2442057);
               method_272(field_357 - 20);
               field_228.fillRect(0, field_357, field_222, field_358);
            case 1:
            case 4:
            case 5:
            default:
               break label18;
            case 2:
               field_351 = field_351 + method_49(field_45[field_350] & 255, field_353 + field_351, field_354 + field_352);
               field_351++;
               break label18;
            case 3:
               break;
            case 6:
               method_361();
               if (field_348 != 3) {
                  break label18;
               }
               break;
            case 7:
               field_228.setColor(2442057);
               method_272(field_357 - 20);
               field_228.fillRect(0, field_357, field_222, field_358);
               method_361();
               if (field_348 != 3) {
                  break label18;
               }
         }

         method_254(field_353 + field_355 - 11, field_223 - 6);
      }

      method_359();
      method_363();
   }

   // $VF: renamed from: bA () void
   private static void method_363() {
      if (field_346 >= 0 && field_346 < field_344) {
         int var0 = field_357 - 20 + 5 - 9;
         method_252(field_222 >> 1, var0, field_361 + field_289, false);
         method_54(field_222 - field_361 >> 1, var0 - field_288, field_345[field_346]);
      }
   }

   // $VF: renamed from: k () boolean
   private static boolean method_364() {
      int var0 = field_350;
      int var1 = field_351;
      int var2 = field_352;

      while (true) {
         while (field_45[var0] != -1) {
            if (field_45[var0] == -2) {
               return true;
            }

            int var3 = var0;

            while (field_45[var3] != -1 && field_45[var3] != -2) {
               var3++;
            }

            int var4 = method_65(var0, var3);
            if (var1 + var4 > field_355) {
               var1 = 0;
               var2 += 16;
               if (var2 + 16 > field_356) {
                  return false;
               }
            }

            if (method_365(field_45[var3 - 1] & 255)) {
               return true;
            }

            var1 += var4;
            var0 = var3;
         }

         var1 += 5;

         while (field_45[var0] == -1) {
            var0++;
         }
      }
   }

   // $VF: renamed from: j (int) boolean
   private static boolean method_365(int var0) {
      for (int var1 = 0; var1 < field_364.length; var1++) {
         if (field_364[var1] == var0) {
            return true;
         }
      }

      return false;
   }

   // $VF: renamed from: bB () void
   private static void method_366() {
      if (field_194 != 0) {
         field_366 = true;
         method_368();
      }
   }

   // $VF: renamed from: bC () void
   private static void method_367() {
      if (field_194 != 0) {
         field_365 = true;
         method_368();
      }
   }

   // $VF: renamed from: bD () void
   private static void method_368() {
      field_367 = 0;
      field_374 = 0;
      field_368 = 13;
      field_369 = field_222 - field_368;
      field_371 = 0;
      field_373 = 0;

      for (int var0 = 0; var0 < field_194; var0++) {
         int var1 = 0;

         for (int var2 = 0; var2 < field_194 - var0; var2++) {
            int var3 = 0;

            for (int var4 = 0; var4 <= var0; var4++) {
               int var5 = method_61(field_369, field_195[var2 + var4], field_195[var2 + var4] + 1, 0) * 16 + field_288;
               var3 += var5;
            }

            var1 = Math.max(var1, var3);
         }

         if (field_223 < var1 + 40) {
            if (field_373 == 0) {
               field_373 = 1;
               field_371 = var1;
            }
            break;
         }

         field_371 = var1;
         field_373++;
      }

      field_370 = field_223 - field_371 >> 1;
      field_372 = 0;
   }

   // $VF: renamed from: bE () void
   private static void method_369() {
      field_372 = 0;
   }

   // $VF: renamed from: bF () void
   private static void method_370() {
      switch (field_372) {
         case 0:
            field_372 = 1;
            return;
         case 1:
            field_372 = 2;
            return;
         case 2:
            if (isKeyJustPressed(1)) {
               if (field_367 > 0) {
                  field_367--;
                  if (field_367 < field_374) {
                     field_374 = field_367;
                  }

                  field_372 = 1;
                  return;
               }
               break;
            } else if (isKeyJustPressed(2)) {
               if (field_367 < field_194 - 1) {
                  field_367++;
                  if (field_367 - field_374 + 1 > field_373) {
                     field_374++;
                  }

                  field_372 = 1;
                  return;
               }
               break;
            } else if (!isKeyJustPressed(16)) {
               break;
            }
         case 3:
            method_371(field_367);
      }
   }

   // $VF: renamed from: ab (int) void
   private static void method_371(int var0) {
      if (field_365) {
         field_365 = false;
         method_205(var0);
      } else {
         field_366 = false;
         method_206(var0);
      }
   }

   // $VF: renamed from: bG () void
   private static void method_372() {
      field_228.setClip(0, 0, field_222, field_223);
      method_48(2, 0);
      switch (field_372) {
         case 0:
            field_228.setColor(2442057);
            method_272(field_370 - 20);
            method_273(field_370 + field_371);
            field_228.fillRect(0, field_370, field_222, field_371);
            return;
         case 1:
         case 3:
            method_374();
         case 2:
      }
   }

   // $VF: renamed from: x (int, int) void
   private static void method_373(int var0, int var1) {
      var0 -= 3;
      var1 -= 3;
      field_228.setClip(var0, var1, 7, 7);
      field_228.drawImage(field_287, var0 - 22, var1 - 20, 20);
      field_228.setClip(0, 0, field_222, field_223);
   }

   // $VF: renamed from: bH () void
   private static void method_374() {
      field_228.setColor(2442057);
      field_228.fillRect(0, field_370, field_222, field_371);
      int var0 = field_370;

      for (int var1 = field_374; var1 < field_374 + field_373; var1++) {
         if (field_367 == var1) {
            method_48(2, 1);
            method_373(6, var0 + field_288);
         } else {
            method_48(2, 0);
         }

         int var2 = method_62(field_368, var0, field_369, 1000, field_195[var1], field_195[var1] + 1, 0, 4);
         var0 += var2 * 16 + field_288;
      }

      if (field_374 > 0) {
         method_253(field_224, field_370 - 10);
      } else {
         method_272(field_370 - 20);
      }

      if (field_374 + field_373 < field_194) {
         method_254(field_224, field_370 + field_371 + 10);
      } else {
         method_273(field_370 + field_371);
      }
   }

   // $VF: renamed from: D (int) int
   private static int method_375(int var0) {
      int var1 = -1;
      method_140(var0);
      int var2 = field_156;
      int var3 = field_157;

      for (int var4 = var2 - 1; var4 <= var2 + 1; var4++) {
         for (int var5 = var3 - 1; var5 <= var3 + 1; var5++) {
            for (int var6 = field_83 - 1; var6 >= 1; var6--) {
               int var7;
               if ((var7 = method_210(var4, var5, var6)) >= 0) {
                  if (var1 < 0) {
                     var1 = var7;
                  } else {
                     var1 = method_378(var0, var1, var7);
                  }
               }
            }
         }
      }

      return var1;
   }

   // $VF: renamed from: E (int) int
   private static int method_376(int var0) {
      return var0 * var0;
   }

   // $VF: renamed from: k (int, int) int
   private static int method_377(int var0, int var1) {
      int var2 = 0;
      if (field_210[var1] >= 0) {
         int var3 = field_210[var1];
         var2 = method_376(Math.abs(field_109[var0] - field_109[var3])) + method_376(Math.abs(field_110[var0] - field_110[var3]));
      } else {
         method_153(field_212[var1]);
         int var6 = method_142(field_156) + 32;
         int var4 = method_142(field_157) + 32;
         var2 = method_376(Math.abs(field_109[var0] - var6)) + method_376(Math.abs(field_110[var0] - var4));
      }

      return var2;
   }

   // $VF: renamed from: e (int, int, int) int
   private static int method_378(int var0, int var1, int var2) {
      return method_377(var0, var1) < method_377(var0, var2) ? var1 : var2;
   }

   // $VF: renamed from: bI () void
   private static void method_379() {
      method_102();
      method_120();
      method_99();
      method_159();
      method_91();
      method_300();
      method_123(field_375);
      method_300();
      method_122(true);
      field_97 = -field_92 * 3;
      field_96 = field_97 - field_80;
      method_101();
      method_300();

      for (int var0 = 0; var0 < 4; var0++) {
         method_147(field_336, 0, 0, 0);
         method_117(var0, false);
      }

      method_184();
      method_385();
      if (field_377 < 0) {
         if (method_349()) {
            int var3;
            if ((var3 = method_380(field_326)) >= 0) {
               method_153(var3);
               method_144(field_156, field_157, field_158, 1, 255);
            }

            method_381(0, 0, 1, 3);
            field_109[field_338] = (short)field_324;
            field_110[field_338] = (short)field_325;
         } else {
            int var4;
            if ((var4 = method_380(field_326)) >= 0) {
               method_153(var4);
               method_144(field_156, field_157, field_158, 1, 255);
               method_381(field_156, field_157, field_158, field_376);
               method_348();
            } else if (field_380 > 0) {
               method_153(var4 = field_381[0]);
               method_381(field_156, field_157, field_158, field_376);
            } else {
               method_381(0, 0, 1, 3);
            }
         }
      } else {
         int var6;
         if ((var6 = method_380(field_326)) >= 0) {
            method_153(var6);
            method_144(field_156, field_157, field_158, 1, 255);
         }

         if (field_380 > 0) {
            method_153(var6 = field_381[field_377]);
            method_381(field_156, field_157, field_158, field_376);
            if (field_376 == 0) {
               method_94(field_338, 2, 32);
            } else if (field_376 == 2) {
               method_94(field_338, 4, 32);
            } else if (field_376 == 4) {
               method_94(field_338, 2, 32);
            } else if (field_376 == 6) {
               method_94(field_338, 4, 32);
            }
         } else {
            method_381(0, 0, 1, 3);
         }
      }

      method_140(field_338);
      int var8 = field_156;
      int var1 = field_157;

      for (int var2 = 0; var2 < field_205; var2++) {
         if (field_209[var2] == 3 && field_212[var2] >= 0) {
            method_153(field_212[var2]);
            if (var8 == field_156 && var1 == field_157) {
               method_144(field_156, field_157, field_158, 1, 255);
               field_212[var2] = -1;
               if (field_210[var2] >= 0) {
                  method_150(field_210[var2]);
                  field_210[var2] = -1;
               }
               break;
            }
         }
      }

      field_378 = true;
      field_299 = 0;
      method_157(field_338);
      method_393();
      method_388(true);
      method_109();
   }

   // $VF: renamed from: F (int) int
   private static int method_380(int var0) {
      for (int var1 = 0; var1 < field_86.length; var1++) {
         if ((field_86[var1] & 255) == var0) {
            return var1;
         }
      }

      return -1;
   }

   // $VF: renamed from: o (int, int, int, int) void
   private static void method_381(int var0, int var1, int var2, int var3) {
      field_338 = method_147(field_326, var0, var1, var2);
      field_339 = method_160(field_338);
      method_162(field_339, field_328, var3, 0, true);
   }

   // $VF: renamed from: k (int) boolean
   private static boolean method_382(int var0) {
      return var0 == field_332;
   }

   // $VF: renamed from: d (int, int, int) void
   private static void method_383(int var0, int var1, int var2) {
      int var3 = field_338;
      if (method_96(field_338, var0, var1, false) == 0) {
         method_384(var3, var0);
      }

      if (!method_188() && method_190(0) <= 0) {
         method_97(var3, var0, var1, var2);
         method_388(true);
      }
   }

   // $VF: renamed from: y (int, int) void
   private static void method_384(int var0, int var1) {
      method_140(var0);
      int var2 = field_156;
      int var3 = field_157;
      int var4 = field_158;
      int var5 = (var1 & 1) > 0 ? 1 : 0;
      int var6 = var1 - var5 & 7;
      int var7 = var1 + var5 & 7;
      byte var8 = 0;
      if (!method_382(method_156(var2, var3, var4))) {
         var2 -= field_379[var6];
         var3 -= field_379[var6 + 1];
         if (!method_382(method_156(var2, var3, var4))) {
            if (var6 == var7) {
               return;
            }

            var2 += field_379[var6];
            var3 += field_379[var6 + 1];
            var2 -= field_379[var7];
            var3 -= field_379[var7 + 1];
            if (!method_382(method_156(var2, var3, var4))) {
               return;
            }

            var8 = 2;
         } else {
            var8 = 1;
         }
      }

      int var10 = method_386(var2, var3, var4);
      int var11;
      if ((var11 = method_212(field_87, var10, var6 >> 1, var7 >> 1)) >= 0) {
         int var12 = var11 >> 8 & 0xFF;
         int var13 = var11 & 0xFF;
         int var14 = var11 >> 16 & 0xFF;
         int var15 = method_212(var12, var13, var14, var14) >> 16 & 0xFF;
         if (var8 != 1 || var6 >> 1 == var15) {
            if (var8 != 2 || var7 >> 1 == var15) {
               switch (var15 << 1) {
                  case 0:
                     if ((field_110[field_338] & 63) > 0) {
                        return;
                     }
                  case 1:
                  case 3:
                  case 5:
                  default:
                     break;
                  case 2:
                     if ((field_109[field_338] & 63) != 62) {
                        return;
                     }
                     break;
                  case 4:
                     if ((field_110[field_338] & 63) != 62) {
                        return;
                     }
                     break;
                  case 6:
                     if ((field_109[field_338] & 63) > 0) {
                        return;
                     }
               }

               field_376 = method_95(var14 << 1);
               field_375 = var12;
               field_377 = var13;
               method_191(0, 1);
               method_191(2, var10);
               method_191(3, 0);
               if (field_333 >= 0) {
                  method_211(field_333);
               }
            }
         }
      }
   }

   // $VF: renamed from: bJ () void
   private static void method_385() {
      field_380 = 0;

      for (int var0 = 1; var0 < field_86.length; var0 += field_83) {
         if ((field_86[var0] & 255) == field_332) {
            field_381[field_380++] = var0;
         }
      }
   }

   // $VF: renamed from: f (int, int, int) int
   private static int method_386(int var0, int var1, int var2) {
      int var3 = method_152(var0, var1, var2);

      for (int var4 = 0; var4 < field_380; var4++) {
         if (var3 == field_381[var4]) {
            return var4;
         }
      }

      return -1;
   }

   // $VF: renamed from: e (int, int, int) void
   private static void method_387(int var0, int var1, int var2) {
      field_109[var0] = (short)(method_142(field_156) + 32);
      field_110[var0] = (short)(method_142(field_157) + 32);
      field_111[var0] = (short)(method_142(field_158) + var2 + method_112(var1) * 64);
      field_116[var0] = field_103[var1];
      field_384[var0] = field_104[var1];
      method_390(var0);
      method_117(var0, true);
   }

   // $VF: renamed from: e (boolean) void
   private static void method_388(boolean var0) {
      for (int var1 = 0; var1 < 4; var1++) {
         method_117(var1, false);
      }

      int var6 = -1;
      int var2 = 0;
      int var3 = method_141(field_109[field_338]);
      int var4 = method_141(field_110[field_338]);

      for (int var5 = 0; var5 < field_205; var5++) {
         if (field_208[var5] == field_87) {
            if (field_209[var5] == 1) {
               method_153(field_212[var5]);
               field_107[var2] = (byte)method_113(field_336);
               method_387(var2, field_207[var5], 32);
               var2++;
            } else if (field_209[var5] == 2 && var0) {
               method_153(field_212[var5]);
               if (Math.abs(field_156 - var3) <= 1 && Math.abs(field_157 - var4) <= 1) {
                  if (var6 < 0) {
                     var6 = var5;
                  } else {
                     var6 = method_378(field_338, var6, var5);
                  }
               }
            } else if (var0) {
               if (var6 < 0) {
                  var6 = var5;
               } else {
                  var6 = method_378(field_338, var6, var5);
               }
            }
         }
      }

      if (var6 >= 0 && field_209[var6] == 2) {
         method_153(field_212[var6]);
         field_107[var2] = (byte)method_113(field_337);
         method_387(var2, field_207[var6], 0);
      }
   }

   // $VF: renamed from: bK () void
   private static void method_389() {
      field_385++;
      if (field_385 >= field_382.length) {
         field_385 = 0;
      }

      field_386++;
      if (field_386 >= field_383.length) {
         field_386 = 0;
      }

      for (int var0 = 0; var0 < 4; var0++) {
         method_390(var0);
      }
   }

   // $VF: renamed from: ac (int) void
   private static void method_390(int var0) {
      if (field_107[var0] == method_113(field_336)) {
         field_117[var0] = (byte)(field_384[var0] + field_382[field_385]);
      } else {
         field_117[var0] = (byte)(field_384[var0] + field_383[field_386]);
      }
   }

   // $VF: renamed from: l (int, int) int
   private static int method_391(int var0, int var1) {
      field_102[var0] = (byte)(field_102[var0] & -17);
      method_153(var1);
      method_144(field_156, field_157, field_158, method_112(var0), 255);
      int var2 = method_147(var0, field_156, field_157, field_158);
      field_113[var2] = 32;
      field_114[var2] = 32;
      field_112[var2] = true;
      return var2;
   }

   // $VF: renamed from: bL () void
   private static void method_392() {
      for (int var1 = 0; var1 < field_205; var1++) {
         if (field_209[var1] == 3 && field_212[var1] >= 0) {
            int var2 = Math.abs(field_109[field_338] - field_109[field_210[var1]]);
            int var3 = Math.abs(field_110[field_338] - field_110[field_210[var1]]);
            if (var2 <= 64 && var3 <= 64) {
               if (!method_116(field_210[var1])) {
                  method_153(field_212[var1]);
                  method_144(field_156, field_157, field_158, method_112(field_207[var1]), 255);
                  method_117(field_210[var1], true);
               }
            } else if (method_116(field_210[var1])) {
               method_153(field_212[var1]);
               method_144(field_156, field_157, field_158, 1, field_207[var1]);
               method_117(field_210[var1], false);
            }
         }
      }
   }

   // $VF: renamed from: bM () void
   private static void method_393() {
      method_135(field_109[field_338], field_110[field_338]);
      int var0 = field_159;

      for (int var1 = 0; var1 < field_388; var1++) {
         int var2;
         if ((var2 = field_210[field_389[var1]]) >= 0) {
            method_135(field_109[var2], field_110[var2]);
            if (field_159 > var0) {
               method_315(field_389[var1], 5);
            } else {
               method_315(field_389[var1], 1);
            }
         }
      }
   }

   // $VF: renamed from: bN () void
   private static void method_394() {
      method_102();
      field_390 = true;
      field_391 = 0;
      field_392 = 0;
      if (field_193[0] == 1) {
         field_423 = method_90(23);
      } else {
         field_423 = method_90(25);
      }

      field_394 = method_90(8);
      field_395 = method_90(9);
      field_396 = method_90(10);
      method_326();
      method_388(false);
      field_406 = 0;
      field_398 = 0;
      method_70();
   }

   // $VF: renamed from: bO () void
   private static void method_395() {
      if (field_392 > 0) {
         field_392--;
      }

      field_397 = (field_397 + 1) % field_403.length;
   }

   // $VF: renamed from: bP () void
   private static void method_396() {
      if (field_398 == 0) {
         if (!method_328()) {
            if (field_399 >= 0) {
               method_356(0, field_399);
            }

            field_398 = 2;
         }
      } else if (field_398 == 1) {
         if (!method_328()) {
            method_398();
            method_101();
            method_157(field_338);
            method_109();
            field_390 = false;
            method_69(1, true);
         }
      } else if (field_398 == 3) {
         method_327();
         field_398 = 1;
      } else if (field_391 == field_192 - 1) {
         if (field_400 >= 0) {
            method_356(0, field_400);
         }

         field_398 = 3;
      } else if (field_392 <= 0) {
         for (int var0 = 0; var0 < 4; var0++) {
            if (isKeyJustPressed(field_404[var0 * 2])) {
               method_397(field_404[var0 * 2 + 1]);
               return;
            }
         }
      }
   }

   // $VF: renamed from: ad (int) void
   private static void method_397(int var0) {
      field_393 = var0;
      field_392 = 5;
      if (field_406 > 0 && field_405[field_406 - 1] >= 4) {
         field_406 = 0;
      }

      if (field_193[field_391 + 1] == field_393) {
         field_391++;
         field_405[field_406] = field_393;
         field_406++;
         method_69(3, false);
      } else {
         field_391 = 0;
         field_405[field_406] = field_393 + 4;
         field_406++;
         method_69(4, false);
         if (field_401 >= 0) {
            method_356(0, field_401);
         }
      }
   }

   // $VF: renamed from: bQ () void
   private static void method_398() {
      field_423 = null;
      field_394 = null;
      field_395 = null;
      field_396 = null;
   }

   // $VF: renamed from: bR () void
   private static void method_399() {
      int var0 = field_228.getClipX();
      int var1 = field_228.getClipY();
      int var2 = field_228.getClipWidth();
      int var3 = field_228.getClipHeight();
      int var4 = field_222 - 176 >> 1;
      int var7 = field_223 - 128 >> 1;
      field_228.clipRect(0, var7, field_222, 128);

      for (int var8 = 0; var8 < 128; var8 += field_423.getHeight()) {
         for (int var9 = 0; var9 < field_222; var9 += field_423.getWidth()) {
            field_228.drawImage(field_423, var9, var8 + var7, 20);
         }
      }

      field_228.setClip(var0, var1, var2, var3);
      if (var7 > 0) {
         field_228.setColor(0);
         field_228.fillRect(0, 0, field_222, var7);
         field_228.fillRect(0, var7 + 128, field_222, field_223 - var7 - 128);
      }

      field_228.drawImage(field_394, var4 + 27, var7 + 26, 20);
      int var17 = field_396.getWidth() >> 2;
      int var18 = field_396.getHeight() / 3;
      int var10 = 0;
      var10 = Math.max(var17, var4 + var17);
      int var11;
      var11 = Math.max(var11 = (var18 >> 1) + 1, var7 + var11);

      for (int var12 = 0; var12 < field_406; var12++) {
         int var13 = field_405[var12];
         byte var14 = 1;
         if (field_405[var12] >= 4) {
            var13 -= 4;
            var14 = 2;
         }

         method_400(var13, var14, var10 + var12 * (var17 + 2), var11);
      }

      if (field_398 == 2 && field_347 < 0) {
         field_228.translate(var4 + 64, var7 + 62);
         int var21 = field_403[field_397];
         method_400(0, 0, 0, -32 + var21);
         method_400(1, 0, 0, 32 - var21);
         method_400(2, 0, -32 + var21, 0);
         method_400(3, 0, 32 - var21, 0);
         field_228.translate(-(var4 + 64), -(var7 + 62));
      }

      var4 += 63;
      var7 += 18;
      if (field_392 > 0) {
         var4 += field_402[field_393 * 2];
         var7 += field_402[field_393 * 2 + 1];
      }

      field_228.drawImage(field_395, var4, var7, 20);
   }

   // $VF: renamed from: p (int, int, int, int) void
   private static void method_400(int var0, int var1, int var2, int var3) {
      int var4 = field_228.getClipX();
      int var5 = field_228.getClipY();
      int var6 = field_228.getClipWidth();
      int var7 = field_228.getClipHeight();
      int var8 = field_396.getWidth() >> 2;
      int var9 = field_396.getHeight() / 3;
      var2 -= var8 >> 1;
      var3 -= var9 >> 1;
      field_228.clipRect(var2, var3, var8, var9);
      var2 -= var8 * var0;
      var3 -= var9 * var1;
      field_228.drawImage(field_396, var2, var3, 20);
      field_228.setClip(var4, var5, var6, var7);
   }

   // $VF: renamed from: ae (int) void
   private static void method_401(int var0) {
      if (var0 == 1) {
         field_414 = field_415;
         field_408 = 4;
      } else {
         if (var0 != 2) {
            return;
         }

         field_414 = field_416;
         field_408 = 5;
      }

      method_102();
      method_32(field_408);
      field_409 = field_59[field_408];
      method_34(field_408, 0);
      field_422 = method_90(26);
      if (var0 == 1) {
         field_423 = method_90(23);
      } else {
         field_423 = method_90(24);
      }

      field_396 = method_90(10);
      field_410 = field_414.length >> 1;
      field_411 = new int[field_410 * 2];
      field_412 = new int[field_410 * 2];
      field_413 = new byte[field_410];
      int var1 = 0;

      for (int var2 = 0; var2 < field_410; var2++) {
         if (var2 != 8) {
            int var3 = method_92(0, (field_417.length >> 1) - 1);

            while ((var1 & 1 << var3) > 0) {
               if (++var3 >= field_417.length >> 1) {
                  var3 = 0;
               }
            }

            var1 |= 1 << var3;
            if (field_417[var3 * 2] == 0) {
               field_411[var2 * 2] = 42 - field_409.field_8[var2] - 1;
            } else if (field_417[var3 * 2] == 133) {
               field_411[var2 * 2] = field_417[var3 * 2] + 1;
            } else {
               field_411[var2 * 2] = field_417[var3 * 2] - (field_409.field_8[var2] >> 1);
            }

            if (field_417[var3 * 2 + 1] == 0) {
               field_411[var2 * 2 + 1] = 48 - field_409.field_9[var2] - 1;
            } else if (field_417[var3 * 2 + 1] == 160) {
               field_411[var2 * 2 + 1] = field_417[var3 * 2 + 1] + 1;
            } else {
               field_411[var2 * 2 + 1] = field_417[var3 * 2 + 1] - (field_409.field_9[var2] >> 1);
            }

            field_413[var2] = 0;
         }
      }

      for (int var4 = 0; var4 < field_410; var4++) {
         field_412[var4 * 2] = field_414[var4 * 2] + 42;
         field_412[var4 * 2 + 1] = field_414[var4 * 2 + 1] + 48;
      }

      field_411[16] = field_412[16];
      field_411[17] = field_412[17];
      field_413[8] = 1;
      field_426 = field_222 - 176 >> 1;
      field_427 = field_223 - 208 >> 1;
      field_420 = 88;
      field_421 = 104;
      field_419 = -1;
      method_326();
      method_388(false);
      field_418 = 0;
      field_407 = true;
   }

   // $VF: renamed from: bS () void
   private static void method_402() {
      if (field_418 == 0) {
         if (!method_328()) {
            if (field_424 >= 0) {
               method_356(0, field_424);
            }

            field_418 = 1;
         }
      } else if (field_418 == 3) {
         if (!method_328()) {
            method_403();
            method_101();
            method_157(field_338);
            method_109();
            field_407 = false;
         }
      } else if (field_418 == 2) {
         method_327();
         field_418 = 3;
      } else if (field_418 == 4) {
         int var3 = field_222 - 176 >> 1;
         if (field_426 > var3) {
            field_426--;
         } else if (field_426 < var3) {
            field_426++;
         }

         int var4 = field_223 - 208 >> 1;
         if (field_427 > var4) {
            field_427--;
         } else if (field_427 < var4) {
            field_427++;
         }

         if (field_426 == var3 && field_427 == var4) {
            if (field_425 >= 0) {
               method_356(0, field_425);
            }

            field_418 = 2;
         }
      } else if (method_404()) {
         field_418 = 4;
      } else {
         if (isKeyActive(1)) {
            field_421 = Math.max(0, field_421 - 4);
         } else if (isKeyActive(2)) {
            field_421 = Math.min(208, field_421 + 4);
         }

         if (isKeyActive(4)) {
            field_420 = Math.max(0, field_420 - 4);
         } else if (isKeyActive(8)) {
            field_420 = Math.min(176, field_420 + 4);
         }

         if (field_420 + field_426 < 0) {
            field_426 = -field_420;
         } else if (field_420 + field_426 >= field_222) {
            field_426 = field_222 - field_420;
         }

         if (field_421 + field_427 < 0) {
            field_427 = -field_421;
         } else if (field_421 + field_427 >= field_223) {
            field_427 = field_223 - field_421;
         }

         if (isKeyJustPressed(16)) {
            if (field_419 >= 0) {
               int var0 = field_411[field_419 * 2] - field_412[field_419 * 2];
               int var1 = field_411[field_419 * 2 + 1] - field_412[field_419 * 2 + 1];
               if (Math.abs(var0) <= 8 && Math.abs(var1) <= 8) {
                  field_411[field_419 * 2] = field_412[field_419 * 2];
                  field_411[field_419 * 2 + 1] = field_412[field_419 * 2 + 1];
                  field_413[field_419] = 1;
                  field_419 = -1;
               } else {
                  field_419 = -1;
               }
            } else {
               int var2;
               if ((var2 = method_405()) >= 0) {
                  field_419 = var2;
               }
            }
         }

         if (field_419 >= 0) {
            field_411[field_419 * 2] = field_420 - (field_409.field_8[field_419] >> 1);
            field_411[field_419 * 2 + 1] = field_421 - (field_409.field_9[field_419] >> 1);
         }
      }
   }

   // $VF: renamed from: bT () void
   private static void method_403() {
      field_409 = null;
      field_411 = null;
      field_412 = null;
      field_413 = null;
      method_33(field_408);
      field_422 = null;
      field_423 = null;
      field_396 = null;
   }

   // $VF: renamed from: l () boolean
   private static boolean method_404() {
      for (int var0 = 0; var0 < field_410; var0++) {
         if (field_413[var0] <= 0) {
            return false;
         }
      }

      return true;
   }

   // $VF: renamed from: g () int
   private static int method_405() {
      int var0 = -1;
      int var1 = -1;

      for (int var2 = 0; var2 < field_410; var2++) {
         if (field_413[var2] <= 0) {
            int var3 = field_411[var2 * 2];
            short var4 = field_409.field_8[var2];
            if (field_420 >= var3 && field_420 <= var3 + var4) {
               int var5 = field_411[var2 * 2 + 1];
               short var6 = field_409.field_9[var2];
               if (field_421 >= var5 && field_421 <= var5 + var6) {
                  int var7 = var3 + (var4 >> 1) - field_420;
                  int var8 = var5 + (var6 >> 1) - field_421;
                  if (var0 < 0) {
                     var0 = var2;
                     var1 = var7 * var7 + var8 * var8;
                  } else if (var7 * var7 + var8 * var8 < var1) {
                     var0 = var2;
                     var1 = var7 * var7 + var8 * var8;
                  }
               }
            }
         }
      }

      return var0;
   }

   // $VF: renamed from: f (int, int, int) void
   private static void method_406(int var0, int var1, int var2) {
      field_57[2] = field_409.field_6[var0];
      field_57[3] = field_409.field_7[var0];
      field_57[4] = field_409.field_8[var0];
      field_57[5] = field_409.field_9[var0];
      field_57[6] = 0;
      field_57[7] = 0;
      field_57[8] = 0;
      method_26();
      field_57[0] = var1;
      field_57[1] = var2;
      method_25();
   }

   // $VF: renamed from: bU () void
   private static void method_407() {
      int var0 = field_228.getClipX();
      int var1 = field_228.getClipY();
      int var2 = field_228.getClipWidth();
      int var3 = field_228.getClipHeight();
      if (field_426 > 0 || field_427 > 0) {
         field_228.setColor(0);
         field_228.fillRect(var0, var1, var2, var3);
      }

      field_228.clipRect(0, field_427, field_222, 208);
      if (176 < field_222) {
         for (int var4 = field_427; var4 < field_427 + 208; var4 += field_423.getHeight()) {
            for (int var5 = 0; var5 < field_222; var5 += field_423.getWidth()) {
               field_228.drawImage(field_423, var5, var4, 20);
            }
         }
      }

      field_228.translate(field_426, field_427);
      if (176 >= field_222) {
         for (int var6 = 0; var6 < 208; var6 += field_423.getHeight()) {
            for (int var10 = 0; var10 < 176; var10 += field_423.getWidth()) {
               field_228.drawImage(field_423, var10, var6, 20);
            }
         }
      }

      for (int var7 = 0; var7 < field_410; var7++) {
         if (field_413[var7] > 0) {
            method_406(var7, field_411[var7 * 2], field_411[var7 * 2 + 1]);
         }
      }

      field_228.setColor(248, 248, 248);
      field_228.setStrokeStyle(1);
      field_228.drawRect(41, 47, 91, 112);
      field_228.setStrokeStyle(0);

      for (int var8 = 0; var8 < field_410; var8++) {
         if (field_419 != var8 && field_413[var8] <= 0) {
            method_406(var8, field_411[var8 * 2], field_411[var8 * 2 + 1]);
         }
      }

      if (field_419 >= 0) {
         method_406(field_419, field_411[field_419 * 2], field_411[field_419 * 2 + 1]);
      }

      if (field_418 == 1) {
         if (field_419 < 0) {
            field_228.clipRect(field_420 - 8, field_421 - 8, 16, 16);
            field_228.drawImage(field_422, field_420 - 8, field_421 - 8, 20);
         } else {
            field_228.clipRect(field_420 - 6, field_421 - 5, 13, 11);
            field_228.drawImage(field_422, field_420 - 6, field_421 - 5 - 16, 20);
         }
      }

      field_228.translate(-field_426, -field_427);
      field_228.setClip(var0, var1, var2, var3);
      if (field_418 == 1) {
         int var9 = field_396.getWidth() >> 2;
         int var11 = field_396.getHeight() / 3;
         if (field_427 < 0) {
            method_400(0, 0, field_224, var11 >> 1);
         }

         if (field_427 + 208 > field_223) {
            method_400(1, 0, field_224, field_223 - (var11 >> 1));
         }

         if (field_426 < 0) {
            method_400(2, 0, var9 >> 1, field_225);
         }

         if (field_426 + 176 > field_222) {
            method_400(3, 0, field_222 - (var9 >> 1), field_225);
         }
      }
   }

   // $VF: renamed from: t () void
   public static void method_408() {
      method_305();
   }

   static {
      int[] var10000 = new int[]{0, 270, 180, 90, 8192, 16474, 16384, 8282};
      var10000 = new int[]{500, 500, 500, 500, 500};
   }
}
