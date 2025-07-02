public class MaximumSquareSubmatrix {
    private static int[][] matrixCumulative(int[][] a) {
        int[][] b = new int[a.length][a.length];
        for (int j = 0; j < a.length; j++) {
            b[0][j] = a[0][j];
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 0) {
                    b[i][j] = 0;
                } else {
                    b[i][j] = b[i - 1][j] + 1;
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int length = StdIn.readInt();
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = StdIn.readInt();
            }
        }
        int x = size(matrix);
        System.out.println(x);
    }

    public static int size(int[][] matrix) {
        int[][] b = matrixCumulative(matrix);
        int tamSub = 0;
        for (int lin = 0; lin < matrix.length; lin++) {
            for (int col = 0; col < matrix.length; col++) {
                int tam = einsteinSub(lin, col, b);
                if (tam > tamSub) tamSub = tam;
            }
        }
        return tamSub;
    }

    private static int einsteinSub(int lin, int col, int[][] b) {
        if (b[lin][col] == 0) return 0;
        int tam = 1;
        int prox = col + 1;
        int min = b[lin][col];
        while (prox < b.length) {
            if (b[lin][prox] < min) min = b[lin][prox];
            if (min > tam) {
                tam++;
            } else break;
            prox++;
        }
        return tam;
    }


    private static void printMatrix(int[][] b) {
        for (int[] linha : b) {
            for (int elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }

    }
}

