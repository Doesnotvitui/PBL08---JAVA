public class ContaCorrente {
    private int numero;
    private String senha;
    private double saldo;

    public ContaCorrente(int numero, String senha, double saldo) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void retirar(double valor, String senha) throws ExcecaoSenhaInvalida, ExcecaoSaldoInsuficiente {
        if (saldo < valor) {
            throw new ExcecaoSaldoInsuficiente("Saldo insuficiente");
        } else if (!senha.equals(senha)) {
            throw new ExcecaoSenhaInvalida("Senha Invalida!");
        }else {
            saldo -= valor;
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void alterarSaldo(double valor) {
        saldo = saldo - valor;
    }

}
