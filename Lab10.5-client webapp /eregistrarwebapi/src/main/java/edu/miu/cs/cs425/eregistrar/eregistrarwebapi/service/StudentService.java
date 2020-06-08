package edu.miu.cs.cs425.eregistrar.eregistrarwebapi.service;
import edu.miu.cs.cs425.eregistrar.eregistrarwebapi.model.Student;
import java.util.List;

public interface StudentService {

      public List<Student> getListOfStudent();
      public Student saveStudent(Student student);
      public Student getStudentId(Long studentId);
      public void deleteStudent(long studentId);
      public Student updateStudent( Student editedStudent, Long studentId);

}
