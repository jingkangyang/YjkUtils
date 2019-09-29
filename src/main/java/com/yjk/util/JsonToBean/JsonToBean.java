package com.yjk.util.JsonToBean;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonToBean {
	
	public static void main(String[] args) {
		String jsonStr = "{\r\n" + 
				"	\"message\": {\r\n" + 
				"		\"id\": \"123\",\r\n" + 
				"		\"name\": \"张三\"\r\n" + 
				"	},\r\n" + 
				"	\"course\": [\r\n" + 
				"		{\r\n" + 
				"			\"cid\": \"1\",\r\n" + 
				"			\"cname\": \"数学\",\r\n" + 
				"			\"grade\": \"100\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"cid\": \"2\",\r\n" + 
				"			\"cname\": \"语文\",\r\n" + 
				"			\"grade\": \"90\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";
		System.out.println(jsonStr);
		//String转JSONObject
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		JSONObject jsonObjMessage = jsonObj.getJSONObject("message");
		//JSONObject转Bean
		Message message = (Message) JSONObject.toBean(jsonObjMessage,Message.class);
		System.out.println(message.toString());
		
		JSONArray jsonArrCourse = jsonObj.getJSONArray("course");
		
		//JSONArray转Bean
		@SuppressWarnings("unchecked")
		List<Course> courseList = JSONArray.toList(jsonArrCourse, new Course(), new JsonConfig());
		System.out.println(courseList);

		//Bean转JSONObject
		Message msg = new Message();
		msg.setId("1");
		msg.setName("李四");
		JSONObject jsonObj2 = JSONObject.fromObject(msg);
		System.out.println(jsonObj2.toString());
		
		//List转JSONObject
		JSONArray jsonObj3 = JSONArray.fromObject(courseList);
		System.out.println(jsonObj3.toString());
	}

}
