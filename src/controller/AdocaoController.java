package controller;

import model.Adocao;
import model.Adotante;
import model.Animal;
import java.util.ArrayList;

public class AdocaoController {
    private ArrayList<Adocao> listaAdocoes = new ArrayList<>();

    public void registrar(Animal animal, Adotante adotante) {
        // verifica se o bicho ja foi adotado
        if (!animal.getStatus().equals("disponivel")) {
            System.out.println("erro: esse animal ja foi adotado");
            return;
        }

        Adocao nova = new Adocao(animal, adotante);
        listaAdocoes.add(nova);

        // muda status pra nao adotar de novo
        animal.setStatus("adotado");

        System.out.println("sucesso! adocao registrada");
    }

    public void listar() {
        if (listaAdocoes.isEmpty()) {
            System.out.println("nenhuma adocao feita ainda");
            return;
        }
        for (Adocao a : listaAdocoes) {
            System.out.println(a);
        }
    }
}