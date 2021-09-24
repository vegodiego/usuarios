package co.com.sofka.mongo.helper;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.values.Description;
import co.com.sofka.model.user.values.Email;
import co.com.sofka.mongo.entities.UserEntity;

import java.util.function.Function;

public class UserMapper {
    public Function<UserEntity, User> fromUserEntity() {
        return newEntity -> new User(
                newEntity.getId(),
                new Email(newEntity.getEmail()),
                new Description(newEntity.getDescription())
        );
    }

    public Function<User, UserEntity> fromUser() {
        return newUser -> new UserEntity(
                newUser.getId(),
                newUser.getEmail().getValue(),
                newUser.getDescription().getValue()
        );
    }
}
