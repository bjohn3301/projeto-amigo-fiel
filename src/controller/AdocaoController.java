package controller;

import model.Animal;
import model.Adotante;
import model.Adocao;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdocaoController {
    private ArrayList<Adocao> listaAdocoes;
    private int contId;
    private AnimalController ctrlAnimal;
    private AdotanteController ctrlAdotante;

    public AdocaoController(AnimalController ctrlAnimal, AdotanteController ctrlAdotante) {
        this.listaAdocoes = new ArrayList<>();
        this.contId = 1;
        this.ctrlAnimal = ctrlAnimal;
        this.ctrlAdotante = ctrlAdotante;
    }

    public void registrarAdocao(int idAnimal, int idAdotante) {
        Animal animal = ctrlAnimal.buscarPorId(idAnimal);
        Adotante adotante = ctrlAdotante.buscarPorId(idAdotante);

        if (animal == null) {
            System.out.println("Animal nao existe");
            return;
        }

        if (adotante == null) {
            System.out.println("Adotante nao existe");
            return;
        }

        // ve se o animal ta livre pra adocao
        if (!animal.getStatus().equals("Disponível")) {
            System.out.println("Esse animal nao ta disponivel");
            return;
        }

        Adocao adoc = new Adocao(contId, animal, adotante, LocalDate.now());
        listaAdocoes.add(adoc);
        contId++;

        // muda status do animal
        animal.setStatus("Adotado");

        System.out.println("\n*** ADOCAO REALIZADA ***");
        System.out.println(animal.getNome() + " foi adotado(a) por " + adotante.getNome());
    }

    public void listarAdocoes() {
        if (listaAdocoes.isEmpty()) {
            System.out.println("Nenhuma adocao registrada ainda");
            return;
        }

        System.out.println("\n--- ADOCOES REALIZADAS ---");
        for (Adocao adoc : listaAdocoes) {
            System.out.println("\nID: " + adoc.getId());
            System.out.println("Animal: " + adoc.getAnimal().getNome() + " (" + adoc.getAnimal().getEspecie() + ")");
            System.out.println("Adotante: " + adoc.getAdotante().getNome());
            System.out.println("CPF: " + adoc.getAdotante().getCpf());
            System.out.println("Data: " + adoc.getDataAdocao());
            System.out.println("--------------------------");
        }
    }

    public Adocao buscarPorId(int id) {
        for (Adocao adoc : listaAdocoes) {
            if (adoc.getId() == id) {
                return adoc;
            }
        }
        return null;
    }

    public ArrayList<Adocao> getAdocoes() {
        return listaAdocoes;
    }
}