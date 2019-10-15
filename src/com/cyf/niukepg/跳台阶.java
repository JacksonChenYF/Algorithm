package com.cyf.niukepg;

/**
 * @Auther: ChenYF
 * @Date: 2019/5/5 14:42
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 跳台阶 {
    public static int JumpFloor(int target) {

        if (target <= 2) {
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor((target - 2));
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(10));
    }
}
