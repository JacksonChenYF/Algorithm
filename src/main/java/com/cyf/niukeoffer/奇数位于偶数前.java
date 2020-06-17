package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/23 14:18
 * @Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分， 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 思路：冒泡排序，当前一个数是偶数后一个数是奇数时则交换
 * <p>
 * 12345336667
 * 12345336676
 * 12345337666
 * 12354337666
 */
public class 奇数位于偶数前 {

    public static class Solution {
        public void reOrderArray(int[] array) {

            for (int i = 0; i < array.length; i++) {
                for (int j = array.length - 1; j > i; j--) {
                    if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                        swap(array, j, j - 1);
                    }
                }
            }

            //插入排序思想
            for (int i = 1; i < array.length; i++) {
                int target = array[i];
                if (array[i] % 2 == 1) {
                    int j = i;
                    while (j >= 1 && array[j - 1] % 2 == 0) {
                        array[j] = array[j - 1];
                        j--;
                    }
                    array[j] = target;
                }
            }

        }

        public void swap(int[] arr, int i, int j) {
            int tem = arr[i];
            arr[i] = arr[j];
            arr[j] = tem;
        }

    }

}
