package com.cyf.niukepg;

import java.util.Arrays;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/29 19:18
 * @Description:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 *
 * 解法：数组排序后，如果符合条件的数存在，则一定是数组中间那个数。
 */
public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length / 2]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return array[array.length / 2];
        } else {
            return 0;
        }

    }

}
