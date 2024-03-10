package com.example.prompt.Util;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 * 用于PO和VO转换的Util
 */
public class CustomerConvert {
    public static Object convert(Object obj, Class clazz) throws Exception {
        Object targetObj = clazz.getDeclaredConstructor().newInstance();
        Class<?> originClass = obj.getClass();
        Field[] fields = originClass.getDeclaredFields();

        for (Field field : fields) {
            if(notValidField(field) || isStaticModifier(field)) {
                continue;
            }
            field.setAccessible(true);
            Object fileAtr = field.get(obj);

            Field field1 = clazz.getDeclaredField(field.getName());
            if(notValidField(field1)) {
                continue;
            }
            field1.setAccessible(true);
            field1.set(targetObj,fileAtr);
        }

        return targetObj;
    }

    private static boolean notValidField(Field field) {
        return Objects.isNull(field);
    }

    private static boolean isStaticModifier(Field field) {
        return Modifier.isStatic(field.getModifiers());
    }
}


