package com.star.permanent.algorithm.leetcode;

/*
*   旋转数组
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    Given an array, rotate the array to the right by k steps, where k is non-negative.
    Example 1:
    Input: [1,2,3,4,5,6,7] and k = 3
    Output:[5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:
    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    Note:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
    https://leetcode-cn.com/problems/rotate-array
* */
public class LC_189_Rotate_Array {
    static int[] nums = {1,2,3,4,5,6,7};
    static int k = 3;
    public static void main(String[] args) {
        rotate(nums,k);
        for(int i = 0;i<nums.length;++i) {
            System.out.print(nums[i] + " ");
        }
    }

    /*
    * 空间复杂度 O(1)
    * */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] ak = new int[k];
        System.arraycopy(nums,len-k,ak,0,k);
        for(int i=len-1;i>=k;--i) {
            nums[i] = nums[i-k];
        }
        System.arraycopy(ak,0,nums,0,k);
    }
}
