package com.fking;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Interview_20200503_最大子序和 {


    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(nums));
//        System.out.println(maxSubArray2(nums));
//        System.out.println(maxSubArray3(nums));

        System.out.println(maxSubArray4(nums));
    }

    /**
     * 暴力法
     *执行用时 :
     * 122 ms
     * 内存消耗 :
     * 39.9 MB
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int maxSun = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int iNum = nums[i];
            if (maxSun < iNum) {
                maxSun = iNum;
            }
            if (i < nums.length-1) {
                for (int j = i+1; j < nums.length; j++) {
                    iNum += nums[j];
                    if (maxSun < iNum) {
                        maxSun = iNum;
                    }
                }
            }
        }
        
        return maxSun;
    }

    /**
     * 动态规划
     * 执行用时 :
     * 1 ms
     * 内存消耗 :
     * 39.9 MB
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int preSum = 0;//前面的和
        int maxSum = nums[0];//最大和
        for (int i = 0; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, preSum);
            System.out.println("i:"+i+",nums[i]"+nums[i]+",preSum:" + preSum + ",maxSum:"+maxSum);
        }

        return maxSum;
    }

    /**
     *  分治法
     * 执行用时 :
     * 2 ms
     *内存消耗 :
     * 39.8 MB
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
        int result = Integer.MIN_VALUE;
        int numsSize = nums.length;
        result = maxSubArrayHelper(nums, 0, numsSize - 1);
        return result;
    }
    private static int maxSubArrayHelper(int[] nums, int left, int right)
    {
        if (left == right)
        {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayHelper(nums, left, mid);
        //注意这里应是mid + 1，否则left + 1 = right时，会无线循环
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int midSum = findMaxCrossingSubarray(nums, left, mid, right);
        int result = Math.max(leftSum, rightSum);
        result = Math.max(result, midSum);
        return result;
    }

    private static int findMaxCrossingSubarray(int[] nums, int left, int mid, int right)
    {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--)
        {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        //注意这里i = mid + 1，避免重复用到nums[i]
        for (int i = mid + 1; i <= right; i++)
        {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return (leftSum + rightSum);
    }

    /**
     * 贪心算法
     * 执行用时 :
     * 1 ms
     * 内存消耗 :
     * 39.8 MB
     * @param nums
     * @return
     */
    private  static int maxSubArray4(int[] nums){
        //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
        int result = Integer.MIN_VALUE;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++)
        {
            sum += nums[i];
            result = Math.max(result, sum);
            //如果sum < 0，重新开始找子序串
            if (sum < 0)
            {
                sum = 0;
            }
        }

        return result;

    }
}

