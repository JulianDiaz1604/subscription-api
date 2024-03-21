package co.edu.uco.subscriptionapi.service.user;

import co.edu.uco.subscriptionapi.domain.user.MyUser;

import java.util.UUID;

public interface MyUserService {
    MyUser getUserById(UUID id);

    MyUser getUserByUsername(String username);

    MyUser saveUser(MyUser user);

    MyUser updateUser(MyUser user);

    void deleteUser(UUID id);

}
