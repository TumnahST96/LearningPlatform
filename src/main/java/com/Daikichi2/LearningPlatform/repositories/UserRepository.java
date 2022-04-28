package com.Daikichi2.LearningPlatform.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Daikichi2.LearningPlatform.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByEmail(String email);
	public List<User> findByRole(String role);
	
	//public List<User> findAllTeachers();
	
	//Optional<User> findByEmail(String email);

}
