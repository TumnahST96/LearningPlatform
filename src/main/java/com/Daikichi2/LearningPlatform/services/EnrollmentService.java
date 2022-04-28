package com.Daikichi2.LearningPlatform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Daikichi2.LearningPlatform.models.Enrollment;
import com.Daikichi2.LearningPlatform.models.User;
import com.Daikichi2.LearningPlatform.repositories.EnrollmentRepository;


@Service
public class EnrollmentService {
	@Autowired
	private final EnrollmentRepository enrollmentRepo;

	public EnrollmentService(EnrollmentRepository enrollmentRepo) {
		super();
		this.enrollmentRepo = enrollmentRepo;
	}
	
		//find all enrollments
		public List<Enrollment>allEnrollments(){
			return enrollmentRepo.findAll();
		}
		
		//create enrollments		
		public Enrollment createEnrollment(Enrollment Enrollment) {
			return enrollmentRepo.save(Enrollment);
		}
		
		//find one Enrollment
		public Enrollment findEnrollment(Long id) {			
			Optional<Enrollment> optEnrollment = enrollmentRepo.findById(id);
			if(optEnrollment.isPresent()) {
				return optEnrollment.get();
			}
			else return null;
		}
		
		
		//delete a Enrollment 		
		public void delete(Long id) {		
			enrollmentRepo.deleteById(id);
		}		
		
		//update one Enrollment
		public Enrollment updateEnrollment(Enrollment Enrollment) {
			return enrollmentRepo.save(Enrollment);
		}	
		
		//find enrollments of one student
		public List<Enrollment> findByStudent(User student) {
			List<Enrollment> enrollments = enrollmentRepo.findByStudent(student);
			return enrollments;			
		}
		
		//

};
