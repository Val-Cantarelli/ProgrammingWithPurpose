public class Charge {
    // instance variables
    // private: denies clients access and therefore makes data type abstract
    // final: disallows any change in value and documents that data type is immutable
    private final double rx, ry; // position
    private final double q; // charge value

    // constructor
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }


    // test client
    public static void main(String[] args) {
        Charge c = new Charge(.72, .31, 21.3);
        System.out.println(c);
        System.out.printf("%6.2e\n", c.potentialAt(.42, .71));
    }

    // sobrescrever o toString para algo que eu quero
    @Override
    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }

    // methods
    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }

}
