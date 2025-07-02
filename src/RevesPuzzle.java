public class RevesPuzzle {
    public static void hanoi(int n, char origem, char destino, char aux, int size) {
        if (n == 0) return;
        hanoi(n - 1, origem, aux, destino, size);
        System.out.println("Move disc " + (size + n) + " from " + origem + " to " + destino);
        hanoi(n - 1, aux, destino, origem, size);
    }

    public static void hanoi(int n, char origem, char destino, char aux1, char aux2, int size) {
        if (n == 0) return;
        if (n == 1) {
            System.out.println("Move disc " + (n + size) + " from " + origem + " to " + destino);
            return;
        }
        if (n == 2) {
            hanoi(n, origem, destino, aux2, size);
            return;
        }

        int k = (n + 1) - (int) Math.round(Math.sqrt(2 * n + 1));

        int resto = n - k;
        hanoi(k, origem, aux1, aux2, destino, size);
        hanoi(resto, origem, destino, aux2, size + k);
        hanoi(k, aux1, destino, aux2, origem, size);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoi(n, 'A', 'D', 'B', 'C', 0);
    }
}
