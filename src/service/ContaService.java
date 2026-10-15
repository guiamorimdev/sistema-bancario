// Guarda, Cadastra e Busca novas contas

package service;

import model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaService {

    private List<Conta> contas;

    public ContaService() { this.contas = new ArrayList<>();}

    public void adicionarConta(Conta conta){ contas.add(conta); }

    public List<Conta> listarContas(){ return contas; }

    public Conta buscarConta(int numero){
        for (Conta conta : contas){
            if (conta.getNumero().equals(numero)){ return conta; }
        }
        return null;
    }
}
