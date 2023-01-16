package com.pessoa.api.services;

import com.pessoa.api.dto.EnderecoDto;
import com.pessoa.api.entities.Endereco;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco cadastrarEndereco(EnderecoDto enderecoDto){
        Endereco endereco = enderecoRepository.save(converteObjetoDto(enderecoDto, pessoaRepository));
        return endereco;
    }

   @Transactional
    public Endereco converteObjetoDto(EnderecoDto enderecoDto, PessoaRepository pessoaRepository){
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDto.idPessoa());
        return new Endereco(enderecoDto.logradouro(),
                            enderecoDto.cep(),
                            enderecoDto.numero(),
                            enderecoDto.cidade(),
                            pessoa.get());
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        return endereco;
    }

    public List<Endereco> buscarTodosEnderecos(){
        return enderecoRepository.findAll();
    }

    public List<Endereco> buscarEnderecosPessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            return enderecoRepository.findAll()
                    .stream()
                    .filter(e -> e.getPessoa().getId() == id)
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }
}
