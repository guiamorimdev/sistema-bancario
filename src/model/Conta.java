package model;

import java.util.Random;

public abstract class Conta implements ContaInterface {
    protected String cliente;
    protected String numero;
    protected String agencia;
    protected double saldo;

    public Conta (String cliente){
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
        // verificação do valor da transferência
        if (valor > this.getSaldo() || valor == 0){
            System.out.println("O valor de transferência deve ser menor ou igual ao seu saldo");
            return;
        }

        // caso passe na verificação, desconta da conta e realiza a transferência.
        this.setSaldo(this.getSaldo() - valor);
        contaDestino.depositar(valor);
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
