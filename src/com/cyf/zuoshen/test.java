package com.cyf.zuoshen;

/**
 * @Auther: ChenYF
 * @Date: 2019/6/7 09:59
 * @Description:
 */
public class test {
    public Integer[] arr;
    public test(int s){
        arr = new Integer[s];
    }

    public static void main(String[] args) {
        test t = new test(5);
        System.out.println(t.arr.length);
        System.out.println(t.arr[5]);
    }
}
