package co.edu.uco.subscriptionapi.service.user;

import co.edu.uco.subscriptionapi.domain.user.MyUser;

import java.util.Map;
import java.util.UUID;

public interface MyUserService {
    MyUser getUserById(UUID id);

    MyUser getUserByUsername(String username);

    MyUser saveUser(MyUser user);

    MyUser updateUser(MyUser user);

    MyUser patchUser(UUID id, Map<?, Object> patchFields);

    void deleteUser(UUID id);

}
