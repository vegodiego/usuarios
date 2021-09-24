package co.com.sofka.api;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.values.Description;
import co.com.sofka.model.user.values.Email;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUserDTO {

    public Function<User,UserDTO> toDTO(){
        return user -> new UserDTO(
                user.getId(),
                user.getEmail().getValue(),
                user.getDescription().getValue()
        );
    }

    public Function<UserDTO,User> ToUser(){
        return userDTO -> new User(
                userDTO.getId(),
                new Email(userDTO.getEmail()),
                new Description(userDTO.getDescription())
        );
    }
}
