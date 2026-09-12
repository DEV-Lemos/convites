package io.github.devlemos.convites.servico;

import io.github.devlemos.convites.modelo.Grupo;
import io.github.devlemos.convites.modelo.Pessoa;
import io.github.devlemos.convites.repositorio.RepositorioPessoa;

import java.text.Normalizer;

public class ServicoPessoa {

    private final RepositorioPessoa repositorio;


    public ServicoPessoa(
            RepositorioPessoa repositorio
    ) {
        this.repositorio = repositorio;
    }


    public Pessoa cadastrar(
            Pessoa dadosValidados
    ) {

        String nome =
                removerAcentos(
                        dadosValidados.nome()
                );


        Grupo grupo =
                dadosValidados.grupo();


        if (
                grupo == null ||
                        grupo.id() == null
        ) {
            grupo = null;
        }


        Pessoa pessoa =
                new Pessoa(
                        dadosValidados.id(),
                        nome,
                        grupo
                );


        return repositorio.salvar(
                pessoa
        );
    }


    private String removerAcentos(
            String texto
    ) {

        String textoNormalizado =
                Normalizer.normalize(
                        texto,
                        Normalizer.Form.NFD
                );


        return textoNormalizado.replaceAll(
                "\\p{M}",
                ""
        );
    }
}