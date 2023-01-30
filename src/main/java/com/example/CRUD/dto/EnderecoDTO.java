package com.example.CRUD.dto;

import com.example.CRUD.entity.Endereco;
import com.example.CRUD.entity.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String logradouro;
    private String cidade;
    private Integer cep;
    private Integer numero;

    private List<PessoaDTO> pessoas = new ArrayList<>();

    public EnderecoDTO(){

    }

    public EnderecoDTO(Endereco entity){
        this.id = entity.getId();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
        this.cidade = entity.getCidade();
    }

    public EnderecoDTO(Long id, String logradouro, Integer cep, Integer numero) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }

    public EnderecoDTO(Endereco entidade, Set<Pessoa> pessoa){
        this(entidade);
        pessoa.forEach(pess-> this.pessoas.add(new PessoaDTO(pess)));
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

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
