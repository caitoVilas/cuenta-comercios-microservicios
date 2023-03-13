package com.caito.sucursalradicacionms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("sucursal-radicacion")
                .packagesToScan("com.caito.sucursalradicacionms")
                .build();
    }

    @Bean
    public OpenAPI springShopOpemapi(){
        return new OpenAPI()
                /*.addSecurityItem(new SecurityRequirement().addList(securityScemeName))
                .components(new Components())*/
                .info(new Info().title("Gestion Comercios Sucursal de Radicacion ")
                        .description("Gestor Comercios  Cuenta Sucursal de Radicacion")
                        .version("v1.0"));

    }
}
