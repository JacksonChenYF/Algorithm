package com.cyf.LeetCode;

/**
 * @Auther: yufchen
 * @Date: 2020/7/24 09:57
 * @Description: 加一：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部为9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

}
