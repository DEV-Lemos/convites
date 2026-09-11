package io.github.devlemos.convites.modelo;

public record Pessoa(
        Long id,
        String nome,
        Grupo grupo
) {
}