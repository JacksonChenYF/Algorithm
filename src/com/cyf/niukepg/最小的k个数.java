package com.cyf.niukepg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: ChenYF
 * @Date: 2019/10/7 16:13
 * @Description:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路：构建一个依次入堆的k个元素大根堆，向下调整（寻找第k小的元素，建立数目为k的最大堆，比堆顶大的元素丢弃，小的替换后重新向下调整堆）
 * <p>
 * compareTo方法: 代表的是指定数如果大于参数的话那么则返回1，实现了comparator中重写compare方法，
 * 如果返回值是正数的话，那么就让第二个参数在前面，如果是负数的话，就让第一个数在前面。
 * 在这个方法中，如果o2大于o1那么返回1，就让o2在前面，就成为了最大堆
 */
public class 最小的k个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (input == null || input.length == 0 || k <= 0) {
            return result;
        }
        if (k > input.length) {
            throw new RuntimeException("k不能大于input数组长度");
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o2.compareTo(o1);
                return o2 - o1;
            }
        });

        for (int anInput : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(anInput);
            } else if (maxHeap.peek() > anInput) {
                maxHeap.poll();
                maxHeap.offer(anInput);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
