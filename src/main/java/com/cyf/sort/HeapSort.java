package com.cyf.sort;

/**
 *堆排序:
 * (1)heapInsert(int[] arr, int index)；作用：把数组调整为大根堆（把插入index位置的元素重新调整为大根堆）；
 *  原理：index位置的元素与它的父节点(index-1)/2位置上的元素比较，若大于则交换位置，然后把重新调整index，再作比较；
 *          小于则插入元素成功；  技巧;当index=0 时，(index-1)/2=0，则跳出循环；
 *（2）heapify(int[] arr,int index,int heapSize)；作用：index位置上的元素变小了，导致不是大根堆，可heapify为大根堆；
 *  原理： heapSize为数组数组长度：比较看看是否越界，只要<heapSize则不越界；left = index * 2 + 1，为index左节点,left+1:右节点；
 *          先找出左右节点的大值，再与index位置作比较，若index比较大则break; 否则交换index位置，并调整index，再与重复以上与其下左右子树比较；
 *
 *  堆排序原理：第一步，调用heapInsert，把数组调整为大根堆；接着交换0位置（最大值）与--heapSize(最后一位元素)，弹出--heapSize,
 *          并将新的0位置的数传入heapify过程，重构大根堆，重复以上过程，直到heapSize=0，跳出循环；
 *
 * 注意点：1、双目运算符顺序不能颠倒，因为除了比较大小，这个left + 1 < heapSize不成立的话得直接返回largest = left
 * 2、判断条件记得加上
 *          时间复杂度：O(N*logN),额外空间复杂度O(1);
 * @author Taylove
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0 ; i < arr.length ; i ++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index = (index - 1)/2;
        }
    }

    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left +1
                    : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main (String[] args){
        int[] arr = {3,2,4,5,6};
        heapSort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
