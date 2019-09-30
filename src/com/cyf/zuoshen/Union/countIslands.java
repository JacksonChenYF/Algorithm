package com.cyf.zuoshen.Union;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/13 15:10
 * @Description:岛问题
 * 一个矩阵中只有0和1，每个位置可以和自己的上下左右相连，孤立的1为一个岛，
 * 求一个矩阵中有多少个岛？
 * 解法扩展：多CPU并行处理
 * 切割为多个部分再合起来，主要是边界问题；给岛起名字区分是否连接的是已连接上的岛；
 */
public class countIslands {
    public static int countIslands(int[][] m){
        if (m == null || m[0] == null){
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0 ; i < N ; i ++){
            for (int j = 0 ; j < M ; j ++){
                if (m[i][j] == 1){
                    res++;
                    infect(m,i,j,N,M);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M );
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
    }

}
