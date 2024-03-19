package co.edu.uco.subscriptionapi.service.user.impl;

import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.repository.MyUserRepository;
import co.edu.uco.subscriptionapi.repository.entity.MyUserEntity;
import co.edu.uco.subscriptionapi.service.mappers.MyUserMapper;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class MyUserServiceImpl implements MyUserService {
    @Autowired
    MyUserRepository userRepository;
    MyUserMapper mapper = new MyUserMapper();

    @Override
    public MyUser getUserById(UUID id) {
        return mapper.toDTO(userRepository.findById(id).get());
    }

    @Override
    public MyUser getUserByUsername(String username) {
        return mapper.toDTO(userRepository.getUserByUsername(username));
    }

    @Override
    public MyUser saveUser(MyUser user) {
        user.setId(UUID.randomUUID());
        MyUserEntity userEntity = mapper.toEntity(user);
        return mapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public MyUser updateUser(MyUser user) {
        MyUserEntity userEntity = mapper.toEntity(user);
        return mapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
