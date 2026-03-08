package com.mycompany.sistema_bancario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Banco banco;
    private Scanner scanner;

    public Menu(Banco banco) {
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        do {
            System.out.println("========== MENU BANCO ==========");
            System.out.println("[1] CADASTRAR CLIENTE");
            System.out.println("[2] CADASTRAR CONTA");
            System.out.println("[3] DEPOSITO");
            System.out.println("[4] SAQUE");
            System.out.println("[5] TRANSFERIR");
            System.out.println("[6] CONSULTAR SALDO");
            System.out.println("[7] GERAR RENDIMENTOS");
            System.out.println("[8] PAGAR IMPOSTO");
            System.out.println("[9] LISTAR CLIENTES");
            System.out.println("[10] ENCERRAR CONTA");
            System.out.println("[0] SAIR DO SISTEMA");
            System.out.println("================================");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                switch (opcao) {
                    case 1:
                        banco.cadastrarCliente();
                        break;
                    case 2:
                        banco.abrirConta();
                        break;
                    case 3:
                        banco.deposito();
                        break;
                    case 4:
                        banco.saque();
                        break;
                    case 5:
                        banco.transferir();
                        break;
                    case 6:
                        banco.consultaSaldo();
                        break;
                    case 7:
                        banco.gerarRendimentos();
                        break;
                    case 8:
                        banco.pagImposto();
                        break;
                    case 9:
                        banco.listarClientes();
                        break;
                    case 10:
                        banco.fecharConta();
                        break;
                    case 0:
                        System.out.println("SAINDO DO SISTEMA, OBRIGADO POR TER ESCOLHIDO NOSSO BANCO");
                        break;
                    default:
                        System.out.println("OPÇÃO INVÁLIDA OU INEXISTENTE");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("VOCÊ DEVE DIGITAR UM NÚMERO INTEIRO");
                scanner.nextLine(); // Limpa o buffer em caso de erro
                opcao = -1;
            }

        } while (opcao != 0);

        scanner.close();
    }
}