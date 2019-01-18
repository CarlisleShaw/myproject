package com.example.myproject.model;

import java.util.Date;

public class Respondent {

	private int r_id;

	private int r_fid;

	private String r_respondent;

	private Date r_date;

	public int getId() {

		return r_id;
	}

	public int getFormId() {

		return r_fid;
	}

	public String getRespondent() {
		return r_respondent;
	}

	public Date getResponseTime() {

		return r_date;
	}

}