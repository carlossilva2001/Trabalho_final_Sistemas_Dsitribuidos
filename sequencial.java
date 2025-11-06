public class sequencial {

    public static void main(String[] args) {
        
        //Amostra população
        double populacaoSuceptivel = 9999990.0;
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

        // --- Simulação SIS (segundo laço) ---

        //Amostra população
        populacaoSuceptivel = 990.0;
        infectados = 10.0;

        // calcular a população total garantindo que não seja negativa
        populacaoTotal = Math.max(populacaoSuceptivel + infectados, 0.0);
        
        //Informações virais
        beta = 0.3;   // Taxa de transmissão
        gamma = 0.1;  // Taxa de recuperação

        //Atualização dos dados
        dias = 365; // Número de dias para simulação
        passo = 0.1;
        for(int dia = 0; dia < dias; dia++){
            
            //Probabilidade dos passos
            double chanceInfecacao = (beta * infectados)/ populacaoTotal*passo;
            double chanceRecuperacao = gamma*passo;

            //Atualização dos valores
            //Vai para o paralelo os dois for abaixo e vai retornar os valores novos e recuperadosHoje
            int novos = 0;
            for(int S = 0; S < populacaoSuceptivel; S++){
                if(Math.random() < chanceInfecacao){
                    novos++;
                }
            }
            int recuperadosHoje = 0;
            for(int I = 0; I < infectados; I++){
                if(Math.random() < chanceRecuperacao){
                    recuperadosHoje++;
                }
            }

            //tbm vai para o paralelo e retorna os novos valores
            infectados += novos - recuperadosHoje;
            populacaoSuceptivel += recuperadosHoje - novos;
            
            System.out.printf("%d\t%.2f\t%.2f\n", dia, populacaoSuceptivel, infectados);
        }

    }

}