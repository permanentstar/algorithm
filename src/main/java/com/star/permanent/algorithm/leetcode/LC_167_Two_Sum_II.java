package com.star.permanent.algorithm.leetcode;

//  两数之和 II - 输入有序数组
/*
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    Note:
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.
    Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

    https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
* */
public class LC_167_Two_Sum_II {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int curr = 0;
        int hv = target >> 1;
        while (numbers[curr] <= hv) {
            int start = curr + 1;
            int end = len - 1;
            int v2 = target - numbers[curr];
            while (start <= end) {
                int half = ((start + end) >>> 1);
                if (numbers[half] == v2) {
                    return new int[] {curr + 1, half + 1};
                } else if (numbers[half] > v2) {
                    end = half - 1;
                } else {
                    start = half + 1;
                }
            }
            ++ curr;
        }
        throw new RuntimeException("not found");
    }

    public static int[] twoSumOptimize(int[] numbers, int target) {
        int len = numbers.length;
        int i = 0,j = len - 1, tmp;
        while (i < j) {
            tmp = numbers[i] + numbers[j];
            if (tmp == target) {
                return new int[] {i + 1, j + 1};
            } else if (tmp > target) {
                --j;
            } else ++i;
        }
        throw new RuntimeException("not found");
    }

}
