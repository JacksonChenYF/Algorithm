package com.cyf.niukepg;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/25 15:35
 * @Description:在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 * Parameters:
 * numbers:输入的数组
 * length:输入数组的长度
 * duplication:返回任意重复的一个，赋值duplication[0]
 * Return value:true if the input is valid, and there are some duplications in the array numberotherwise false
 *
 * 时间复杂度：O（N）、空间复杂度O(1)；
 * 比较、交换属于时间复杂度为0（1）的操作；
 */
public class 数组中重复的数字 {

    public static class Solution {

        public static boolean duplicate(int numbers[],int length,int [] duplication) {

            if (numbers == null || length <= 0){
                return false;
            }

            for (int i = 0 ; i < length ; i ++ ){
                while(numbers[i] != i){
                    if (numbers[i] == numbers[numbers[i]]){
                        duplication[0] = numbers[i];
                        return true;
                    }
                    swap(numbers, i , numbers[i]);
                }
            }
            return false;
        }

        public static void swap(int[] arr, int i , int j){
            int k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,7,8,9,8,4,3,5,6};
        int[] s = new int[2];
        System.out.println(Solution.duplicate(arr,9,s));
        System.out.println(s.toString());
    }
}
