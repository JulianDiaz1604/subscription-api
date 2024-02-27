package co.edu.uco.subscriptionapi.service.user.impl;

import co.edu.uco.subscriptionapi.domain.user.User;
import co.edu.uco.subscriptionapi.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(UUID id) {
        return new User();
    }

    @Override
    public User getUserByUsername(String username) {
        return new User();
    }

    @Override
    public User saveUser(User user) {
        return user;
    }

    @Override
    public User updateUser(User user) {
        return user;
    }

    @Override
    public void deletUser(UUID id) {
    }
}
