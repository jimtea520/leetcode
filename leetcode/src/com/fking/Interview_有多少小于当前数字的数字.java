package com.fking;

import java.util.*;

/**
 * 整数反转
 *
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class Interview_有多少小于当前数字的数字 {


    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,2,3};

        System.out.println(smallerNumbersThanCurrent(nums));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] rets =  new int[nums.length];
        int[] copys = nums.clone();
        Map<Integer,Integer> maps = new HashMap<>(nums.length);
        Arrays.sort(copys);
        for (int i = copys.length-1; i >= 0; i--) {
            int num = copys[i];
            if (maps.containsKey(num)){
                continue;
            }
            int count = 0;
            for (int j = i; j >=0; j--) {
                if (num > copys[j]){
                    count++;
                }
            }
            maps.put(num,count);
        }

        if (!maps.values().isEmpty()) {
            for (int i = 0; i < nums.length; i++) {
                rets[i] = maps.get(nums[i]) ;
            }
        }

        return rets;
    }
}
