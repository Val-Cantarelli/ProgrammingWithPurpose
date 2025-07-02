public class RandomWalker {
    public static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int i = 0;

        System.out.println("(" + x + ", " + y + ")");

        for (; Math.abs(x) + Math.abs(y) < distance; i++) {
            double step = Math.random();
            if (step < 0.25) y++;
            if (0.25 <= step && step < 0.50) --y;
            if (0.50 <= step && step < 0.75) ++x;
            if (step >= 0.75) --x;
            System.out.println("(" + x + ", " + y + ")");

        }
        System.out.println("steps = " + i);

    }


}

