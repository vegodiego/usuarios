package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserRepository userRepository;

    public Mono<User> execute(User user){
        return userRepository.listUser(user.getId()).flatMap(useR -> {
            useR.setEmail(user.getEmail());
            useR.setDescription(user.getDescription());
            return userRepository.updateUser(useR);
        }).switchIfEmpty(Mono.error(new IllegalAccessError("El usuario no existe")));
    }
}
