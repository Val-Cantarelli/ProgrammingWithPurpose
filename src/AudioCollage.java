import edu.princeton.cs.algs4.StdAudio;

public class AudioCollage {

    public static double[] amplify(double[] a, double alpha) {
        double[] newArray = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i] * alpha;
        }
        return newArray;
    }

    public static double[] reverse(double[] a) {
        double[] newArray = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[(a.length - i) - 1];
        }
        return newArray;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] newArray = new double[a.length + b.length];
        System.arraycopy(a, 0, newArray, 0, a.length);
        int i = 0;
        for (int j = a.length; j < newArray.length; j++, i++) {
            newArray[j] = b[i];
        }
        return newArray;
    }

    public static double[] mix(double[] a, double[] b) {
        double[] sum = new double[Math.max(a.length, b.length)];
        for (int i = 0; i < a.length; i++) {
            sum[i] = sum[i] + a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sum[i] = sum[i] + b[i];
        }
        return sum;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        double tamanho = a.length / alpha;

        double[] acelerated = new double[(int) tamanho];
        for (int i = 0; i < acelerated.length; i++) {
            double index = Math.floor(alpha * i);
            acelerated[i] = a[(int) index];
        }
        return acelerated;
    }

    public static void main(String[] args) {
        StdAudio.play(amplify(StdAudio.read("singer.wav"), 0.9375));
        StdAudio.play(reverse(StdAudio.read("singer.wav")));
        StdAudio.play(merge(StdAudio.read("piano.wav"), StdAudio.read("harp.wav")));
        StdAudio.play(mix(StdAudio.read("beatbox.wav"), StdAudio.read("chimes.wav")));
        StdAudio.play(changeSpeed(StdAudio.read("beatbox.wav"), 1.0));
    }
}