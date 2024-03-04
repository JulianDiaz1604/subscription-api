package co.edu.uco.subscriptionapi.service.user;

import co.edu.uco.subscriptionapi.domain.user.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    User getUserByUsername(String username);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(UUID id);

}
