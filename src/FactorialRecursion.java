public class FactorialRecursion {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if (n == 1) return 1;

        else return factorial(n - 1) * n;
    }
}
