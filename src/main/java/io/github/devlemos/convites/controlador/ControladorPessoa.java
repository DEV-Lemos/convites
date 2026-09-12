package io.github.devlemos.convites.controlador;

import io.github.devlemos.convites.modelo.Pessoa;
import io.github.devlemos.convites.servico.ServicoPessoa;
import io.github.devlemos.convites.validacao.ValidacaoPessoa;

public class ControladorPessoa {

    private final ServicoPessoa servico;
    private final ValidacaoPessoa validacao;


    public ControladorPessoa(
            ServicoPessoa servico,
            ValidacaoPessoa validacao
    ) {
        this.servico = servico;
        this.validacao = validacao;
    }


    public Pessoa cadastrar(
            Pessoa dados
    ) {

        Pessoa dadosValidados =
                validacao.validar(
                        dados
                );

        return servico.cadastrar(
                dadosValidados
        );
    }


    public void listar() {

    }
}