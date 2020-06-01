package edu.mum.cs.cs425.MyStudentMgmtApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "transcripts")
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trascriptId;
	
	@NotBlank
	private String degreeTitle;
	
	
	
	public Transcript(Long trascriptId, String degreeTitle) {
		super();
		this.trascriptId = trascriptId;
		this.degreeTitle = degreeTitle;
	}


	public Transcript(String degreeTitle) {
		super();
		this.degreeTitle = degreeTitle;
	}
	

	public Transcript() {
		super();
	}


	public Long getTrascriptId() {
		return trascriptId;
	}


	public void setTrascriptId(Long trascriptId) {
		this.trascriptId = trascriptId;
	}


	public String getDegreeTitle() {
		return degreeTitle;
	}


	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}


	@Override
	public String toString() {
		return String.format("Transcript [trascriptId=%s, degreeTitle=%s]", trascriptId, degreeTitle);
	}
	
	
	
	
}
