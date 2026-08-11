package dados;

public class ContaCorrente extends Conta implements ContaInterface {

    public ContaCorrente(String cliente) {
        super(cliente);
    }

    public String toString (){
        return "Cliente: " + cliente + "\nNúmero: " + numero + "\nAgência: " + agencia + "\nSaldo: " + saldo;
    }
}
