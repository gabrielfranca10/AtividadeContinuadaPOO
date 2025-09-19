package br.edu.cs.poo.ac.ordem.entidades;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    private final String cpfCnpj;
    private String nome;
    private Contato contato;
    private final LocalDate dataCadastro;

    public Cliente(String cpfCnpj, String nome, Contato contato, LocalDate dataCadastro) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.contato = contato;
        this.dataCadastro = dataCadastro;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public int getIdadeCadastro() {
        if (dataCadastro == null) return 0;
        return Period.between(dataCadastro, LocalDate.now()).getYears();
    }
}
