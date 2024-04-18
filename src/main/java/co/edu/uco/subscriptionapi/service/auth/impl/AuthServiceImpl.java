package co.edu.uco.subscriptionapi.service.auth.impl;

import co.edu.uco.subscriptionapi.domain.jwt.JwtRequest;
import co.edu.uco.subscriptionapi.domain.jwt.JwtResponse;
import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.registration.UserRegistrationRequest;
import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.service.auth.AuthService;
import co.edu.uco.subscriptionapi.service.jwt.JwtService;
import co.edu.uco.subscriptionapi.service.mappers.MyUserMapper;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MyUserService userService;

    @Autowired
    private PersonService personService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse authenticate(JwtRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userService.getUserByUsername(request.getUsername());
        return new JwtResponse(jwtService.getToken(user));
    }

    @Override
    public JwtResponse register(UserRegistrationRequest request) {

        MyUser user = request.getUser();
        Person person = request.getPerson();
        MyUser savedUser;

        person.setId(UUID.randomUUID());
        personService.savePerson(person);
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPersonId(person.getId());

        savedUser = userService.saveUser(user);

        return new JwtResponse(jwtService.getToken(savedUser));

    }

}
