package com.Daikichi2.LearningPlatform.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.Daikichi2.LearningPlatform.models.LoginUser;
import com.Daikichi2.LearningPlatform.models.User;
import com.Daikichi2.LearningPlatform.repositories.UserRepository;

@Service
public class UserService {	
	@Autowired
	private UserRepository userRepository;
	private User user;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public static Boolean IsLoggedIn(HttpSession session) {
		return session.getAttribute("user")!=null ;
	}
	
	public static String Logout(HttpSession session)
	{
		if(!IsLoggedIn(session)) return "redirect:/";
		session.removeAttribute("user");
		return "redirect:/ ";
	}	
	
	public void Create(User user)
	{
		userRepository.save(user);
		
	}

	public User FindByEmail(String email)
	{
		User user = userRepository.findByEmail(email);
		return user;
	}
	
	public User ReadOne(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
		}
		
	public ArrayList<User> ReadAll()
	{
		ArrayList<User> users=(ArrayList<User>)userRepository.findAll();
		return users;
	}
	
	public List<User> allUsers(String role) {
		
		return userRepository.findByRole(role);
	}

	
	public User register(User user, BindingResult result) {
		User existing_user = userRepository.findByEmail(user.getEmail());
		int errors = 0;
		if(existing_user != null) {
			result.rejectValue("email","email not match", "Email has been used.");
			errors++;
		}
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm","password not match", "Password and confirmation must match");
			errors++;			
		}
		if(errors > 0)  return null;
		String hashed_pw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8));
		user.setPassword(hashed_pw);
		userRepository.save(user);	
		return user;
	}
	
	public User login(LoginUser form_user, BindingResult result, HttpSession session) {
		User db_user = userRepository.findByEmail(form_user.getEmail());
		int errors = 0;
		if(db_user == null) {
			result.rejectValue("email","email not exist", "Email not found");
			errors++;
		}
		if(db_user != null) {
			Boolean match = BCrypt.checkpw(form_user.getPassword(), db_user.getPassword());
			if(!match) {
				result.rejectValue("password","password not match", "Invalid Password");
				errors++;
			}
		}
		if(errors > 0) return null;
		session.setAttribute("user", db_user);
		return db_user;		
	}	
	
	
//	public ArrayList<User> findAllTeachers() {
//		ArrayList<User> teachers = new ArrayList<User>();
//		userRepository.findAll();
//		
//	}
}
