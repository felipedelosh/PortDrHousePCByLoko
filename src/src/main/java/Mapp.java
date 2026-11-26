import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Mapp extends MIDlet {
   private GameEngine field_429 = null;
   private Display field_430;
   private boolean field_431 = false;

   public Mapp() {
      this.field_430 = Display.getDisplay(this);
   }

   public final void startApp() {
      if (!this.field_431) {
         this.field_429 = new GameEngine(this);
         this.field_430.setCurrent(this.field_429);
         this.field_431 = true;
      }
   }

   @Override 
   public void requestExit() {
      GameEngine.field_30 = false;
   }

   public final void pauseApp() {
   }

   public final void destroyApp(boolean var1) {
      GameEngine.method_17();
   }

   public final void method_409() {
      this.destroyApp(true);
      this.notifyDestroyed();
   }
}
