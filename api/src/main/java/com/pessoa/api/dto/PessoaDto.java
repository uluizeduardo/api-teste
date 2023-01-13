package com.pessoa.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record PessoaDto(
        @NotBlank
        String nome,

        Date dataNascimento,
        @NotBlank
        @Valid
        EnderecoDto enderecoDto) {
}
