import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Mapp extends MIDlet {
   // $VF: renamed from: a c
   private class_3 field_429 = null;
   // $VF: renamed from: a javax.microedition.lcdui.Display
   private Display field_430;
   // $VF: renamed from: a boolean
   private boolean field_431 = false;

   public Mapp() {
      this.field_430 = Display.getDisplay(this);
   }

   public final void startApp() {
      if (!this.field_431) {
         this.field_429 = new class_3(this);
         this.field_430.setCurrent(this.field_429);
         this.field_431 = true;
      }
   }

   public final void pauseApp() {
   }

   public final void destroyApp(boolean var1) {
      class_3.method_17();
   }

   // $VF: renamed from: a () void
   public final void method_409() {
      this.destroyApp(true);
      this.notifyDestroyed();
   }
}
