package com.cyf.test;

/**
 * 递归实验 还有amend！还想修改
 */
public class GetMax {

    public static int getMax(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int mid = (L + R)/2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid+1,R);
        return  Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args){
        int[] arr = {4,3,2,1};
        System.out.println(getMax(arr,0,arr.length-1));
        char b = 'b';
        System.out.println(b - 'a');
    }
}
