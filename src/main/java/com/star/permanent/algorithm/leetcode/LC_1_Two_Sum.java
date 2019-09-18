package com.star.permanent.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

//  两数之和
/*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    https://leetcode-cn.com/problems/two-sum
* */
public class LC_1_Two_Sum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int another;
        Integer v;
        for(int i = 0;i < nums.length;++i) {
            another = target - nums[i];
            v = map.get(another);
            if (v != null) {
               return new int[] {v, i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("not found");
    }
}
