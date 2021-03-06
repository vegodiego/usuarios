package co.com.sofka.model.user.gateways;

import co.com.sofka.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> addUser(User user);

    Flux<User> listUsers();

    Mono<User> listUser(String id);

    Mono<User> listUserByEmail(String email);

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(String id);

    Mono<Void> deleteUserByEmail(String email);
}

