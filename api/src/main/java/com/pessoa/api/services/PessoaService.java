package com.pessoa.api.services;

import com.pessoa.api.dto.PessoaDto;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Pessoa cadastrarPessoa(PessoaDto pessoaDto){
        Pessoa pessoa = pessoaRepository.save(converteObjetoDto(pessoaDto));
        return pessoa;
    }

    public Pessoa converteObjetoDto(PessoaDto pessoaDto){
        return new Pessoa( pessoaDto.nome(),
                           pessoaDto.dataNascimento());
    }

    public Optional<Pessoa> buscarPessoa(Long pessoaId) {
        return pessoaRepository.findById(pessoaId);
    }
}
