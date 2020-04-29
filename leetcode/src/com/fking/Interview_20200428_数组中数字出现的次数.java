package com.fking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 限制：
 * 2 <= nums <= 10000
 */
public class Interview_20200428_数组中数字出现的次数 {


    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        System.out.println(singleNumbers(nums));

//        int[] nums2 = new int[]{4,1,4};
//        System.out.println(singleNumbersOne(nums2));
    }

    /**
     * 执行用时 :
     * 2 ms
     * 内存消耗 :
     * 41.5 MB
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            //根据该位置是否为0分成2组
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    /**
     * 如果是只有一个数字出现一次，其他出现2次的情况，则是全员异或一下就行
     * @param nums
     * @return
     */
    public static int[] singleNumbersOne(int[] nums) {
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        return new int[k];
    }

}
