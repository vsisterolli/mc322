package tests;
import main.Usuario;

public class TestUser extends TestRunnerModel {

    public String testarCriacaoUsuario() {
        try {
            Usuario usuario1 = new Usuario("User1");
            Usuario usuario2 = new Usuario("User2", 12);
            Usuario usuario3 = new Usuario("User3", 12, 10);
            Usuario usuario4 = new Usuario("User4", 12, 10, 20);

            assert usuario1.getNome().equals("User1") && usuario1.getTotalAlugados() == 0 && usuario1.getAlugadosAgora() == 0 && usuario1.getMultaPendente() == 0;
            assert usuario2.getNome().equals("User2") && usuario2.getTotalAlugados() == 12 && usuario2.getAlugadosAgora() == 0 && usuario2.getMultaPendente() == 0;
            assert usuario3.getNome().equals("User3") && usuario3.getTotalAlugados() == 12 && usuario3.getAlugadosAgora() == 10 && usuario3.getMultaPendente() == 0;
            assert usuario4.getNome().equals("User4") && usuario4.getTotalAlugados() == 12 && usuario4.getAlugadosAgora() == 10 && usuario4.getMultaPendente() == 20;

            return esperado();
        } catch(Exception | AssertionError e) {
            return falhou();
        }
    }

    public String testarTotalAlugadosInvalido() {
        try {
            Usuario usuario = new Usuario("User3", 1, 2);
            return falhou();
        } catch(Exception e) {
            return esperado();
        }
    }

    public String testarMultaInvalida() {
        try {
            Usuario usuario = new Usuario("User3", 1, 1, -1);
            return falhou();
        } catch(Exception e) {
            return esperado();
        }
    }

    public String testarCapacidadeAluguel() {
        try {
            Usuario podeAlugar = new Usuario("user1", 0, 0, 0);
            Usuario jaAlugado = new Usuario("user2", 1, 1, 0);
            Usuario multaPendente = new Usuario("user3", 1, 0, 100);
            assert podeAlugar.podeAlugar() && !jaAlugado.podeAlugar() && !multaPendente.podeAlugar();

            return esperado();
        } catch(Exception | AssertionError e) {
            return falhou();
        }
    }

    public String testarRegistroAluguel() {
        try {
            Usuario user = new Usuario("user1", 0, 0, 0);
            user.registrarAluguel();

            assert user.getTotalAlugados() == 1 && user.getAlugadosAgora() == 1;
            return esperado();
        } catch(Exception | AssertionError e) {
            return falhou();
        }
    }

    public String testarDevolucao() {
        try {
            Usuario user = new Usuario("user1", 1, 1, 0);
            user.devolverAluguel();
            assert user.getAlugadosAgora() == 0;

            user.devolverAluguel();
            return falhou();
        } catch(Exception e) {
            return esperado();
        } catch(AssertionError e) {
            return falhou();
        }
    }

    public String testarMulta() {
        try {
            Usuario user = new Usuario("user1", 1, 1, 0);
            user.multar(10.20);

            assert user.getMultaPendente() == 10.20;
            user.pagarMulta(10.20);
            assert user.getMultaPendente() == 0;

            user.pagarMulta(10);
            return falhou();
        } catch(Exception e) {
            return esperado();
        } catch(AssertionError e) {
            return falhou();
        }
    }

}
