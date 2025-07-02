public class ShannonEntropy {
    public static void main(String[] args) {
        int[] input = StdIn.readAllInts();
        int m = input[0];
        int[] events = new int[input.length];

        
        for (int i = 1; i < events.length && events[i] < m; i++) {
            int index = input[i];
            events[index]++;
        }
        double pi;
        double totalEntropy = 0;
        double logBase2 = 0;
        double entropy;
        for (int i = 1; i < events.length; i++) {
            pi = events[i] / (double) (input.length - 1);
            if (pi > 0) {
                logBase2 = Math.log(pi) / Math.log(2);
                entropy = -(pi * logBase2);
                totalEntropy = totalEntropy + entropy;
            }
        }
        System.out.printf("%.4f", totalEntropy);
    }

}
