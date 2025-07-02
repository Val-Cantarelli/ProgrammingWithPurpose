public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2.0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2.0);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;

        double halfLength = length / 2.0;
        draw(n - 1, x - halfLength, y + halfLength, halfLength);
        draw(n - 1, x + halfLength, y + halfLength, halfLength);
        drawSquare(x, y, length);
        draw(n - 1, x - halfLength, y - halfLength, halfLength);
        draw(n - 1, x + halfLength, y - halfLength, halfLength);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
