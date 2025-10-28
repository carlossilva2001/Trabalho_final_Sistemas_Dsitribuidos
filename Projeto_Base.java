
public class Projeto_Base {

    public static void main(String[] args) {

       // System.out.println("Projeto Base para Modelo Epidemiologico");

        ModeloEpidemiologico virusModel = new ModeloEpidemiologico();
        model modelo = new model();

        virusModel.setSusceptiveis(1000);
        virusModel.setInfectados(10);
        virusModel.setRecuperados(0);
        virusModel.setBeta(1.18);
        virusModel.setGamma(0.1);
        virusModel.setDelta(0.05);


        // Simulador de tempo
        int steps = 100;
        double timeStep = 1.0; // Intervalo de tempo
        for (int i = 0; i < steps; i++) {
            System.out.printf("Passo %d:%n", i + 1);
            modelo.displayState(virusModel);
            modelo.simulateStep(timeStep, virusModel);
        }
    }
}