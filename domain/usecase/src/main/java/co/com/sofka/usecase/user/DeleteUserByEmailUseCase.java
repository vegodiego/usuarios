package co.com.sofka.usecase.user;

import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteUserByEmailUseCase {
    private final UserRepository userRepository;

    public Mono<Void> execute(String email){
        return userRepository.deleteUserByEmail(email);
    }
}
