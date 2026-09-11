package io.github.devlemos.convites.http;

import io.javalin.Javalin;

import java.util.function.Consumer;

import io.javalin.config.JavalinConfig;

public class ServidorHttp {

    private final Javalin servidor;


    public ServidorHttp(
            Consumer<JavalinConfig> configuracao
    ) {

        this.servidor =
                Javalin.create(configuracao);
    }


    public void iniciar(int porta) {

        servidor.start(porta);
    }
}