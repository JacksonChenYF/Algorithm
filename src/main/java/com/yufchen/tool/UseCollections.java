package com.yufchen.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Auther: yufchen
 * @Date: 2020/6
 * @Description:
 */
public class UseCollections {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 28, 6));
        System.out.println("原始数组： " + arrayList);

        Collections.reverse(arrayList);
        System.out.println("使用reverse()反转数组： " + arrayList);

        Collections.rotate(arrayList, 4);
        System.out.println("使用rotate旋转数组: " + arrayList);

        Collections.sort(arrayList);
        System.out.println("使用sort排序 :" + arrayList);

        Collections.shuffle(arrayList);
        System.out.println("使用shuffle()随机排序:" + arrayList);

        Collections.swap(arrayList, 2, 4);
        System.out.println("使用swap()交换:" + arrayList);

        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：" + arrayList);

        System.out.println("使用max():" + Collections.max(arrayList));
        System.out.println("使用min():" + Collections.min(arrayList));

        Collections.replaceAll(arrayList, 3, -3);
        System.out.println("使用replaceAll将3全部替换为-3：" + arrayList);

        System.out.println("使用frequency统计-3出现次数：" + Collections.frequency(arrayList, -3));

        ArrayList arrayList2 = new ArrayList<Integer>(Arrays.asList(5, -3));
        System.out.println("统计2在1出现的位置： " + Collections.indexOfSubList(arrayList, arrayList2));

        Collections.sort(arrayList);
        System.out.println("二分查找返回索引，需有序：" + Collections.binarySearch(arrayList, 5));

    }
}
