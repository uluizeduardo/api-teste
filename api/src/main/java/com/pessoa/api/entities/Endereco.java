package com.pessoa.api.entities;

import com.pessoa.api.dto.EnderecoDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "endereco")
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lougradouro;

    private int cep;

    private String numero;

    private String cidade;

    @ManyToOne
    private Pessoa pessoa;
    public Endereco(EnderecoDto enderecoDto) {
        this.lougradouro = enderecoDto.logradouro();
        this.cep = enderecoDto.cep();
        this.numero = enderecoDto.numero();
        this.cidade = enderecoDto.cidade();
        this.pessoa = new Pessoa(enderecoDto.pessoaDto());
    }
}
