package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/30 11:11
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Power {

    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     *
     * 13的二进制是1101，第一次右移得110，第二次右移是11，第三次是1，第四次是0，即最右边一位移掉，最左边移进来的位补零；exponent&1是exponent的最后一位与1相与，整体运算结果相当于把exponent的二进制反转
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        int n;
        double res = 1, curr = base;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            if (base == 0)
                throw new RuntimeException("");
            n = -exponent;
        } else {
            return 1;
        }

        //这部分其实就是一个降幂运算，比如2的4次方等于2的2次方的平方，但是如果是2的5次方呢，那当然是先5-1=4再进行上述操作了，而5-1就体现在(exponent&1)==1这一步骤了。
        while (n != 0) {
            if ((n & 1) == 1)
                res *= curr;
            curr *= curr;//翻倍
            n >>= 1;//右移一位
        }
        return exponent >= 0 ? res : (1 / res);
    }

}
