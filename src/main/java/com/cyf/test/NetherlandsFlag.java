package com.cyf.test;

/**快速排序简单化
 * 荷兰国旗问题：给定一个数组和一个num，若比num小，则放到左边；等于则中间；大则右边；
 * 原理：在数组左边定义一个less=数组起点-1，右边定义more=数组尾+1；
 * 从第一个元素开始比较，若小则与less+1位置交换元素，此时需把比较元素移到下一位L++（因为左边的元素已经比较过无需再次比较）
 * 若大则与--more交换位置，因此位置还没比较过，故返回 原位置L，再次比较；
 */
public class NetherlandsFlag {

    public static int[] partition(int[] arr, int L ,int R, int num){
        int less = L - 1;
        int more = R + 1;
        while (L < more){
            if(arr[L] < num){
                swap(arr,L++,++less);
            }else if (arr[L] > num){
                swap(arr,L,--more);
            }else{
                L++;
            }
        }
        return new int[]{ less + 1 , more - 1};
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,5};
        partition(arr,0,4,3);
        for (int i = 0 ; i < arr.length ; i++){
        System.out.println(arr[i]);
        }
    }
}
