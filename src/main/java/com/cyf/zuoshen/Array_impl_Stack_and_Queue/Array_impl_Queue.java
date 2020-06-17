package com.cyf.zuoshen.Array_impl_Stack_and_Queue;

/**
 * @Auther: ChenYF
 * @Date: 2019/6/7 09:49
 * @Description: 数组实现队列:start：记录第一个元素；end：添加元素位置；size：记录元素个数
 * 1、添加元素：end = end == arr.length - 1 ? 0 : end + 1;
 * 2、出元素：int tmp = start; //最后一步才return
 *         start = start == arr.length - 1 ? 0 : start + 1;
 *         return arr[tmp];
 */
public class Array_impl_Queue {
    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public Array_impl_Queue(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0 ;
        start = 0 ;
        end = 0;
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[start];
    }

    public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size++;
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer poll(){
        if (size == 0){
            throw new IllegalArgumentException("the queue is empty !");
        }
        size--;
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[tmp];
    }

}
