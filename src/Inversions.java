public class Inversions {
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j] && i < j) count++;
            }
        }
        return count;
    }

    public static int[] generate(int n, long k) {
        int[] arr = new int[n];
        int i = 1;
        int initialPos = 0;
        while (k != 0) {
            if (k >= n - i) {
                arr[initialPos] = n - i;
                k = k - (n - i);
                i++;
                initialPos++;
            } else {
                arr[(int) ((n - 1) - k)] = (n - 1) - initialPos;
                k = 0;
            }
        }
        for (int j = 0, x = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                arr[j] = x;
                x++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            System.out.print(generate(n, k)[i] + " ");
        }
    }
}