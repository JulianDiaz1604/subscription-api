package co.edu.uco.subscriptionapi.service.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String getToken(UserDetails user);

}
