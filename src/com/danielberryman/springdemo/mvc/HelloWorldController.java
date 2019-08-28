package com.danielberryman.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormV2")
	public String shout(HttpServletRequest request, Model model) {
		String string = request.getParameter("studentName");
		string = string.toUpperCase();
		String result = "Yo! " + string + "!";
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormV3")
	public String shoutViaParam(
			@RequestParam("studentName") String name,
			Model model) {
		name = name.toUpperCase();
		String result = "Hey dude from v3! " + name + "!";
		model.addAttribute("message", result);
		return "helloworld";
	}
}
