package com.pessoa.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
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
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();

    public Pessoa(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
