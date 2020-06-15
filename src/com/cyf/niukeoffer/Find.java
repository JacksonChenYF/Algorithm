package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/22 12:32
 * @Description:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * <p>
 * 思路：观察找出特殊点（即该点（同一行最大&&同一列最小 或者 同一列最大，同一行最小））
 * 设置指针指示当前元素位置，判断后决定向那个方向移动
 * 时间复杂度O（M+N）:即走到对角线
 * <p>
 * 练习：11.18：边界没把握好（记好是列数与下标）；1.9: 成功 ; 6.15: 算法有点生疏了
 */
public class Find {
    public static class Solution {
        public boolean Find(int target, int[][] array) {
            if (array == null || array.length == 0 || array[0].length == 0) {
                return false;
            }

            int rows = array.length;//行数
            int cols = array[0].length;//列数

            //指针[下标]  左下角点
            int r = rows - 1;
            int c = 0;

            while (r >= 0 && c < cols) {
                if (target == array[r][c]) {
                    return true;
                } else if (target > array[r][c]) {
                    c++;
                } else {
                    r--;
                }
            }
            return false;
        }

        public boolean findOut(int target, int[][] array) {

            if (array != null) {
                int rows = array.length;        //行数
                int cols = array[0].length;     //列数

                int r = rows - 1;   //最后一行
                int c = 0;          //第一列

                while (r >= 0 && c < cols) {    //c 是小于不是小于或等于
                    if (target > array[r][c]) {
                        c++;
                    } else if (target < array[r][c]) {
                        r--;
                    } else
                        return true;
                }
            }

            return false;
        }

    }
}
