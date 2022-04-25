package com.Daikichi2.LearningPlatform.services;

import java.util.List;
import java.util.Optional;

import com.Daikichi2.LearningPlatform.models.Course;
import com.Daikichi2.LearningPlatform.repositories.CoursesRepository;



public class CourseService {
	
	private final CoursesRepository courseRepo;

	public CourseService(CoursesRepository courseRepo) {
		super();
		this.courseRepo = courseRepo;
	}
	
	//find all courses
		public List<Course>allCourses(){
			return courseRepo.findAll();
		}
		//create courses
		
		public Course createCourse(Course course) {
			return courseRepo.save(course);
		}
		
		//find one Course
		public Course findCourse(Long id) {
			
			Optional<Course> optCourse = courseRepo.findById(id);
			
			if(optCourse.isPresent()) {
				return optCourse.get();
			}
			else return null;
		}
		
		
		//delete a Course from rpeo
		
		public void CourseMan(Long id) {
			
			courseRepo.deleteById(id);
		}
		
		
		//update one Course
		public Course updateCourse(Course course) {
			return courseRepo.save(course);
		}	

};
