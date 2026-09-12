package io.github.devlemos.convites.validacao;

import io.github.devlemos.convites.modelo.Grupo;
import io.github.devlemos.convites.modelo.Pessoa;
import io.github.devlemos.convites.excecao.ValidacaoException;

public class ValidacaoPessoa {
    public Pessoa validar(Pessoa dados) {
        String nome = dados.nome();
        Long id = dados.id();
        Grupo grupo = dados.grupo();

        if(nome == null || nome.isBlank()){
            throw new ValidacaoException(
                    "Pessoa não informada"
            );
        }

        return new Pessoa(id,nome,grupo);
    }
}
