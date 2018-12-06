package com.spring.demo01.service.util;

import com.spring.demo01.domain.DemoEnum.DemoEnum1;
import org.json.JSONArray;
import org.json.JSONObject;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;


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
                      Iterator<Object> objs = array.iterator();
                      while (objs.hasNext()){


                      }



                      Class<?> fieldClass = fields[i].getType();
                      Object fieldObj = jsonToBean((JSONObject) value, fieldClass);
                      PropertyDescriptor pd = new PropertyDescriptor(fields[i].getName(), clazz);
                      Method pdWriteMethod = pd.getWriteMethod();
                      pdWriteMethod.invoke(t,fieldObj);
                      break;
                  }
              }



          }
      }
      return t;

      /*
      if(jsonObject == null || jsonObject.isEmpty())
            return null;

        T t = cla.newInstance();
        Field[] fields = cla.getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();


            JsonElement je = getValueByPath(jsonObject, fieldName);


            if (je != null && !je.isJsonNull()) {
                PropertyDescriptor pd = new PropertyDescriptor(fieldName, cla);

                Method method = pd.getWriteMethod();
                if (method != null) {
                    Class<?> fieldType = field.getType();

                    if (fieldType.isPrimitive()) {
                        // 如果是基本类型或是其封装类型
                        method.invoke(t, toPrimitive(je, fieldType));
                    } else if (fieldType.isEnum()) {
                        // 如果是枚举类型
                    } else if (fieldType.isArray()) {
                        // 如果是数组
                    } else if (Collection.class.isAssignableFrom(fieldType) && je.isJsonArray()) {
                        // 如果是Collection数组
                        ParameterizedType type = (ParameterizedType) field.getGenericType();
                        method.invoke(t, toCollection(je.getAsJsonArray(), (Class<?>) type.getActualTypeArguments()[0]));
                    } else if (fieldType.isInterface() || fieldType.isAnnotation() || fieldType.isAnonymousClass() || fieldType.isMemberClass() || fieldType.isLocalClass()) {
                        // 如果是 接口 或者是 注解 或者是 匿名类 或者是成员类 局部类
                    } else if (je.isJsonObject()) {
                        method.invoke(t, toBean(je.getAsJsonObject(), fieldType));
                    }
                }
            }
        }*/


    }

    // 判断是否为基本数据类型，或者是基本数据类型包装类型
    public static boolean isPrimitive(Class clazz){
        if(clazz.equals(Integer.class) || clazz.equals(Float.class) || clazz.equals(Long.class) || clazz.equals(Short.class)
                || clazz.equals(Byte.class) || clazz.equals(Character.class) || clazz.equals(Double.class) || clazz.equals(Boolean.class))
            return true;
        return false;

    }



}
