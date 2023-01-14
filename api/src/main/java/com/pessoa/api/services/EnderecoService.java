package com.pessoa.api.services;

import com.pessoa.api.dto.EnderecoDto;
import com.pessoa.api.entities.Endereco;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(EnderecoDto enderecoDto){
        Endereco endereco = enderecoRepository.save(converteObjetoDto(enderecoDto, pessoaRepository));
        return endereco;
    }

    public Endereco converteObjetoDto(EnderecoDto enderecoDto, PessoaRepository pessoaRepository){
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDto.idPessoa());
        return new Endereco(enderecoDto.logradouro(),
                            enderecoDto.cep(),
                            enderecoDto.numero(),
                            enderecoDto.cidade(),
                            pessoa.get());
    }
}
