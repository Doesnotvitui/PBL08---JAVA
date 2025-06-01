import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ContaCorrente> contas = new ArrayList<>();
        ContaCorrente c1 = new ContaCorrente(1, "minhasenha", 10.000);
        Banco banco1 = new Banco ("Banco do Brasil", contas );

        contas.add(c1);

        banco1.criar_conta(1, "teste", 5.000);
        banco1.criar_conta(2, "senha", 3.000);

        try {
            banco1.sacar(2, "senha6", 10.001);
        } catch(ExcecaoContaInvalida e) {
            System.out.println(e.getMessage());
        } catch (ExcecaoSenhaInvalida e) {
            System.out.println(e.getMessage());
        } catch(ExcecaoSaldoInsuficiente e) {
            System.out.println(e.getMessage());
        }
    }
}
