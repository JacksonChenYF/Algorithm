package com.cyf.LeetCode;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 思路：插入排序；把num2元素依次添加到num1末尾并向左比较，所小于则交换元素后继续比较，否则跳出循环break；
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //遍历nums2
        for(int i = 0 ; i < n ; i ++){
            //依次将num2的元素添加到num1的末尾
            nums1[m+i] = nums2[i];

/*            //遍历num1
            for(int j = m + i - 1 ; j >= 0 ; j--){
                if(nums1[j] > nums1[j+1]){
                    swap(nums1,j,j+1);
                }
                else break;
            }*/
            //简化上一步
            for (int j = m + i - 1 ; j >= 0 && nums1[j] > nums1[j+1] ; j --){
                swap(nums1,j,j+1);
            }

        }
    }

    //交换i、j元素位置
    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args){
    int[] arr1=new int[8];
    arr1[0]=5;
    arr1[1]=8;
    int[] arr2={1,5,6,9,10};
    merge(arr1,2,arr2,5);
    for(int i = 0;i < arr1.length - 1 ;i++){
        System.out.println(arr1[i]);
    }
    }


}
