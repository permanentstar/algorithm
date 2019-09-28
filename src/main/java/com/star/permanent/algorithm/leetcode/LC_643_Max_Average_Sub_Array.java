package com.star.permanent.algorithm.leetcode;
/*
    子数组最大平均数 I
    给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
    Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
    Example 1:
    Input: [1,12,-5,-6,50,3], k = 4
    Output: 12.75
    Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
    Note:
    1 <= k <= n <= 30,000.
    Elements of the given array will be in the range [-10,000, 10,000].
    https://leetcode-cn.com/problems/maximum-average-subarray-i
* */
public class LC_643_Max_Average_Sub_Array {
    static int[] nums = {0,4,0,3,2};
    public static void main(String[] args) {
        System.out.println(findMaxAverage(nums,1));
    }
    /*
    * sum(n) = sum(n-1)-p(n-k)+p(n)
    * 求 max(sum(n))
    * */
    public static double findMaxAverage(int[] nums, int k) {
        int max = 0;
        int pre = 0;
        for(int i=0;i<k;++i) {
            pre += nums[i];
            max = pre;
        }
        for(int i=k;i<nums.length;++i) {
            pre += (nums[i] - nums[i-k]);
            if (pre > max) {
                max = pre;
            }
        }
        return ((double)max) / k;
    }
}
