package model;

import java.time.LocalDate;

public abstract class Animal implements IMostrarDados {
    protected int id;
    protected String nome;
    protected String porte;
    protected String sexo;
    protected LocalDate dataEntrada;
    protected String status;

    public Animal(int id, String nome, String porte, String sexo, LocalDate dataEntrada) {
        this.id = id;
        this.nome = nome;
        this.porte = porte;
        this.sexo = sexo;
        this.dataEntrada = dataEntrada;
        this.status = "disponivel";
    }

    // metodo abstrato, filho tem que implementar
    public abstract String emitirSom();

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return getDetalhes();
    }
}