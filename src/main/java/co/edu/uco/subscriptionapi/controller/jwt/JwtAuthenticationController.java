package co.edu.uco.subscriptionapi.controller.jwt;

import co.edu.uco.subscriptionapi.domain.authenticateResponse.AuthenticateResponse;
import co.edu.uco.subscriptionapi.domain.jwt.JwtRequest;
import co.edu.uco.subscriptionapi.domain.jwt.JwtResponse;
import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.registration.UserRegistrationRequest;
import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.jwt.JwtTokenUtil;
import co.edu.uco.subscriptionapi.repository.PersonRepository;
import co.edu.uco.subscriptionapi.service.jwt.JwtUserDetailsService;
import co.edu.uco.subscriptionapi.service.mappers.PersonMapper;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import co.edu.uco.subscriptionapi.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @Autowired
    private MyUserService myUserService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails
                userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final UUID myUserId = myUserService.getUserByUsername(authenticationRequest.getUsername()).getId();
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticateResponse(myUserId, token));
    }

    @PostMapping("/register")
    public MyUser saveUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        MyUser user = userRegistrationRequest.getUser();
        Person person = userRegistrationRequest.getPerson();
        MyUser savedUser = new MyUser();
        try {
            person.setId(UUID.randomUUID());
            personService.savePerson(person);
            user.setId(UUID.randomUUID());
            user.setPersonId(person.getId());
            savedUser = userDetailsService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedUser;
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_D ISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
