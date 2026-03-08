package com.mycompany.sistema_bancario;

import java.util.ArrayList;

public class Cliente {
    protected String CPF;
    protected String nome;
    protected int idade;
    protected String endereco;
    protected String senha;
    protected ArrayList<Conta> contas = new ArrayList<>();
    
    public Cliente(String CPF, String nome, int idade, String endereco, String senha) {
        this.CPF = CPF;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.senha = senha;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
