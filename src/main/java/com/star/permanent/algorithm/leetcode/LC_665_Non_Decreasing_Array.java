package com.star.permanent.algorithm.leetcode;

/*
    非递减数列
    给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
    我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
    Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
    We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
    Example 1:
    Input: [4,2,3]
    Output: True
    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
    Example 2:
    Input: [4,2,1]
    Output: False
    Explanation: You can't get a non-decreasing array by modify at most one element.
    Note: The n belongs to [1, 10,000].
    https://leetcode-cn.com/problems/non-decreasing-array
* */
public class LC_665_Non_Decreasing_Array {

    public static void main(String[] args) {

    }
    /*
    * 动态规划 状态为截止当前元素是否已经出现过一次问题点
    * 问题点的判定条件为 目标点是否小于全局max
    * 当第二次出现问题点时直接返回false 否则最终返回true
    * */
    public static boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int cnt = 0;
        if(nums[0] > nums[1]) {
            ++cnt;
            nums[0] = nums[1];
        }
        for(int i=2;i<nums.length;++i) {
            if (nums[i] < nums[i-1]) {
                if(++cnt == 2) return false;
                if(nums[i] >= nums[i-2]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return true;
    }
}
