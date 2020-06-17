package com.cyf.niukeoffer;

import java.util.ArrayList;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/30 11:43
 * @Description:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 思考：1.10
 */
public class PrintMatrix {

    /**
     * 从外到里打印
     * 边界
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        int rowIndex = matrix.length - 1;    //行下标
        int colIndex = matrix[0].length - 1;      //列下标

        int r = 0, c = 0;  //指针
        ArrayList<Integer> result = new ArrayList<>();  //返回值
        while ((r <= rowIndex) && (c <= colIndex)) {    //确定要绕着转几圈
            getResult(r++, c++, rowIndex--, colIndex--, result, matrix);
        }
        return result;
    }

    /**
     * 打印过程（转圈过程）
     *
     * @param r
     * @param c
     * @param rowIndex
     * @param colIndex
     * @param result
     * @param matrix
     */
    private void getResult(int r, int c, int rowIndex, int colIndex, ArrayList<Integer> result, int[][] matrix) {
        if (r == rowIndex) {
            for (; c <= colIndex; ++c) {
                result.add(matrix[r][c]);
            }
        } else if (c == colIndex) {
            for (; r <= rowIndex; ++r) {
                result.add(matrix[r][c]);
            }
        } else {
            int curHang = r;  //行
            int curLie = c;   //列
            while (curHang != colIndex) {
                result.add(matrix[curLie][curHang++]);
            }
            while (curLie != rowIndex) {
                result.add(matrix[curLie++][curHang]);
            }
            while (curHang != r) {
                result.add(matrix[curLie][curHang--]);
            }
            while (curLie != c) {
                result.add(matrix[curLie--][curHang]);
            }
        }
    }
}
