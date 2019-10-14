package com.cyf.sort;

/**
 * 插入排序：（扑克牌排序法：摸到排后自右向左比较排序）
 * 1、原理：第一遍从下标j=1的元素开始跟j-1比较，若arr[j] > arr[j+1]则交换位置，并且j--,
 * 再作比较直到arr[j] <= arr[j+1]
 * 第n遍则直接从j=i-1开始，规则如上。
 * （从第一二元素开始逐渐有序的过程）
 * 时间复杂度：O(n^2);按最坏情况算
 * <p>
 * 练习次数：1->10.14success
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void insertionSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                } else {
                    break;
                }
            }
        }
    }


    //交换i、j元素位置
    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6};
        insertionSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
