public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n == 1) System.out.print("+ ");

        else {
            int size = 4;
            int[] newArray = new int[n];
            newArray[0] = 0;
            newArray[1] = 1;
            int m;
            while (size <= n) {

                m = size / 4;

                for (int i = m; i < (2 * m); i++) {
                    newArray[i + m] = newArray[i];
                }
                for (int j = 0; j < m; j++) {
                    newArray[j + (3 * m)] = newArray[j];
                }
                size *= 2;
            }
            int k = size / 2;
            m = size / 4;
            for (int i = m; i < (2 * m) && k < n; i++, k++) {
                newArray[i + m] = newArray[i];
            }
            for (int j = 0; j < m && k < n; j++, k++) {
                newArray[j + (3 * m)] = newArray[j];
            }
            for (int lin = 0; lin < n; lin++) {
                for (int col = 0; col < n; col++) {
                    if (newArray[lin] == newArray[col])
                        if (col == 0) System.out.print("+ ");
                        else System.out.print(" + ");
                    else {
                        if (col == 0) System.out.print("- ");
                        else System.out.print(" - ");
                    }
                }
                System.out.println();

            }


            System.out.println();
        }


    }
}