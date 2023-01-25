package com.example.CRUD.controller;

import com.example.CRUD.dto.PessoaDTO;
import com.example.CRUD.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<PessoaDTO> salvarPessoa(@RequestBody PessoaDTO pessoaDTO){
        pessoaDTO = pessoaService.salvarNovaPessoa(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoaDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> editarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        pessoaDTO = pessoaService.editarPessoa(id, pessoaDTO);
        return ResponseEntity.ok().body(pessoaDTO);
    }

}
