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

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "/cadastrarPessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.cadastrarPessoa(pessoaDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarPessoa/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable(value = "id") Long id){
        return new ResponseEntity<Pessoa>(pessoaService.buscarPessoaPorId(id), HttpStatus.OK);
    }

    @PutMapping(value = "/editarPessoa/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable(value = "id") Long id, @RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.editarPessoa(pessoaDto, id), HttpStatus.OK);
    }

    @GetMapping(value = "/listarPessoas")
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return new ResponseEntity<List<Pessoa>>(pessoaService.buscarPessoas(), HttpStatus.OK);
    }
}
