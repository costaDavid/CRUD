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
    private Date dataNascimento;
    private List<EnderecoDTO> enderecoDTOS = new ArrayList<>();


    public PessoaDTO(){

    }

    public PessoaDTO(Long id, String nome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public PessoaDTO(Pessoa entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.dataNascimento = entity.getDataNascimento();
    }

    public PessoaDTO(Pessoa entidade, Set<Endereco> enderecos){
        this(entidade);
        enderecos.forEach(end -> this.enderecoDTOS.add(new EnderecoDTO(end)));
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDTO> getEnderecoDTOS() {
        return enderecoDTOS;
    }

    public void setEnderecoDTOS(List<EnderecoDTO> enderecoDTOS) {
        this.enderecoDTOS = enderecoDTOS;
    }
}
