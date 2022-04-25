package com.Daikichi2.LearningPlatform.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Daikichi2.LearningPlatform.models.Course;

@Repository
public interface CoursesRepository extends CrudRepository<Course, Long>{
	
	List<Course>findAll();

}
