package com.star.permanent.algorithm.leetcode;
/*
    最大连续1的个数
    给定一个二进制数组， 计算其中最大连续1的个数。
    Given a binary array, find the maximum number of consecutive 1s in this array.
    Example 1:
    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
        The maximum number of consecutive 1s is 3.
    Note:
    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
    https://leetcode-cn.com/problems/max-consecutive-ones
* */
public class LC_485_Max_Consecutive_Ones {
    static int[] nums = {1,1,0,1,1,1};
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /*
    * 顺次遍历一遍 阶段性记录局部最大连续长度 与max比较
    * */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        for (int i = 0;i<nums.length;++i) {
            if(nums[i] > 0) {
                ++cnt;
            } else if(cnt>0) {  // 分界点
                if (cnt > max) {
                    max = cnt;
                }
                cnt = 0;
            }
        }
        if (cnt > max) {
            max = cnt;
        }
        return max;
    }
}
