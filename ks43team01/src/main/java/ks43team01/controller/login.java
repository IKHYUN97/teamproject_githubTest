package ks43team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {

	@GetMapping("/login")
	
	public String login() {
	
		return "login/login";
	}
	
@GetMapping("/userjoin")
	
	public String join() {
	
		return "login/userjoin";
	}

@GetMapping("/test")

	public String test() {

		return "adminpage/main";
	}

}
