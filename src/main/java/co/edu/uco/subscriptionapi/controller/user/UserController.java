package co.edu.uco.subscriptionapi.controller.user;

import co.edu.uco.subscriptionapi.domain.user.User;
import co.edu.uco.subscriptionapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUserById(@RequestParam UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
    }
}
