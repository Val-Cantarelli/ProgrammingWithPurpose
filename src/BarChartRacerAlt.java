import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*heckstyle ends with 1 errors.
[ERROR] BarChartRacerAlt.java:1: You must construct 'Bar' object in this program. [Bar]
[WARN] BarChartRacerAlt.java:1: Use the 'readLine()' and 'hasNextLine()' methods from the 'In' class to read the data file one line at a time. [FileInput]
[WARN] BarChartRacerAlt.java:1: Call 'Arrays.sort()' to sort the Bar objects by value. [Sort]
Checkstyle ends with 1 error and 2 warnings.*/

public class BarChartRacerAlt {

    public static void main(String[] args) {
        // Set o canvas uma vez e abre o buffer
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();


        String filename = args[0];
        int barsInput = Integer.parseInt(args[1]);
        In in = new In(filename);
        //String content = in.readAll();


        // Le os títulos uma vez:
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();


        // Cria um objeto uma vez e reset depois de desenhar ele
        BarChart chart = new BarChart(title, xAxis, source);

        while (!in.isEmpty()) {
            String line = in.readLine();

            if (line.isEmpty()) {
                int sizeGroup = Integer.parseInt(in.readLine());
                chart.reset();

                ArrayList<BarInfo> barInfos = new ArrayList<>();

                for (int i = 0; i < sizeGroup; i++) {
                    String[] array = in.readLine().split(",");
                    String name = array[1];
                    int value = Integer.parseInt(array[3]);
                    String category = array[4];
                    // Adiciona a BarInfo na lista
                    barInfos.add(new BarInfo(name, value, category));
                    chart.setCaption(array[0]);
                }

                // Ordena a lista de BarInfo em ordem decrescente de valor
                barInfos.sort(Comparator.comparingInt(BarInfo::getValue).reversed());

                // Seleciona apenas os 10 primeiros elementos (os maiores valores)
                List<BarInfo> topBarInfos = barInfos.subList(0, Math.min(barsInput, barInfos.size()));

                // Adiciona os dados ordenados ao objeto chart
                for (BarInfo barInfo : topBarInfos) {
                    chart.add(barInfo.getName(), barInfo.getValue(), barInfo.getCategory());
                }

                StdDraw.clear();
                chart.draw();
                StdDraw.pause(3);
                //StdAudio.playInBackground("soundtrackA.wav");
                StdDraw.show();
            }
        }
    }

    private static class BarInfo {
        private final String name;
        private final int value;
        private final String category;

        public BarInfo(String name, int value, String category) {
            this.name = name;
            this.value = value;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public String getCategory() {
            return category;
        }
    }
}