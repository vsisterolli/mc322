package tests;
import main.Livros;

public class TestLivros extends TestRunnerModel {

    public String testarCriacao() {
        try {
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            assert livro.getNome().equals("livro1");
            assert livro.getAutor().equals("autor");
            assert livro.incluiGenero("Genero1");
            assert livro.incluiGenero("Genero2");
            assert !livro.incluiGenero("Genero3");
            assert livro.getGeneros().length == 2;
            assert livro.getIdioma().equals("portugues");
            assert livro.getEdicao() == 1;
            assert livro.getQuantidadeDisponivel() == 1;

            return esperado();
        } catch (AssertionError | Exception e) {
            return falhou();
        }
    }

    public String testarDisponibilidade() {
        try {
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            assert livro.disponivelParaAlugar();

            livro.registrarAluguel();
            assert livro.getQuantidadeDisponivel() == 0;

            assert !livro.disponivelParaAlugar();
            livro.registrarAluguel();

            return falhou();
        } catch (Exception e) {
            return esperado();
        } catch(AssertionError e) {
            return falhou();
        }
    }

    public String testarDevolucao() {
        try {
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            assert livro.getQuantidadeDisponivel() == 1;

            livro.devolverLivro();;
            assert livro.getQuantidadeDisponivel() == 2;

            return esperado();
        } catch(AssertionError | Exception e) {
            return falhou();
        }
    }

    public String testarQuantidadeDisponivel() {
        try {
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, -1);

            return falhou();
        } catch(Exception e) {
            return esperado();
        }
    }

    public String testarSetQuantidadeDisponivel() {
        try {
            Livros livro = new Livros("livro1", "autor", new String[]{"Genero1", "Genero2"}, "portugues", 1, 1);
            livro.setQuantidadeDisponivel(2);

            assert livro.getQuantidadeDisponivel() == 2;
            livro.setQuantidadeDisponivel(-1);

            return falhou();
        } catch (Exception e) {
            return esperado();
        } catch (AssertionError e) {
            return falhou();
        }
    }

}
