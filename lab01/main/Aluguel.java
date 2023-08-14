package main;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel {

    private static double multaDiaria = 0.2;

    public static double getMultaDiaria() {
        return multaDiaria;
    }

    public static void setMultaDiaria(double multaDiaria) throws Exception {
        if(multaDiaria < 0) {
            throw new Exception("A multa diária não pode ser negativa.");
        }
        Aluguel.multaDiaria = multaDiaria;
    }

    private Usuario usuario;
    private Livros livro;
    private LocalDate expiraEm;

    private Aluguel(Usuario usuario, Livros livro, LocalDate expiraEm) throws Exception {
        if(expiraEm.isBefore(LocalDate.now())) {
            throw new Exception("A data de expiração deve ser uma data futura");
        }
        this.usuario = usuario;
        this.livro = livro;
        this.expiraEm = expiraEm;
    }

    public static Aluguel criarAluguel(Usuario usuario, Livros livro, LocalDate expiraEm) throws Exception {
        if(!usuario.podeAlugar()) {
            throw new Exception("Esse usuario tem multas pendentes ou atingiu o limite de alugueis simultâneos");
        }
        if(!livro.disponivelParaAlugar()) {
            throw new Exception("Esse livro não está disponível para ser alugado");
        }
        if(usuario.getAluguelDiasMaximos() < Duration.between(expiraEm, LocalDate.now()).toDays()) {
            throw new Exception("Este usuario não tem permissão para registrar um aluguel tão longo.");
        }
        usuario.registrarAluguel();
        livro.registrarAluguel();
        return new Aluguel(usuario, livro, expiraEm);
    }


    public double calcularMulta() {
        LocalDate hoje = LocalDate.now();
        if(hoje.isAfter(this.expiraEm)) {
            long totalDias = ChronoUnit.DAYS.between(hoje, this.expiraEm);
            return totalDias * multaDiaria;
        }
        return 0;
    }
    public void devolverAluguel() throws Exception {
        usuario.devolverAluguel();
        livro.devolverLivro();
        double multa = this.calcularMulta();
        usuario.multar(multa);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public LocalDate getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(LocalDate expiraEm) {
        this.expiraEm = expiraEm;
    }
}
