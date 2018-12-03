package com.spring.demo01.service.util;

import org.json.JSONObject;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class JsonUtil {


   /* public static <T> T jsonToBean(JSONObject jsonObject, Class<T> cla) throws ReflectiveOperationException, IllegalArgumentException, IntrospectionException {
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
        }
        return t;
    }
*/

}
