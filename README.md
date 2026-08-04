# 💰 Sistema Bancário em Java (Em desenvolvimento)

Um sistema de gerenciamento bancário desenvolvido em Java, focado na aplicação dos pilares da **Programação Orientada a Objetos (POO)**.

---

## 🚀 Funcionalidades

- **Gestão de Contas:**
  - Criação automática de contas com números e agências automáticos.
- **Operações Bancárias:**
  - Depósito com validação de valores válidos.
  - Saque com controle de saldo disponível.
  - Consulta de saldo formatada para o padrão monetário brasileiro (R$).

---

## 🛠️ Tecnologias e Conceitos

- **Linguagem:** Java
- **Controle de Versão:** Git e GitHub
- **Conceitos de POO Aplicados:**
  - **Encapsulamento:** Proteção de dados sensíveis da conta (`saldo`, `agencia`, `numero`).
  - **Interfaces e Polimorfismo:** Padronização dos comportamentos das contas bancárias.
  - **Tratamento de Regras de Negócio:** Validações de valores para depósito e saque.

---

## 📂 Estrutura do Projeto

```text
src/
 ├── dados/          # Classes de domínio (Conta, ContaCorrente)
 └── Main.java       # Classe principal para testes e execução
