public class Palindrome {
    // O for lê a primeira metade comparando com a segunda metade de trás para frente
    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) != s.charAt(N - i - 1)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String test = args[0];
        System.out.println(isPalindrome(test));
    }
}
