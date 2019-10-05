package com.star.permanent.algorithm.leetcode;

/*
    区域和检索 - 数组不可变
    给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
    Example:
    Given nums = [-2, 0, 3, -5, 2, -1]
    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3
    Note:
    You may assume that the array does not change.
    There are many calls to sumRange function.
    https://leetcode-cn.com/problems/range-sum-query-immutable
* */
public class LC_303_Range_Sum_Query_Immutable {

    public static void main(String[] args) {

    }

    public LC_303_Range_Sum_Query_Immutable(int[] nums) {
        data = nums;
        sum = new int[nums.length];
        int tmp = 0;
        for(int i=0;i<nums.length;++i) {
            tmp += nums[i];
            sum[i] = tmp;
        }
    }
    int[] data;
    int[] sum;
    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + data[i];
    }
}
