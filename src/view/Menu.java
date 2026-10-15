package view;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Consultar Dados da Conta");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Avançar Ciclo (Poupança)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CRIAR NOVA CONTA ---");

                    System.out.print("Digite o nome do titular: ");
                    scanner.nextLine();
                    String nomeTitular = scanner.nextLine();

                    // Pergunta o tipo de conta
                    System.out.println("Escolha o tipo de conta:");
                    System.out.println("1 - Conta Corrente (Saldo inicial: R$ 0.0)");
                    System.out.println("2 - Conta Poupança (Saldo inicial: R$ 50.0)");
                    System.out.print("Opção: ");
                    int tipoConta = scanner.nextInt();

                    // Variável genérica do tipo Conta para guardar a nova conta instanciada
                    Conta novaConta = null;

                    if (tipoConta == 1) {
                        // Instancia a Conta Corrente
                        novaConta = new ContaCorrente(nomeTitular);
                        System.out.println("Conta Corrente criada com sucesso!");

                    } else if (tipoConta == 2) {
                        // Instancia a Conta Poupança (com saldo inicial de 50.0 definido automaticamente)
                        novaConta = new ContaPoupanca(nomeTitular);
                        System.out.println("Conta Poupança criada com sucesso!");

                    } else {
                        System.out.println("Tipo de conta inválido! Operação cancelada.");
                    }

                    // Se a conta foi criada com sucesso, o próximo passo será salvá-la no seu ContaService!
                    if (novaConta != null) {
                        System.out.println("Titular: " + nomeTitular);
                        // Aqui você poderá chamar o seu service para guardar a `novaConta` em uma lista.
                    }
                    break;
                case 2:
                    System.out.println("Opção de depósito selecionada.");
                    break;
                case 3:
                    /**/
                case 4:
                    System.out.println("Opção de saque selecionada.");
                    break;
                case 5:
                    System.out.println("Opção de transferência selecionada.");
                    break;
                case 6:
                    System.out.println("Avançando ciclo da poupança...");
                    break;
                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}