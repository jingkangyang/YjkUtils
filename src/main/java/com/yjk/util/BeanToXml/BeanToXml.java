package com.yjk.util.BeanToXml;

import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.yjk.util.JsonToBean.Course;
import com.yjk.util.JsonToBean.Message;
import com.yjk.util.JsonToBean.StudentBean;

public class BeanToXml {

	public static void main(String[] args) {
		StudentBean stu = new StudentBean();
		Message msg = new Message();
		msg.setId("123");
		msg.setName("张三");
		Course cou1 = new Course();
		Course cou2 = new Course();
		List<Course> courseList = new ArrayList<Course>();
		cou1.setCid("1");
		cou1.setCname("数学");
		cou1.setGrade("100");
		cou2.setCid("2");
		cou2.setCname("语文");
		cou2.setGrade("90");
		courseList.add(cou1);
		courseList.add(cou2);
		stu.setMessage(msg);
		stu.setList(courseList);
		String xml = beanToXml(stu);
		System.out.println(xml);

	}

	public static String beanToXml(StudentBean stu) {
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
		xStream.alias("root", StudentBean.class);
		xStream.alias("course", Course.class);
		return xStream.toXML(stu);
	}

}
