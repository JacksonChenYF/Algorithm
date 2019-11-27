package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/27 10:34
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {

    /**
     * 丑数的定义是1或者因子只有2 3 5，可推出丑数=丑数*丑数，假定丑数有序序列为：a1,a2,a3.......an
     * 所以可以将以上序列（a1除外）可以分成3类，必定满足：
     * 包含2的有序丑数序列：2*a1, 2*a2, 2*a3 .....
     * 包含3的有序丑数序列：3*a1, 3*a2, 3*a3 .....
     * 包含5的有序丑数序列：5*a1, 5*a2, 5*a3 .....
     * 以上3个序列的个数总数和为n个，而且已知a1 = 1了，将以上三个序列合并成一个有序序列即可
     * 程序中t2,t3,t5实际就是合并过程中三个序列中带排序的字段索引
     * <p>
     * 感觉厉害的地方在于根据已知求到结果，再把这个结果当成已知，求下一个结果。。直到目标结果出现
     *
     * @param index
     * @return
     */
    public int getUglyNumber_Solution(int index) {

        if (index < 0) {
            throw new RuntimeException("参数错误");
        }
        if (index <= 6) {
            return index;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; i++) {
            arr[i] = Math.min(arr[index2] * 2, Math.min(arr[index3] * 3, arr[index5] * 5));
            if (arr[i] == arr[index2] * 2) {
                index2++;
            }
            if (arr[i] == arr[index3] * 3) {
                index3++;
            }
            if (arr[i] == arr[index5] * 5) {
                index5++;
            }
        }
        return arr[index - 1];

    }

}
