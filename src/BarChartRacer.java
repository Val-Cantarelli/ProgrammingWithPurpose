import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BarChartRacer {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String filename = args[0];
        int limitBars = Integer.parseInt(args[1]);
        In in = new In(filename);

        // Le os títulos uma vez(tenho que fazer do zero):
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        BarChart barChart = new BarChart(title, xAxis, source);

        while (in.hasNextLine()) {
            String line = in.readLine();

            if (line.isEmpty()) {
                barChart.reset();
                int sizeGroup = Integer.parseInt(in.readLine());
                ArrayList<Bar> bar = new ArrayList<>();

                for (int i = 0; i < sizeGroup; i++) {
                    String[] array = in.readLine().split(",");
                    String name = array[1];
                    int value = Integer.parseInt(array[3]);
                    String category = array[4];

                    bar.add(new Bar(name, value, category));
                    barChart.setCaption(array[0]);
                }

                bar.sort(Comparator.reverseOrder());
                // Selecionar apenas a entrada limitBars
                List<Bar> topLimitBars = bar.subList(0, Math.abs(limitBars));

                // Agora que add ao objeto do BarChart que vai desenhar
                for (Bar b : topLimitBars) {
                    barChart.add(b.getName(), b.getValue(), b.getCategory());
                }

                StdDraw.clear();
                barChart.draw();
                StdDraw.pause(3);
                StdDraw.show();
            }
        }
    }
}
