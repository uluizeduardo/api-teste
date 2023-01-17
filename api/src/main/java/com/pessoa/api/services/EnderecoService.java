package com.pessoa.api.services;

import com.pessoa.api.dto.EnderecoDto;
import com.pessoa.api.entities.Endereco;
import com.pessoa.api.entities.Pessoa;
import com.pessoa.api.repositories.EnderecoRepository;
import com.pessoa.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        verificaEnderecoPrincipal(enderecoDto);
        Endereco endereco = enderecoRepository.save(converteObjetoDto(enderecoDto, pessoaRepository));
        return endereco;
    }

    public Endereco converteObjetoDto(EnderecoDto enderecoDto, PessoaRepository pessoaRepository){
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDto.idPessoa());
        return new Endereco(enderecoDto.logradouro(),
                            enderecoDto.cep(),
                            enderecoDto.numero(),
                            enderecoDto.cidade(),
                            pessoa.get(),
                            enderecoDto.enderecoPrincipal());
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        if(endereco == null){
            throw new RuntimeException("Endereco não encontrada");
        }
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

    public void verificaEnderecoPrincipal(EnderecoDto enderecoDto){
        Endereco enderecoAntesDeSalvar = converteObjetoDto(enderecoDto, pessoaRepository);
        if(enderecoAntesDeSalvar.getEnderecoPrincipal().equals(true)){
            List<Endereco> listaDeEnderecos = buscarEnderecosPessoa(enderecoAntesDeSalvar.getPessoa().getId());
            for (Endereco enderecosDaPesoa : listaDeEnderecos){
                if (enderecosDaPesoa.getEnderecoPrincipal().equals(true)) {
                    enderecosDaPesoa.setEnderecoPrincipal(false);
                }
            }
        }
    }
}
