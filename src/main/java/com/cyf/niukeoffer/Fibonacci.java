package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/21 10:18
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<= 39
 *  // 斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 */
public class Fibonacci {
    public int fibonacci(int n) {
        //公式法：时间复杂度O^2N
        /* if(n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);*/

        int tem[] = new int[40];
        tem[0] = 0;
        tem[1] = 1;
        for (int i = 2; i < 40; i++) {
            tem[i] = tem[i - 1] + tem[i - 2];
        }
        return tem[n];
    }
}
