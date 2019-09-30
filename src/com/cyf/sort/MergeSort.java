package com.cyf.sort;

/**
 * 归并排序：
 * 1、原理：把一个数组分成两部分，分别给两部分排好序（用到后边的排序算法），再两部分第一个元素比较，小的赋予给一个辅助数组，
 * 下标下移到下一个接着比较，以此类推；
 * 注意点：把help数组赋给原数组时，限制条件要用小于help.length；因为只排序到当前help数组中的元素；
 *
 * 时间复杂度O(N*logN),额外空间复杂度O(N);
 * 运行debug解析：0-1，0-1-2，3-4，3-4-5，0-1-2-3-4-5按这些位置比较排序；
 *
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length-1);
    }

    public static void sortProcess(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int mid = (L + R)/2;//L + ((R - L) >> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr, mid+1, R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个范围有且只有一个越界
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        //先分别帮两部分排序，最后比较（先小后大）
        for (i = 0 ; i < help.length ; i++){
            arr[L + i] = help[i];
        }
    }

    public static void main (String[] args){
        //23-235-235 149->
        int[] arr = {3,2,5,4,1,9};
        mergeSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
