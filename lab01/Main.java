import java.time.LocalDate;
import java.util.logging.Logger;

public class Main {
    public static void main(String args[]) {
        Usuario pessoa1 = new Usuario("Victor", 0, 0, 0);
        Livros livro1 = new Livros("Pequeno princípe", "Antoine de Saint-Exupéry", new String[]{"Ação", "Aventura"}, "português", 1, 10);

        Aluguel aluguel1;
        try {
            aluguel1 = Aluguel.criarAluguel(pessoa1, livro1, LocalDate.now().plusDays(7));
        } catch (Exception e) {
            System.out.println("Não foi possível que esse usuário alugue o livro:");
            System.out.println(e);
        }

    }
}
