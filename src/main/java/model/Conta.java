package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Conta implements ContaInterface {
    protected String cliente;
    protected String numero;
    protected String agencia;
    protected double saldo;
    protected List<Transacao> historico = new ArrayList<>();

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
            throw new exception.ValorInvalidoException("\nImpossível Depositar um Valor Menor ou Igual a Zero (R$0,00)");
        } else {
            this.saldo += valor;

            this.historico.add(new Transacao("DEPÓSITO", valor));

            return String.format("\nDepositado com sucesso!\nO valor de R$%.2f já se encontra presente na sua conta.\nSaldo Atual: R$%.2f", valor , this.saldo);
        }
    }

    @Override
    public String sacar(double valor) {
        if (valor <= 0) {
            return "\nImpossível sacar um valor menor ou igual a zero (R$0,00)";
        } else if (valor > saldo) {
            throw new exception.SaldoInsuficienteException(
                    String.format("\nImpossível Sacar um Valor Maior que o Saldo da Sua Conta! \nSaldo Atual: R$%.2f", this.saldo)
            );
        } else {
            this.saldo -= valor;

            this.historico.add(new Transacao("SAQUE", valor));

            return String.format("\nSaque realizado com sucesso!\nO valor de R$%.2f foi sacado da sua conta.\nSaldo Atual: R$%.2f", valor , this.saldo);
        }
    }

    @Override
    public String transferir(double valor, Conta contaDestino) {
        if (valor > this.getSaldo() || valor <= 0) {
            return "O Valor de Transferência Deve Ser Menor ou Igual ao Seu Saldo";
        } else {
            this.saldo -= valor;
            this.historico.add(new Transacao("TRANSFERÊNCIA ENVIADA", valor));

            contaDestino.saldo += valor;
            contaDestino.historico.add(new Transacao("TRANSFERÊNCIA RECEBIDA", valor));

            return "\nTransferência Realizada com sucesso!\nO Valor R$" + valor + " Já se Encontra na Conta de Destino.";
        }
    }

    public static void validarNomeTitular(String nome){
        if (nome == null || nome.trim().isEmpty()){
            throw new exception.NomeTitularInvalidoException("\nErro: O Nome do Titular Não Pode Estar Vazio!");
        }

        if (nome.matches(".*\\d.*")){
            throw new exception.NomeTitularInvalidoException("\nErro: O Nome do Titular Não Pode Conter Números!");
        }
    }

    public void exibirExtrato(){
        if (historico.isEmpty()){
            System.out.println("Nenhuma Transação Realizada Ainda.");
        } else {
            for (Transacao t : historico) {
                System.out.println(t);
            }
        }
    }

    @Override
    // uso o Math para mostrar o valor com duas casas decimais sem trocar o retorno do tipo double
    public double getSaldo() { return Math.round(this.saldo * 100.0) / 100.0;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getAgencia() {
        return agencia;
    }

    @Override
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Override
    public String getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Transacao> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Transacao> historico) {
        this.historico = historico;
    }
}
