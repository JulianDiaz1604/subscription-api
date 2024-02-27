package co.edu.uco.subscriptionapi.controller.user;

import co.edu.uco.subscriptionapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class User {

    @Autowired
    private UserService userService;
@GetMapping("/user")
    public co.edu.uco.subscriptionapi.domain.user.User getUserById(@RequestParam UUID id){ return userService.getUserById(id);}
@GetMapping("/user/username/{username}")
    public co.edu.uco.subscriptionapi.domain.user.User getUserByUsername(@PathVariable String username){return userService.getUserByUsername(username);}
@PostMapping("/person")
    public co.edu.uco.subscriptionapi.domain.user.User saveUser(@RequestBody co.edu.uco.subscriptionapi.domain.user.User user){ return userService.saveUser(user);}
@PutMapping("/person")
    public co.edu.uco.subscriptionapi.domain.user.User updateUser(@RequestBody co.edu.uco.subscriptionapi.domain.user.User user){ return userService.updateUser(user);}
@DeleteMapping("/person")
    public void deletUser(@RequestParam UUID id){ userService.deletUser(id); }
}
