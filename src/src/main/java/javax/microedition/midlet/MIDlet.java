package javax.microedition.midlet;

import java.util.jar.Manifest;

public abstract class MIDlet {

    private final Manifest manifest = new Manifest();

    protected MIDlet() {

        try (var in = getClass().getResourceAsStream("/META-INF/MANIFEST.MF")) {

            if (in != null) {
                manifest.read(in);
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAppProperty(String key) {
        return manifest.getMainAttributes().getValue(key);
    }

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
