package com.Daikichi2.LearningPlatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Daikichi2.LearningPlatform.models.Course;
import com.Daikichi2.LearningPlatform.services.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/new_course")
	public String new_course(Model model) {
		model.addAttribute("course", new Course());
		return "new_course";
	}
	
	
	
}
