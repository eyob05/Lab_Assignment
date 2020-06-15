package miu.edu.cs.cs425.lab12.eRegitrarSecurity.service;


import miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public abstract List<Student> getAllStudents();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Long studentId);
    public abstract void deleteStudentById(Long StudentId);
    public abstract List<Student> searchStudents(String searchString);

    Optional<Student> findByStudentNumber(String studentNumber);
}