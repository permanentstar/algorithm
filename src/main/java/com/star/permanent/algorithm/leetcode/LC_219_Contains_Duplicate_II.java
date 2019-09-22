package com.star.permanent.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
    Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
    Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true
    Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true
    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
    https://leetcode-cn.com/problems/contains-duplicate-ii
* */
public class LC_219_Contains_Duplicate_II {
    static int[] nums = {1,2,3,1};
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(nums,3));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i<len;++i) {
            Integer s = map.get(nums[i]);
            if (s == null || i-s > k) {
                map.put(nums[i],i);
            } else {
                return true;
            }
        }
        return false;
    }

}
