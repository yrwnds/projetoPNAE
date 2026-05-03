package org.example.projetopnae;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
        info = @Info(
                title = "API ProjetoPNAE",
                version = "1.0",
                description = "Documentação da API biblioteca digital.",
                contact = @Contact(name = "Leticia Nunes", email = "nunes.leticia@acad.ufsm.br")
        )
)

@SpringBootApplication
public class ProjetopnaeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetopnaeApplication.class, args);
    }

}
