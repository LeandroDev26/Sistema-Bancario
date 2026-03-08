package com.mycompany.sistema_bancario;

public class Sistema_Bancario {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Menu menu = new Menu(banco);
        menu.exibirMenu();
    }
}