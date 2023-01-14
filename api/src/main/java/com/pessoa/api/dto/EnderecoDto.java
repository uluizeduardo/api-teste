package com.pessoa.api.dto;

public record EnderecoDto(
        String logradouro,
        int cep,
        String numero,
        String cidade,
        Long idPessoa) {
}
