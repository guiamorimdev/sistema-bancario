package view;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import service.ContaService;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final ContaService contaService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.contaService = new ContaService();
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
            System.out.println("6 - Render Juros (Poupança)");
            System.out.println("7 - Simular Último Dia do Ciclo (Poupança)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CRIAR NOVA CONTA ---");

                    System.out.print("Digite o Nome do Titular: ");
                    scanner.nextLine();
                    String nomeTitular = scanner.nextLine();

                    // Pergunta o tipo de conta
                    System.out.println("Escolha o Tipo de Conta:");
                    System.out.println("1 - Conta Corrente (Saldo inicial: R$ 0.0)");
                    System.out.println("2 - Conta Poupança (Saldo inicial: R$ 50.0)");
                    System.out.print("Opção: ");
                    int tipoConta = scanner.nextInt();

                    // Variável genérica do tipo Conta para guardar a nova conta instanciada
                    Conta novaConta = null;

                    if (tipoConta == 1) {
                        // Instancia a Conta Corrente
                        novaConta = new ContaCorrente(nomeTitular);
                        System.out.println("Conta Corrente Criada com Sucesso!");

                    } else if (tipoConta == 2) {
                        // Instancia a Conta Poupança (com saldo inicial de 50.0 definido automaticamente)
                        novaConta = new ContaPoupanca(nomeTitular);
                        System.out.println("Conta Poupança Criada com Sucesso!");

                    } else {
                        System.out.println("Tipo de Conta Inválido! Operação Cancelada.");
                    }

                    // Se a conta foi criada com sucesso, o próximo passo será salvá-la no seu ContaService!
                    if (novaConta != null) {
                        contaService.adicionarConta(novaConta); // adiciona a conta recém criada na lista do ContaService

                        System.out.println("\nConta Criada com Sucesso!");
                        System.out.println("\nTitular: " + nomeTitular);
                        System.out.println("Número da Conta: " + novaConta.getNumero());
                        System.out.println("Agência: " + novaConta.getAgencia());
                        System.out.print("Saldo: " + novaConta.getSaldo() + "\n");
                    }
                    break;
                case 2:
                    System.out.println("\n--- DEPÓSITO ---");

                    // Limpa o enter pendente deiaxdo pelo nextInt() do menu principal
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta para Depósito: ");
                    String numeroContaDeposito = scanner.nextLine();

                    Conta contaDeposito = contaService.buscarConta(numeroContaDeposito);

                    if (contaDeposito != null) {
                        System.out.print("Digite o Valor a Ser Depositado: R$");
                        double valorDeposito = scanner.nextDouble();

                        String mensagemRetorno = contaDeposito.depositar(valorDeposito);

                        System.out.println(mensagemRetorno);
                    } else {
                        System.out.println("\nConta Não Encontrada!");
                    }
                    break;
                case 3:
                    System.out.println("\n--- CONSULTAR DADOS DA CONTA ---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta: ");
                    String numeroBusca = scanner.nextLine();

                    Conta contaEncontrada = contaService.buscarConta(numeroBusca);

                    if (contaEncontrada != null) {
                        System.out.println("\n--- CONTA ENCONTRADA ---");
                        System.out.println("\nTitular: " + contaEncontrada.getCliente());
                        System.out.println("Número: " + contaEncontrada.getNumero());
                        System.out.println("Agência: " + contaEncontrada.getAgencia());
                        System.out.print("Saldo: " + contaEncontrada.getSaldo());

                        if (contaEncontrada instanceof ContaCorrente) {
                            System.out.print("\nTipo: Conta Corrente\n");
                        } else {
                            System.out.println("\nTipo: Conta Poupança\n");
                        }
                        break;
                    }
                case 4:
                    System.out.println("\n--- SAQUE ---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta: ");
                    String numeroContaSaque = scanner.nextLine();

                    Conta contaSaque = contaService.buscarConta(numeroContaSaque);

                    if (contaSaque != null) {
                        System.out.print("Digite o Valor a Ser Sacado: R$");
                        double valorSaque = scanner.nextDouble();

                        // captura e exibe a mensagem do método sacar
                        String mensagemRetorno = contaSaque.sacar(valorSaque);
                        System.out.println(mensagemRetorno);

                    } else {
                        System.out.print("\nConta Não Encontrada!");
                    }
                    break;
                case 5:
                    System.out.println("\n--- TRANSFERÊNCIA ---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta: ");
                    String numeroContaOrigem = scanner.nextLine();

                    Conta contaOrigem =  contaService.buscarConta(numeroContaOrigem);

                    // valida se a conta origem existe
                    if (contaOrigem != null) {
                        System.out.print("Digite o Número da Conta de Destino: ");
                        String numeroContaDestino = scanner.nextLine();

                        // evita que haja a transferência para a própria conta
                        if (numeroContaOrigem.equals(numeroContaDestino)){
                            System.out.println("\nNão é Possível Fazer uma Transferência para a Própria Conta!");
                            break;
                        }

                        Conta contaDestino =  contaService.buscarConta(numeroContaDestino);

                        // valida se a conta destino existe
                        if (contaDestino != null) {
                            System.out.print("Digite o Valor a Ser Transferido: R$");
                            double valorOrigem = scanner.nextDouble();

                            // executa a transf. e retorna a mensagem
                            String mensagemRetorno = contaOrigem.transferir(valorOrigem, contaDestino);
                            System.out.println(mensagemRetorno);

                        } else {
                            System.out.println("\nConta de Destino Não Encontrada!");
                        }

                    } else {
                        System.out.println("\nConta de Origem Não Encontrada!");
                    }

                    break;
                case 6:
                    System.out.println("\n--- RENDIMENTO DE JUROS ---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Sua Conta Poupança: ");
                    String numeroConta = scanner.nextLine();

                    Conta conta = contaService.buscarConta(numeroConta);

                    if (conta != null) {
                        if (conta instanceof ContaPoupanca poupanca) {
                            String mensagemRetorno = poupanca.renderJuros();
                            System.out.println("\n" + mensagemRetorno);
                        } else {
                            System.out.println("\nEsta Conta Não é do Tipo Poupança!");
                        }
                    } else {
                        System.out.println("\nConta Não Encontrada!");
                    }
                    break;
                case 7:
                    System.out.println("\n--- ATALHO: AVANÇAR DIAS (SIMULAÇÃO)---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Sua Conta Poupança: ");
                    String numConta = scanner.nextLine();

                    Conta c = contaService.buscarConta(numConta);

                    if (c != null) {
                        if (c instanceof ContaPoupanca p) {
                            String msgRetorno = p.simularUltimoDia();
                            System.out.println("\n" + msgRetorno);
                        } else {
                            System.out.println("\nEsta Conta Não é do Tipo Poupança");
                        }
                    } else {
                        System.out.println("\nConta Não Encontrada!");
                    }
                    break;
                case 0:
                    System.out.println("\n--- SAINDO DO SISTEMA! ---");
                    break;
                default:
                    System.out.println("\nOpção Inválida! Digite uma Opção Válida!");
            }
        }
    }
}