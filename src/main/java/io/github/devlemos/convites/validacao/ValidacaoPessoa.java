package io.github.devlemos.convites.validacao;

import io.github.devlemos.convites.excecao.ValidacaoException;
import io.github.devlemos.convites.modelo.Pessoa;

public class ValidacaoPessoa {

    public Pessoa validar(
            Pessoa dados
    ) {

        if (dados == null) {
            throw new ValidacaoException(
                    "Pessoa não informada."
            );
        }


        String nome =
                dados.nome();


        if (
                nome == null ||
                        nome.isBlank()
        ) {
            throw new ValidacaoException(
                    "Nome da pessoa não informado."
            );
        }


        return new Pessoa(
                dados.id(),
                nome.trim(),
                dados.grupo()
        );
    }
}