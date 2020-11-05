package com.yjk.utils.JsonToBean;

public class Course {
	
	private String cid;
	
	private String cname;
	
	private String grade;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", grade=" + grade + "]";
	}
	
}
