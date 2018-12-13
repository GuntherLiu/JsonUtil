package com.spring.demo01.service.util;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;
import org.json.JSONArray;
import org.json.JSONObject;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JsonUtil {


  public static <T> T jsonToBean(JSONObject jsonObject, Class<T> clazz) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {

      Field[] fields = clazz.getDeclaredFields();
      T t = clazz.newInstance();
      Iterator<String> keys = jsonObject.keys();

      // 首先遍历 JSONObject
      while (keys.hasNext()){
          String key = keys.next();
          Object value = jsonObject.get(key);

          // value 为基本数据类型, 或者String类型
          if(isPrimitive(value.getClass()) || value.getClass().equals(String.class)){
              // 遍历bean的所有字段
              for( int i = 0; i < fields.length;i++){
                 if (key.equals(fields[i].getAnnotation(DemoEnum1.class).value())){
                     PropertyDescriptor pd = new PropertyDescriptor(fields[i].getName(), clazz);
                     Method pdWriteMethod = pd.getWriteMethod();
                     pdWriteMethod.invoke(t,value);
                     break;
                 }
              }
          }else if(value.getClass().equals(JSONObject.class)){    //  value 为 Bean 类型
              for( int i = 0; i < fields.length;i++){
                  if (key.equals(fields[i].getAnnotation(DemoEnum1.class).value())){
                      Class<?> fieldClass = fields[i].getType();
                      Object fieldObj = jsonToBean((JSONObject) value, fieldClass);
                      PropertyDescriptor pd = new PropertyDescriptor(fields[i].getName(), clazz);
                      Method pdWriteMethod = pd.getWriteMethod();
                      pdWriteMethod.invoke(t,fieldObj);
                      break;
                  }
              }

          }else if(value.getClass().equals(JSONArray.class)){     // value 为 Array类型
              for( int i = 0; i < fields.length;i++){
                  if (key.equals(fields[i].getAnnotation(DemoEnum1.class).value())){
                      JSONArray array = (JSONArray) value;

                      List<Object> fieldObj = new ArrayList<Object>();
                      Type genericType = fields[i].getGenericType();
                      Class<?> actualType = null;

                      if (genericType instanceof ParameterizedType) {
                          ParameterizedType paGenericType = (ParameterizedType)genericType;
                          Type[] actualTypeArguments = paGenericType.getActualTypeArguments();
                          actualType = (Class<?>) actualTypeArguments[0];

                          if(isPrimitive(actualType) || actualType.equals(String.class)){
                              for (int j =0; j < array.length(); j++) {
                                  fieldObj.add(array.get(j));
                              }
                          }else{
                              for (int j =0; j < array.length(); j++) {
                                  fieldObj.add(jsonToBean((JSONObject) array.getJSONObject(j),actualType));
                              }
                          }
                      }

                      PropertyDescriptor pd = new PropertyDescriptor(fields[i].getName(), clazz);
                      Method pdWriteMethod = pd.getWriteMethod();
                      pdWriteMethod.invoke(t,fieldObj);
                      break;
                  }
              }
          }
      }
      return t;

    }

    // 判断是否为基本数据类型，或者是基本数据类型包装类型
    public static boolean isPrimitive(Class clazz){
        if(clazz.equals(Integer.class) || clazz.equals(Float.class) || clazz.equals(Long.class) || clazz.equals(Short.class)
                || clazz.equals(Byte.class) || clazz.equals(Character.class) || clazz.equals(Double.class) || clazz.equals(Boolean.class))
            return true;
        return false;

    }

}
