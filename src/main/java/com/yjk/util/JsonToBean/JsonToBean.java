package com.yjk.util.JsonToBean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

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
		JSONObject jsonObj = JSON.parseObject(jsonStr);
		JSONObject jsonObjMessage = jsonObj.getJSONObject("message");
		//JSONObject转Bean
		Message message = JSON.toJavaObject(jsonObjMessage,Message.class);
		System.out.println(message.toString());
		
		JSONArray jsonArrCourse = jsonObj.getJSONArray("course");
		
		//JSONArray转Bean
		@SuppressWarnings("unchecked")
		List<Course> courseList = JSONObject.parseArray(jsonArrCourse.toJSONString(),Course.class);
		System.out.println(courseList);

		//Bean转JSONObject
		Message msg = new Message();
		msg.setId("1");
		msg.setName("李四");
		String jsonObj2Str = JSON.toJSONString(msg);
		System.out.println(jsonObj2Str);
		
		//List转JSONObject
		JSONArray jsonObj3 = JSONArray.parseArray(JSON.toJSONString(courseList));
		System.out.println(jsonObj3.toString());
	}

}
