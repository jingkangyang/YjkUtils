package com.yjk.utils.XmlAnalysis;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.yjk.utils.JsonToBean.Course;

/**
 * dom4j解析xml
 */
public class XmlAnalysis {

	public static void main(String[] args) throws DocumentException {
		String xmlStr = "<root>\r\n" + 
				"  <message>\r\n" + 
				"    <id>123</id>\r\n" + 
				"    <name>张三</name>\r\n" + 
				"  </message>\r\n" + 
				"  <courseList>\r\n" + 
				"    <course>\r\n" + 
				"      <cid>1</cid>\r\n" + 
				"      <cname>数学</cname>\r\n" + 
				"      <grade>100</grade>\r\n" + 
				"    </course>\r\n" + 
				"    <course>\r\n" + 
				"      <cid>2</cid>\r\n" + 
				"      <cname>语文</cname>\r\n" + 
				"      <grade>90</grade>\r\n" + 
				"    </course>\r\n" + 
				"  </courseList>\r\n" + 
				"</root>\r\n" + 
				"";
		Document documentT = DocumentHelper.parseText(xmlStr);
		String id = documentT.selectSingleNode("/root/message/id").getText();
		System.out.println(id);
		@SuppressWarnings("unchecked")
		List<Element> items = documentT.selectNodes("/root/courseList/course");
		if (items == null) {
			items = new ArrayList<Element>();
		}
		List<Course> courseList = getCourseList(items);
		System.out.println(courseList);
	}

	public static List<Course> getCourseList(List<Element> items){
		List<Course> courseList = new ArrayList<Course>();
		for(Element e:items) {
			Course course = new Course();
			course.setCid(e.selectSingleNode("cid").getText());
			course.setCname(e.selectSingleNode("cname").getText());
			course.setGrade(e.selectSingleNode("grade").getText());
			courseList.add(course);
		}
		return courseList;
	}
}
