package com.mycompany.sistema_bancario;
public class ContaPJ extends Conta {

    public ContaPJ(int numConta, String finalidade, float saldo, boolean status) {
        super(numConta, finalidade, saldo, status);
    }

    
    public static void pagImposto(Conta c){
       if (c.getStatus()) {
        float imposto = c.getSaldo() * 0.02f; // 2% de imposto
        c.setSaldo(c.getSaldo() - imposto);
        System.out.println("Imposto de R$" + imposto + " descontado da conta PJ " + c.getNumConta());
    } else {
        System.out.println("Conta inativa. Imposto não aplicado.");
    }
    }

   
    
}


