package co.edu.uco.subscriptionapi.service.jwt;

import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.repository.MyUserRepository;
import co.edu.uco.subscriptionapi.repository.entity.MyUserEntity;
import co.edu.uco.subscriptionapi.service.mappers.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    private MyUserMapper myUserMapper = new MyUserMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUserEntity userEntity = myUserRepository.getUserByUsername(username);
        MyUser user = myUserMapper.toDTO(userEntity);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

    }

    public MyUser save(MyUser myUser) {

        myUser.setPassword(bcryptEncoder.encode(myUser.getPassword()));
        MyUserEntity userEntity = myUserMapper.toEntity(myUser);
        return myUserMapper.toDTO(myUserRepository.save(userEntity));

    }

}
