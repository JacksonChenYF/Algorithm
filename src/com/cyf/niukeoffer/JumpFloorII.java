package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/22 10:15
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    public int jumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        return 2 * jumpFloorII(target - 1);
    }

}
