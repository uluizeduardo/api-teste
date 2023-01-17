package com.pessoa.api.services;


import com.pessoa.api.dto.PessoaDto;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    public Pessoa editarPessoa(PessoaDto pessoaDto, Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        if(pessoa == null){
            //criar exception
        }
        pessoa.setNome(pessoaDto.nome());
        pessoa.setDataNascimento(pessoaDto.dataNascimento());

        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public Pessoa converteObjetoDto(PessoaDto pessoaDto){
        return new Pessoa( pessoaDto.nome(),
                pessoaDto.dataNascimento());
    }

    public Pessoa buscarPessoaPorId(Long pessoaId) {
       Pessoa pessoa = pessoaRepository.findById(pessoaId).orElse(null);
       return pessoa;
    }

    public List<Pessoa> buscarPessoas() {
        return pessoaRepository.findAll();
    }
}
