package model;

public interface ContaInterface {
    String depositar(double valor);
    String sacar(double valor);
    void transferir(double valor, Conta contaDestino);
    double getSaldo();
    void setSaldo(double saldo);
}
