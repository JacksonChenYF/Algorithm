package com.cyf.LeetCode;

/**
 * @Auther: ChenYF
 * @Date: 2019/4/16 09:50
 * @Description:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class 反转字符串 {

/*    public static void reverseString(char[] s) {
        if (s.length < 2){
            return;
        }else if(s.length%2 == 1){
            int k = s.length - 1;
            for (int i = 0 ; i < s.length / 2 ; i ++){
            swap(s,i,k);
            k--;
        }
        }else {
            int k = s.length - 1;
            for (int i = 0 ; i < s.length / 2 ; i ++){
                swap(s,i,k);
                k--;
            }
        }
    }
    public static void swap(char[] s, int i , int j){
        char tem = s[i];
        s[i] = s[j];
        s[j] = tem;
    }*/

    public static void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        //
        char[] a = {};
        System.out.println(a.length%2 == 1);
        reverseString(a);
        System.out.println(a);
    }
}
