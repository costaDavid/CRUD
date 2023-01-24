package com.example.CRUD.dto;

import com.example.CRUD.entity.Endereco;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String logradouro;
    private Integer cep;
    private Integer numero;

    public EnderecoDTO(){

    }

    public EnderecoDTO(Endereco entity){
        this.id = entity.getId();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
    }

    public EnderecoDTO(Long id, String logradouro, Integer cep, Integer numero) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
