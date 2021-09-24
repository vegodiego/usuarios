package co.com.sofka.mongo;

import co.com.sofka.mongo.entities.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface UserDBRepository extends ReactiveMongoRepository<UserEntity, String>, ReactiveQueryByExampleExecutor<UserEntity> {
}
