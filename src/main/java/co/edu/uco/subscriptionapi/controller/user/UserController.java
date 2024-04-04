package co.edu.uco.subscriptionapi.controller.user;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class UserController {

    @Autowired
    private MyUserService userService;

    @GetMapping("/user")
    public MyUser getUserById(@RequestParam UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/username/{username}")
    public MyUser getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user")
    public MyUser saveUser(@RequestBody MyUser user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user")
    public MyUser updateUser(@RequestBody MyUser user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
    }
    @PatchMapping("/user")
    public MyUser patchMyUser(@RequestBody Map<?, Object> patchFields, @RequestParam UUID id) { return userService.patchUser(id, patchFields); }
}
