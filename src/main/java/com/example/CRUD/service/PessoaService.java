package com.example.CRUD.service;

import com.example.CRUD.dto.EnderecoDTO;
import com.example.CRUD.dto.PessoaDTO;
import com.example.CRUD.entity.Endereco;
import com.example.CRUD.entity.Pessoa;
import com.example.CRUD.repository.EnderecoRepository;
import com.example.CRUD.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    public PessoaDTO salvarNovaPessoa(PessoaDTO pessoaDTO){
        Pessoa entidade = new Pessoa();
        copiarDadosPessoa(pessoaDTO, entidade);
        entidade = pessoaRepository.save(entidade);
        return new PessoaDTO(entidade);
    }

    @Transactional
    public PessoaDTO editarPessoa (Long id, PessoaDTO pessoaDTO){
        try {
            Pessoa entidade = pessoaRepository.getOne(id);
            copiarDadosPessoa(pessoaDTO, entidade);
            entidade = pessoaRepository.save(entidade);
            return new PessoaDTO(entidade);
        }
        catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Id não encontrado" + id);
        }
    }

    private void copiarDadosPessoa(PessoaDTO pessoaDTO, Pessoa entidade){
        entidade.setNome(pessoaDTO.getNome());
        entidade.setDataNascimento(pessoaDTO.getDataNascimento());
    }
}
