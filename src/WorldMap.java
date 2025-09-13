import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class WorldMap {
    /* Read the boundaries of the country and plots a graphic. */

    /* You will get substantially improved performance if you call 'StdDraw.enableDoubleBuffering()'
    once at the beginning if this program and 'StdDraw.show()' once at the end of this program.*/
    public static void main(String[] args) {
        int canvasWidth = StdIn.readInt();
        int canvasHeight = StdIn.readInt();
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, canvasWidth);
        StdDraw.setYscale(0, canvasHeight);
        StdDraw.enableDoubleBuffering();

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int numVertices = StdIn.readInt();
            double[] xx = new double[numVertices];
            double[] yy = new double[numVertices];
            for (int i = 0; i < numVertices; i++) {
                double x = StdIn.readDouble();
                double y = StdIn.readDouble();
                xx[i] = x;
                yy[i] = y;
            }
            StdDraw.polygon(xx, yy);
        }
        StdDraw.show();
    }
}