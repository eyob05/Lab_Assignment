package miu.edu.cs.cs425.lab9.eregistrar.eregistrar.controller;

import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.model.Student;
import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.service.StudentService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    StudentService studentService;

    @Autowired
   public StudentController(StudentService studentService){
        this.studentService=studentService;

   }

    @GetMapping(value = {"/eregistrar/student/list"})
    public ModelAndView listBooks(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentsPaged(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

//    @GetMapping(value={"/eregistrar/student/search"})
//    public ModelAndView showStudetList(){
//
//        ModelAndView modelAndView=  new ModelAndView();
//        modelAndView.addObject("students",studentService.getListOfStudent());
//         modelAndView.setViewName("student/list");
//        return  modelAndView;
//
//    }
    @GetMapping(value = {"/eregistrar/student/add"})
    public String displayStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping(value = {"/eregistrar/student/add","/student/addstudent"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/add";
        }
        student=studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"eregistrar/student/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {

        Student student = studentService.getStudentId(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
     return "student/list";

    }

    @PostMapping(value = {"/eregistrar/student/edit","/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/delete/{studentId}","/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable long studentId, Model model) {

        studentService.deleteStudent(studentId);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/{studentId}"})
    public Student getStudent(@PathVariable long studentId, Model model) {
        Student student=studentService.getStudentId(studentId);
        model.addAttribute("student", student);
        return student;
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
