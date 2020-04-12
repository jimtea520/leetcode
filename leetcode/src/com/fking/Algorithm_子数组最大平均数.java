package com.fking;

/**
 * @ClassName Algorithm_子数组最大平均数
 * @Description:
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数
 * @Author fking
 * @Date 2020/4/12 0012
 * @Version V1.0
 **/
public class Algorithm_子数组最大平均数 {
    public static void main(String[] args) {
        int[] ints = new int[]{0,4,0,3,2};
        int k = 1;
        System.out.println(findMaxAverage(ints, k));
    }

    /**
     * 执行用时 :2 ms
     * 内存消耗 :43.6 MB
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        for(int i=0;i<k;++i){
            sum+=nums[i];
        }

        //记录第一个i  和  i+k   sum+nums[i+k-1]-nums[i-1];
        int temp=sum;
        for(int i=1;i+k-1<nums.length;++i){
            temp = temp+nums[i+k-1]-nums[i-1];
            if(temp>sum) sum = temp;
        }

        return sum/(double)k;
    }
}
