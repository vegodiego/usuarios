package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserRepository userRepository;

    public Mono<Void> execute(String id){
        return userRepository.deleteUser(id);
    }
}
