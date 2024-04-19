package loginregister.registration.service;


import loginregister.user.data.UserRole;
import loginregister.user.data.Users;
import loginregister.user.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    public  String register(RegistrationRequest request){
        boolean isValidEmail = EmailValidator.getInstance().isValid(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid!");
        }

        return userService.signUpUser(
                new Users(request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
