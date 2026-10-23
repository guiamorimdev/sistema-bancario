package view;

import exception.ContaNaoEncontradaException;
import exception.SaldoInsuficienteException;
import exception.TipoContaInvalidoException;
import exception.ValorInvalidoException;
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
            System.out.println("8 - Exibir Extrato Bancário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CRIAR NOVA CONTA ---");

                    System.out.print("Digite o Nome do Titular: ");
                    scanner.nextLine();
                    String nomeTitular = scanner.nextLine();

                    try {
                        Conta.validarNomeTitular(nomeTitular);
                    } catch(exception.NomeTitularInvalidoException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Operação de Criação de Conta Cancelada!");
                        break;
                    }

                    // Pergunta o tipo de conta
                    System.out.println("Escolha o Tipo de Conta:");
                    System.out.println("1 - Conta Corrente (Saldo inicial: R$ 0.0)");
                    System.out.println("2 - Conta Poupança (Saldo inicial: R$ 50.0)");
                    System.out.print("Opção: ");
                    int tipoConta = scanner.nextInt();

                    // Variável genérica do tipo Conta para guardar a nova conta instanciada
                    Conta novaConta = null;

                    try {
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
                    } catch (TipoContaInvalidoException e){
                        System.out.println(e.getMessage());
                        System.out.println("Operação de Criação de Conta Cancelada!");
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

                    try {
                        Conta contaDeposito = contaService.buscarConta(numeroContaDeposito);

                        System.out.print("Digite o Valor a Ser Depositado: R$");
                        double valorDeposito = scanner.nextDouble();

                        String mensagemRetorno = contaDeposito.depositar(valorDeposito);
                        System.out.println(mensagemRetorno);

                    } catch (ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n--- CONSULTAR DADOS DA CONTA ---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta: ");
                    String numeroBusca = scanner.nextLine();

                    try {
                        Conta contaEncontrada = contaService.buscarConta(numeroBusca);

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

                    } catch (ContaNaoEncontradaException e) {
                            System.out.println(e.getMessage());

                    }
                    break;
                case 4:
                    System.out.println("\n--- SAQUE ---");

                    // Limpa o buffer
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta: ");
                    String numeroContaSaque = scanner.nextLine();

                    Conta contaSaque = contaService.buscarConta(numeroContaSaque);

                    try {
                        System.out.print("Digite o Valor a Ser Sacado: R$");
                        double valorSaque = scanner.nextDouble();

                        String mensagemRetorno = contaSaque.sacar(valorSaque);
                        System.out.println(mensagemRetorno);

                    } catch (exception.ContaNaoEncontradaException | exception.SaldoInsuficienteException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\n--- TRANSFERÊNCIA ---");
                    scanner.nextLine();

                    System.out.print("Digite o Número da Conta de Origem: ");
                    String numeroContaOrigem = scanner.nextLine();

                    System.out.print("Digite o Número da Conta de Destino: ");
                    String numeroContaDestino = scanner.nextLine();

                    // Evita transferência para a mesma conta
                    if (numeroContaOrigem.equals(numeroContaDestino)) {
                        System.out.println("\nNão é Possível Fazer uma Transferência para a Própria Conta!");
                        break;
                    }

                    try {
                        // Busca ambas as contas (se alguma não existir, lança ContaNaoEncontradaException)
                        Conta contaOrigem = contaService.buscarConta(numeroContaOrigem);
                        Conta contaDestino = contaService.buscarConta(numeroContaDestino);

                        System.out.print("Digite o Valor a Ser Transferido: R$");
                        double valorOrigem = scanner.nextDouble();

                        String mensagemRetorno = contaOrigem.transferir(valorOrigem, contaDestino);
                        System.out.println(mensagemRetorno);

                    } catch (exception.ContaNaoEncontradaException | exception.SaldoInsuficienteException | exception.ValorInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\n--- RENDIMENTO DE JUROS ---");
                    scanner.nextLine();

                    System.out.print("Digite o Número da Sua Conta Poupança: ");
                    String numeroConta = scanner.nextLine();

                    try {
                        // Se a conta não existir, ContaNaoEncontradaException
                        Conta conta = contaService.buscarConta(numeroConta);

                        // Verifica se é uma Conta Poupança
                        if (!(conta instanceof ContaPoupanca)) {
                            throw new IllegalArgumentException("\nEsta Conta Não é do Tipo Poupança!");
                        }

                        ContaPoupanca poupanca = (ContaPoupanca) conta;
                        String mensagemRetorno = poupanca.renderJuros();
                        System.out.println("\n" + mensagemRetorno);

                    } catch (exception.ContaNaoEncontradaException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("\n--- ATALHO: AVANÇAR DIAS (SIMULAÇÃO) ---");
                    scanner.nextLine();

                    System.out.print("Digite o Número da Sua Conta Poupança: ");
                    String numConta = scanner.nextLine();

                    try {
                        Conta c = contaService.buscarConta(numConta);

                        if (!(c instanceof ContaPoupanca)) {
                            throw new IllegalArgumentException("\nEsta Conta Não é do Tipo Poupança!");
                        }

                        ContaPoupanca p = (ContaPoupanca) c;
                        String msgRetorno = p.simularUltimoDia();
                        System.out.println("\n" + msgRetorno);

                    } catch (exception.ContaNaoEncontradaException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("\n--- EXTRATO BANCÁRIO ---");
                    scanner.nextLine(); // Limpa o buffer

                    System.out.print("Digite o Número da Conta: ");
                    String numeroContaExtrato = scanner.nextLine();

                    try {
                        Conta contaExtrato = contaService.buscarConta(numeroContaExtrato);
                        contaExtrato.exibirExtrato();

                    } catch (ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
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