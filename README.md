# 💰 Sistema Bancário em Java

Um sistema de gerenciamento bancário desenvolvido em Java, focado na aplicação dos pilares da **Programação Orientada a Objetos (POO)**.

---

## 🚀 Funcionalidades

- **Gestão de Contas**
  - Criação de contas Corrente e Poupança
  - Geração automática de número da conta e agência
- **Operações Bancárias**
  - Depósito com validação de valores
  - Saque com controle de saldo disponível
  - Transferência entre contas
  - Consulta de dados da conta, com saldo formatado no padrão monetário brasileiro (R$)
- **Conta Poupança**
  - Rendimento de juros de 5% por ciclo
  - Simulação do último dia do ciclo (30º dia) para testes
- **Persistência de Dados e Extrato**
  - Salvamento e carregamento automático de contas em arquivo JSON (`contas.json`)
  - Registro temporal e exibição de extrato bancário com histórico de transações

---

## 🛠️ Tecnologias e Conceitos

- **Linguagem:** Java 17
- **Gerenciador de Dependências e Build:** Apache Maven
- **Controle de versão:** Git e GitHub
- **Persistência / Serialização:** Google Gson
- **Testes Unitários:** JUnit 5
- **Conceitos de POO:** Encapsulamento, Polimorfismo, Classes Abstratas, Exceções Personalizadas e TypeAdapters customizados

---

## 📂 Estrutura do Projeto

```text
src/
├── main/
│   └── java/
│       ├── exception/  # Classes de exceções personalizadas
│       ├── model/      # Classes de domínio (Conta, ContaCorrente, ContaPoupanca, ContaInterface)
│       ├── service/    # Lógica de negócio e gerenciamento (ContaService)
│       ├── util/       # Adaptadores para serialização JSON
│       ├── view/       # Interface do console (Menu)
│       └── Main.java   # Classe principal para execução
└── test/
    └── java/           # Estrutura preparada para testes unitários
```

---

## 💻 Como Executar

### Pré-requisitos

- Java JDK 17
- Apache Maven
- Git

### 1. Clonar o repositório

```bash
git clone https://github.com/guiamorimdev/sistema-bancario.git
cd sistema-bancario
```

### 2. Executar via IDE (IntelliJ IDEA, Eclipse, VS Code)

1. Abra a IDE e selecione **Open / Import Project**.
2. Navegue até a pasta onde clonou o projeto e abra-a.
3. Aguarde a IDE terminar de indexar o projeto.
4. Localize o arquivo `src/main/java/Main.java`.
5. Clique com o botão direito nele e selecione **Run 'Main.main()'** (ou pressione `Shift + F10` no IntelliJ).

### 3. Executar pelo terminal

1. Compile e construa o projeto:
   `mvn clean compile`

2. Execute os testes unitários:
   `mvn test`

3. Execute a aplicação:
   `mvn exec:java -Dexec.mainClass="Main"`

## 📋 Como Usar

Ao iniciar a aplicação, você verá o menu interativo:

```text
=== SISTEMA BANCÁRIO ===
1 - Criar Conta
2 - Depositar
3 - Consultar Dados da Conta
4 - Sacar
5 - Transferir
6 - Render Juros (Poupança)
7 - Simular Último Dia do Ciclo (Poupança)
8 - Exibir Extrato Bancário
0 - Sair
Escolha uma opção:
```

1. Crie uma conta (**opção 1**) para gerar um número de conta válido.
2. Faça depósitos, saques, transferências e consultas entre as contas para testar as validações.

### Testando a Conta Poupança

1. Crie uma **Conta Poupança**.
2. Use a **opção 7** para avançar o ciclo direto para o 30º dia.
3. Use a **opção 6** para render os juros de 5% e ver o saldo atualizado.

---

## 🔮 Próximos Passos

- [x] Exceções customizadas para validações de regras de negócio
- [x] Testes unitários com JUnit 5
- [x] Histórico de transações (extrato bancário)
- [x] Persistência de dados em arquivo ou banco de dados
---

## 👨‍💻 Autor

**Guilherme Melo**
GitHub: [@guiamorimdev](https://github.com/guiamorimdev)

---
