package model;

import java.time.LocalDate;

public class Cachorro extends Animal {

    public Cachorro(int id, String nome, String porte, String sexo, LocalDate dataEntrada) {
        super(id, nome, porte, sexo, dataEntrada);
    }

    @Override
    public String emitirSom() {
        return "au au";
    }

    @Override
    public String getDetalhes() {
        return id + " - cachorro: " + nome + " (" + porte + ") - status: " + status;
    }
}