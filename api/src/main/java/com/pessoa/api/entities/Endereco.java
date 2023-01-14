package com.pessoa.api.entities;

import com.pessoa.api.dto.EnderecoDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Optional;

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

    public Endereco(String lougradouro, int cep, String numero, String cidade, Pessoa pessoa) {
        this.lougradouro = lougradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }
}
