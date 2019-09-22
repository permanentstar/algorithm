package com.star.permanent.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
    存在重复元素
    给定一个整数数组，判断是否存在重复元素。
    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
    Given an array of integers, find if the array contains any duplicates.
    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
    Example 1:
    Input: [1,2,3,1]
    Output: true
    Example 2:
    Input: [1,2,3,4]
    Output: false
    Example 3:
    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true
    https://leetcode-cn.com/problems/contains-duplicate
* */
public class LC_271_Contain_Duplicate {
    static int[] nums1 = {1,2,3,1};
    public static void main(String[] args) {
        System.out.println(containsDuplicate(nums1));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;++i){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
