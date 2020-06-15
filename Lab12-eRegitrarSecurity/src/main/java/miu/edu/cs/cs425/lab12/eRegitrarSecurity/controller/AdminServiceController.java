package miu.edu.cs.cs425.lab12.eRegitrarSecurity.controller;

import miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.Student;
import miu.edu.cs.cs425.lab12.eRegitrarSecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminServiceController {

    private StudentService studentService;

    @Autowired
    public AdminServiceController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/secured/admin/list","/eregistrar/secured/admin/list"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("/secured/admin/list");
        return modelAndView;
    }
    @GetMapping(value = {"/eregistrar/admin/student/edit/{studentId}", "/admin/student/edit/{studentId}"})
    public String editStudent(@PathVariable long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "/secured/admin/edit";
        }
        return "/secured/admin/list";
    }

    @PostMapping(value = {  "/eregistrar/admin/student/edit", "/admin/student/edit"})
    public String updateStudents(@Validated @ModelAttribute("student") Student student,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/admin/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/secured/admin/list";
    }

    @GetMapping(value = {"/eregistrar/admin/student/delete/{studentId}", "/admin/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/secured/admin/list";
    }
    @GetMapping(value = {"/eregistrar/admin/student/search", "/admin/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("secured/admin/list");
        return modelAndView;
    }
}
