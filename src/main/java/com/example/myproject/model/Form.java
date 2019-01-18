package com.example.myproject.model;

import java.util.Date;

public class Form {

	private int f_id;

	private int f_uid;

	private Date f_date;

	private String f_name;

	public int getId() {

		return f_id;
	}

	public int getUserId() {

		return f_uid;
	}

	public Date getCreationTime() {

		return f_date;
	}

	public String getFormName() {

		return f_name;
	}
}