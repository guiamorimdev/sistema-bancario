package dados;

public interface Conta {
    String depositar(double valor);
    String sacar(double valor);
    void transferir(double valor, Conta contaDestino);
    String getSaldo();
}
