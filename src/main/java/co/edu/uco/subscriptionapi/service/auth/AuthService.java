package co.edu.uco.subscriptionapi.service.auth;

import co.edu.uco.subscriptionapi.domain.jwt.JwtRequest;
import co.edu.uco.subscriptionapi.domain.jwt.JwtResponse;
import co.edu.uco.subscriptionapi.domain.registration.UserRegistrationRequest;

public interface AuthService {

    JwtResponse authenticate(JwtRequest request);
    JwtResponse register(UserRegistrationRequest request);

}
