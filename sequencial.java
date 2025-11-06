public class sequencial {

    public static void main(String[] args) {
        
        //Amostra população
        double populacaoSuceptivel = 990.0;
        double infectados = 10.0;
        double recuperados = 0.0;
        // calcular a população total garantindo que não seja negativa
        double populacaoTotal = Math.max(populacaoSuceptivel + infectados + recuperados, 0.0);

        //Informações virais
        double beta = 0.3;   // Taxa de transmissão
        double gamma = 0.1;  // Taxa de recuperação
        
        //Atualização dos dados
        int dias = 365; // Número de dias para simulação
        double passo = 0.1;

        for(int dia = 0; dia < dias; dia++){
            double novosSuceptivel = (-beta * populacaoSuceptivel * infectados) / populacaoTotal;
            double novosInfectados = (beta * populacaoSuceptivel * infectados) / populacaoTotal - (gamma * infectados);
            double novosRecuperados = gamma * infectados;

            populacaoSuceptivel += novosSuceptivel * passo;
            infectados += novosInfectados * passo;
            recuperados += novosRecuperados * passo;

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\n", dia, populacaoSuceptivel, infectados, recuperados);
        }

    }


}