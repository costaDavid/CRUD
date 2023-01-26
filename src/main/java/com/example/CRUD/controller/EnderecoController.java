package com.example.CRUD.controller;

import com.example.CRUD.dto.EnderecoDTO;
import com.example.CRUD.service.EnderecoService;
import com.example.CRUD.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<EnderecoDTO> salvarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        enderecoDTO = enderecoService.salvarNovoEndereco(enderecoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(enderecoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(enderecoDTO);
    }

    @GetMapping(value = "/pessoa")
    public ResponseEntity<Page<EnderecoDTO>> listarEnderecosPessoa(
            @RequestParam(value = "pessoaId", defaultValue = "0") Long pessoaId,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
    ){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<EnderecoDTO> list = enderecoService.listarEnderecosPorPessoa(pessoaId, pageRequest);
        return ResponseEntity.ok().body(list);
    }
}
