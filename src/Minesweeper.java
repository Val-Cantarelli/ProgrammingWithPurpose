public class Minesweeper {
    public static void main(String[] args) {
        int lin = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        int bomb = Integer.parseInt(args[2]);
        int[] bombs = new int[bomb];
        int[] arrayPositions = new int[(lin * col)];
        int[][] matrix = new int[lin][col];

        for (int i = 0; i < arrayPositions.length; i++)
            arrayPositions[i] = i;

        int swaps = 0;
        while (bomb != 0) {
            int random = (int) (Math.random() * (arrayPositions.length - swaps));
            bombs[swaps] = arrayPositions[random];
            swaps++;
            int temp = arrayPositions[random];
            arrayPositions[random] = arrayPositions[arrayPositions.length - swaps];
            arrayPositions[arrayPositions.length - swaps] = temp;
            bomb--;
        }

        for (int count = 0; count < bombs.length; count++) {
            int i = bombs[count] / col;
            int j = bombs[count] % col;
            matrix[i][j] = -1;

            for (int ii = Math.max(0, i - 1); ii <= Math.min(lin - 1, i + 1); ii++) {
                for (int jj = Math.max(0, j - 1); jj <= Math.min(col - 1, j + 1); jj++) {
                    if (matrix[ii][jj] != -1) {
                        matrix[ii][jj] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) System.out.print(" * ");
                else
                    System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
