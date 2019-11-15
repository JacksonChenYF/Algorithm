package com.cyf.LeetCode;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/16 09:02
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 每次进行取余操作 （ %10），取出最低的数字：y = x % 10
 * 将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
 * 每取一个最低位数字，x 都要自除以 10
 * 判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
 * 最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
 *

 */
public class 回文数 {

    public boolean isPalindrome1(int x) {
        if (x == 0) {
            return true;
        }
        String str = "" + x;
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        /**
         *  // 特殊情况：
         *         // 如上所述，当 x < 0 时，x 不是回文数。
         *         // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
         *         // 则其第一位数字也应该是 0
         *         // 只有 0 满足这一属性
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        /**
         * 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
         */
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        /**
         *  // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
         *         // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
         *         // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
         */
        return x == revertedNumber || x == revertedNumber / 10;

    }

}
