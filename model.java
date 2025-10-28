public class model {
    
        // Método para simular um passo do modelo
    public void simulateStep(double timeStep, ModeloEpidemiologico model) {
            // Leitura dos estados atuais
            double S = model.getSusceptiveis();
            double I = model.getInfectados();
            double R = model.getRecuperados();

            // População total (evitar divisão por zero)
            double N = S + I + R;
            if (N <= 0) {
                // Nada a simular
                return;
            }

            // Normalizar transmissão pela população total (modo mass-action por pessoa)
            double newInfected = model.getBeta() * S * I / N * timeStep;
            double newRecovered = model.getGamma() * I * timeStep;
            double newSusceptibleFromRecovered = model.getDelta() * R * timeStep;

            // Calcular próximos estados de forma atômica
            double nextS = S - newInfected + newSusceptibleFromRecovered;
            double nextI = I + newInfected - newRecovered;
            double nextR = R + newRecovered - newSusceptibleFromRecovered;

            // Garantir que os valores não sejam negativos
            nextS = Math.max(nextS, 0);
            nextI = Math.max(nextI, 0);
            nextR = Math.max(nextR, 0);

            // Aplicar atualizações no modelo
            model.setSusceptiveis(nextS);
            model.setInfectados(nextI);
            model.setRecuperados(nextR);
    }

    // Método para exibir o estado atual
    public void displayState(ModeloEpidemiologico model) {
        System.out.printf("Suscetíveis: %.2f, Infectados: %.2f, Recuperados: %.2f%n", model.getSusceptiveis(), model.getInfectados(), model.getRecuperados());
    }
}
