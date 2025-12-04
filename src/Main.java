package view;

import controller.AdocaoController;
import controller.AdotanteController;
import controller.AnimalController;
import model.Adotante;
import model.Animal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // instanciando controllers
        AnimalController aniCtrl = new AnimalController();
        AdotanteController adoCtrl = new AdotanteController();
        AdocaoController adocaoCtrl = new AdocaoController();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- sistema amigo fiel ---");
            System.out.println("1 - cadastrar animal");
            System.out.println("2 - listar animais");
            System.out.println("3 - cadastrar adotante");
            System.out.println("4 - registrar adocao");
            System.out.println("5 - relatorio de adocoes");
            System.out.println("0 - sair");
            System.out.print("opcao: ");

            // try catch pra nao quebrar se digitar letra
            try {
                opcao = sc.nextInt();
                sc.nextLine(); // limpar buffer
            } catch (InputMismatchException e) {
                System.out.println("erro: digita so numero, valeu?");
                sc.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("tipo: 1-cachorro ou 2-gato?");
                    String tipo = sc.nextLine();
                    System.out.print("nome: ");
                    String nome = sc.nextLine();
                    System.out.print("porte: ");
                    String porte = sc.nextLine();
                    System.out.print("sexo: ");
                    String sexo = sc.nextLine();

                    aniCtrl.cadastrar(tipo, nome, porte, sexo);
                    break;
                case 2:
                    System.out.println("lista de animais:");
                    aniCtrl.listar();
                    break;
                case 3:
                    System.out.print("nome adotante: ");
                    String nomeAdo = sc.nextLine();
                    System.out.print("contato: ");
                    String contato = sc.nextLine();
                    adoCtrl.cadastrar(nomeAdo, contato);
                    break;
                case 4:
                    System.out.println("--- nova adocao ---");
                    aniCtrl.listar();
                    System.out.print("digita o id do animal: ");
                    int idAni = sc.nextInt();

                    adoCtrl.listar();
                    System.out.print("digita o id do adotante: ");
                    int idAdo = sc.nextInt();

                    Animal animal = aniCtrl.buscarPorId(idAni);
                    Adotante adotante = adoCtrl.buscarPorId(idAdo);

                    if (animal != null && adotante != null) {
                        adocaoCtrl.registrar(animal, adotante);
                    } else {
                        System.out.println("id nao encontrado");
                    }
                    break;
                case 5:
                    System.out.println("historico:");
                    adocaoCtrl.listar();
                    break;
                case 0:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("opcao invalida");
            }
        }
    }
}