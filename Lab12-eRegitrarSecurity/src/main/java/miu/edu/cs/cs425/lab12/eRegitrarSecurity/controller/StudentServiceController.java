package miu.edu.cs.cs425.lab12.eRegitrarSecurity.controller;

import miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.Student;
import miu.edu.cs.cs425.lab12.eRegitrarSecurity.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentServiceController {

    private StudentService studentService;

    public StudentServiceController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/secured/student/list","/eregistrar/secured/student/list"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("/secured/student/list");
        return modelAndView;
    }
}
