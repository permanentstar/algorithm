package com.star.permanent.algorithm.leetcode;

//  搜索插入位置
/*
*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You may assume no duplicates in the array.
    Example 1:
    Input: [1,3,5,6], 5
    Output: 2
    Example 2:
    Input: [1,3,5,6], 2
    Output: 1
    Example 3:
    Input: [1,3,5,6], 7
    Output: 4
    Example 4:
    Input: [1,3,5,6], 0
    Output: 0
    https://leetcode-cn.com/problems/search-insert-position
* */

public class LC_35_Search_Insert_Position {
    static int[] a1 = {1,3,5,6};
    public static void main(String[] args) {
        System.out.println(searchInsert(a1,7));

    }

    public static int searchInsert(int[] nums,int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

//    [start, end]
    public static int searchInsert(int[] nums, int start, int end,int target) {
        if (start == end) {  // not found finish
            return target <= nums[start] ? start : start + 1;
        }
        int half = ((start + end) >> 1); // absolute position
        int c = nums[half];
        if (target == c) {
            return half;
        } else if (target < c) {
            if (half - 1 < 0) {
                return 0;
            }
            int mb = nums[half - 1];
            if (target == mb){
                return half - 1;
            } else if (target > mb) {
                return half;
            } else {
                return searchInsert(nums, start, half - 1, target);
            }
        } else {
            if (half + 1 > nums.length - 1) {
                return nums.length;
            }
            int mb = nums[half + 1];
            if (target <= mb){
                return half + 1;
            }  else {
                return searchInsert(nums, half + 1, end, target);
            }
        }
    }
}
