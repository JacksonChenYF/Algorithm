package com.cyf.LeetCode;

import java.util.Arrays;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/28 10:35
 * @Description: 567、字符串排序
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {

    /**
     * 滑动窗口解法：
     * 找s1的排列，意味着s1中的字符必须排在一起，只是顺序上不同。
     * 以s1的长度为一个窗口H，统计各个字符的个数。
     * 在s2中，从左向右移动与s1等长的窗口W，统计窗口W中的字符数。比较H与W。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();//边界
        int[] c1 = new int[26];
        int[] c2 = new int[26];//26：因为[a--z] - a 范围{0-25}，所以数组长度=26
        //遍历s1,为有值的位置+1； eg：c = b | c1[1] = 1; c = c | c1[2] = 1;
        for (char c : s1.toCharArray())
            c1[c - 'a']++;

        for (int i = 0; i < len2; i++) {
            if (i >= len1)
                --c2[s2.charAt(i - len1) - 'a'];//先把坐标查过的减去
            c2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(c1, c2))//false的话是进入判断条件
                return true;
        }
        return false;

    }

}
