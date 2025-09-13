import edu.princeton.cs.algs4.In;

public class Huntingtons {

    public static int maxRepeats(String dna) {
        String s = "CAG";
        int index = 0;
        int indexStart = dna.indexOf(s, index);
        int tamMaxSegment = 0;
        while (indexStart != -1) {
            int ocorrencias = 0;
            int[] segment = repOcorr(indexStart, dna, s);
            ocorrencias = (segment[1] - segment[0]) / s.length();
            if (ocorrencias > tamMaxSegment) tamMaxSegment = ocorrencias;
            indexStart = dna.indexOf(s, segment[1]);
        }
        return tamMaxSegment;
    }

    private static int[] repOcorr(int indexStart, String dna, String s) {
        int index = indexStart + s.length();
        while (true) {
            int match = dna.indexOf(s, index);
            if (match != index)
                break;
            index += s.length();
        }
        return new int[]{indexStart, index};
    }

    public static String removeWhitespace(String s) {
        return s.replace(" ", "")
                .replace("\t", "")
                .replace("\n", "")
                .replace("\r", "");

    }

    public static String diagnose(int maxRepeats) {
        String diagnoses = "";
        if (maxRepeats <= 9 || maxRepeats >= 181) diagnoses = "not human";
        if (maxRepeats <= 35 && maxRepeats >= 10) diagnoses = "normal";

        if (maxRepeats >= 36 && maxRepeats <= 39) diagnoses = "high risk";
        if (maxRepeats >= 40 && maxRepeats <= 180) diagnoses = "Huntington's";
        return diagnoses;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);

        String content = in.readAll();
        String dna = removeWhitespace(content);

        int repetitions = maxRepeats(dna);
        System.out.println("max repeats = " + repetitions);
        System.out.println(diagnose(repetitions));
    }
}
