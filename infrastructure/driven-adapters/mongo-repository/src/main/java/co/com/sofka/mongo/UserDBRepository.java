package co.com.sofka.mongo;

import co.com.sofka.model.user.User;
import co.com.sofka.mongo.entities.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Mono;

public interface UserDBRepository extends ReactiveMongoRepository<UserEntity, String>, ReactiveQueryByExampleExecutor<UserEntity> {
    Mono<UserEntity> findByEmail (String email);
    Mono<UserEntity> deleteByEmail(String email);
}
