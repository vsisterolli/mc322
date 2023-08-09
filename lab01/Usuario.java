public class Usuario {
    private String nome;
    private int totalAlugados;
    private int alugadosAgora;
    private double multaPendente;

    public Usuario(String nome, int totalAlugados, int alugadosAgora, double multaPendente) {
        this.nome = nome;
        this.totalAlugados = totalAlugados;
        this.alugadosAgora = alugadosAgora;
        this.multaPendente = multaPendente;
    }

    public Boolean podeAlugar() {
        return totalAlugados <= 1 && multaPendente == 0;
    }

    public Boolean registrarAluguel() {
        this.totalAlugados++;
        this.alugadosAgora++;
    }

    public void devolverAluguel() throws Exception {
        if(this.alugadosAgora == 0) {
            throw new Exception("O usuário não tem nenhum livro alugado.");
        }
        this.alugadosAgora--;
    }

    public void multar(double quantia) {
        this.multaPendente += quantia;
    }

    public void pagarMulta(double quantia) {
        if(quantia > this.multaPendente) {
            throw new Exception("Pagamentos antecipados não são permitidos");
        }
        this.multaPendente -= quantia;
    }



}
