package model;

import java.time.LocalDate;

public class Gato extends Animal {

    public Gato(int id, String nome, String porte, String sexo, LocalDate dataEntrada) {
        super(id, nome, porte, sexo, dataEntrada);
    }

    @Override
    public String emitirSom() {
        return "miau";
    }

    @Override
    public String getDetalhes() {
        return id + " - gato: " + nome + " (" + porte + ") - status: " + status;
    }
}