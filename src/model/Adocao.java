package model;

import java.time.LocalDate;

public class Adocao {
    private Animal animal;
    private Adotante adotante;
    private LocalDate data;

    public Adocao(Animal animal, Adotante adotante) {
        this.animal = animal;
        this.adotante = adotante;
        this.data = LocalDate.now();
    }

    @Override
    public String toString() {
        return "adocao realizada: " + animal.getNome() + " adotado por " + adotante.getNome() + " em " + data;
    }
}