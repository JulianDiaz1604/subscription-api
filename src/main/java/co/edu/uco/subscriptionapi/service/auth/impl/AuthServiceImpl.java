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

    private MyUserMapper userMapper = new MyUserMapper();

    @Override
    public JwtResponse authenticate(JwtRequest request) {
        return null;
    }

    @Override
    public JwtResponse register(UserRegistrationRequest request) {

        MyUser user = request.getUser();
        Person person = request.getPerson();
        MyUser savedUser;

        person.setId(UUID.randomUUID());
        personService.savePerson(person);
        user.setId(UUID.randomUUID());
        user.setPersonId(person.getId());

        savedUser = userService.saveUser(user);

        return new JwtResponse(jwtService.getToken(savedUser));

    }

}
