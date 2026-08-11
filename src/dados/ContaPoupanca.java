package dados;

public class ContaPoupanca extends Conta implements ContaInterface {
    private static final double JUROS = 0.05;

    public ContaPoupanca(String cliente) {
        super(cliente);
        this.saldo = 50.00;
    }

    public String renderJuros(){
        if (this.saldo == 0){
            return "Impossível render juros com o saldo igual a R$0,00";
        } else {
            double rendimento;
            rendimento = saldo + (saldo * JUROS);
            saldo = rendimento;
            return String.format("Saldo Atual Após o Rendimento: R$%.2f", saldo);
        }
    }

    public String toString (){
        return "\nCliente: " + cliente + "\nNúmero: " + numero + "\nAgência: " + agencia + "\nSaldo: " + saldo + "\nTaxa de Juros Atual: " + JUROS;
    }
}
