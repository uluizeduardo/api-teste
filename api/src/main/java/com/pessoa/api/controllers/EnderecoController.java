package com.pessoa.api.controllers;


import com.pessoa.api.dto.EnderecoDto;
import com.pessoa.api.entities.Endereco;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import com.pessoa.api.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        return new ResponseEntity<Endereco>(enderecoService.cadastrarEndereco(enderecoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarEndereco(@PathVariable(value = "id") Long id){
        Optional<Endereco> endereco = enderecoService.buscarEndereco(id);
        if (!endereco.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(endereco.get());
    }
}
