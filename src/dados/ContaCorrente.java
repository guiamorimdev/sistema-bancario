package dados;

import java.util.Random;

public class ContaCorrente implements Conta {
    private String cliente;
    private String numero;
    private String agencia;
    private double saldo;

    public ContaCorrente(String cliente) {
        Random random = new Random();
        this.saldo = 0.00;
        this.numero = String.format("%04d", random.nextInt(10000));
        this.cliente = cliente;
        this.agencia = String.format("%08d", random.nextInt(100000000));
    }

    @Override
    public String depositar(double valor) {
        if (valor <= 0) {
            return "\nImpossível depositar um valor menor ou igual a zero (R$0,00)";
        } else {
            this.saldo += valor;
            return String.format("\nDepositado com sucesso!\nO valor de R$%.2f já se encontra presente na sua conta.\nSaldo Atual: R$%.2f", valor , this.saldo);
        }
    }

    @Override
    public String sacar(double valor) {
        if (valor <= 0) {
            return "\nImpossível sacar um valor menor ou igual a zero (R$0,00)";
        } else if (valor > saldo) {
            return String.format("\nImpossível sacar um valor maior que o saldo da conta. \nSaldo Atual: R$%.2f", this.saldo);
        } else {
            this.saldo -= valor;
            return String.format("\nSaque realizado com sucesso!\nO valor de R$%.2f foi sacado da sua conta.\nSaldo Atual: R$%.2f", valor , this.saldo);
        }
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        /*
        *
        *
        *
        *
        * */
    }

    @Override
    public String getSaldo() {
        return String.format("\nSaldo Atual: R$%.2f", this.saldo);
    }

    public String toString (){
        return "Cliente: " + cliente + "\nNúmero: " + numero + "\nAgência: " + agencia + "\nSaldo: " + saldo;
    }
}
