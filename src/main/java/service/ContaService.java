// Guarda, Cadastra e Busca novas contas

package service;

import model.Conta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import util.ContaAdapter;
import util.LocalDateTimeAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaService {

    private List<Conta> contas;
    private static final String CAMINHO_ARQUIVO = "conta.json";
    private final Gson gson;


    public ContaService() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .registerTypeAdapter(Conta.class, new ContaAdapter())
                .setPrettyPrinting()
                .create();
        carregarDados();
    }

    private void carregarDados() {
        try(FileReader reader = new FileReader(CAMINHO_ARQUIVO)){
            Type tipoLista = new TypeToken<ArrayList<Conta>>(){}.getType();
            List<Conta> contasCarregadas = gson.fromJson(reader,tipoLista);
            if (contasCarregadas != null) {
                this.contas = contasCarregadas;
            }
        } catch (IOException e) {
            this.contas = new ArrayList<>();
        }
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
        salvarDados();
    }

    public void salvarDados() {
        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)) {
            gson.toJson(contas, writer);
        } catch (IOException e) {
            System.out.println("\nErro ao Salvar Dados: " + e.getMessage());
        }
    }

    public List<Conta> listarContas(){ return contas; }

    public Conta buscarConta(String numero){
        for (Conta conta : contas){
            if (conta.getNumero().equals(numero)){ return conta; }
        }
        throw new exception.ContaNaoEncontradaException("\nErro: Conta com o Número " + numero + " Não Foi Encontrada!");
    }


}
