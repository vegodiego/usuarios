package co.com.sofka.api;

import co.com.sofka.usecase.user.CreateUserUseCase;
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

    public Mono<UserDTO> createUser(UserDTO userDTO) {
        return createUserUseCase.execute(mapperUserDTO.ToUser().apply(userDTO)).map(mapperUserDTO.toDTO());
    }

    public Flux<UserDTO> getUsers() {
        return listUsersUseCase.execute().map(mapperUserDTO.toDTO());
    }
}
