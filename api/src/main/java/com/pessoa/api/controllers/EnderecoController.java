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

import java.util.List;
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

    @PostMapping(value = "/cadastrarEndereco")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        return new ResponseEntity<Endereco>(enderecoService.cadastrarEndereco(enderecoDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarEndereco/{id}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable(value = "id") Long id){
        return new ResponseEntity<Endereco>(enderecoService.buscarEnderecoPorId(id), HttpStatus.OK);
    }

    @GetMapping( value = "/listarEnderecos")
    public ResponseEntity<List<Endereco>> listarTodosEnderecos(){
        return new ResponseEntity<List<Endereco>>(enderecoService.buscarTodosEnderecos(), HttpStatus.OK);
    }

    @GetMapping(value = "/listarEnderecosPessoa/{id}")
    public ResponseEntity<List<Endereco>> listarEnderecosPessoa(@PathVariable(value = "id") Long id){
        return new ResponseEntity<List<Endereco>>(enderecoService.buscarEnderecosPessoa(id), HttpStatus.OK);
    }
}