package com.example.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.* ;
import org.json.JSONObject;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.*;

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

@RequestMapping(path="/login", method=RequestMethod.POST)
@ResponseBody
public String getUser(@RequestBody String requestStr) {
	JSONObject requestJson =  new JSONObject(requestStr);
	String username= requestJson.getString("username");
	String password= requestJson.getString("password");
	System.out.println(username);
	System.out.println(password);

	String dr = "";
	if(username.equals("admin")&&password.equals("admin")) {//这里没有用数据库验证
		dr = "{\"result\":\"success\"}";
	}
	else {
		dr = "{\"result\":\"fail\"}";
	}

	return dr;
}

}

