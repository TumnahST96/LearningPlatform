package com.Daikichi2.LearningPlatform.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Daikichi2.LearningPlatform.models.Course;
import com.Daikichi2.LearningPlatform.models.Enrollment;
import com.Daikichi2.LearningPlatform.models.User;


@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, Long>{
	
	List<Enrollment>findAll();
	List<Enrollment> findByStudent(User student);
	List<Enrollment> findByEnrolledCourseId(Long course_id);
}
