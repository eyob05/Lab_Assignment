package edu.miu.cs.cs425.eregistrar.eregistrarwebapi.controller;

import edu.miu.cs.cs425.eregistrar.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrarwebapi.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value="/eregistrar")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;

    }


    @GetMapping(value = {"/get/{studentId}"})
    public Student getStudent(@PathVariable long studentId  ) {
        return studentService.getStudentId(studentId);

    }
    @PostMapping(value = "/add")
    public Student saveStudent( @Valid @RequestBody Student student ) {
        return studentService.saveStudent(student);

    }
    @DeleteMapping(value = {"/delete/{studentId}"})
    public void deleteStudent(@PathVariable long studentId ) {
        studentService.deleteStudent(studentId);

    }
    @GetMapping(value="/get/students")
    public List<Student> getStudent() {
        return studentService.getListOfStudent();

    }
    @PutMapping(value = "/edit/{studentId}")
    public Student editStudent(@Valid @RequestBody Student editedStudent, @PathVariable Long studentId) {
        return studentService.updateStudent(editedStudent, studentId);

    }
}
