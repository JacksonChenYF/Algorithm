package com.cyf.sort;

/**
 * 选择排序（瘦子在前排序）
 * 1、知识点：三目运算符："min=(a<b)?a:b"即如果a<b为真,则表达式取a值,否则取b值;
 * 2、原理：（1）先遍历第一遍把最小的数排到i=0位置上;
 *          （2）第二次遍历即minIndex=1位置上与后边元素作比较，找出第二小的元素存放；以此类推从小到大排序；
 *          (3)minindex在第一层遍历中与i初始化等于i，在过程中相当一个过程变量，负责找出最小元素，在外遍历最后与i位置交换
 * 3、关键步骤：int minIndex = i ; minIndex = arr[j] < arr[minIndex] ? j : minIndex;
 * 4、时间复杂度：O(n^2);
 */
public class SelectionSort {

    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0 ; i < arr.length - 1 ; i++){
            int minIndex = i ;
            for (int j = i+ 1 ; j < arr.length ; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr , minIndex , i);
        }
    }

    //交换i、j元素位置
    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main (String[] args){
        int[] arr = {3,2,4,5,6};
        selectionSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}


