import java.time.LocalDate;
public class TestRunner {

    private static void mostrarResultado(String resultado, int numero, String nome) {
        if(resultado == "esperado") {
            System.out.println("Teste " + numero + " - " + nome + " - Sucesso");
        }
        else System.out.println("Teste " + numero + " - " + nome + " - Falhou");
    }

    public static void main(String[] args) {
        System.out.println("---------------------------- Test: Usuarios ----------------------------");
        mostrarResultado(TestUser.testarCriacaoUsuario(), 1, "Testar usuário");
        mostrarResultado(TestUser.testarTotalAlugadosInvalido(), 2, "Testar total alugados inválido");
        mostrarResultado(TestUser.testarMultaInvalida(), 3, "Testar multa inválida");
        mostrarResultado(TestUser.testarCapacidadeAluguel(), 4, "Testar capacidade de aluguel");
        mostrarResultado(TestUser.testarRegistroAluguel(), 5, "Testar registro de aluguel");
        mostrarResultado(TestUser.testarDevolucao(), 6, "Testar devolução de aluguel");
        System.out.println("User test runner: " + TestUser.getSucesso() + " OK | " + TestUser.getFalhas() + " Failed");
        System.out.println("---------------------------- Test: Livros ----------------------------");
    }

}
