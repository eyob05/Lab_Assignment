package edu.mum.cs.cs425.MyStudentMgmtApp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@NotBlank(message = "StudentNumber is required")
	@Column ( name = "studentNumbers", nullable = false, unique = true)
	private String studentNumber;
	
	@NotBlank
	private String fName;
	
	
	private String middleName;
	
	@NotBlank
	private String lastName;
	
	private Double cGpa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfEnrollment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="transcript",nullable = false)
	private Transcript transcript;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="classroom",nullable =false)
	private ClassRoom classRoom;
	
	
	public Student(Long studentId, String studentNumber, String fName, String middleName, String lastName, Double cGpa,
			LocalDate dateOfEnrollment, Transcript transcript, ClassRoom classRoom) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cGpa = cGpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classRoom = classRoom;
	}


	public Student() {
		super();
	}

	

	
	public Student(@NotBlank(message = "StudentNumber is required") String studentNumber, @NotBlank String fName,
			@NotBlank String lastName, LocalDate dateOfEnrollment, Transcript transcript, ClassRoom classRoom) {
		super();
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.lastName = lastName;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classRoom = classRoom;
	}


	public Student(@NotBlank String studentNumber, @NotBlank String fName, String middleName, @NotBlank String lastName,
			Double cGpa, @NotBlank LocalDate dateOfEnrollment, Transcript transcript, ClassRoom classRoom) {
		super();
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cGpa = cGpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classRoom = classRoom;
	}


	public Student(Long studentId, String studentNumber, String fName, String middleName, String lastName, Transcript transcript, ClassRoom classRoom) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.fName = fName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.transcript = transcript;
		this.classRoom = classRoom;
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
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


	public Double getcGpa() {
		return cGpa;
	}


	public void setcGpa(Double cGpa) {
		this.cGpa = cGpa;
	}


	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}


	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}


	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, studentNumber=%s, fName=%s, middleName=%s, lastName=%s, cGpa=%s, dateOfEnrollment=%s, transcript=%s, classRoom=%s]",
				studentId, studentNumber, fName, middleName, lastName, cGpa, dateOfEnrollment, transcript, classRoom);
	}


	public Transcript getTranscript() {
		return transcript;
	}


	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}


	public ClassRoom getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	
	
	
	
}
