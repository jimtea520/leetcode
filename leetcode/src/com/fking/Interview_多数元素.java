package com.fking;

import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * @ClassName Interview_多数元素
 * @Description:
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @Author Administrator
 * @Date 2020/3/13 0013
 * @Version V1.0
 **/
public class Interview_多数元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2,2};

        System.out.println(majorityElement2(arr));
    }

    /**
     * map 统计查询
     * 执行用时 : 22 ms
     * 内存消耗 :47.3 MB
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int ret = -1;
        if(nums.length <= 2){
            return nums[0];
        }
        int count = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int mapKey = entry.getKey();
            int mapValue = entry.getValue();
            if (mapValue> count){
                ret = mapKey;
                break;
            }
        }

        return ret;
    }

    /**
     * 单次循环 计数
     * 执行用时 :2 ms
     * 内存消耗 :41.6 MB
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {

        int ret = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (ret == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if (0 == cnt) {
                    ret = nums[i];
                    cnt = 1;
                }
            }
        }

        return ret;
    }

    /**
     * 使用自带的排序
     * 执行用时 :2 ms
     * 内存消耗 :42.2 MB
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
