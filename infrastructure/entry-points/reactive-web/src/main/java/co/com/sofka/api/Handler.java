package co.com.sofka.api;

import co.com.sofka.usecase.user.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final CreateUserUseCase createUserUseCase;
    private final MapperUserDTO mapperUserDTO;


    public Mono<UserDTO> createUser(UserDTO usuarioDTO) {
        return createUserUseCase.execute(mapperUserDTO.ToUser().apply(usuarioDTO)).map(mapperUserDTO.toDTO());
    }
}
