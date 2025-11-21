package controller;

import model.Animal;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnimalController {
    private ArrayList<Animal> listaAnimais;
    private int contId;

    public AnimalController() {
        this.listaAnimais = new ArrayList<>();
        this.contId = 1;
    }

    public void cadastrarAnimal(String nome, String especie, String porte, String sexo) {
        Animal a = new Animal(contId, nome, especie, porte, sexo, LocalDate.now());
        listaAnimais.add(a);
        contId++;
        System.out.println("Animal cadastrado");
    }

    public void listarAnimais() {
        if (listaAnimais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado ainda");
            return;
        }

        System.out.println("\n--- ANIMAIS CADASTRADOS ---");
        for (Animal a : listaAnimais) {
            System.out.println("\nID: " + a.getId());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Especie: " + a.getEspecie());
            System.out.println("Porte: " + a.getPorte());
            System.out.println("Sexo: " + a.getSexo());
            System.out.println("Entrada: " + a.getDataEntrada());
            System.out.println("Status: " + a.getStatus());
            System.out.println("---------------------------");
        }
    }

    public Animal buscarPorId(int id) {
        for (Animal a : listaAnimais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void listarDisponiveis() {
        System.out.println("\n--- ANIMAIS DISPONIVEIS PRA ADOCAO ---");
        boolean tem = false;

        for (Animal a : listaAnimais) {
            if (a.getStatus().equals("Disponível")) {
                System.out.println("ID: " + a.getId() + " | " + a.getNome() + " - " + a.getEspecie());
                tem = true;
            }
        }

        if (!tem) {
            System.out.println("Nenhum animal disponivel no momento");
        }
    }

    public void atualizaStatus(int id, String novoStatus) {
        Animal a = buscarPorId(id);

        if (a == null) {
            System.out.println("Animal nao encontrado");
            return;
        }

        a.setStatus(novoStatus);
        System.out.println("Status atualizado");
    }

    public ArrayList<Animal> getAnimais() {
        return listaAnimais;
    }
}