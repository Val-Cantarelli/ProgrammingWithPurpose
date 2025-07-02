public class Teste {

    public static int compara(String dna, String s, int index) {
        int ocorr = 1;
        int i = index + s.length();
        int j = 0;
        while (i < dna.length() && dna.charAt(i) == s.charAt(j)) {
            i++;
            j++;
            if (j == s.length()) {
                ocorr++;
                j = 0;
            }

        }
        return ocorr;
    }


    public static void main(String[] args) {
        String dna = "ABCABCABC";
        String s = "ABC";
        int index = 0;
        System.out.println(compara(dna, s, index));

    }
}
