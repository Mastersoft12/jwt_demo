package com.bancolombia.jwt_demo.api;

import com.bancolombia.jwt_demo.jwt.JWTUtil;
import com.bancolombia.jwt_demo.model.Role;
import com.bancolombia.jwt_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class UsuarioHandler {

    @Autowired
    private JWTUtil jwtUtil;

    public Mono<ServerResponse> getUsuario(ServerRequest request) {
        User user = new User("faamarti","123456789");
        Mono<User> monoUser = Mono.just(user);
        return monoUser.flatMap(p -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(p))
        ).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getUsuarioDos(ServerRequest request) {
        User user = new User("faamarti2","123456789");
        Mono<User> monoUser = Mono.just(user);
        return monoUser.flatMap(p -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(p))
        ).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getToken(ServerRequest request) {
        return generarToken().flatMap(p -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(p))
        ).switchIfEmpty(ServerResponse.notFound().build());
    }

    private Mono<String> generarToken(){
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_USER);
        User user = new User("faamarti","123456789");
        user.setRoles(roles);
        return Mono.just("Bearer ".concat(jwtUtil.generateToken(user)));
    }
}
