package com.Daikichi2.LearningPlatform.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="Title is required!")
    @Size(min=3, max=30, message="Title must be between 3 and 30 characters")
    private String title;
    
    private String instructor;
    
    private Integer credit;
    
    private Double price;
    
    private String description;
    
    private String imgURL;
    
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
        
    private String required;
    





    

// 	public Course(
// 			@NotEmpty(message = "Title is required!") @Size(min = 3, max = 30, message = "Title must be between 3 and 30 characters") String title, 
//     String instructor,
// 			Integer credit, Double price, String description, String imgURL, Date startDate, boolean required) {
// =======
//   //creating many to one relationship between teachers and courses; 
//   	@ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name="user_id")
//     private User teacher;
  	
//   	//creating many to many relationship between students and courses;
//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(
//             name = "enrollments", 
//             joinColumns = @JoinColumn(name = "course_id"), 
//             inverseJoinColumns = @JoinColumn(name = "student_id")
//         )
//         private List<User> students;
    
    public Course() {}; 
    
    

	public Course(
			@NotEmpty(message = "Title is required!") @Size(min = 3, max = 30, message = "Title must be between 3 and 30 characters") String title,
			Integer credit, Double price, String description, String imgURL, Date startDate, String required) {

		super();
		this.title = title;
		this.instructor = instructor;
		this.credit = credit;
		this.price = price;
		this.description = description;
		this.imgURL = imgURL;
		this.startDate = startDate;
		this.required = required;
	}


	



	public List<User> getStudents() {
		return students;
	}



	public void setStudents(List<User> students) {
		this.students = students;
	}



	public User getTeacher() {
		return teacher;
	}



	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}






	public String getRequired() {
		return required;
	}



	public void setRequired(String required) {
		this.required = required;
	}



	public Integer getCredit() {
		return credit;
	}




	public void setCredit(Integer credit) {
		this.credit = credit;
	}




	public Double getPrice() {
		return price;
	}




	public void setPrice(Double price) {
		this.price = price;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
    
	
    
}
