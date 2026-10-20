package model;

public interface ContaInterface {
    String depositar(double valor);
    String sacar(double valor);
    String transferir(double valor, Conta contaDestino);
    double getSaldo();
    void setSaldo(double saldo);
    String getNumero();
    void setNumero(String numero);
    String getAgencia();
    void setAgencia(String agencia);
    String getCliente();
    void setCliente(String cliente);

}
