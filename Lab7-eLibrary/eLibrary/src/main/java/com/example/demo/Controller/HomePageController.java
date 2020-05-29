package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping(value = {"/","/eLibrary","/eLibrary/home"})
	public String displayHomepage() {
		return "home/index";
	}

}
