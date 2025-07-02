public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] arrEntry = new int[n];
        int[] arrSum = new int[n];

        for (int i = 0; i < n; i++) {
            arrEntry[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println();
        arrSum[0] = arrEntry[0];
        for (int s = 1; s < n; s++) {
            arrSum[s] = arrSum[s - 1] + arrEntry[s];
        }
        System.out.println();
        for (int p = 0; p < m; p++) {
            double aleatorio = Math.random() * arrSum[n - 1];
            for (int j = 0; j < n; j++) {
                if (aleatorio < arrSum[j]) {
                    System.out.print(j + 1 + " ");
                    break;
                }
            }
        }
    }
}