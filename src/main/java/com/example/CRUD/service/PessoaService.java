package com.example.CRUD.service;

import com.example.CRUD.dto.EnderecoDTO;
import com.example.CRUD.dto.PessoaDTO;
import com.example.CRUD.entity.Endereco;
import com.example.CRUD.entity.Pessoa;
import com.example.CRUD.repository.EnderecoRepository;
import com.example.CRUD.repository.PessoaRepository;
import com.example.CRUD.service.exceptions.EntidadeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
            throw new EntidadeNotFound("Id não encontrado" + id);
        }
    }

    @Transactional(readOnly = true)
    public PessoaDTO buscarPessoaId(Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        Pessoa entidade = pessoa.orElseThrow(()-> new EntidadeNotFound("Pessoa não encontrada"));
        return new PessoaDTO(entidade);
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> buscarTodas(){
        List<Pessoa> list = pessoaRepository.findAll();
        return list.stream().map(x-> new PessoaDTO(x)).collect(Collectors.toList());
    }

    private void copiarDadosPessoa(PessoaDTO pessoaDTO, Pessoa entidade){
        entidade.setNome(pessoaDTO.getNome());
        entidade.setDataNascimento(pessoaDTO.getDataNascimento());
    }
}
