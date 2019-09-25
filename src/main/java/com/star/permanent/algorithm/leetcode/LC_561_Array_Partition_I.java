package com.star.permanent.algorithm.leetcode;

import java.util.Arrays;

/*
    数组拆分 I
    给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
    Example 1:
    Input: [1,4,3,2]
    Output: 4
    Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
    Note:
    n is a positive integer, which is in the range of [1, 10000].
    All the integers in the array will be in the range of [-10000, 10000].
    https://leetcode-cn.com/problems/array-partition-i
* */
public class LC_561_Array_Partition_I {

    public static void main(String[] args) {

    }
    /*
    * 排序法 升序后取索引偶数求和 时间复杂度 O(nlogn) 空间复杂度O(1)
    * */
    public static int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
