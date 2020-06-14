package miu.edu.cs.cs425.lab9.eregistrar.eregistrar.controller;

import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.model.Student;
import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class StudentController {

    StudentService studentService;

    @Autowired
   public StudentController(StudentService studentService){
        this.studentService=studentService;

   }
   @GetMapping(value = {"/eregistrar/student/list"})
    public ModelAndView listStudents(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentsPaged(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
    @GetMapping(value = {"/eregistrar/student/add"})
    public String displayStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping(value = {"/ergistrar/student/add","/student/addstudent"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/add";
        }
       studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {

        Student student = studentService.getStudentId(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
     return "student/list";

    }
    @GetMapping(value = {"/eregistrar/student/delete/{studentId}","/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable long studentId, Model model) {

        studentService.deleteStudent(studentId);
        return "redirect:/eregistrar/student/list";
    }
    @GetMapping(value = {"/eregistrar/student/search", "/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
}
