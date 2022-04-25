package com.Daikichi2.LearningPlatform.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Daikichi2.LearningPlatform.models.User;
import com.Daikichi2.LearningPlatform.services.CourseService;
import com.Daikichi2.LearningPlatform.services.UserService;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	
	public CourseService courseServe;

	public UserController(UserService userService, CourseService courseServe) {
		this.userService = userService;
		this.courseServe = courseServe;
	}
	
	
	@GetMapping("/teacher_new")
	public String teacher_new(@ModelAttribute("teacher") User user) {
		user.setRole("teacher");
		return "teacherRegister";
	}
	
	@PostMapping("/teacher_save")
	public String teacher_save(@Valid @ModelAttribute("teacher") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "teacherRegister";
		}
		User errors = userService.register(user, result);
		if(errors == null) return "teacherRegister";
		return "redirect:/";	
		
	}
	
	
//	@GetMapping("/singleTeacher")
//	public String singleTeacher(@ModelAttribute("teacher") User user) {
//		user.setRole("teacher");
//		return "teacherRegister";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//student
	
	@GetMapping("/student_new")
	public String student_new(@ModelAttribute("student") User user) {
		user.setRole("student");
		return "studentRegister";
	}
	
	@PostMapping("/student_save")
	public String student_save(@Valid @ModelAttribute("student") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "studentRegister";
		}
		User errors = userService.register(user, result);
		if(errors == null) return "studentRegister";
		return "redirect:/courses";		
	}
	
	
	//everything for courses 
	@GetMapping("/courses")
	public String courses (Model model) {
		// user in session so query me
		//then add to jsp
		model.addAttribute("allCourses", courseServe.allCourses());
		return "courses";
	}
	
	
	@GetMapping("/singleCourse/{id}")
	public String SingleCourse (@PathVariable("id")Long id,  Model model) {
	
		model.addAttribute("course", courseServe.findCourse(id));
		return "singleCourse";
	}
	
	
	
	
	//=======================================//
	
}
