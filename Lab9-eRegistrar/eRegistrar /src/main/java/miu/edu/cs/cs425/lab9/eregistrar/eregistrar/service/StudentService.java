package miu.edu.cs.cs425.lab9.eregistrar.eregistrar.service;

import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public  Iterable<Student> getListOfStudent();
    public Student saveStudent(Student student);
    public Student getStudentId(Long studentId);
    public abstract Page<Student> getAllStudentsPaged(int pageNo);
    void deleteStudent(long studentId);

    List<Student> searchStudents(String searchString);
}
