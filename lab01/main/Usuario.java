package main;

public class Usuario {

    protected int aluguelDiasMaximos = 7;
    public int getAluguelDiasMaximos() {
        return aluguelDiasMaximos;
    }

    public void setAluguelDiasMaximos(int aluguelDiasMaximos) {
        this.aluguelDiasMaximos = aluguelDiasMaximos;
    }

    private String nome;
    private int totalAlugados;
    private int alugadosAgora;
    protected double multaPendente;

    public Usuario(String nome) {
        this.nome = nome;
        this.totalAlugados = 0;
        this.alugadosAgora = 0;
        this.multaPendente = 0;
    }
    public Usuario(String nome, int totalAlugados) {
        this(nome);
        this.totalAlugados = totalAlugados;
    }
    public Usuario(String nome, int totalAlugados, int alugadosAgora) throws Exception {
        this(nome, totalAlugados);
        if(alugadosAgora > totalAlugados) {
            throw new Exception("O número de alugueis totais não pode ser inferior ao de alugueis agora");
        }
        this.alugadosAgora = alugadosAgora;
    }

    public Usuario(String nome, int totalAlugados, int alugadosAgora, double multaPendente) throws Exception {
        this(nome, totalAlugados, alugadosAgora);
        if(multaPendente < 0) {
            throw new Exception("A multa pendente não pode ser um valor negativo.");
        }
        this.multaPendente = multaPendente;
    }

    public Boolean podeAlugar() {
        return totalAlugados == 0 && multaPendente == 0;
    }

    public void registrarAluguel() {
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

    public void pagarMulta(double quantia) throws Exception {
        if(quantia > this.multaPendente) {
            throw new Exception("Pagamentos antecipados não são permitidos");
        }
        this.multaPendente -= quantia;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalAlugados() {
        return totalAlugados;
    }

    public int getAlugadosAgora() {
        return alugadosAgora;
    }

    public double getMultaPendente() {
        return multaPendente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
