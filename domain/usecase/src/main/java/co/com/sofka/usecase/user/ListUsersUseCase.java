package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListUsersUseCase {
    private final UserRepository userRepository;

    public Flux<User> execute(){
        return userRepository.listUsers();
    }
}
