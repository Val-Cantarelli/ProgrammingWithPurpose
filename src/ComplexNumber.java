import edu.princeton.cs.algs4.StdOut;

public class ComplexNumber {
    private final double real;
    private final double imag;

    public ComplexNumber(double real0, double imag0) {
        real = real0;
        imag = imag0;
    }

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(3.0, 4.0);
        ComplexNumber b = new ComplexNumber(-2.0, 3.0);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
        StdOut.println("a * b = " + a.times(b));
        StdOut.println("a + b = " + a.plus(b));
    }

    public ComplexNumber plus(ComplexNumber b) {
        double real = this.real + b.real;
        double imag = this.imag + b.imag;
        return new ComplexNumber(real, imag);

    }

    public ComplexNumber times(ComplexNumber b) {
        double real = this.real * b.real - this.imag * b.imag;
        double imag = this.real * b.imag + this.imag * b.real;

        return new ComplexNumber(real, imag);
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public String toString() {
        return this.real + " + " + imag + "i";
    }


}
