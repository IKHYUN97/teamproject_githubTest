package ks43team01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ks43team01.dto.User;
import ks43team01.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	//DI//
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/userjoin") //회원가입시겟맵핑 잡아주는거//
	public String addUserInsert() {
		
		return "userpage/userjoin";
	}
	@PostMapping("/userjoin") //회원가입시겟맵핑 잡아주는거//
	public String addUserInsert(User user,HttpSession session) {
	
		userService.addUserInsert(user);
		log.info("받아온멤버",user);
		session.setAttribute("CheckId", user.getUserId());
		session.setAttribute("CheckName", user.getUserName());
		session.setAttribute("CheckPhone", user.getUserContact());
		session.setAttribute("CheckEmail", user.getUserEmail());
		session.setAttribute("CheckArea", user.getUserArea());
		
		
		return "userpage/userjoinCheck";
	}
	
	@PostMapping("/userjoinCheck")
	public String userInsertCheck(Model model) {
		return "userpage/sellerjoin";
	}
	
}
