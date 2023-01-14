package com.pessoa.api.controllers;

import com.pessoa.api.dto.EnderecoDto;
import com.pessoa.api.dto.PessoaDto;
import com.pessoa.api.entities.Endereco;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public void cadastrarEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        System.out.println(enderecoDto);
        enderecoRepository.save(new Endereco(enderecoDto));
    }
}
