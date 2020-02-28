package com.fking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 */
public class Algorithm_寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 3},new int[]{2});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums3 = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            nums3.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            nums3.add(nums2[i]);
        }
        Collections.sort(nums3);

        if (nums3.size()%2 == 0){
            return (nums3.get((nums3.size()-1)/2)+nums3.get(nums3.size()/2))/(double)2;
        }else{
            return nums3.get(nums3.size()/2);
        }
    }
}
