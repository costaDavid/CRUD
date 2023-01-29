package com.example.CRUD.repository;

import com.example.CRUD.entity.Endereco;
import com.example.CRUD.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT DISTINCT e FROM Endereco e INNER JOIN e.pessoa p WHERE "
            + "(COALESCE(:pessoas) IS NULL OR p IN :pessoas) AND "
            + "(LOWER(e.logradouro) LIKE LOWER(CONCAT('%',:nomeEndereco,'%'))) ")
    Page<Endereco> buscarEnderecoPorPessoa(List<Pessoa> pessoas, String nomeEndereco, Pageable pageable);
}
