package com.cyf.LeetCode;

import java.util.Arrays;

public class ContainsDuplicate {
        public boolean containsDuplicate(int[] nums) {

            Arrays.sort(nums);
            for (int i = 1 ; i < nums.length ; i++) {
                if (nums[i - 1] == nums[i])
                    return true;
            }
            return false;


            // if(nums.length < 2){
            //     return false;
            // }
            // for(int i = 0 ; i < nums.length - 1 ; i++){
            //     for(int j = i +1 ; j < nums.length ; j++){
            //         if(nums[i] == nums[j]){
            //             return true;
            //         }
            //     }
            // }
            // return false;
        }
}
