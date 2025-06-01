import java.util.ArrayList;

public class Banco {
    private String nome;
    ArrayList<ContaCorrente> contas;

    public Banco(String nome, ArrayList<ContaCorrente> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public void criar_conta(int numero, String senha, double saldo) {
        contas.add(new ContaCorrente(numero, senha, saldo));
    }

    public void sacar(int numero, String senha, double valor) throws ExcecaoContaInvalida, ExcecaoSenhaInvalida,ExcecaoSaldoInsuficiente {
        boolean contaExsite = false;
        boolean senhaExite = false;
        boolean saldoExite = false;
        for (ContaCorrente conta : contas) {
            if (numero == conta.getNumero()) {
                contaExsite = true;
            }
            if (conta.getSenha().equals(senha)) {
                senhaExite = true;
            }
            if (valor <= conta.getSaldo()) {
                conta.alterarSaldo(valor);
                saldoExite = true;
            }
        }
        if (!contaExsite) {
             throw new ExcecaoContaInvalida("Conta invalida!");
        }
        if (!senhaExite) {
            throw  new ExcecaoSenhaInvalida("Senha Invalida");
        }
        if (!saldoExite) {
            throw new ExcecaoSaldoInsuficiente("Saldo insuficiente");
        }
    }
}