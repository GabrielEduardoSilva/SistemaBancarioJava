public class Funcionario implements Runnable {
    private final String nome;
    private final Conta contaSalario;
    private final Conta contaInvestimento;

    public Funcionario(String nome, Conta contaSalario, Conta contaInvestimento) {
        this.nome = nome;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void investir() {
        double valorInvestido = contaSalario.getSaldo() * 0.20;
        contaSalario.sacar(valorInvestido);
        contaInvestimento.depositar(valorInvestido);
        System.out.printf("%s investiu R$ %.2f.%n", nome, valorInvestido);
    }

    @Override
    public void run() {
        // Tem que implementar isso aqui
    }
}