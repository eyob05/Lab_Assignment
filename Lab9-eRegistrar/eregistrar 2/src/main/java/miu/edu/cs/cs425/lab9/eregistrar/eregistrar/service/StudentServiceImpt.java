package miu.edu.cs.cs425.lab9.eregistrar.eregistrar.service;

import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.model.Student;
import miu.edu.cs.cs425.lab9.eregistrar.eregistrar.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpt  implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> getListOfStudent() {
        return studentRepository.findAll();


    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public Student getStudentId(Long studentId) {

        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("firstName")));
    }

    @Override
    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(isDate(searchString)) {
            return studentRepository.findAllByEnrollmentDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {

            return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrIsInternationalContainingOrderByFirstName(
                    searchString, searchString, searchString
            );
        }
    }


    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {

        return searchString.contains(".");
    }
}
