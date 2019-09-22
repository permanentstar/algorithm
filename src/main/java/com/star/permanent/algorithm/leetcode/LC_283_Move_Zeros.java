package com.star.permanent.algorithm.leetcode;

/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Example:
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
    https://leetcode-cn.com/problems/move-zeroes
* */
public class LC_283_Move_Zeros {
    static int[] nums = {0,1,0,3,12};
    public static void main(String[] args) {
        moveZeroes(nums);
        for(int i=0;i<nums.length;++i) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void moveZeroes(int[] nums) {
        int zs = -1;
        for(int i=0;i<nums.length;++i) {
            if (nums[i] == 0) {
                zs = i;
                break;
            }
        }
        if (zs >= 0) { // 确保有0
            for(int i = zs + 1;i<nums.length;++i) {
                if (nums[i] != 0) {
                    nums[zs++] = nums[i];
                    nums[i] = 0;  // 使用此步骤 下面while循环可以省略 以减少不必要的0写入
                }
            }
            /*while (zs<nums.length) {
                nums[zs++] = 0;
            }*/
        }
    }
}
