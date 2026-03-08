package com.mycompany.sistema_bancario;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco implements AcoesConta {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void cadastrarCliente() {
        System.out.println("======= CADASTRO DE CLIENTE =======");
        System.out.print("INSIRA O CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("INSIRA O NOME O NOME: ");
        String nome = scanner.nextLine();
        System.out.print("INSIRA A IDADE: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INSIRA O ENDEREÇO: ");
        String endereco = scanner.nextLine();
        System.out.print("INSIRA UMA SENHA DE 4 DIGITOS: ");
        String senha = scanner.nextLine();
        Cliente novoCliente = new Cliente(cpf, nome, idade, endereco, senha);
        listaClientes.add(novoCliente);
        System.out.println("NOVO CLIENTE CADASTRADO COM SUCESSO");
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("NENHUM CLIENTE CADASTRADO");
        } else {
            System.out.println("======= LISTA DE CLIENTES =======");
            for (Cliente c : listaClientes) {
                System.out.println("NOME: " + c.getNome() + " | CPF: " + c.getCPF() + " | IDADE: " + c.getIdade() + " | ENDEREÇO: " + c.getEndereco() + " | SENHA: ****");
                if (c.getContas().isEmpty()) {
                    System.out.println("-> Nenhuma conta cadastrada.");
                    System.out.println("=============================");
                } else {
                    System.out.print("-> Contas: ");
                    for (Conta conta : c.getContas()) {
                        System.out.print("Nº" + conta.getNumConta() + " (" + conta.getFinalidade() + "), ");
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("=======================================");
    }

    @Override
    public void abrirConta() {
        System.out.print("INFORME O CPF DO CLIENTE NA QUAL VAI SER ABERTO A CONTA: ");
        String cpf = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpf)) {
                clienteEncontrado = c;
                break;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("CLIENTE NÃO CADASTRADO OU INEXISTENTE");
            return;
        }
        System.out.print("DIGITE O NUMERO DA CONTA: ");
        int numConta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("SELECIONE O TIPO DE CONTA:");
        System.out.println("[1] CONTA POUPANÇA");
        System.out.println("[2] CONTA PJ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        Conta novaConta = null;
        switch (opcao) {
            case 1:
                novaConta = new ContaPoupanca(numConta, "POUPANÇA", 0.0f, true);
                break;
            case 2:
                novaConta = new ContaPJ(numConta, "PJ", 0.0f, true);
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA. CONTA NÃO CRIADA.");
                return;
        }
        clienteEncontrado.adicionarConta(novaConta);
        System.out.println("CONTA CRIADA COM SUCESSO PARA O CLIENTE: " + clienteEncontrado.getNome());
    }

    @Override
    public void fecharConta() {
        System.out.print("DIGITE O CPF DO CLIENTE NO QUAL SERÁ CANCELADA A CONTA: ");
        String cpf = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpf)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("CLIENTE NÃO CADASTRADO OU INEXISTENTE");
            return;
        }
        System.out.print("DIGITE A SENHA DA CONTA: ");
        String senha = scanner.nextLine();
        if (!cliente.getSenha().equals(senha)) {
            System.out.println("SENHA INCORRETA");
            return;
        }
        System.out.print("DIGITE O NUMERO DA CONTA QUE SERÁ FECHADA: ");
        int numConta = scanner.nextInt();
        scanner.nextLine();
        Conta contaFechar = null;
        for (Conta conta : cliente.getContas()) {
            if (conta.getNumConta() == numConta && conta.getStatus()) {
                contaFechar = conta;
                break;
            }
        }
        if (contaFechar == null) {
            System.out.println("CONTA NÃO ENCONTRADA, INEXISTENTE OU JÁ INATIVA");
        } else if (contaFechar.getSaldo() > 0) {
            System.out.println("O SALDO DESSA CONTA ESTA POSITIVO, OPERAÇÃO INVALIDA");
        } else {
            contaFechar.setStatus(false);
            System.out.println("CONTA " + numConta + " ENCERRADA COM SUCESSO");
        }
    }

    @Override
    public void deposito() {
        System.out.print("DIGITE O CPF DO CLIENTE: ");
        String cpf = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpf)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("CLIENTE NÃO ENCONTRADO");
            return;
        }
        System.out.print("NÚMERO DA CONTA: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        Conta conta = null;
        for (Conta c : cliente.getContas()) {
            if (c.getNumConta() == numeroConta && c.getStatus()) {
                conta = c;
                break;
            }
        }
        if (conta == null) {
            System.out.println("CONTA NÃO ENCONTRADA OU INATIVA");
            return;
        }
        System.out.print("SENHA: ");
        String senha = scanner.nextLine();
        if (!cliente.getSenha().equals(senha)) {
            System.out.println("SENHA INCORRETA. DEPÓSITO CANCELADO.");
            return;
        }
        System.out.print("VALOR: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("DEPÓSITO DE R$" + valor + " REALIZADO.");
    }

    @Override
    public void saque() {
        System.out.print("DIGITE O CPF DO CLIENTE: ");
        String cpf = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpf)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("CLIENTE NÃO ENCONTRADO");
            return;
        }
        System.out.print("NÚMERO DA CONTA: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        Conta conta = null;
        for (Conta c : cliente.getContas()) {
            if (c.getNumConta() == numeroConta && c.getStatus()) {
                conta = c;
                break;
            }
        }
        if (conta == null) {
            System.out.println("CONTA NÃO ENCONTRADA OU INATIVA");
            return;
        }
        System.out.print("SENHA: ");
        String senha = scanner.nextLine();
        if (!cliente.getSenha().equals(senha)) {
            System.out.println("SENHA INCORRETA. SAQUE CANCELADO.");
            return;
        }
        System.out.print("VALOR: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();
        if (conta.getSaldo() < valor) {
            System.out.println("SALDO INSUFICIENTE.");
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("SAQUE DE R$" + valor + " REALIZADO.");
        }
    }

    @Override
    public void transferir() {
        System.out.print("DIGITE O CPF DO CLIENTE ORIGEM: ");
        String cpfOrigem = scanner.nextLine();
        Cliente origem = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpfOrigem)) {
                origem = c;
                break;
            }
        }
        if (origem == null) {
            System.out.println("CLIENTE DE ORIGEM NÃO ENCONTRADO");
            return;
        }
        System.out.print("NÚMERO CONTA ORIGEM: ");
        int numOrigem = scanner.nextInt();
        scanner.nextLine();
        Conta contaOrigem = null;
        for (Conta c : origem.getContas()) {
            if (c.getNumConta() == numOrigem && c.getStatus()) {
                contaOrigem = c;
                break;
            }
        }
        if (contaOrigem == null) {
            System.out.println("CONTA ORIGEM NÃO ENCONTRADA OU INATIVA");
            return;
        }
        System.out.print("SENHA: ");
        String senha = scanner.nextLine();
        if (!origem.getSenha().equals(senha)) {
            System.out.println("SENHA INCORRETA. TRANSFERÊNCIA CANCELADA.");
            return;
        }
        System.out.print("DIGITE O CPF DO CLIENTE DESTINATARIO: ");
        String cpfDestino = scanner.nextLine();
        Cliente destino = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpfDestino)) {
                destino = c;
                break;
            }
        }
        if (destino == null) {
            System.out.println("CLIENTE DE DESTINO NÃO ENCONTRADO");
            return;
        }
        System.out.print("NÚMERO CONTA DESTINO: ");
        int numDestino = scanner.nextInt();
        scanner.nextLine();
        Conta contaDestino = null;
        for (Conta c : destino.getContas()) {
            if (c.getNumConta() == numDestino && c.getStatus()) {
                contaDestino = c;
                break;
            }
        }
        if (contaDestino == null) {
            System.out.println("CONTA DESTINO NÃO ENCONTRADA OU INATIVA");
            return;
        }
        System.out.print("VALOR: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();
        if (contaOrigem.getSaldo() < valor) {
            System.out.println("SALDO INSUFICIENTE");
        } else {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.println("TRANSFERÊNCIA DE R$" + valor + " CONCLUÍDA");
        }
    }

    @Override
    public void consultaSaldo() {
        System.out.print("DIGITE O CPF DO CLIENTE: ");
        String cpf = scanner.nextLine();
        for (Cliente cliente : listaClientes) {
            if (cliente.getCPF().equals(cpf)) {
                if (cliente.getContas().isEmpty()) {
                    System.out.println("CLIENTE NÃO POSSUI CONTAS.");
                } else {
                    for (Conta conta : cliente.getContas()) {
                        System.out.println("CONTA Nº " + conta.getNumConta() + " (" + conta.getFinalidade() + ") - SALDO: R$" + conta.getSaldo());
                    }
                }
                return;
            }
        }
        System.out.println("CLIENTE NÃO ENCONTRADO.");
    }

    @Override
    public void gerarRendimentos() {
        System.out.print("DIGITE O CPF DO CLIENTE: ");
        String cpf = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpf)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("CLIENTE NÃO ENCONTRADO.");
            return;
        }
        System.out.print("DIGITE O NÚMERO DA CONTA: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        Conta conta = null;
        for (Conta c : cliente.getContas()) {
            if (c.getNumConta() == numero && c.getStatus()) {
                conta = c;
                break;
            }
        }
        if (conta == null) {
            System.out.println("CONTA NÃO ENCONTRADA OU INATIVA.");
            return;
        }
        if (conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).gerarRendimentos();
        } else {
            System.out.println("ESSA CONTA NÃO É UMA CONTA POUPANÇA.");
        }
    }

    @Override
    public void pagImposto() {
        System.out.print("DIGITE O CPF DO CLIENTE: ");
        String cpf = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getCPF().equals(cpf)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("CLIENTE NÃO ENCONTRADO.");
            return;
        }
        System.out.print("DIGITE O NÚMERO DA CONTA: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        Conta conta = null;
        for (Conta c : cliente.getContas()) {
            if (c.getNumConta() == numero && c.getStatus()) {
                conta = c;
                break;
            }
        }
        if (conta == null) {
            System.out.println("CONTA NÃO ENCONTRADA OU INATIVA.");
            return;
        }
        if (conta instanceof ContaPJ) {
            ContaPJ.pagImposto(conta);
        } else {
            System.out.println("ESSA CONTA NÃO É DO TIPO PJ.");
        }
    }
}