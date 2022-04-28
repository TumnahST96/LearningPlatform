package com.Daikichi2.LearningPlatform.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enrollments")
public class Enrollment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private User student;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course enrolledCourse;
	
	public Enrollment() {}

	public Enrollment(User student, Course enrolledCourse) {
		super();
		this.student = student;
		this.enrolledCourse = enrolledCourse;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getEnrolledCourse() {
		return enrolledCourse;
	}

	public void setEnrolledCourse(Course enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}
	
	
	
	
	
	
	
}