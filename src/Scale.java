import edu.princeton.cs.algs4.Picture;
import java.awt.Color;

public class Scale {

    public static void main(String[] args) {


        String filename = "/Mandrill-Image-on-Synthetic-Surface.ppm";
        // serão os tamanhos de target
        int w = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);

        Picture source = new Picture(filename);
        Picture target = new Picture(w, h);
        // Para cada pixel no target,  queremos descobrir onde teremos de ir no source para obter
        // um pixel que esteja próximo de onde deveria estar de acordo com a escala.
        for (int tcol = 0; tcol < w; tcol++) {
            for (int trow = 0; trow < h; trow++) {
                int scol = tcol * source.width() / w;
                int srow = trow * source.height() / h;
                Color color = source.get(scol, srow);
                target.set(tcol, trow, color);
            }

        }
        target.show();
    }
}
