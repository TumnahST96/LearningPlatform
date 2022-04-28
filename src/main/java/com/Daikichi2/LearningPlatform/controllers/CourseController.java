package com.Daikichi2.LearningPlatform.controllers;

import java.util.List;

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
import com.Daikichi2.LearningPlatform.models.Enrollment;
import com.Daikichi2.LearningPlatform.models.User;
import com.Daikichi2.LearningPlatform.services.CourseService;
import com.Daikichi2.LearningPlatform.services.EnrollmentService;
import com.Daikichi2.LearningPlatform.services.UserService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	@Autowired
	private EnrollmentService enrollmentService;

	public CourseController(CourseService courseService, UserService userService, EnrollmentService enrollmentService) {
		this.courseService = courseService;
		this.userService = userService;
		this.enrollmentService = enrollmentService;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session)
	{
		model.addAttribute("allCourses", courseService.allCourses());
		return "dashboard";
	}
	
	@GetMapping("/courses")
	public String courses (Model model, HttpSession session) {
		// user in session so query me
		//then add to jsp
		model.addAttribute("allCourses", courseService.allCourses());
		return "courses";
	}
	
	@GetMapping("/my_courses")
	public String my_courses(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
//		//System.out.println(user.getCourses());
		if(user.getRole().equals("teacher")) {
		List<Course> myCourses = (List<Course>)courseService.findTechersCourses(user);
		System.out.println("if");
		model.addAttribute("myCourses", myCourses);
	}
		if(user.getRole().equals("student")) {
			List<Course> myCourses =(List<Course>) user.getEnrolledCourses();
			model.addAttribute("myCourses", myCourses);
		}
		return "myCourses";
	}
	
	//Route to show one course
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
		return "redirect:/dashboard";
	}
					
	//render the update course form
	
	@GetMapping("/updateCourse/{id}")
	public String updateCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course,Model model) {
		model.addAttribute("course", courseService.findCourse(id));
		return "updateCourse";
	}
	//process the post to update course
	@RequestMapping(value ="/updatingCourse/{id}", method = RequestMethod.PUT)
	public String updatingCourse(@Valid @ModelAttribute("course")Course course, BindingResult result) {
		
		if(result.hasErrors()) return "updateCourse";
		
		else {
			courseService.updateCourse(course);
		}
		return "redirect:/courses";
	}
	
	//route to delete a course 
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id,  Model model) {
		
		courseService.delete(id);
		return "redirect:/courses";
	}

	//for students enroll in a course
	@GetMapping("/student/enroll/{id}")
	public String student_enroll_course(@PathVariable("id") Long id, HttpSession session, Model model) {
		Course course = (Course)courseService.findCourse(id);
		//System.out.println(course.getTitle());
		Enrollment enrollment = new Enrollment();
		User student = (User) session.getAttribute("user");
		//System.out.println(student.getFirstName());
		enrollment.setStudent(student);
		enrollment.setEnrolledCourse(course);
		enrollmentService.createEnrollment(enrollment);
		return "redirect:/dashboard";
	}
	

	
	
	
	
}
