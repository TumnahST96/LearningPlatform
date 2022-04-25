package com.Daikichi2.LearningPlatform.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Daikichi2.LearningPlatform.models.Course;


public interface CoursesRepository extends CrudRepository<Course, Long>{
	
	List<Course>findAll();

}
