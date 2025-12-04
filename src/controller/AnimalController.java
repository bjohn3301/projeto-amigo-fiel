package controller;

import model.Animal;
import model.Cachorro;
import model.Gato;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnimalController {
    private ArrayList<Animal> animais = new ArrayList<>();
    private int contador = 1;

    public void cadastrar(String tipo, String nome, String porte, String sexo) {
        Animal novo;
        // aqui decide se cria cachorro ou gato (polimorfismo)
        if (tipo.equals("1")) {
            novo = new Cachorro(contador, nome, porte, sexo, LocalDate.now());
        } else {
            novo = new Gato(contador, nome, porte, sexo, LocalDate.now());
        }

        animais.add(novo);
        contador++;
        System.out.println(novo.getNome() + " cadastrado. som: " + novo.emitirSom());
    }

    public void listar() {
        if (animais.isEmpty()) {
            System.out.println("nenhum animal na lista");
            return;
        }
        for (Animal a : animais) {
            System.out.println(a.getDetalhes());
        }
    }

    public Animal buscarPorId(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) return a;
        }
        return null;
    }
}