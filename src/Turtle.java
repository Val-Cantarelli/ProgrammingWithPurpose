public class Turtle {
    private double x, y; // position
    private double angle; // orientation

    public Turtle(double x0, double y0, double a0) {
        // Do not declare variables! They create local variables, which are diferent from de instance variables!
        x = x0;
        y = y0;
        angle = a0;
    }

    //test client - triangle
    public static void main(String[] args) {
        Turtle turle = new Turtle(0.0, 0.0, 0.0);
        turle.goFoward(1.0);
        turle.turnLeft(120.0);
        turle.goFoward(1.0);
        turle.turnLeft(120.0);
        turle.goFoward(1.0);
        turle.turnLeft(120.0);
    }

    public void turnLeft(double delta) {
        angle += delta;
    }

    public void goFoward(double d) {
        double oldx = x;
        double oldy = y;
        x += d * Math.cos(Math.toRadians(angle));
        y += d * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);

    }
}
