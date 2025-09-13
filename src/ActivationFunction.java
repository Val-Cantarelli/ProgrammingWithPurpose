public class ActivationFunction {
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else if (x == 0.0) return 0.5;
        else if (x < 0.0) return 0.0;
        else return 1.0;
    }

    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else return 1 / (1 + Math.pow(Math.E, -x));
    }

    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else return (Math.pow(Math.E, x) - Math.pow(Math.E, -x)) / (Math.pow(Math.E, x) + Math.pow(Math.E, -x));
    }

    public static double softsign(double x) {
        double sign;
        if (x >= 0) sign = 1.0;
        else sign = -1.0;
        return 1 / (1 / x + sign);
    }

    public static double sqnl(double x) {
        double result = 0;
        if (Double.isNaN(x)) return Double.NaN;
        else if (x >= 0 && x < 2) result = x - (Math.pow(x, 2) / 4);
        else if (x > -2 && x < 0) result = x + (Math.pow(x, 2) / 4);
        else if (x >= 2) result = 1;
        else if (x <= -2) result = -1;


        return result;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        //The submission tests call my functions. Do not use main.
        if (Double.isNaN(x)) {
            System.out.println("heaviside(" + x + ") = " + "NaN");
            System.out.println("sigmoid(" + x + ") = " + "NaN");
            System.out.println("tanh(" + x + ") = " + "NaN");
            System.out.println("softsign(" + x + ") = " + "NaN");
            System.out.println("sqnl(" + x + ") = " + "NaN");
        } else {
            System.out.println("heaviside(" + x + ") = " + heaviside(x));
            System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
            System.out.println("tanh(" + x + ") = " + tanh(x));
            System.out.println("softsign(" + x + ") = " + softsign(x));
            System.out.println("sqnl(" + x + ") = " + sqnl(x));
        }
    }
}
