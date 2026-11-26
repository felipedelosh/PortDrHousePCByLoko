package javax.microedition.lcdui.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import configuration.GameConfiguration;

public class GameCanvas {

    // GAME RESOLUTION
    private final int width = GameConfiguration.SELECTED_RESOLUTION.getWidth();
    private final int height = GameConfiguration.SELECTED_RESOLUTION.getHeight();

    private final BufferedImage buffer = new BufferedImage(
        width, height, BufferedImage.TYPE_INT_RGB
    );

    private final BufferedImage front = new BufferedImage(
        width, height, BufferedImage.TYPE_INT_RGB
    );

    private final javax.microedition.lcdui.Graphics graphics =
        new javax.microedition.lcdui.Graphics(buffer);

    private final JPanel panel;

    protected GameCanvas(boolean suppress) {

        panel = new JPanel() {

            @Override
            protected void paintComponent(java.awt.Graphics g) {

                super.paintComponent(g);

                int scale = Math.max(
                    1,
                    Math.min(getWidth() / width, getHeight() / height)
                );

                synchronized (front) {
                    g.drawImage(
                        front,
                        (getWidth() - width * scale) / 2,
                        (getHeight() - height * scale) / 2,
                        width * scale,
                        height * scale,
                        null
                    );
                }
            }
        };

        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(
            width * GameConfiguration.WINDOW_SCALE,
            height * GameConfiguration.WINDOW_SCALE
        ));
        panel.setFocusable(true);

        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                panel.requestFocusInWindow();
            }
        });

        panel.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {

                for (int k : new int[]{
                    -1, -2, -3, -4, -5, -6, -7,
                    48, 49, 50, 51, 52, 53, 54,
                    55, 56, 57, 35, 42
                }) {
                    GameCanvas.this.keyReleased(k);
                }
            }
        });

        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                GameCanvas.this.keyPressed(map(e));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                GameCanvas.this.keyReleased(map(e));
            }
        });
    }

    private int map(KeyEvent e) {

        return switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> -1;
            case KeyEvent.VK_DOWN -> -2;
            case KeyEvent.VK_LEFT -> -3;
            case KeyEvent.VK_RIGHT -> -4;
            case KeyEvent.VK_ENTER, KeyEvent.VK_SPACE -> -5;
            case KeyEvent.VK_F1 -> -6;
            case KeyEvent.VK_F2, KeyEvent.VK_ESCAPE -> -7;
            default -> e.getKeyChar();
        };
    }

    public int getGameAction(int k) {

        return switch (k) {
            case -1, 50 -> 1;
            case -2, 56 -> 6;
            case -3, 52 -> 2;
            case -4, 54 -> 5;
            case -5, 53 -> 8;
            default -> 0;
        };
    }

    public JPanel panel() {
        return panel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setFullScreenMode(boolean b) {
    }

    public boolean isShown() {
        return panel.isShowing();
    }

    public javax.microedition.lcdui.Graphics getGraphics() {
        return graphics;
    }

    public void flushGraphics() {

        synchronized (front) {

            var g = front.createGraphics();

            g.drawImage(buffer, 0, 0, null);
            g.dispose();
        }

        panel.repaint();
    }

    public void keyPressed(int k) {
    }

    public void keyReleased(int k) {
    }

    public void showNotify() {
    }

    public void hideNotify() {
    }

}
