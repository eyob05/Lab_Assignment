package miu.edu.cs.cs425.lab12.eRegitrarSecurity.service.impl;

import miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.Student;
import miu.edu.cs.cs425.lab12.eRegitrarSecurity.repository.StudentRepository;
import miu.edu.cs.cs425.lab12.eRegitrarSecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }


    @Override
    public Student getStudentById(Long studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        repository.deleteById(studentId);
    }


    @Override
    public List<Student> searchStudents(String searchString) {
        if(containsDecimalPoint(searchString) && isCGPA(searchString)) {
            return repository.findAllByCgpaEquals(Double.parseDouble(searchString));

        } else if(isDate(searchString)) {
            return repository.findAllByEnrollmentDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return repository.findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(searchString, searchString, searchString);
        }
    }

    @Override
    public Optional<Student> findByStudentNumber(String studentNumber) {
        return repository.findStudentByStudentNumber(studentNumber);
    }

    private boolean isCGPA(String searchString) {
        boolean isParseableAsCGPA = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsCGPA = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsCGPA = false;
            }
        }
        return isParseableAsCGPA;
    }


    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }
}
