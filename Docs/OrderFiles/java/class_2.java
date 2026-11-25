import javax.microedition.io.Connector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

// $VF: renamed from: a
public final class class_2 implements CommandListener, Runnable {
   // $VF: renamed from: a javax.microedition.lcdui.Displayable
   private Displayable field_18;
   // $VF: renamed from: a javax.microedition.midlet.MIDlet
   private static MIDlet field_19;
   // $VF: renamed from: a java.lang.String
   private String field_20;
   // $VF: renamed from: b java.lang.String
   private String field_21;
   // $VF: renamed from: c java.lang.String
   private String field_22;

   public class_2(MIDlet var1) {
      field_19 = var1;
      this.field_20 = method_0(var1.getAppProperty("Play2Me"));
      this.field_21 = method_0(var1.getAppProperty("Play2Me-URL"));
      this.field_22 = method_0(var1.getAppProperty("Play2Me-TXT"));
   }

   // $VF: renamed from: a (java.lang.String) java.lang.String
   private static String method_0(String var0) {
      return var0 == null ? "" : var0;
   }

   // $VF: renamed from: a () boolean
   public final boolean method_1() {
      return 0 >= this.field_20.length() ? false : this.field_20.charAt(0) == '1';
   }

   // $VF: renamed from: b () boolean
   public final boolean method_2() {
      return 1 >= this.field_20.length() ? false : this.field_20.charAt(1) == '1';
   }

   // $VF: renamed from: a () void
   public final void method_3() {
      this.method_4(this.field_21);
   }

   // $VF: renamed from: a (java.lang.String) void
   private void method_4(String var1) {
      if (this.method_1() && var1 != null) {
         this.field_21 = var1;
         new Thread(this).start();
      }
   }

   // $VF: renamed from: run () void
   public final void run() {
      try {
         field_19.platformRequest(this.field_21);
         field_19.notifyDestroyed();
      } catch (Exception var2) {
      }
   }

   // $VF: renamed from: b () void
   public final void method_5() {
      if (this.method_2()) {
         this.method_6();
      }
   }

   // $VF: renamed from: c () void
   private void method_6() {
      Form var1;
      (var1 = new Form("Díselo a un amigo")).append(new TextField("Número de teléfono", "", 12, 3));
      var1.append(new TextField("Tu comentario...", "", 160 - this.field_22.length(), 0));
      var1.append(new StringItem(null, this.field_22 + " " + this.field_21));
      var1.addCommand(new Command("Enviar", 4, 1));
      var1.addCommand(new Command("Cancelar", 3, 1));
      var1.setCommandListener(this);
      this.field_18 = Display.getDisplay(field_19).getCurrent();
      Display.getDisplay(field_19).setCurrent(var1);
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getCommandType() == 4) {
         Form var3;
         TextField var4 = (TextField)(var3 = (Form)var2).get(0);
         TextField var5 = (TextField)var3.get(1);
         StringItem var6 = (StringItem)var3.get(2);
         method_7(var4.getString(), var5.getString() + ". " + var6.getText(), false);
      }

      Display.getDisplay(field_19).setCurrent(this.field_18);
   }

   // $VF: renamed from: a (java.lang.String, java.lang.String, boolean) void
   private static void method_7(String var0, String var1, boolean var2) {
      try {
         MessageConnection var3 = (MessageConnection)Connector.open("sms://" + var0);
         if (!var2) {
            TextMessage var4;
            (var4 = (TextMessage)var3.newMessage("text")).setPayloadText(var1);
            var3.send(var4);
         }

         var3.close();
      } catch (Exception var5) {
      }
   }
}
