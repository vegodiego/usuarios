package co.com.sofka.api;

import co.com.sofka.usecase.user.CreateUserUseCase;
import co.com.sofka.usecase.user.ListUserByEmailUseCase;
import co.com.sofka.usecase.user.ListUserUseCase;
import co.com.sofka.usecase.user.ListUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final CreateUserUseCase createUserUseCase;
    private final MapperUserDTO mapperUserDTO;
    private final ListUsersUseCase listUsersUseCase;
    private final ListUserUseCase listUserUseCase;
    private final ListUserByEmailUseCase listUserByEmailUseCase;

    public Mono<UserDTO> createUser(UserDTO userDTO) {
        return createUserUseCase.execute(mapperUserDTO.ToUser().apply(userDTO)).map(mapperUserDTO.toDTO());
    }

    public Flux<UserDTO> getUsers() {
        return listUsersUseCase.execute().map(mapperUserDTO.toDTO());
    }

    public Mono<UserDTO> getUser(String id) {
        return listUserUseCase.execute(id).map(mapperUserDTO.toDTO())
                .switchIfEmpty(Mono.just(new UserDTO())).map(user -> {
                    if(user.getId() == null){
                        user.setId("-1");
                        user.setEmail("El usuario no existe");
                        user.setDescription("El usuario no existe");
                    }
                    return user;
                });
    }

    public Mono<UserDTO> getUserByEmail(String id) {
        return listUserByEmailUseCase.execute(id).map(mapperUserDTO.toDTO())
                .switchIfEmpty(Mono.just(new UserDTO())).map(user -> {
                    if(user.getId() == null){
                        user.setId("-1");
                        user.setEmail("El usuario no existe");
                        user.setDescription("El usuario no existe");
                    }
                    return user;
                });
    }
}
