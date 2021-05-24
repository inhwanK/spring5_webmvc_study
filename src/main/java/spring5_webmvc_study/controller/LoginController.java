package spring5_webmvc_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthService authService;

    @GetMapping
    public String form(LoginCommand loginCommand) {
        return "/login/loginForm";
    }

    @PostMapping
    public String submit(LoginCommand loginCommand, Errors errors) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors())
            return "/login/loginForm";
        try {
            AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
            //TODO 세션에 authInfo 저장해야함
            return "/login/loginSuccess";
        }catch (WrongIdPasswordException ex) {
            errors.reject("idPasswordNotMatching");
            return "/login/loginForm";
        }
    }

}
