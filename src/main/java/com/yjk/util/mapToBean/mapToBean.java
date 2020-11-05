package com.yjk.util.mapToBean;

import com.yjk.util.JsonToBean.Message;
import com.yjk.util.JsonToBean.StudentBean;
import org.springframework.cglib.beans.BeanMap;
import java.util.HashMap;
import java.util.Map;

public class mapToBean {
    public static void main(String[] args){
        try {
        Map<String,Object> stuMap = new HashMap<String, Object>();
        Map<String,Object> msgMap = new HashMap<String, Object>();
        StudentBean stu = new StudentBean();
        Message msg = new Message();
        msgMap.put("id","123");
        msgMap.put("name","张三");
        msg = mapToBean(msgMap,msg);
        stu.setMessage(msg);
        //stuMap.put("message",msgMap);
        //BeanUtils.populate(stu,stuMap);
        System.out.println(stu.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * bean转Map
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> bean2Map(T bean){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if (bean != null){
                BeanMap beanMap = BeanMap.create(bean);
                map.putAll(beanMap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
