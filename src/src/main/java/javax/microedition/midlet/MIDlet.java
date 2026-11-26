package javax.microedition.midlet;

/**
 * Defines the original Java ME application lifecycle contract.
 * Preserves the game's startup, suspension, and shutdown
 * behavior within the Java SE compatibility layer.
*/
public abstract class MIDlet {

    public abstract void startApp();

    public abstract void pauseApp();

    public abstract void destroyApp(boolean unconditional);

    public void requestExit() {

        destroyApp(true);
        notifyDestroyed();
    }

    public void notifyDestroyed() {
        javax.microedition.lcdui.Display.getDisplay(this).close();
    }

}
