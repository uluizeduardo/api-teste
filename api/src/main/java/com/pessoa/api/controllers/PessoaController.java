package com.pessoa.api.controllers;

import com.pessoa.api.dto.PessoaDto;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.PessoaRepository;
import com.pessoa.api.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.cadastrarPessoa(pessoaDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPessoa(@PathVariable(value = "id") Long id){
        Optional<Pessoa> pessoa = pessoaService.buscarPessoa(id);
        if (!pessoa.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable(value = "id") Long id, @RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.editarPessoa(pessoaDto, id), HttpStatus.OK);
    }
}
