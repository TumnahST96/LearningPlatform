package com.Daikichi2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheController {
	
	@GetMapping("/consider")
	public String Role() {
//		if()
		return "NewSong";
	}
}
