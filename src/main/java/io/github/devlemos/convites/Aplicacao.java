package io.github.devlemos.convites;

import io.github.devlemos.convites.controlador.ControladorPessoa;
import io.github.devlemos.convites.http.ServidorHttp;
import io.github.devlemos.convites.repositorio.RepositorioPessoa;
import io.github.devlemos.convites.rotas.RotasPessoa;
import io.github.devlemos.convites.servico.ServicoPessoa;
import io.github.devlemos.convites.validacao.ValidacaoPessoa;

public class Aplicacao {

    private final ServidorHttp servidor;


    public Aplicacao() {

        RotasPessoa rotasPessoa =
                criarRotasPessoa();


        this.servidor =
                new ServidorHttp(
                        config -> {

                            rotasPessoa.registrar(
                                    config
                            );
                        }
                );
    }


    private RotasPessoa criarRotasPessoa() {

        RepositorioPessoa repositorioPessoa =
                new RepositorioPessoa();


        ServicoPessoa servicoPessoa =
                new ServicoPessoa(
                        repositorioPessoa
                );


        ValidacaoPessoa validacaoPessoa =
                new ValidacaoPessoa();


        ControladorPessoa controladorPessoa =
                new ControladorPessoa(
                        servicoPessoa,
                        validacaoPessoa
                );


        return new RotasPessoa(
                controladorPessoa
        );
    }


    public void iniciar() {

        servidor.iniciar(
                8000
        );
    }
}