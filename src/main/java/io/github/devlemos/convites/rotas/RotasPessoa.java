package io.github.devlemos.convites.rotas;
import io.javalin.config.JavalinConfig;
import io.github.devlemos.convites.controlador.ControladorPessoa;
import io.github.devlemos.convites.modelo.Pessoa;

public class RotasPessoa{
    private final ControladorPessoa controlador;

    public RotasPessoa(ControladorPessoa controlador){
        this.controlador = controlador;
    }

    public void registrar(JavalinConfig config){
        config.routes.get("/pessoa", ctx ->{
            controlador.listar();
        })


        config.routes.post("/pessoa", ctx -> {

            Pessoa dados =
                    ctx.bodyAsClass(
                            Pessoa.class
                    );

            Convite resposta =
                    controlador.cadastrar(dados);

            ctx.status(201);
            ctx.json(resposta);
        });

    }
}
