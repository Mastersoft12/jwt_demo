package com.bancolombia.jwt_demo.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(UsuarioHandler handler) {
        return route(GET("/usuario"),handler::getUsuario)
                .andRoute(GET("/usuariodos"),handler::getUsuarioDos)
                .andRoute(GET("/token"),handler::getToken);
    }
}
