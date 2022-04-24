package com.Daikichi2.LearningPlatform.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Daikichi2.LearningPlatform.models.LoginUser;


@Controller
public class RootController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("login", new LoginUser());
		return "index";
	}
	
	
}
