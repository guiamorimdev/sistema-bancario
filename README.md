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

---

## 🛠️ Tecnologias e Conceitos

- **Linguagem:** Java
- **Controle de versão:** Git e GitHub
- **Conceitos de POO aplicados:**
  - **Encapsulamento:** proteção dos dados sensíveis da conta (`saldo`, `agencia`, `numero`)
  - **Interfaces e Polimorfismo:** padronização dos comportamentos das contas bancárias
  - **Regras de negócio:** validações de valores para depósito e saque

---

## 📂 Estrutura do Projeto

```text
src/
├── model/           # Classes de domínio (Conta, ContaCorrente, ContaInterface, ContaPoupanca)
├── service/         # Lógica de negócio e gerenciamento (ContaService)
├── view/            # Interface do console (Menu)
└── TestesMain.java  # Classe principal para testes e execução
```

---

## 💻 Como Executar

### Pré-requisitos

- Java JDK 17 ou superior (recomendado)
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
4. Localize o arquivo `src/TestesMain.java`.
5. Clique com o botão direito nele e selecione **Run 'TestesMain.main()'** (ou pressione `Shift + F10` no IntelliJ).

### 3. Executar pelo terminal

1. Entre na pasta de código-fonte:

```bash
   cd src
```

2. Compile as classes:

```bash
   javac model/*.java service/*.java view/*.java TestesMain.java
```

3. Execute o programa:

```bash
   java TestesMain
```

---

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

- [ ] Persistência de dados em arquivo ou banco de dados
- [ ] Testes unitários (JUnit)
- [ ] Exceções customizadas para as regras de negócio
- [ ] Histórico de transações (extrato)

---

## 👨‍💻 Autor

**Guilherme Melo**
GitHub: [@guiamorimdev](https://github.com/guiamorimdev)

---
