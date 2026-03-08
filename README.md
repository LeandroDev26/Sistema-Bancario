# 💰 Java Banking System

Este projeto é um sistema robusto de gestão bancária desenvolvido em Java. Ele simula as operações do dia a dia de uma instituição financeira, permitindo o gerenciamento de clientes e diferentes modalidades de contas com regras de negócio específicas.

## 🚀 Funcionalidades do Sistema
O sistema oferece um menu interativo com as seguintes operações:
1.  **Cadastrar Cliente:** Registro de novos correntistas no banco.
2.  **Cadastrar Conta:** Abertura de novas contas vinculadas a um CPF.
3.  **Depósito:** Incremento de saldo em contas ativas.
4.  **Saque:** Retirada de valores com validação de saldo e senha.
5.  **Transferir:** Movimentação de recursos entre diferentes contas e clientes.
6.  **Consultar Saldo:** Verificação instantânea dos valores disponíveis.
7.  **Gerar Rendimentos:** Aplicação de juros exclusiva para **Contas Poupança**.
8.  **Pagar Imposto:** Dedução de taxas obrigatórias para **Contas PJ**.
9.  **Listar Clientes:** Exibição de todos os clientes e suas respectivas contas.
10. **Encerrar Conta:** Desativação de contas (apenas com saldo zerado).

## 🏗️ Arquitetura e Classes
O projeto foi estruturado seguindo rigorosamente os princípios da Programação Orientada a Objetos:

* **`Sistema_Bancario.java`**: Ponto de entrada (Main) que inicializa o banco e o menu.
* **`Menu.java`**: Interface de usuário via console com tratamento de exceções.
* **`Banco.java`**: Motor principal que implementa a lógica das operações bancárias.
* **`AcoesConta.java`**: Interface que define o contrato de métodos obrigatórios para o banco.
* **`Cliente.java`**: Modelo que armazena dados pessoais e a lista de contas do usuário.
* **`Conta.java`**: Classe abstrata que serve de base para os tipos específicos de conta.
* **`ContaPoupanca.java`** & **`ContaPJ.java`**: Especializações que demonstram o uso de **Herança** e **Polimorfismo** (ex: regras de rendimentos e impostos).


## 🛠️ Conceitos Avançados Aplicados
* **Abstração:** Uso de classes abstratas e interfaces para definir comportamentos padrão.
* **Polimorfismo:** Diferentes comportamentos para o método de gerar rendimentos/impostos dependendo do tipo da conta.
* **Tratamento de Exceções:** Uso de `try-catch` e `InputMismatchException` para garantir a resiliência do sistema contra entradas inválidas.
* **Coleções (ArrayList):** Gerenciamento dinâmico de listas de clientes e contas.

## 💻 Como executar
1.  Clone o repositório.
2.  Compile o projeto no seu terminal ou IDE (NetBeans/IntelliJ):
    ```bash
    javac Sistema_Bancario.java
    ```
3.  Execute a aplicação:
    ```bash
    java Sistema_Bancario
    ```

---
*Projeto desenvolvido para consolidar conceitos avançados de POO no 3º Período de Ciência da Computação.*