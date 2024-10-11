package com.deezer.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentação API: Atividade com o tema sobre a plataforma Deezer")
                        .version("V1")
                        .description(
                                "Neste projeto, desenvolvemos uma API utilizando Spring Boot que interage com a API externa do Deezer para buscar informações sobre artistas e músicas. Para realizar essa integração, utilizamos o RestTemplate para fazer requisições HTTP à API do Deezer, processar as respostas e armazenar as informações relevantes no banco de dados MariaDB.\n" + //
                                "\n" + //
                                "As informações capturadas da API do Deezer incluem dados como o nome do artista, a quantidade deálbuns (nb_album), e as músicas associadas. Esses dados foram mapeados para entidades da aplicação earmazenados no banco para que posteriormente pudessem ser acessados através de requisições HTTP,expondo endpoints que permitem consultar, filtrar e manipular as informações salvas."))
                .tags(
                    Arrays.asList(
                        new Tag().name("Artista").description("Requisições entidade Artist"),
                        new Tag().name("Música").description("Requisiçoes da entidade Música"),
                        new Tag().name("API externa").description("Acesso a API externa")
                    )
                );
                
                
    }

}
