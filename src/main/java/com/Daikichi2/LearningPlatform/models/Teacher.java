package com.Daikichi2.LearningPlatform.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="teachers")
public class Teacher extends User {  
    @NotEmpty(message = "Subject is requied")
	@Size(min=2, max=255, message="Subject must be between 2 and 255 characters")
    private String subject;
    
    @NotEmpty(message = "College is requied")
	@Size(min=2, max=255, message="College must be between 2 and 255 characters")
    private String college;
    
    @NotEmpty(message = "Major is requied")
	@Size(min=2, max=255, message="Major must be between 2 and 255 characters")
    private String major;

	public Teacher() {
		super();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
    
}