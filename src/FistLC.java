public class FistLC {

    public static int countCompleteDayPairs(int[] hours) {
        int count = 0;

        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length - 1; j++) {
                if (hours[i] + hours[j] % 24 == 0) count++;
            }

        }
        return count;

    }

}
