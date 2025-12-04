package model;

public class Adotante {
    private int id;
    private String nome;
    private String contato;

    public Adotante(int id, String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return id + " - " + nome + " | tel: " + contato;
    }
}