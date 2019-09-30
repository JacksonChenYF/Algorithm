package com.cyf.sort;

/**
 * @Auther: ChenYF
 * @Date: 2019/5/5 15:16
 * @Description: 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N),且要求不能用非基于比较的排序
 * 思路：基于桶排序
 * 设置空桶目的：一个同内部的差值不是最大值；
 * 初始化最小值为系统最大：int min = Integer.MAX_VALUE;
 *
 */
public class MaxGap {
    public static int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //遍历找出数组的最大最小值
        for (int i = 0 ; i < len ; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if (min == max){
            return 0;
        }
        //记录桶的信息
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        //当前数去第几个桶 及 更新信息
        for (int i = 0 ; i < len ; i++){
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len ; i++){
            if (hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    //确定一个数来自第几号桶
    public static int bucket(long num, long len, long min, long max) {
        return (int)((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int test[] = {1,5,9,3,58,6,489,5};
        System.out.println(MaxGap.maxGap(test));
    }
}
