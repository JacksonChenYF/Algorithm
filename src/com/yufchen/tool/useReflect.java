package com.yufchen.tool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class useReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //获取TargetObject类的Class对象并且创建TargetObject类实例
        Class<?> targetClass = Class.forName("com.yufchen.tool.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        //获取所有类中所有定义的方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + ' ');
        }
        System.out.println();

        //获取指定方法并调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        System.out.print("获取指定方法（publicMethod）并调用： ");
        publicMethod.invoke(targetObject, "yufchen");

        //获取指定参数并对参数进行修改
        Field field = targetClass.getDeclaredField("value");
        //为了对类中的参数进行修改 取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "Notyufchen");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        //为了调用private方法 取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

    }

}
