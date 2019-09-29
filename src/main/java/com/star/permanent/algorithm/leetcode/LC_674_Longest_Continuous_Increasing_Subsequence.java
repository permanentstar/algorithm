package com.star.permanent.algorithm.leetcode;

/*
    最长连续递增序列
    给定一个未经排序的整数数组，找到最长且连续的的递增序列。
    Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
    Example 1:
    Input: [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
    Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
    Example 2:
    Input: [2,2,2,2,2]
    Output: 1
    Explanation: The longest continuous increasing subsequence is [2], its length is 1.
    Note: Length of the array will not exceed 10,000.
    https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
* */
public class LC_674_Longest_Continuous_Increasing_Subsequence {
    static int[] nums = {1,3,5,4,7,2,3,4,5};
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length ==0) return 0;
        if (nums.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        int pre = 1;
        for(int i = 1; i<nums.length;++i) {
            if (nums[i] > nums[i-1]) {
                ++ pre;
            } else {
                if (pre > max) {
                    max = pre;
                }
                pre = 1;
            }
        }
        if (pre > max) {
            max = pre;
        }
        return max;
    }
}
