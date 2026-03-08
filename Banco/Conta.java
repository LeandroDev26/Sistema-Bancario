package com.mycompany.sistema_bancario;
public abstract class Conta {
    private int numConta;
    private String finalidade;
    float saldo;
    private boolean status;

    public Conta(int numConta, String finalidade, float saldo, boolean status) {
        this.numConta = numConta;
        this.finalidade = finalidade;
        this.saldo = saldo;
        this.status = status;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
