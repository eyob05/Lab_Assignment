package miu.edu.cs.cs425.lab12.eRegitrarSecurity.repository;

import miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(String firstName,
                                                                                                            String lastName,
                                                                                                            String studentNumber);
    List<Student> findAllByEnrollmentDateEquals(LocalDate enrollmentdate);
    List<Student> findAllByCgpaEquals(Double cGpa);

    // More queries
    List<Student> findBooksByEnrollmentDateIsStartingWith(String str);

    Optional<Student> findStudentByStudentNumber(String studentNumber);
}