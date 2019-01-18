package com.example.myproject.model;

public class Answer {

	private int a_qid;

	private int a_fid;

	private int a_rid;

	private String a_answer;

	public int getQuestionId() {

		return a_qid;
	}

	public int getFormId() {

		return a_fid;
	}
	
	public String getAnswer() {

		return a_answer;
	}


	public int getRespondentId() {

		return a_rid;
	}

}