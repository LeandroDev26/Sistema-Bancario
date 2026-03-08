package com.mycompany.sistema_bancario;
public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numConta, String finalidade, float saldo, boolean status) {
        super(numConta, finalidade, saldo, status);
    }
    
    public void gerarRendimentos(){
      if (this.getStatus()) {
        float rendimento = this.getSaldo() * 0.005f; 
        this.setSaldo(this.getSaldo() + rendimento);
        System.out.println("Rendimento de R$" + rendimento + " aplicado na conta poupança " + this.getNumConta());
    } else {
        System.out.println("Conta inativa. Rendimento não aplicado.");
    }
    }
}
