public class Ramanujan {
    public static boolean isRamanujan(long n) {
        long[] array = new long[2];
        long comp = 0;
        long x = 0;
        long compCheck = 0;
        boolean ramanujan = false;

        for (long i = 1; i <= Math.cbrt(n); i++) {
            x = i * i * i;
            comp = (long) Math.cbrt(n - x);
            compCheck = comp * comp * comp;

            if (compCheck + x == n) {
                if (array[0] == 0 && array[1] == 0) {
                    array[0] = comp;
                    array[1] = i;
                } else if (array[0] != i && array[0] != comp && array[1] != i && array[1] != comp) ramanujan = true;
            }
        }
        return ramanujan;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}