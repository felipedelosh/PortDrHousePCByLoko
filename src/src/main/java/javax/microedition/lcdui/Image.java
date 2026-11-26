package javax.microedition.lcdui;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public final class Image {

    final BufferedImage data;

    private Image(BufferedImage data) {
        this.data = data;
    }

    public static Image createImage(int w, int h) {

        return new Image(
            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
        );
    }

    public static Image createImage(String path) throws IOException {

        try (var in = Image.class.getResourceAsStream(path)) {

            if (in == null) {
                throw new IOException(path);
            }

            return read(in);
        }
    }

    public static Image createImage(byte[] b, int off, int len) {

        try {
            return read(new ByteArrayInputStream(b, off, len));

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static Image read(InputStream in) throws IOException {

        var b = ImageIO.read(in);

        if (b == null) {
            throw new IOException("Invalid image");
        }

        return new Image(b);
    }

    public int getWidth() {
        return data.getWidth();
    }

    public int getHeight() {
        return data.getHeight();
    }

    public Graphics getGraphics() {
        return new Graphics(data);
    }

}
