package com.yjk.utils.JsonToBean;

import com.alibaba.fastjson.JSON;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaBean和xml互转
 */
public class JAXBUtils {

    /**JavaBean转换成xml
     * @param obj
     * @param encoding
     * @param formatOrNot
     * @returns
     */
    public static String convertToXml(Object obj,String encoding,Object formatOrNot) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            //是否格式化（按标签自动换行）
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,formatOrNot);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj,writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**xml转换成JavaBean
     * @param xml
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T converyToJavaBean(String xml,Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

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

        String xml = convertToXml(stu,"UTF-8",true);
        System.out.println("xml:"+xml);
        StudentBean stu2 = converyToJavaBean(xml,StudentBean.class);
        String stuJsonStr = JSON.toJSONString(stu2);

        System.out.println("stu2:"+stuJsonStr);
    }
}
