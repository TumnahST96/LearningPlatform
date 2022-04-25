package com.Daikichi2.LearningPlatform.services;

import java.util.List;

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
		

};
