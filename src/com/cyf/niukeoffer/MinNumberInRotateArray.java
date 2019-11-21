package com.cyf.niukeoffer;

/**
 * @Auther: ChenYF
 * @Date: 2019/11/21 09:51
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * <p>
 * /**二分法
 * 1、array[mid] > array[high];//此时最小值一定在右边
 * 2、array[mid] == array[high]；//array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，只能排查最右不是最小
 * 3、array[mid] < array[high]；//此时排查最小在左边或mid
 * 链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?f=discussion
 * 来源：牛客网
 * <p>
 * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
 * 比如 array = [4,6]
 * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
 * 如果high = mid - 1，就会产生错误， 因此high = mid
 */


public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high = high - 1;
            }
        }
        return array[low];
    }

}
