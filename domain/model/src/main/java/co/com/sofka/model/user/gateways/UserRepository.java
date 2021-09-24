package co.com.sofka.model.user.gateways;

import co.com.sofka.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> addUser(User user);

}
