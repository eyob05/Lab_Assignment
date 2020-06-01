package edu.mum.cs.cs425.MyStudentMgmtApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "classrooms")
public class ClassRoom {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long classRoomId;
	
	@NotBlank
	private String buildingName;
	
	@NotBlank(message = "Room Number is required")
	private String roomNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classRoom")
	private List<Student> students;

	public ClassRoom(Long classRoomId, String buildingName, String roomNumber) {
		super();
		this.classRoomId = classRoomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;

	}

	public ClassRoom() {
		super();
	}

	public ClassRoom(String buildingName, String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
}
