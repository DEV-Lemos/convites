package io.github.devlemos.convites;

import io.github.devlemos.convites.http.ServidorHttp;

public class Aplicacao {

    private final ServidorHttp servidor;

    public Aplicacao() {

        this.servidor =
                new ServidorHttp();
    }


    public void iniciar() {

        servidor.iniciar();
    }
}