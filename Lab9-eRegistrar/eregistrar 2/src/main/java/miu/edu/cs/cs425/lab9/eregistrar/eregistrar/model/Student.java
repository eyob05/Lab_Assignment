package miu.edu.cs.cs425.lab9.eregistrar.eregistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
    @Table(name="students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long studentid;
        @NotBlank(message = "student Number is required")
        @Column(nullable = false, unique = true)
        private String  studentNumber ;
        @NotBlank(message = "ftName is required")
        private  String firstName ;
        private  String middleName;
    @NotBlank(message = "lastName is required")
    private String lastName;
    @NotBlank(message = "cgpa is required")
    @NotEmpty(message = "cgpa is required")
    @NotNull(message = "cgpa is required")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "4.0", inclusive = true)
    private Double cgpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @NotBlank
    private String isInternational;



    public Student() {
    }

    public Student(String studentNumber, @NotBlank(message = "firstName is required") String firstName, String middleName, @NotBlank(message = "lastName is required") String lastName, Double cgpa, LocalDate enrollmentDate, String isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }



    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getInternational() {
        return isInternational;
    }

    public void setInternational(String international) {
        isInternational = international;
    }
}
