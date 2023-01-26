package com.example.CRUD.service;

import com.example.CRUD.controller.EnderecoController;
import com.example.CRUD.dto.EnderecoDTO;
import com.example.CRUD.dto.PessoaDTO;
import com.example.CRUD.entity.Endereco;
import com.example.CRUD.entity.Pessoa;
import com.example.CRUD.repository.EnderecoRepository;
import com.example.CRUD.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    public EnderecoDTO salvarNovoEndereco(EnderecoDTO enderecoDTO){
        Endereco entidade = new Endereco();
        copiarDadosEndereco(enderecoDTO, entidade);
        entidade = enderecoRepository.save(entidade);
        return new EnderecoDTO(entidade);
    }

    @Transactional
    public Page<EnderecoDTO> listarEnderecosPorPessoa(Long pessoaId, PageRequest pageRequest){
        List<Pessoa> pessoas = (pessoaId == 0) ? null : Arrays.asList(pessoaRepository.getOne(pessoaId));
        Page<Endereco> page = enderecoRepository.buscarEnderecoPorPessoa(pessoas, pageRequest);
        return page.map(x-> new EnderecoDTO(x, x.getPessoa()));
    }

    private void copiarDadosEndereco(EnderecoDTO enderecoDTO, Endereco endereco){
        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());

        endereco.getPessoa().clear();
        for(PessoaDTO pessoaDTO : enderecoDTO.getPessoas()){
            Pessoa pessoa = pessoaRepository.getOne(pessoaDTO.getId());
            endereco.getPessoa().add(pessoa);
        }
    }
}
