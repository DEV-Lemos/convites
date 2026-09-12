package io.github.devlemos.convites.rotas;
import io.javalin.config.JavalinConfig;
import io.github.devlemos.convites.controlador.ControladorPessoa;
import io.github.devlemos.convites.modelo.Pessoa;

public class RotasPessoa{
    private final ControladorPessoa controlador;

    public RotasPessoa(ControladorPessoa controlador){
        this.controlador = controlador;
    }

    public void registrar(JavalinConfig config) {
        config.routes.get("/pessoa", ctx -> controlador.listar());


        config.routes.post("/pessoa", ctx -> {

            System.out.println("ENTROU NA ROTA");

            String body =
                    ctx.body();

            System.out.println(
                    "BODY RECEBIDO:"
            );

            System.out.println(
                    body
            );


            Pessoa dados =
                    ctx.bodyAsClass(
                            Pessoa.class
                    );

            System.out.println(
                    "OBJETO PESSOA:"
            );

            System.out.println(
                    dados
            );


            Pessoa resposta =
                    controlador.cadastrar(
                            dados
                    );

            System.out.println(
                    "RESPOSTA DO CONTROLADOR:"
            );

            System.out.println(
                    resposta
            );


            ctx.status(201);

            ctx.json(
                    resposta
            );
        });
    }
}
