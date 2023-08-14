package tests;

import main.*;
import java.time.LocalDate;

public class TestAluguel extends TestRunnerModel {
    public String testarMultaDiaria() {
        try {
            assert Aluguel.getMultaDiaria() == 0.2;
            Aluguel.setMultaDiaria(0.1);

            assert Aluguel.getMultaDiaria() == 0.1;
            Aluguel.setMultaDiaria(-1);

            return falhou();
        } catch(AssertionError e) {
            return falhou();
        } catch(Exception e) {
            return esperado();
        }
    }

    public String testarCriacao() {
        try {
            Usuario user = new Usuario("user1", 0, 0, 0);
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            Aluguel aluguel = Aluguel.criarAluguel(user, livro, LocalDate.now().plusDays(7));

            assert livro.getQuantidadeDisponivel() == 0;
            assert user.getAlugadosAgora() == 1;

            return esperado();
        } catch (Exception | AssertionError e) {
            return falhou();
        }
    }
    public String testarDataInvalida() {
        try {
            Usuario user = new Usuario("user1", 0, 0, 0);
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            Aluguel aluguel = Aluguel.criarAluguel(user, livro, LocalDate.now().minusDays(7));

            return falhou();
        } catch (Exception e) {
            return esperado();
        }
    }

    public String testarUsuarioInvalido() {
        try {
            Usuario user = new Usuario("user1", 1, 1, 0);
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            Aluguel aluguel = Aluguel.criarAluguel(user, livro, LocalDate.now().plusDays(7));

            return falhou();
        } catch (Exception e) {
            return esperado();
        }
    }

    public String testarLivroInvalido() {
        try {
            Usuario user = new Usuario("user1", 0, 0, 0);
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 0);
            Aluguel aluguel = Aluguel.criarAluguel(user, livro, LocalDate.now().plusDays(7));

            return falhou();
        } catch (Exception e) {
            return esperado();
        }
    }
}
