package com.star.permanent.algorithm.leetcode;

/*
    数组的度
    给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
    你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
    Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
    Example 1:
    Input: [1, 2, 2, 3, 1]
    Output: 2
    Explanation:
    The input array has a degree of 2 because both elements 1 and 2 appear twice.
    Of the subarrays that have the same degree:
    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    The shortest length is 2. So return 2.
    Example 2:
    Input: [1,2,2,3,1,4,2]
    Output: 6
    Note:
    nums.length will be between 1 and 50,000.
    nums[i] will be an integer between 0 and 49,999.
    https://leetcode-cn.com/problems/degree-of-an-array
* */
public class LC_697_Degree_Of_An_Array {
    static int[] nums = {1,2,2,3,1,4,2};

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(nums));
    }

    /*
    * 先求出数组的度及满足该度的每个元素的首末位置，根据Note，可以使用计数法。
    * 上述输出元素首末长度为候选长度(可能多个元素符合需要取min)
    * */
    public static int findShortestSubArray(int[] nums) {
        int[][] s = new int[50000][3];  // 索引为 value  官方解答使用Map
        int maxDegree = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;++i) {
            s[nums[i]][0] = s[nums[i]][0] + 1; //  cnt + 1
            if(nums[i] != nums[0] && s[nums[i]][1] == 0) {  // = nums[0] 时不能执行否则该元素startpos会被覆盖
                s[nums[i]][1] = i;  // start pos
            }
            s[nums[i]][2] = i;  // update end pos
            if (s[nums[i]][0] > maxDegree) {
                maxDegree = s[nums[i]][0];
            }
        }
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;++i) {
            if (s[nums[i]][0] == maxDegree && s[nums[i]][2]-s[nums[i]][1] + 1 < minLen) {
                minLen = s[nums[i]][2]-s[nums[i]][1] + 1;
            }
        }
        return minLen;
    }
}
