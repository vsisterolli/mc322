package tests;

public class TestRunnerModel {

    public TestRunnerModel() {
    }

    protected int falhas = 0;
    protected int sucessos = 0;

    public String esperado() {
        this.sucessos++;
        return "esperado";
    }
    public String falhou() {
        this.falhas++;
        return "falhou";
    }
    public int getFalhas() {
        return falhas;
    }

    public int getSucessos() {
        return sucessos;
    }

}
