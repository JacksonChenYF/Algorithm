package com.cyf.sort;

/**
 *   冒泡排序（抓胖子排序）
 *   1、原理：每次遍历比对相邻元素，把大的交换到后边，以此类推，第一遍把max放到最后；
 *   		第二次遍历，只需重复第一步，但只需遍历到length-1位元素；
 *   	    重复到大于0的索引位置，即得到一个从小到大的数组。
 *     2、注意：（1）、arr.length < 2；
 *              （2）、两个遍历，一个是遍历数组每次减去最大的(设置一个end变量从length-1)，一个是遍历比较；
 *     3、时间复杂度：O(n^2);<n,n-1,...,1,是一个等差数列>
 *
 *
 * 练习次数：1->10.9success 2- 10.24success
 */
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int end = arr.length - 1 ; end > 0 ; end--) {
            for(int i = 0 ; i < end ; i++) {
                if(arr[i] > arr[i+1] ) {
                    swap(arr, i, i+1);
                }
            }
        }
    }

    public void bubbleSort1(int[] arr){
        if (arr ==null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1; end > 0 ; end --){
            for (int i = 0 ; i < end ; i ++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public void bubbleSort2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1 ; end > 0 ; end --){
            for (int i = 0 ; i < end ; i ++){
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }

    //交换元素位置
    public void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

/*cyf    public static void maopao(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1 ; end > 0 ; end--){
            for (int i = 0 ; i < end ; i++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }*/







/*cyf    public static void maopao(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1 ; end > 0 ; end --){
            for (int i = 0 ; i < end ; i ++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }*/

    public static void main (String[] args){
        int[] arr = {3,2,4,5,6};
        //bubbleSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }


}