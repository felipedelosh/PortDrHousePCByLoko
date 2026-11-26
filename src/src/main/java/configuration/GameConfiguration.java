package configuration;

/**
 * FelipedelosH
 * 2026
 * 
 * GAME CONFIG 
 * DISPLAY
 * LAN
 * Audio
 */
public final class GameConfiguration {

    private GameConfiguration() {
    }

    // DISPLAY CONFIGURATION
    public static final Resolution SELECTED_RESOLUTION = Resolution.TV_SD;
    public static final int WINDOW_SCALE = 1;
    public static final boolean FULLSCREEN = false;

    // LANGUAGE CONFIGURATION
    public static final String[] LANGUAGE_CODES = {"en", "es"};
    public static final String[] LANGUAGE_NAMES = {"English", "Español"};

    // AVAILABLE RESOLUTIONS
    public enum Resolution {

        ORIGINAL(240, 320),
        QVGA(320, 240),
        TV_SD(640, 480),
        HD(1280, 720),
        FULL_HD(1920, 1080);

        private final int width;
        private final int height;

        Resolution(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

}
