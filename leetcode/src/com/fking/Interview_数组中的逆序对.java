package com.fking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Interview_数组中的逆序对 {


    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};

        System.out.println(reversePairs(nums));
    }

    /**
     * 归并排序算法
     *
     *执行用时 :
     * 35 ms
     * 内存消耗 :
     * 48.7 MB
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        int len = nums.length;

        //如果是长度小于2则没有逆序对
        if (len < 2) {
            return 0;
        }

        //拷贝数组
        int[] tmpNums = nums.clone();

        //辅助临时数组
        int[] temp = new int[len];
        return reversePairs(tmpNums, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param start
     * @param end
     * @param temp
     * @return
     */
    private static int reversePairs(int[] nums, int start, int end, int[] temp) {

        //数组长度只有1的情况下则没有逆序对
        if (start == end) {
            return 0;
        }

        //中间长度 (left+right)/2会有整型溢出问题
        int mid = start + (end - start) / 2;
        //左边逆序对数量
        int leftPairs = reversePairs(nums, start, mid, temp);
        //右边逆序对数量
        int rightPairs = reversePairs(nums, mid + 1, end, temp);

        //如果是已经有序了则返回左边的+右边的
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        //跨越区间逆序对计算
        int crossPairs = mergeAndCount(nums, start, mid, end, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[start..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param start
     * @param mid
     * @param end
     * @param temp
     * @return
     */
    private static int mergeAndCount(int[] nums, int start, int mid, int end, int[] temp) {

        //拷贝 start到end数组到辅助数组
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        //i, j两位置的第一个元素
        int i = start;
        int j = mid + 1;

        int count = 0;
        for (int k = start; k <= end; k++) {

            if (i == mid + 1) {//当i超出范围[start..mid]，j归并
                nums[k] = temp[j];
                j++;
            } else if (j == end + 1) {//当j超出范围[mid+1..end]，i归并
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {//当i小于J i归并回去
                nums[k] = temp[i];
                i++;
            } else {//当j<i时 j归并回去 并且计数
                nums[k] = temp[j];
                j++;

                //计数
                count += (mid - i + 1);
            }
        }

        return count;
    }
}
