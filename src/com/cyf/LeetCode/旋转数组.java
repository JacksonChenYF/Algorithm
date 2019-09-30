package com.cyf.LeetCode;

/**
 * @Auther: ChenYF
 * @Date: 2019/4/16 10:36
 * @Description:给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 */
public class 旋转数组 {
    public static void rotate(int[] nums, int k) {
        /*if (nums == null || nums.length < 2){
            return;
        }
        for (int i = 0 ; i < nums.length ; i++){
            swap(nums,i,(i+k)%nums.length);
        }*/

    }

    public static void swap(int[] nums, int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
     }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotate(nums,1);
        for (int i = 0 ; i < nums.length ; i ++){
            System.out.print(nums[i]);
        }
    }
}
