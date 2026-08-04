import dados.ContaCorrente;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // classe usada para testes até o presente momento.
        ContaCorrente c1 = new ContaCorrente("Guilherme");
        System.out.println(c1);
        System.out.println(c1.getSaldo());
        System.out.println(c1.depositar(0));
        System.out.println(c1.depositar(500));
        System.out.println(c1.sacar(0));
        System.out.println(c1.sacar(1000));
        System.out.println(c1.sacar(300));
    }
}