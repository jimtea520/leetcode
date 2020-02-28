package com.fking;

import java.util.*;

/**
 * 数组中重复的数字:
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了.
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字.
 */
public class Interview_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println( findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int  num = nums[i];
            arr[num]++;
            if(arr[num] > 1) return num;
        }
        return -1;
    }
}
