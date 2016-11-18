package mum.edu.cs544.Car_Rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/users")
	public String showUsers(){
		return "users";
	}
	

}
