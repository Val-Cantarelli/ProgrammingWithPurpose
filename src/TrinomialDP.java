

public class TrinomialDP {
    // Inicializa matrix
    public static long trinomial(int n, int k) {
        long[][] memo = new long[n + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo.length; j++) memo[i][j] = -1;
        }
        return trinomialHelper(n, k, memo);
    }

    private static long trinomialHelper(int n, int k, long[][] memo) {
        // Casos base
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        // Se o valor já foi calculado, retorná-lo
        if (memo[n][Math.abs(k)] != -1) return memo[n][Math.abs(k)];
        // Calcular o coeficiente trinomial recursivamente
        long result = trinomialHelper(n - 1, k - 1, memo) + trinomialHelper(n - 1, k, memo) + trinomialHelper(n - 1, k + 1, memo);
        // Armazenar o valor calculado no array memo
        memo[n][Math.abs(k)] = result;
        return result;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        System.out.println(trinomial(x, y));
    }
}
