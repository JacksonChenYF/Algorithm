package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/8/28 12:25
 * @Description:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],(B中每个位置为不乘自身的数)
 *              其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class 构建乘积数组 {

    public static class Solution {
        public int[] multiply(int[] A) {
            int length = A.length;
            int[] B = new int[length];

            for (int i = 0 , produce = 1 ; i < length ; produce *= A[i], i++ ){
                B[i] = produce;
            }
            for (int i = length - 1 , produce = 1 ; i >= 0 ; produce *= A[i], i--){
                B[i] *= produce;
            }
            return B;
        }
    }

}
