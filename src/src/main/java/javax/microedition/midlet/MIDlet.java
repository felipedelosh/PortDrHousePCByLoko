package javax.microedition.midlet;

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
