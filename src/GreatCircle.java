public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double radius = 6371.0;
        double result = Math.pow(Math.sin((x2 - x1)/2), 2);
        double result2 = Math.pow(Math.sin((y2-y1)/2), 2);

        double  distance = 2 * radius * Math.asin(Math.sqrt(result + Math.cos(x1) * Math.cos(x2) * result2));

        System.out.println(distance + " kilometers");
    }
}
