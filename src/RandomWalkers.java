public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int count = 0;
        double averageSteps = 0;

        while (count < trials) {
            int x = 0;
            int y = 0;
            int i = 0;
            for (; Math.abs(x) + Math.abs(y) < r; i++) {
                double move = Math.random();
                if (move < 0.25) y++;
                if (0.25 <= move && move < 0.50) --y;
                if (0.50 <= move && move < 0.75) ++x;
                if (move >= 0.75) --x;
            }
            averageSteps += i;
            count++;
        }

        System.out.println("average number of steps = " + averageSteps / trials);

    }
}
