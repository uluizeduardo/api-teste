package com.pessoa.api.entities;

import com.pessoa.api.dto.PessoaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pessoa")
@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @OneToMany(mappedBy = "pessoa")
    List<Endereco> endereco = new ArrayList<>();

    public Pessoa(PessoaDto pessoaDto) {
        this.nome = pessoaDto.nome();
        this.dataNascimento = pessoaDto.dataNascimento();
        this.endereco = (List<Endereco>) new Endereco(pessoaDto.enderecoDto());
    }
}
