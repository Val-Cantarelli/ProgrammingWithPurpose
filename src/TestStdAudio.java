import edu.princeton.cs.algs4.StdAudio;

public class TestStdAudio {
    public static void main(String[] args) {
        while (true) {
            StdAudio.play("hello/input_samples/harp.wav");
            StdAudio.play("hello/input_samples/piano.wav");
            StdAudio.read("hello/input_samples/piano.wav");

        }
    }
}