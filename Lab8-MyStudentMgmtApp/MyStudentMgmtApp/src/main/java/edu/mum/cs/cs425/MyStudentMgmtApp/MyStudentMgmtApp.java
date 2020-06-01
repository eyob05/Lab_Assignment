package edu.mum.cs.cs425.MyStudentMgmtApp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.MyStudentMgmtApp.model.ClassRoom;
import edu.mum.cs.cs425.MyStudentMgmtApp.model.Student;
import edu.mum.cs.cs425.MyStudentMgmtApp.model.Transcript;
import edu.mum.cs.cs425.MyStudentMgmtApp.repository.ClassRoomRepository;
import edu.mum.cs.cs425.MyStudentMgmtApp.repository.StudentRepository;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassRoomRepository classRoomRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ClassRoom classRoom1 = new ClassRoom("McLaughin Building", "M105");
		ClassRoom classRoom2 = new ClassRoom("McLaughin Building", "M103");

		Transcript trans1 = new Transcript("Bs Computer Science");
		Transcript trans2 = new Transcript("Bs Algorithm");
		Transcript trans3 = new Transcript("Bs Software Engineering");

		Student student1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.4, LocalDate.of(2019, 05, 24), trans1,classRoom1);
		Student student2 = new Student("000-61-0002", "Ayub","Weldeyohannes", LocalDate.of(2018, 05, 24), trans2, classRoom1);
		Student student3 = new Student("000-61-0003", "Job", "Rich", "Jonson", 3.0, LocalDate.of(2020, 02, 24), trans3,classRoom2);
		Student student4 = new Student("000-61-0004", "Abreham", "Habtom", "Weldeyohannes", 3.5, LocalDate.of(2017, 11, 20), trans3,classRoom2);

		List<Student> list = Arrays.asList(student1, student2, student3, student4);
		classRoom1.setStudents(list);

		saveStudent(student1);
		saveStudent(student2);
		saveStudent(student3);
		saveStudent(student4);
		
		saveclassRoomRepository(classRoom1);
		saveclassRoomRepository(classRoom2);

	}

	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	private ClassRoom saveclassRoomRepository(ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}

}
