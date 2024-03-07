package co.edu.uco.subscriptionapi.service.user.impl;

import co.edu.uco.subscriptionapi.domain.user.User;
import co.edu.uco.subscriptionapi.repository.UserRepository;
import co.edu.uco.subscriptionapi.repository.entity.UserEntity;
import co.edu.uco.subscriptionapi.service.mappers.UserMapper;
import co.edu.uco.subscriptionapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    UserMapper mapper = new UserMapper();

    @Override
    public User getUserById(UUID id) {
        return mapper.toDTO(userRepository.findById(id).get());
    }

    @Override
    public User getUserByUsername(String username) {
        return mapper.toDTO(userRepository.getUserByUsername(username));
    }

    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID());
        UserEntity userEntity = mapper.toEntity(user);
        return mapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        return mapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
