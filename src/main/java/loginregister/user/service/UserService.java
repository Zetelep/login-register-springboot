package loginregister.user.service;

import loginregister.user.data.Users;
import loginregister.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User %S not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUpUser(Users users){
        boolean userExist = userRepository.findByEmail(users.getEmail()).isPresent();

        if(userExist){
            throw new IllegalStateException("Email already registered");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(users.getPassword());

        users.setPassword(encodedPassword);

        userRepository.save(users);

        //TODO: send confirmation token by email

        return "aman";
    }
}
