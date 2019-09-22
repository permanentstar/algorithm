package com.star.permanent.algorithm.leetcode;

/*
    缺失数字
    给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
    Example 1:
    Input: [3,0,1]
    Output: 2
    Example 2:
    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8
    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
    https://leetcode-cn.com/problems/missing-number
* */
public class LC_268_Missing_Number {
    static int[] nums = {9,6,4,2,3,5,7,0,1};
    public static void main(String[] args) {
        System.out.println(missingNumber(nums));
    }
    /*
    * 0~n 连续数字 只缺少一个 (n0+nx)*len/2 求和减去所有数字即为目标缺失值
    * */
    public static int missingNumber(int[] nums) {
        int up = nums.length;
        long sum = (((up+0) * (up+1)) >> 1);
        for (int i = 0;i<nums.length;++i) {
            sum -= nums[i];
        }
        return (int) sum;
    }
}
