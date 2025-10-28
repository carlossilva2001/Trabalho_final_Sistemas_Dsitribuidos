public class ModeloEpidemiologico {

    // Parâmetros do modelo
    private double susceptiveis;    // População suscetível
    private double infectados;      // População infectada
    private double recuperados;     // População recuperada
    private double beta;            // Taxa de transmissão
    private double gamma;           // Taxa de recuperação
    private double delta;           // Taxa de perda de imunidade (SIS)

    public double getSusceptiveis() {
        return susceptiveis;
    }

    public void setSusceptiveis(double susceptiveis) {
        this.susceptiveis = susceptiveis;
    }

    public double getInfectados() {
        return infectados;
    }

    public void setInfectados(double infectados) {
        this.infectados = infectados;
    }

    public double getRecuperados() {
        return recuperados;
    }

    public void setRecuperados(double recuperados) {
        this.recuperados = recuperados;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public ModeloEpidemiologico(double susceptiveis, double infectados, double recuperados, double beta, double gamma, double delta) {
        this.susceptiveis = susceptiveis;
        this.infectados = infectados;
        this.recuperados = recuperados;
        this.beta = beta;
        this.gamma = gamma;
        this.delta = delta;
    }

    public ModeloEpidemiologico() {
        this.susceptiveis = 0;
        this.infectados = 0;
        this.recuperados = 0;
        this.beta = 0;
        this.gamma = 0;
        this.delta = 0;
    }
}   