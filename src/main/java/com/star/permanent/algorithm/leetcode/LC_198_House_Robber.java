package com.star.permanent.algorithm.leetcode;

/*
    打家劫舍
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
    Example 1:
    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                 Total amount you can rob = 1 + 3 = 4.
    Example 2:
    Input: [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                 Total amount you can rob = 2 + 9 + 1 = 12.
    https://leetcode-cn.com/problems/house-robber
* */
public class LC_198_House_Robber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    /*
    * DP  s[k] = max(s[k-2]+k,s[k-1])
    * */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int s1 = nums[0]; // s[k-2]
        int s2 = Math.max(nums[0],nums[1]); //s[k-1]
        int temp;
        int max = s2;
        for(int i = 2;i<nums.length;++i) {
            temp = Math.max(s1+nums[i],s2);
            s1 = s2;
            s2 = temp;
            if (temp > max) max = temp;
        }
        return max;
    }
}
