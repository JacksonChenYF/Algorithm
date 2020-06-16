package com.yufchen.tool;

/**
 * 供com.yufchen.tool.useReflect测试反射机制用
 */
public class TargetObject {

    private String value;

    public TargetObject() {
        value = "yufchen";
    }

    public void publicMethod(String s) {
        System.out.println("I am " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
