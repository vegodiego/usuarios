package co.com.sofka.mongo;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import co.com.sofka.mongo.entities.UserEntity;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.helper.UserMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryAdapter extends AdapterOperations<UserEntity, UserEntity, String, UserDBRepository>
implements UserRepository{

    private UserMapper userMapper = new UserMapper();

    public UserRepositoryAdapter(UserDBRepository repository, ObjectMapper mapper) {
            super(repository, mapper, d -> mapper.map(d, UserEntity.class));
    }

    @Override
    public Mono<User> addUser(User user){
        return this.repository.save(userMapper.fromUser().apply(user)).map(userMapper.fromUserEntity());
    }

    @Override
    public Flux<User> listUsers(){
        return this.repository.findAll().map(userMapper.fromUserEntity());
    }

    @Override
    public Mono<User> listUser(String id){
        return this.repository.findById(id).map(userMapper.fromUserEntity());
    }

    @Override
    public Mono<User> listUserByEmail(String email){
        return this.repository.findByEmail(email).map(userMapper.fromUserEntity());
    }

    @Override
    public Mono<User> updateUser(User user){
        return this.repository.save(userMapper.fromUser().apply(user)).map(userMapper.fromUserEntity());
    }

    @Override
    public Mono<Void> deleteUser(String id){
        return this.repository.deleteById(id).then(Mono.empty());
    }

    @Override
    public Mono<Void> deleteUserByEmail(String email){
        return this.repository.deleteByEmail(email).then(Mono.empty());
    }
}
