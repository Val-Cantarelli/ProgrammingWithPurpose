public class Divisors {
    public static int gcd(int a, int b) {
        int aa = Math.abs(a);
        int bb = Math.abs(b);

        if (aa == 0 || bb == 0) return Math.max(aa, bb);
        else {
            int resto;
            resto = aa % bb;
            while (resto != 0) {
                aa = bb;
                bb = resto;
                resto = aa % bb;
            }
        }
        return bb;
    }

    public static int lcm(int a, int b) {
        int divisor = gcd(a, b);
        int result = 0;
        if (divisor == 0) return result;
        else {
            result = (Math.abs(a) / divisor) * Math.abs(b);
        }
        return result;
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int totient(int n) {
        //
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        System.out.println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
        System.out.println("lcm(" + x + ", " + y + ") = " + lcm(x, y));
        System.out.println("areRelativelyPrime(" + x + ", " + y + ") = " + areRelativelyPrime(x, y));
        System.out.println("totient(" + x + ") = " + totient(x));
        System.out.println("totient(" + y + ") = " + totient(y));
    }
}
