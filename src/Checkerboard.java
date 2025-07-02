public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0.0, n);
        for (double x = 0.5; x < n; x++) {
            for (double y = 0.5; y < n; y++) {
                if ((x + y) % 2 != 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.5);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(x, y, 0.5);
                }
            }
        }
    }
}


