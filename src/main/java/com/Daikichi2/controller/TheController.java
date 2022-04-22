package com.Daikichi2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Daikichi2.models.Lecture;

@Controller
public class TheController {
	
	@GetMapping("/consider")
	public String NewSong(Model model) {
		model.addAttribute("lecture", new Lecture());
		model.addAttribute("songs",songServe.RealAll());
		return "NewSong";
	}
}
