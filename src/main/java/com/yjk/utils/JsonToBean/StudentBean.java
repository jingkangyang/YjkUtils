package com.yjk.utils.JsonToBean;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class StudentBean {
	@XmlElement(name = "message")
	private Message message;

	@XmlElementWrapper(name = "courseList")
	@XmlElement(name = "course")
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

	@Override
	public String toString() {
		return "StudentBean{" +
				"message=" + message +
				", courseList=" + courseList +
				'}';
	}
}
