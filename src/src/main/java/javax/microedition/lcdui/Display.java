package javax.microedition.lcdui;
import javax.swing.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.game.GameCanvas;
public final class Display {
 private static final Display INSTANCE=new Display(); private JFrame frame; private MIDlet app;
 public static Display getDisplay(MIDlet app){INSTANCE.app=app;return INSTANCE;}
 public void setCurrent(GameCanvas canvas){Runnable task=()->{frame=new JFrame("House PC");frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);frame.addWindowListener(new java.awt.event.WindowAdapter(){public void windowClosing(java.awt.event.WindowEvent e){app.requestExit();}public void windowOpened(java.awt.event.WindowEvent e){canvas.panel().requestFocusInWindow();}});frame.setContentPane(canvas.panel());frame.pack();frame.setLocationRelativeTo(null);frame.setVisible(true);canvas.panel().requestFocusInWindow();}; if(SwingUtilities.isEventDispatchThread())task.run();else SwingUtilities.invokeLater(task);}
 public void close(){SwingUtilities.invokeLater(()->{if(frame!=null)frame.dispose();});}
}
