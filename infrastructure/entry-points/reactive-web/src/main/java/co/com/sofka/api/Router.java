package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> createUser(Handler handler) {
        return route(POST("/api/usuario/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDTO.class)
                        .flatMap(userDTO -> handler.createUser(userDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getUsers(Handler handler) {
        return route(
                GET("/api/users").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(handler.getUsers(), UserDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getUser(Handler handler) {
        return route(GET("/api/usuario/porId/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(handler.getUser(request.pathVariable("id")), UserDTO.class)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getUserByEmail(Handler handler) {
        return route(GET("/api/usuario/porEmail/{email}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(handler.getUserByEmail(request.pathVariable("email")), UserDTO.class)
        );
    }
}
