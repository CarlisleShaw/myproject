package com.example.myproject.controller;

import java.util.*;
import java.util.ArrayList;
import java.lang.String;
import org.json.JSONObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.lang.Integer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.context.request.async.DeferredResult;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import com.example.myproject.service.loginResult;
import com.example.myproject.model.User;
import com.example.myproject.model.Form;
// import com.example.myproject.model.Question;
// import com.example.myproject.model.Choice;
// import com.example.myproject.model.Respondent;
// import com.example.myproject.model.Answer;
import com.example.myproject.mapper.UserMapper;
import com.example.myproject.mapper.FormMapper;
// import com.example.myproject.mapper.QuestionMapper;
// import com.example.myproject.mapper.ChoiceMapper;
// import com.example.myproject.mapper.RespondentMapper;
// import com.example.myproject.mapper.AnswerMapper;


@RestController
public class myRestController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FormMapper formMapper;
	// private QuestionMapper questionMapper;
	// private ChoiceMapper choiceMapper;
	// private RespondentMapper respondentMapper;
	// private AnswerMapper answerMapper;

	private User user;
	private Form form;
	// private Question question;
	// private Choice choice;
	// private Respondent respondent;
	// private Answer answer;
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public String getString(){
		return "hahahaha";
	}

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public loginResult login(@RequestBody String requestStr, HttpServletResponse response)  throws NoSuchAlgorithmException {

		JSONObject requestJson =  new JSONObject(requestStr);
		String username= requestJson.getString("username");
		String password= requestJson.getString("password");

		if (userMapper.findByName(username) != null)  user = userMapper.findByName(username);	
		else return new loginResult("fail");

		if(username.equals(user.getName())&&password.equals(user.getPasswd())) {

			// MessageDigest md = MessageDigest.getInstance("MD5");
	  //       md.update(username.getBytes());
	  //       Cookie c = new Cookie("ID",(new BigInteger(1, md.digest())).toString(16));
		Cookie c = new Cookie("ID",String.valueOf(user.getId()));
			response.addCookie(c);
			return new loginResult("success");
		}
		else {
			return new loginResult("fail");
		}
	}

	@RequestMapping(path="/signup", method=RequestMethod.POST)
	public loginResult signup(@RequestBody String requestStr, HttpServletResponse response) throws NoSuchAlgorithmException {

		JSONObject requestJson =  new JSONObject(requestStr);
		String username= requestJson.getString("username");
		String password= requestJson.getString("password");

		if(userMapper.findByName(username) != null)  return new loginResult("fail");

		userMapper.insert(username, password);
		// MessageDigest md = MessageDigest.getInstance("MD5");
  //       md.update(username.getBytes());
  //       Cookie c = new Cookie("ID",(new BigInteger(1, md.digest())).toString(16));
		user = userMapper.findByName(username);
		Cookie c = new Cookie("ID",String.valueOf(user.getId()));

		response.addCookie(c);

		return new loginResult("success");

	}

	@RequestMapping(path="/getForm", method=RequestMethod.GET)
	public ArrayList<Form> manage(@CookieValue(value="ID") String cookie, HttpServletResponse response){

		System.out.println(cookie);

		
		ArrayList<Form> formList;

		if (formMapper.findByUserId(Integer.parseInt(cookie)) != null)  formList = formMapper.findByUserId(Integer.parseInt(cookie));	
		else return new ArrayList<Form>();

		return formList;
	}

	@RequestMapping(path="/mybatis", method=RequestMethod.GET)
	public String mybatis() {

		return userMapper.findByName("FirstUser").getPasswd();
	}
}