package dados;

public interface ContaInterface {
    String depositar(double valor);
    String sacar(double valor);
    void transferir(double valor, ContaInterface contaDestino);
    String getSaldo();
}
