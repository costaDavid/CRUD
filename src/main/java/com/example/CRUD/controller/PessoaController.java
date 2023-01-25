package com.example.CRUD.controller;

import com.example.CRUD.dto.PessoaDTO;
import com.example.CRUD.entity.Pessoa;
import com.example.CRUD.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> buscarPessoaPorId(@PathVariable Long id){
        PessoaDTO pessoaDTO = pessoaService.buscarPessoaId(id);
        return ResponseEntity.ok().body(pessoaDTO);
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<List<PessoaDTO>> buscarTodasPessoas(){
        List<PessoaDTO> list = pessoaService.buscarTodas();
        return ResponseEntity.ok().body(list);
    }

}
