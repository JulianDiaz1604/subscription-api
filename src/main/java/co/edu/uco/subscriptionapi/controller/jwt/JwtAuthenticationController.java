package co.edu.uco.subscriptionapi.controller.jwt;

import co.edu.uco.subscriptionapi.domain.jwt.JwtRequest;
import co.edu.uco.subscriptionapi.domain.jwt.JwtResponse;
import co.edu.uco.subscriptionapi.domain.registration.UserRegistrationRequest;
import co.edu.uco.subscriptionapi.service.auth.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> saveUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return ResponseEntity.ok(authService.register(userRegistrationRequest));
    }

}
