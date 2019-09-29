package com.yjk.util.JsonToBean;

import java.util.List;

public class StudentBean {

	private Message message;

	private List<Course> courseList;

	public List<Course> getList() {
		return courseList;
	}

	public void setList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
