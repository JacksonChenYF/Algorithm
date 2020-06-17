package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/8 14:26
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及
 * 条件判断语句（A?B:C）。
 */
public class Sum_Solution {

    /**
     * 动态规划, 辅助数组
     */
    int[] help = new int[1024];
    public Sum_Solution(){
        for (int i = 0 ; i < help.length ; i ++){
            help[i] = -1;
        }
    }

    public int sum_Solution(int n) {
        if (n == 1) {
            return n;
        }
        if (help[n] != -1) {
            return help[n];
        }
        help[n] = n + sum_Solution(n - 1);
        return help[n];
    }

    /**
     * 1.需利用逻辑与的短路特性实现递归终止。
     * 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
     * @param n
     * @return
     */
    public int sum_Solution1(int n) {
        return n > 0?sum_Solution1(n-1)+n:0;
    }

}
