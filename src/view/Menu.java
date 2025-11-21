package view;

import controller.AnimalController;
import controller.AdotanteController;
import controller.AdocaoController;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private AnimalController ctrlAnimal;
    private AdotanteController ctrlAdotante;
    private AdocaoController ctrlAdocao;

    public Menu() {
        this.sc = new Scanner(System.in);
        this.ctrlAnimal = new AnimalController();
        this.ctrlAdotante = new AdotanteController();
        this.ctrlAdocao = new AdocaoController(ctrlAnimal, ctrlAdotante);
    }

    public void exibirMenu() {
        int op = 0;

        while (op != 9) {
            System.out.println("\n***************************************");
            System.out.println("   SISTEMA AMIGO FIEL");
            System.out.println("***************************************");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("2 - Listar Animais");
            System.out.println("3 - Cadastrar Adotante");
            System.out.println("4 - Listar Adotantes");
            System.out.println("5 - Fazer Adocao");
            System.out.println("6 - Ver Adocoes");
            System.out.println("9 - Sair");
            System.out.println("***************************************");
            System.out.print("Digite a opcao: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    cadastraAnimal();
                    break;
                case 2:
                    ctrlAnimal.listarAnimais();
                    break;
                case 3:
                    cadastraAdotante();
                    break;
                case 4:
                    ctrlAdotante.listarAdotantes();
                    break;
                case 5:
                    fazAdocao();
                    break;
                case 6:
                    ctrlAdocao.listarAdocoes();
                    break;
                case 9:
                    System.out.println("Tchau");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }

        sc.close();
    }

    private void cadastraAnimal() {
        System.out.println("\n--- CADASTRAR ANIMAL ---");

        System.out.print("Nome do animal: ");
        String nome = sc.nextLine();

        System.out.print("Especie (Cachorro/Gato/Outro): ");
        String esp = sc.nextLine();

        System.out.print("Porte (P/M/G): ");
        String porte = sc.nextLine();

        System.out.print("Sexo (M/F): ");
        String sexo = sc.nextLine();

        ctrlAnimal.cadastrarAnimal(nome, esp, porte, sexo);
    }

    private void cadastraAdotante() {
        System.out.println("\n--- CADASTRAR ADOTANTE ---");

        System.out.print("Nome completo: ");
        String nome = sc.nextLine();

        System.out.print("CPF (so numeros): ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String tel = sc.nextLine();

        System.out.print("Endereco: ");
        String end = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        ctrlAdotante.cadastrarAdotante(nome, cpf, tel, end, email);
    }

    private void fazAdocao() {
        System.out.println("\n--- REGISTRAR ADOCAO ---");

        ctrlAnimal.listarDisponiveis();

        System.out.print("\nID do animal: ");
        int idAni = sc.nextInt();

        System.out.print("ID do adotante: ");
        int idAdot = sc.nextInt();
        sc.nextLine();

        ctrlAdocao.registrarAdocao(idAni, idAdot);
    }
}