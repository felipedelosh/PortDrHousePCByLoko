package javax.microedition.lcdui;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class Graphics {

    private final Graphics2D g;

    private int tx;
    private int ty;

    private final int w;
    private final int h;

    public Graphics(BufferedImage b) {

        g = b.createGraphics();

        w = b.getWidth();
        h = b.getHeight();

        g.setClip(0, 0, w, h);

        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
        );
    }

    public void setColor(int rgb) {
        g.setColor(new Color(rgb));
    }

    public void setColor(int r, int gr, int b) {
        g.setColor(new Color(r, gr, b));
    }

    public void setFont(Font f) {
        g.setFont(f.awt);
    }

    public void setStrokeStyle(int s) {

        g.setStroke(
            s == 0
                ? new BasicStroke(1)
                : new BasicStroke(1, 0, 0, 1, new float[]{1, 1}, 0)
        );
    }

    public void translate(int x, int y) {

        g.translate(x, y);

        tx += x;
        ty += y;
    }

    public int getTranslateX() {
        return tx;
    }

    public int getTranslateY() {
        return ty;
    }

    public void setClip(int x, int y, int w, int h) {
        g.setClip(x, y, w, h);
    }

    public void clipRect(int x, int y, int w, int h) {
        g.clipRect(x, y, w, h);
    }

    public int getClipX() {
        return g.getClipBounds().x;
    }

    public int getClipY() {
        return g.getClipBounds().y;
    }

    public int getClipWidth() {
        return g.getClipBounds().width;
    }

    public int getClipHeight() {
        return g.getClipBounds().height;
    }

    public void drawLine(int x, int y, int a, int b) {
        g.drawLine(x, y, a, b);
    }

    public void drawRect(int x, int y, int w, int h) {
        g.drawRect(x, y, w, h);
    }

    public void fillRect(int x, int y, int w, int h) {
        g.fillRect(x, y, w, h);
    }

    public void fillArc(int x, int y, int w, int h, int start, int arc) {
        g.fillArc(x, y, w, h, start, arc);
    }

    private int ax(int x, int w, int a) {
        return x - ((a & 8) != 0 ? w : (a & 1) != 0 ? w / 2 : 0);
    }

    private int ay(int y, int h, int a) {
        return y - ((a & 32) != 0 ? h : (a & 2) != 0 ? h / 2 : 0);
    }

    public void drawImage(Image im, int x, int y, int a) {

        g.drawImage(
            im.data,
            ax(x, im.getWidth(), a),
            ay(y, im.getHeight(), a),
            null
        );
    }

    public void drawRegion(
        Image im,
        int sx,
        int sy,
        int w,
        int h,
        int t,
        int x,
        int y,
        int a
    ) {

        if (w <= 0 || h <= 0) {
            return;
        }

        int dw = t >= 4 ? h : w;
        int dh = t >= 4 ? w : h;

        var b = new BufferedImage(
            dw,
            dh,
            BufferedImage.TYPE_INT_ARGB
        );

        for (int j = 0; j < h; j++) {

            for (int i = 0; i < w; i++) {

                int dx = i;
                int dy = j;

                switch (t) {

                    case 1:
                        dy = h - 1 - j;
                        break;

                    case 2:
                        dx = w - 1 - i;
                        break;

                    case 3:
                        dx = w - 1 - i;
                        dy = h - 1 - j;
                        break;

                    case 4:
                        dx = j;
                        dy = i;
                        break;

                    case 5:
                        dx = h - 1 - j;
                        dy = i;
                        break;

                    case 6:
                        dx = j;
                        dy = w - 1 - i;
                        break;

                    case 7:
                        dx = h - 1 - j;
                        dy = w - 1 - i;
                        break;
                }

                if (
                    sx + i >= 0 &&
                    sy + j >= 0 &&
                    sx + i < im.getWidth() &&
                    sy + j < im.getHeight()
                ) {
                    b.setRGB(
                        dx,
                        dy,
                        im.data.getRGB(sx + i, sy + j)
                    );
                }
            }
        }

        g.drawImage(
            b,
            ax(x, dw, a),
            ay(y, dh, a),
            null
        );
    }

}
