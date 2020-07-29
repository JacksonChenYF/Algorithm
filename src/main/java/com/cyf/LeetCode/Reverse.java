package com.cyf.LeetCode;

/**
 * @Auther: yufchen
 * @Date: 2020/7/24 11:21
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Reverse {
    public int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }
}
