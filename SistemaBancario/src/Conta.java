import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo;
    private final String titular;
    private final ReentrantLock lock = new ReentrantLock();

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
            System.out.printf("%s depositou R$ %.2f. Saldo atual: R$ %.2f%n", titular, valor, saldo);
        } finally {
            lock.unlock();
        }
    }

    public void sacar(double valor) {
        lock.lock();
        try {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.printf("%s sacou R$ %.2f. Saldo atual: R$ %.2f%n", titular, valor, saldo);
            } else {
                System.out.printf("%s tentou sacar R$ %.2f, mas o saldo é insuficiente!%n", titular, valor);
            }
        } finally {
            lock.unlock();
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
