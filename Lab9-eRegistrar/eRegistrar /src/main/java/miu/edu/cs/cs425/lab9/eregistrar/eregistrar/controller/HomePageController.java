package miu.edu.cs.cs425.lab9.eregistrar.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value={"/","eregistrar/home"})
    public String showHomePage(){
        return "home/index";

    }




}
