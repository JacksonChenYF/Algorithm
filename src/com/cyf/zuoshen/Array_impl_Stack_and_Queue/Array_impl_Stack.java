package com.cyf.zuoshen.Array_impl_Stack_and_Queue;

import java.util.Arrays;

/**
 * @Auther: ChenYF
 * @Date: 2019/5/16 09:15
 * @Description: 数组实现栈结构
 * 主要实现：
 * index：刚开始为0，表示新进来一个数的位置；
 * 1、查看栈顶元素：arr[index - 1]
 * 2、添加元素：arr[index++] = 新元素
 * 3、弹出元素：arr[--index]
 */
public class Array_impl_Stack {

    public static class ArrayStack{
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        //返回栈顶元素是什么
        public Integer peek(){
            if (index == 0){
                return null;
            }
            return arr[index - 1];
        }

        //把元素推进去
        public void push(int obj){
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++] = obj;
        }

        //弹出栈顶元素【被弹出元素不抹除，如果再添加元素则会覆盖】
        public Integer pop(){
            if(index == 0){
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--index];
        }

        @Override
        public String toString() {
            return "ArrayStack{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.peek();
        arrayStack.push(2);
        arrayStack.pop();
        arrayStack.push(3);
        /*arrayStack.push(1);
        arrayStack.push(1);*/
        //arrayStack.push(1);

        System.out.println(arrayStack);

    }
}
