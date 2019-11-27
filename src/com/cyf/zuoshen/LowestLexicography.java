package com.cyf.zuoshen;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/27 21:33
 * @Description: 最小词典算法 ： “fbc”、“bcd”、“f” -> bcdfbcf
 */
public class LowestLexicography {

    //自定义比较器：要拼接后比较；eg：fbcf < ffbc
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));

    }

}
