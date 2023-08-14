package main;

public class Funcionario extends Usuario {

    private String cargo;

    public Funcionario(String nome, int totalAlugados, int alugadosAgora, double multaPendente, String cargo, String especialidade) throws Exception {
        super(nome, totalAlugados, alugadosAgora, multaPendente);
        this.cargo = cargo;
    }

    public void multar(double quantia) {
        this.multaPendente += 0.1 * quantia;
    }
    public int getAluguelDiasMaximos() {
        return aluguelDiasMaximos * 3;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}