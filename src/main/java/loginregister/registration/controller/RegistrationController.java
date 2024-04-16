package loginregister.registration.controller;

import loginregister.registration.service.RegistrationRequest;
import loginregister.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request){
        return  registrationService.register(request);

    }

}
