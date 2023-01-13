package com.pessoa.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(
        @NotBlank
        String logradouro,
        @NotBlank
        int cep,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        @NotBlank
        @Valid
        PessoaDto pessoaDto) {
}
