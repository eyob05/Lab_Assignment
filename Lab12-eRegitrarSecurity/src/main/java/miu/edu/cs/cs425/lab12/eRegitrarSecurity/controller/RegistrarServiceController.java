package miu.edu.cs.cs425.lab12.eRegitrarSecurity.controller;

import miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.Student;
import miu.edu.cs.cs425.lab12.eRegitrarSecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrarServiceController {
    private StudentService studentService;
    @Autowired
    public RegistrarServiceController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/eregistrar/registrar/student/list", "/registrar/student/list"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("/secured/registrar/list");
        return modelAndView;
    }
    @GetMapping(value = {"/eregistrar/registrar/student/new", "/registrar/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "/secured/registrar/new";
    }

    @PostMapping(value = {"/eregistrar/student/new", "/eregistrar/secured/registrar/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/registrar/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/registrar/student/list";
    }
    @GetMapping(value = {"/eregistrar/student/search", "/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("secured/registrar/list");
        return modelAndView;
    }
}
