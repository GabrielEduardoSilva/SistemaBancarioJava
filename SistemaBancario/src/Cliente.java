import java.util.*;

public class Cliente implements Runnable {
    private final String nome;
    private final Conta conta;
    private final Loja[] lojas;
    private final Banco banco;
    private final Random random = new Random();

    public Cliente(String nome, Conta conta, Loja[] lojas, Banco banco) {
        this.nome = nome;
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    public void realizarCompra(Loja loja) {
        double valorCompra = 200 + (random.nextDouble() * 300); // Valor entre 200 e 500
        System.out.printf("%s está realizando uma compra de R$ %.2f na loja %s.%n", nome, valorCompra, loja);
        loja.receberPagamento(conta, valorCompra);
    }

    @Override
    public void run() {
        for (Loja loja : lojas) {
            realizarCompra(loja);
            realizarCompra(loja); // 2 compras por loja
        }
    }
}
