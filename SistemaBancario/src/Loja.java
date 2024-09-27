public class Loja implements Runnable {
    private final String nome;
    private final Conta conta;
    private final Funcionario[] funcionarios;
    private final Banco banco;

    public Loja(String nome, Conta conta, Funcionario[] funcionarios, Banco banco) {
        this.nome = nome;
        this.conta = conta;
        this.funcionarios = funcionarios;
        this.banco = banco;
    }

    public void receberPagamento(Conta cliente, double valor) {
        banco.transferir(cliente, this.conta, valor);
        pagarFuncionarios();
    }

    public void pagarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            if (conta.getSaldo() >= 1400.00) {
                banco.transferir(conta, funcionario.getContaSalario(), 1400.00);
                funcionario.investir();
            }
        }
    }

    @Override
    public void run() {
    }
}
