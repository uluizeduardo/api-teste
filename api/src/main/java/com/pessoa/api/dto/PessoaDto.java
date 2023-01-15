package com.pessoa.api.dto;

import com.pessoa.api.entities.Endereco;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record PessoaDto(
        @NotBlank
        String nome,


        Date dataNascimento) {

}
