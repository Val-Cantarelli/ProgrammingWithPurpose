public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int experim = 0;

        int[] resultadosExperimentos = new int[n + 2];
        /* Arry resultadosExperimentos:
        resultadosExperimentos[x] é o total de experimentos que pararam em x.
        ex: resultadosExperimentos[4] = 3000, significa que houve 3000 experimentos
        que pararam após a chegada da 4a pessoa.

        +2: meu vetor precisa de uma posićao a mais porque pessoas comeca em 1-ou seja, a cadeira zero não será usada -
         e para a ultima pessoa a entrar na sala
         */
        while (experim != trials) {
            int[] room = new int[n + 1];//cada pessoa entra e fica em uma cadeira espec(position)

            int birthday;
            for (int people = 1; true; people++) {
                birthday = (int) (Math.random() * n) + 1;
                if (room[birthday] == 0) room[birthday] += 1;
                else {
                    experim++;
                    resultadosExperimentos[people] += 1;
                    break;
                }
            }
        }
        double fraction = 0.0;
        int count = 0;
        int cumulativeCount = 0;
        int i = 0;
        int j = 1;
        System.out.println(1 + " " + count + " " + fraction);
        for (; fraction < 0.5; j++) {
            count = resultadosExperimentos[j + 1];
            cumulativeCount += count;
            fraction = cumulativeCount / (double) trials;
            System.out.println(j + 1 + " " + count + " " + fraction);

        }
    }
}
