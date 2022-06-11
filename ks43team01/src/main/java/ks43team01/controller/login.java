package ks43team01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  ////URL 맵핑테스트용임, -한진-
public class login {

	@GetMapping("/login")
	
	public String login() {
	
		return "userpage/login";
	}


@GetMapping("/test")

	public String test() {

		return "adminpage/main";
	}

}
