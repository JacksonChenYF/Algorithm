package com.cyf.LeetCode;

import java.util.Arrays;

/**
 * @Auther: ChenYF
 * @Date: 2019/4/14 22:16
 * @Description:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 我的思路：先排序，再依次比较相邻的元素；
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0 ; i < nums.length - 2 ; i++){
        if (nums[i] == nums[i+1]){
            i++;
        }
        else {
            return nums[i];
        }
    }
    return nums[nums.length - 1];
    }

    //Leetcode解答
    /*public static int singleNumber(int[] nums) {
        //使用异或运算似的出现偶数次数的数组元素消除。
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            result=result^nums[i];
        }
        return result;

    }*/

    public static void main(String[] args) {
        int[] arr = {7,8,7,8,9,10,10};
        System.out.println(singleNumber(arr));
        /*for (int i = 0 ; i <arr.length - 1 ; i++){
            System.out.println(arr[i]);
        }*/
    }
}
