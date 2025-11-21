package controller;

import model.Adotante;
import java.util.ArrayList;

public class AdotanteController {
    private ArrayList<Adotante> listaAdotantes;
    private int contId;

    public AdotanteController() {
        this.listaAdotantes = new ArrayList<>();
        this.contId = 1;
    }

    public void cadastrarAdotante(String nome, String cpf, String tel, String end, String email) {
        // verifica se preencheu tudo
        if (nome.isEmpty() || cpf.isEmpty() || tel.isEmpty() || end.isEmpty() || email.isEmpty()) {
            System.out.println("Preencha todos os campos");
            return;
        }

        // cpf tem que ter 11 numeros
        if (cpf.length() != 11) {
            System.out.println("CPF tem que ter 11 digitos");
            return;
        }

        Adotante adot = new Adotante(contId, nome, cpf, tel, end, email);
        listaAdotantes.add(adot);
        contId++;
        System.out.println("Adotante cadastrado com sucesso");
    }

    public void listarAdotantes() {
        if (listaAdotantes.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado");
            return;
        }

        System.out.println("\n--- LISTA DE ADOTANTES ---");
        for (Adotante adot : listaAdotantes) {
            System.out.println("\nID: " + adot.getId());
            System.out.println("Nome: " + adot.getNome());
            System.out.println("CPF: " + adot.getCpf());
            System.out.println("Tel: " + adot.getTelefone());
            System.out.println("End: " + adot.getEndereco());
            System.out.println("Email: " + adot.getEmail());
            System.out.println("-------------------------");
        }
    }

    public Adotante buscarPorId(int id) {
        for (Adotante adot : listaAdotantes) {
            if (adot.getId() == id) {
                return adot;
            }
        }
        return null;
    }

    public ArrayList<Adotante> getAdotantes() {
        return listaAdotantes;
    }
}