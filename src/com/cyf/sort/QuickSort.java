package com.cyf.sort;

/**
 * 快速排序（优化版）：
 * 原理：从第一个元素开始与数组最后元素一个元素作比较，
 * 若小于则与++less位置交换元素，此时需把比较元素移到下一位L++（因为左边的元素已经比较过无需再次比较）
 * 若大于则与--more【倒数第二个元素】（more初始值为最后元素的位置）交换位置，因此位置还没比较过，故返回 原位置L，再次比较；
 * #因为要排序因此需要用到递归，先排一次后，递归左边，再递归右边；
 * 关键代码：1、p[0] - 1、p[1] + 1：partition函数返回的是一个2个元素数组，储存的第一个是与最后一个元素相等的第一个元素，
 * 第二个是与最后一个元素相等的最后一个元素；
 * 2、32行 swap(arr,more,R)：循环结束后more指示的是与相等元素右相邻的第一个元素，交换后达到把比较的元素拯救出来的效果；
 * 时间复杂度：O(N*logN),额外时间复杂度O(logN）；
 * <p>
 * 稳定性：很难，论文级别，不讨论
 */
public class QuickSort {
    public static void quickSort(int[] arr, int L, int R) {
        //L = R:即没有等于范围，直接返回；
        if (L < R) {
            //swap(arr,L + (int)(Math.random()*(R - L + 1)),R);//随机快排
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //第一次
    public static void quickSort1(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = partition1(arr, L, R);
            quickSort1(arr, L, p[0] - 1);
            quickSort1(arr, p[1] + 1, R);
        }
    }

    private static int[] partition1(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void quickSort2(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = partition2(arr, L, R);
            quickSort2(arr, L, p[0] - 1);
            quickSort2(arr, p[1] + 1, R);
        }
    }

    private static int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        quickSort(arr, 0, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
