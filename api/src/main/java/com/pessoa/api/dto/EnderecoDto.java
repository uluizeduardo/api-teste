package com.pessoa.api.dto;

import com.pessoa.api.entities.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(

        String logradouro,

        int cep,

        String numero,

        String cidade,
        Pessoa pessoa) {
}
