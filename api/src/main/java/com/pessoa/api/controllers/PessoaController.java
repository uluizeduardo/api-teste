package com.pessoa.api.controllers;

import com.pessoa.api.dto.PessoaDto;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public void cadastrarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
        System.out.println(pessoaDto);
        pessoaRepository.save(new Pessoa(pessoaDto));
    }
}
