public class Hanoi {

    public static void hanoi(int n, char origem, char destino, char aux, int size) {
        if (n == 0) return;
        hanoi(n - 1, origem, aux, destino, size);
        System.out.println("Move disc " + (size + n) + " from " + origem + " to " + destino);
        hanoi(n - 1, aux, destino, origem, size);
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'C', 'B', 10);
    }
}
