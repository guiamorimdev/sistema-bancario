package model;

public class ContaPoupanca extends Conta implements ContaInterface {
    private static final double JUROS = 0.05;
    public int contadorDias = 1;

    public ContaPoupanca(String cliente) {
        super(cliente);
        this.saldo = 50.00;
    }

    public String renderJuros(){
        if (this.saldo == 0) {
            return "Impossível render juros com o saldo igual a R$0,00";
        }

        if (getContadorDias() == 30) {
            double rendimento = getSaldo() + (getSaldo() * JUROS);
            setSaldo(rendimento);

            // reserta o ciclo após o rendimento
            setContadorDias(1);
            return "Ciclo de 30 Dias Concluído! Rendimento Aplicado. \nConsulte os Dados da Conta para Verificar seu Saldo Atual!";
        } else {
            int diaAtual = getContadorDias();
            this.contadorDias++;
            return String.format("Dia Atual do Ciclo: %d/30. Os Juros Só Serão Aplicados no 30º Dia.", diaAtual);
        }
    }

    public String simularUltimoDia(){
        setContadorDias(30);
        return "Contador de Dias Definido para 30/30. Pronto para Render Juros!";
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
