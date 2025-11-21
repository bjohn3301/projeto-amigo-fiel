package model;

import java.time.LocalDate;

public class Adocao {
    private int id;
    private Animal animal;
    private Adotante adotante;
    private LocalDate dataAdocao;

    public Adocao(int id, Animal animal, Adotante adotante, LocalDate dataAdocao) {
        this.id = id;
        this.animal = animal;
        this.adotante = adotante;
        this.dataAdocao = dataAdocao;
    }

    public int getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }
}