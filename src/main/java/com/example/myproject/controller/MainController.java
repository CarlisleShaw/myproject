package com.example.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String goHome(){
		return "index";
	}

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}

	
	@RequestMapping(path="/manage", method=RequestMethod.GET)
	public String manage(){
		return "manage";
	}

	@RequestMapping(path="/create/form", method=RequestMethod.GET)
	public String create(){
		return "create";
	}

	


}

