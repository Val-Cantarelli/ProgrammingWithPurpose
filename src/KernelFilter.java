import edu.princeton.cs.algs4.Picture;
import java.awt.Color;


public class KernelFilter {
    private static int[][][] convertPicturetoMatrix(Picture picture) {
        int[][][] tempMatrix = new int[picture.width()][picture.height()][3];
        for (int col = 0; col < picture.width(); col++) {
            for (int lin = 0; lin < picture.height(); lin++) {
                Color color = picture.get(col, lin);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();


                tempMatrix[col][lin][0] = r;
                tempMatrix[col][lin][1] = g;
                tempMatrix[col][lin][2] = b;
            }
        }
        return tempMatrix;
    }


    private static int[] applyFilter(int[][] kernel, int colOrigin, int linOrigin, int[][][] matrix, double weight) {
        int pad = (kernel.length - 1) / 2;
        int[] value = {0, 0, 0};

        for (int col = 0; col < kernel.length; col++) {
            for (int lin = 0; lin < kernel.length; lin++) {
                int newCol = (matrix.length + (colOrigin - pad + col)) % matrix.length;
                int newLin = (matrix[0].length + (linOrigin - pad + lin)) % matrix[0].length;
                value[0] = value[0] + kernel[col][lin] * matrix[newCol][newLin][0];
                value[1] = value[1] + (kernel[col][lin] * matrix[newCol][newLin][1]);
                value[2] = value[2] + (kernel[col][lin] * matrix[newCol][newLin][2]);
            }
        }

        for (int v = 0; v < value.length; v++) {
            value[v] = (int) (value[v] / weight + 0.5);
            if (value[v] > 255) value[v] = 255;
            else if (value[v] < 0) value[v] = 0;
        }
        return value;
    }

    public static Picture identity(Picture picture) {
        int[][] kernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        int[][][] matrix = convertPicturetoMatrix(picture);
        int[] vetor;
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < newPic.width(); col++) {
            for (int lin = 0; lin < newPic.height(); lin++) {
                vetor = applyFilter(kernel, col, lin, matrix, 1);
                Color ci = new Color(vetor[0], vetor[1], vetor[2]);
                newPic.set(col, lin, ci);
            }
        }
        return newPic;
    }

    public static Picture gaussian(Picture picture) {
        int[][] kernel = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};

        int[][][] matrix = convertPicturetoMatrix(picture);
        int[] vetor;
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < newPic.width(); col++) {
            for (int lin = 0; lin < newPic.height(); lin++) {
                vetor = applyFilter(kernel, col, lin, matrix, 16.0);
                Color ci = new Color(vetor[0], vetor[1], vetor[2]);
                newPic.set(col, lin, ci);
            }
        }
        return newPic;
    }

    public static Picture sharpen(Picture picture) {
        int[][] kernel = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        int[][][] matrix = convertPicturetoMatrix(picture);
        int[] vetor;
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < newPic.width(); col++) {
            for (int lin = 0; lin < newPic.height(); lin++) {
                vetor = applyFilter(kernel, col, lin, matrix, 1);

                Color ci = new Color(vetor[0], vetor[1], vetor[2]);
                newPic.set(col, lin, ci);
            }
        }
        return newPic;
    }

    public static Picture laplacian(Picture picture) {
        int[][] kernel = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        int[][][] matrix = convertPicturetoMatrix(picture);
        int[] vetor;
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < newPic.width(); col++) {
            for (int lin = 0; lin < newPic.height(); lin++) {
                vetor = applyFilter(kernel, col, lin, matrix, 1);
                Color ci = new Color(vetor[0], vetor[1], vetor[2]);
                newPic.set(col, lin, ci);
            }
        }
        return newPic;
    }

    public static Picture emboss(Picture picture) {
        int[][] kernel = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};


        int[][][] matrix = convertPicturetoMatrix(picture);
        int[] vetor;
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int col = 0; col < newPic.width(); col++) {
            for (int lin = 0; lin < newPic.height(); lin++) {
                vetor = applyFilter(kernel, col, lin, matrix, 1);

                Color ci = new Color(vetor[0], vetor[1], vetor[2]);
                newPic.set(col, lin, ci);
            }
        }
        return newPic;
    }

    public static Picture motionBlur(Picture picture) {
        int[][] kernel = {{1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1}};

        int[][][] matrix = convertPicturetoMatrix(picture);
        int[] vetor;
        Picture newPic = new Picture(picture.width(), picture.height());

        for (int col = 0; col < newPic.width(); col++) {
            for (int lin = 0; lin < newPic.height(); lin++) {
                vetor = applyFilter(kernel, col, lin, matrix, 9.0);
                Color ci = new Color(vetor[0], vetor[1], vetor[2]);
                newPic.set(col, lin, ci);
            }
        }
        return newPic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture pic = new Picture(filename);
        identity(pic).show();
        sharpen(pic).show();
        laplacian(pic).show();
        emboss(pic).show();
        gaussian(pic).show();
        motionBlur(pic).show();
    }
}
