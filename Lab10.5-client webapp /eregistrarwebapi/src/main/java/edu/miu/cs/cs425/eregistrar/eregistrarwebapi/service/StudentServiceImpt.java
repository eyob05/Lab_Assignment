package edu.miu.cs.cs425.eregistrar.eregistrarwebapi.service;


import edu.miu.cs.cs425.eregistrar.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrarwebapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpt implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getListOfStudent() {

        return studentRepository.findAll();
    }
    @Override
    public Student   saveStudent(Student student) {

        return studentRepository.save(student);
    }
    @Override
    public Student getStudentId(Long studentId) {

        return studentRepository.findById(studentId).orElse(null);
    }
    @Override
    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }
    @Override
    public Student updateStudent(Student editedStudent, Long studentId) {
      return studentRepository.findById(studentId)
              .map(student ->{
          student.setFirstName(editedStudent.getFirstName());
          student.setMiddleName(editedStudent.getMiddleName());
          student.setLastName(editedStudent.getLastName());
          student.setCgpa(editedStudent.getCgpa());
          student.setEnrollmentDate(editedStudent.getEnrollmentDate());
          student.setIsInternational(editedStudent.getIsInternational());
          student.setStudentNumber(editedStudent.getStudentNumber());
          return studentRepository.save(student);
         }).orElseGet(()->{
          return studentRepository.save(editedStudent);
        });
    }



}
