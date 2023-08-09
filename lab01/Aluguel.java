import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel {

    private static double multaDiaria = 0.2;

    private Usuario usuario;
    private Livros livro;
    private LocalDate expiraEm;

    private Aluguel(Usuario usuario, Livros livro, LocalDate expiraEm) {
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
    public void devolverAluguel() {
        usuario.devolverAluguel();
        livro.devolverLivro();
        double multa = this.calcularMulta();
        usuario.multar(multa);
    }
}
