public class ColorHSB {
    private final int h;
    private final int s;
    private final int b;

    public ColorHSB(int h0, int s0, int b0) {
        this.h = h0;
        this.s = s0;
        this.b = b0;

        if (h0 > 359 || h0 < 0) throw new IllegalArgumentException();
        if (s0 < 0 || s0 > 100) throw new IllegalArgumentException();
        if (b0 < 0 || b0 > 100) throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int hub0 = Integer.parseInt(args[0]);
        int sat0 = Integer.parseInt(args[1]);
        int bri0 = Integer.parseInt(args[2]);
        ColorHSB input = new ColorHSB(hub0, sat0, bri0);
        String nameColor = "";
        int minDistance = 1000;
        ColorHSB closest = null;

        while (!StdIn.isEmpty()) {

            String name = StdIn.readString();
            int hub1 = StdIn.readInt();
            int sat1 = StdIn.readInt();
            int bri1 = StdIn.readInt();
            ColorHSB trial = new ColorHSB(hub1, sat1, bri1);

            int distanceNow = input.distanceSquaredTo(trial);
            if (distanceNow < minDistance) {
                minDistance = distanceNow;
                closest = new ColorHSB(hub1, sat1, bri1);
                nameColor = name;
            }
        }
        System.out.println(nameColor + " " + closest);
    }

    public String toString() {
        return "(" + this.h + ", " + this.s + ", " + this.b + ")";
    }

    public boolean isGrayscale() {
        return this.s == 0 || this.b == 0;
    }

    private int square(int a) {
        return a * a;
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException();
        int min = Math.min(square(this.h - that.h), square(360 - Math.abs(this.h - that.h)));
        return (min + square(this.s - that.s) + square(this.b - that.b));
    }
}