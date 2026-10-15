package model;

public class ContaPoupanca extends Conta implements ContaInterface {
    private static final double JUROS = 0.05;
    public int contadorDias = 1;

    public ContaPoupanca(String cliente) {
        super(cliente);
        this.saldo = 50.00;
    }

    public String renderJuros(){
        if (this.saldo == 0){
            return "Impossível render juros com o saldo igual a R$0,00";
        } else if (getContadorDias() == 30){
            double rendimento;
            rendimento = saldo + (saldo * JUROS);
            setSaldo(rendimento);
            return String.format("Saldo Atual Após o Rendimento: R$%.2f", saldo);
        }
        return "";
    }

    public void incrementadorDias(){
        if (getContadorDias() == 30) { setContadorDias(1); }
        this.contadorDias++;
    }

    public void setContadorDias(int contadorDias) {
        this.contadorDias = contadorDias;
    }

    public int getContadorDias() {
        return contadorDias;
    }

    public String toString (){
        return "\nCliente: " + cliente + "\nNúmero: " + numero + "\nAgência: " + agencia + "\nSaldo: " + saldo + "\nTaxa de Juros Atual: " + JUROS;
    }
}
