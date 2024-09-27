public class Banco {
    public void transferir(Conta origem, Conta destino, double valor) {
        synchronized (this) {
            origem.sacar(valor);
            destino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada com sucesso de %s para %s.%n", valor, origem, destino);
        }
    }
}