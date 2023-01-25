package com.example.CRUD.dto;

import com.example.CRUD.entity.Endereco;
import com.example.CRUD.entity.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class PessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String dataNascimento;

    public PessoaDTO(){

    }

    public PessoaDTO(Long id, String nome, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public PessoaDTO(Pessoa entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.dataNascimento = entity.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
