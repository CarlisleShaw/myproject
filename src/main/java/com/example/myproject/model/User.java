package com.example.myproject.model;

public class User {

	private int u_id;

	private String u_name;

	private String u_passwd;

	public int getId() {
		return u_id;
	}

	public String getName() {
		return u_name;
	}

	public String getPasswd() {
		return u_passwd;
	}

	public void setId(int id) {
		u_id = id;
	}

	public void setName(String name) {
		u_name = name;
	}

}