import java.awt.Color;

// Luminancia é o brilho de uma imagem. Os olhos humanos são mais sensíveis ao brilho do que à cor. Por isso,
// quando ajustamos a luminância isso ajuda a melhorar a visualizaćão

// Which font color will be most readable with which background colors on a display?
// Absolute value  od difference in luminosity should be > 128
// Math.abs(lum(a) - lum(b) > 128)

public class Luminance {
    public static double lum(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        // NTSC standard formula for luminance
        return .299 * r + .587 * g + .114 * b;
    }

    // When all three R,G and B values are the same, resulting color is on grayscale from 0 to 255
    public static Color toGray(Color c) {
        int y = (int) Math.round(lum(c));
        Color gray = new Color(y, y, y);
        return gray;
    }

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        Color c = new Color(r, g, b);
        System.out.println(Math.round(lum(c)));
    }
}
