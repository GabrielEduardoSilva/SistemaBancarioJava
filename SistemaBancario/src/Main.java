public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criar contas das lojas
        Conta contaLoja1 = new Conta("Loja 1", 0);
        Conta contaLoja2 = new Conta("Loja 2", 0);

        // Criar funcionários
        Funcionario[] funcionariosLoja1 = {
                new Funcionario("Funcionario 1.1", new Conta("Salario 1.1", 0), new Conta("Investimento 1.1", 0)),
                new Funcionario("Funcionario 1.2", new Conta("Salario 1.2", 0), new Conta("Investimento 1.2", 0))
        };
        Funcionario[] funcionariosLoja2 = {
                new Funcionario("Funcionario 2.1", new Conta("Salario 2.1", 0), new Conta("Investimento 2.1", 0)),
                new Funcionario("Funcionario 2.2", new Conta("Salario 2.2", 0), new Conta("Investimento 2.2", 0))
        };

        // Criar lojas
        Loja loja1 = new Loja("Loja 1", contaLoja1, funcionariosLoja1, banco);
        Loja loja2 = new Loja("Loja 2", contaLoja2, funcionariosLoja2, banco);

        // Criar clientes
        Loja[] lojas = { loja1, loja2 };
        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), new Conta("Cliente " + (i + 1), 2000.00), lojas, banco);
        }

        // Iniciar threads dos clientes
        for (Cliente cliente : clientes) {
            new Thread(cliente).start();
        }
    }
}