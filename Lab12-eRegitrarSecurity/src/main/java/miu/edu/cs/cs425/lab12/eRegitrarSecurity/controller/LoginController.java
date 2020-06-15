package miu.edu.cs.cs425.lab12.eRegitrarSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/public/login","/eregistrar/public/login"})
    public String login() {
        return "public/login";
    }

}
