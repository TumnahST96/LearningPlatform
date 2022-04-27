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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Daikichi2.LearningPlatform.models.Course;
import com.Daikichi2.LearningPlatform.services.CourseService;
import com.Daikichi2.LearningPlatform.services.UserService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;

	public CourseController(CourseService courseService, UserService userService) {
		this.courseService = courseService;
		this.userService = userService;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model)
	{
		model.addAttribute("allCourses", courseService.allCourses());
		return "dashboard";
	}
	//Route to show one candy
			@GetMapping("/oneCourse/{id}")
			public String oneCourse(@PathVariable("id")Long id,  Model model) {
				
				model.addAttribute("course", courseService.findCourse(id));
				return "singleCourse";
			}
			
			@GetMapping("/new_course")
			public String new_course(Model model) {
				model.addAttribute("course", new Course());
				model.addAttribute("allTeachers", userService.allUsers("teacher"));
				//model.addAttribute("allTeachers", UserService.)
				return "new_course";
			}
			
			//process the post to create candy
			@PostMapping("/add_course")
			public String postingCourse(@Valid @ModelAttribute("course")Course course, BindingResult result) {
				
				if(result.hasErrors()) return "new_course";
				
				else {
					courseService.createCourse(course);
				}				
				return "redirect:/";
			}
			
//	@GetMapping("/courses")
//	public String all_courses(Model model) {
//		model.addAttribute("allCourses", courseService.allCourses());
//		return "courses";
//	}
	
	@GetMapping("/my_courses/{id}")
	public String my_courses(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		return "myCourses";
	}
	
	//render the update candfy form
	
		@GetMapping("/updateCourse/{id}")
		public String updateCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course,Model model) {
			model.addAttribute("course", courseService.findCourse(id));
			return "updateCourse";
		}
		//process the post to update candy
		@RequestMapping(value ="/updatingCourse/{id}", method = RequestMethod.PUT)
		public String updatingCourse(@Valid @ModelAttribute("course")Course course, BindingResult result) {
			
			if(result.hasErrors()) return "updateCourse";
			
			else {
				courseService.updateCourse(course);
			}
			return "redirect:/courses";
		}
		
		//route to delete a candy 
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id")Long id,  Model model) {
			
			courseService.delete(id);
			return "redirect:/courses";
		}


	

	
	
	
	
}
