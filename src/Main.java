import dados.ContaCorrente;
import dados.ContaPoupanca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // classe usada para testes até o presente momento.
        ContaPoupanca p1 = new ContaPoupanca("Guilherme");
        System.out.println(p1);
        p1.renderJuros();
        System.out.println(p1);
    }
}