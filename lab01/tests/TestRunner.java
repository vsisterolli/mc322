package tests;

public class TestRunner {

    private static int falhasTotais = 0;
    private static int sucessosTotais = 0;
    private static int numero = 1;

    private static void mostrarResultado(String resultado, String nome) {
        if(resultado.equals("esperado")) {
            System.out.println("Teste " + numero + " - " + nome + " - Sucesso");
            sucessosTotais++;
        }
        else {
            System.out.println("Teste " + numero + " - " + nome + " - Falhou");
            falhasTotais++;
        }
        numero++;
    }

    private final static TestUser testUserInstance = new TestUser();
    private final static TestLivros testLivrosInstance = new TestLivros();
    private final static TestAluguel testAluguelInstance = new TestAluguel();

    public static void main(String[] args) {
        System.out.println("---------------------------- Test: Usuarios ----------------------------");
        mostrarResultado(testUserInstance.testarCriacaoUsuario(), "Testar criação de usuário");
        mostrarResultado(testUserInstance.testarTotalAlugadosInvalido(),  "Testar total alugados inválido");
        mostrarResultado(testUserInstance.testarMultaInvalida(), "Testar multa inválida");
        mostrarResultado(testUserInstance.testarCapacidadeAluguel(), "Testar capacidade de aluguel");
        mostrarResultado(testUserInstance.testarRegistroAluguel(), "Testar registro de aluguel");
        mostrarResultado(testUserInstance.testarDevolucao(), "Testar devolução de aluguel");
        mostrarResultado(testUserInstance.testarMulta(), "Testar devolução de aluguel");

        System.out.println("User test runner: " + testUserInstance.getSucessos() + " OK | " + testUserInstance.getFalhas() + " Failed");
        System.out.println("---------------------------- Test: main.Livros ----------------------------");
        mostrarResultado(testLivrosInstance.testarCriacao(), "Testar criação de livro");
        mostrarResultado(testLivrosInstance.testarDisponibilidade(), "Testar disponibilidade");
        mostrarResultado(testLivrosInstance.testarQuantidadeDisponivel(), "Testar criação com quantidade negativa");
        mostrarResultado(testLivrosInstance.testarSetQuantidadeDisponivel(), "Testar set quantidade negativa");
        System.out.println("main.Livros test runner: " + testLivrosInstance.getSucessos() + " OK | " + testLivrosInstance.getFalhas() + " Failed");

        System.out.println("---------------------------- Test: main.Aluguel ----------------------------");
        mostrarResultado(testAluguelInstance.testarMultaDiaria(), "Testar multa de aluguel");
        mostrarResultado(testAluguelInstance.testarCriacao(), "Testar criação de aluguel");
        mostrarResultado(testAluguelInstance.testarDataInvalida(), "Testar criação de aluguel com data inválida");
        mostrarResultado(testAluguelInstance.testarUsuarioInvalido(), "Testar criação de aluguel com usuario impedido");
        mostrarResultado(testAluguelInstance.testarLivroInvalido(), "Testar criação de aluguel com livro indisponível");
        System.out.println("main.Aluguel test runner: " + testAluguelInstance.getSucessos() + " OK | " + testAluguelInstance.getFalhas() + " Failed");

    }

}
