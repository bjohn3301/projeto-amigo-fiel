package model;

import java.time.LocalDate;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String porte;
    private String sexo;
    private LocalDate dataEntrada;
    private String status;

    public Animal(int id, String nome, String especie, String porte, String sexo, LocalDate dataEntrada) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.porte = porte;
        this.sexo = sexo;
        this.dataEntrada = dataEntrada;
        this.status = "Disponível";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPorte() {
        return porte;
    }

    public String getSexo() {
        return sexo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}