package com.pessoa.api.services;

import com.pessoa.api.dto.EnderecoDto;
import com.pessoa.api.dto.PessoaDto;
import com.pessoa.api.entities.Endereco;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa cadastrarPessoa(PessoaDto pessoaDto){
        Pessoa pessoa = pessoaRepository.save(converteObjetoDto(pessoaDto ,enderecoRepository));
        return pessoa;
    }

    public Pessoa converteObjetoDto(PessoaDto pessoaDto, EnderecoRepository enderecoRepository){
        return new Pessoa( pessoaDto.nome(),
                           pessoaDto.dataNascimento());
    }
}
