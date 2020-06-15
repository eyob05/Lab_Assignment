package miu.edu.cs.cs425.lab12.eRegitrarSecurity.controller;

import miu.edu.cs.cs425.lab12.eRegitrarSecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EResgistrarServicesController {

    private StudentService studentService;
    @Autowired
    public EResgistrarServicesController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/secured/services","/ereigstrar/secured/services"})
    public String services() {
        return "secured/services";
    }



}
