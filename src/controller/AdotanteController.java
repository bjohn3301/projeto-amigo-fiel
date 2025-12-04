package controller;

import model.Adotante;
import java.util.ArrayList;

public class AdotanteController {
    private ArrayList<Adotante> adotantes = new ArrayList<>();
    private int contador = 1;

    public void cadastrar(String nome, String contato) {
        adotantes.add(new Adotante(contador, nome, contato));
        contador++;
        System.out.println("adotante salvo");
    }

    public void listar() {
        if (adotantes.isEmpty()) {
            System.out.println("nenhum adotante cadastrado");
            return;
        }
        for (Adotante a : adotantes) {
            System.out.println(a);
        }
    }

    public Adotante buscarPorId(int id) {
        for (Adotante a : adotantes) {
            if (a.getId() == id) return a;
        }
        return null;
    }
}