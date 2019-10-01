package com.star.permanent.algorithm.leetcode;

import java.util.TreeSet;

/*
    第三大的数
    给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
    Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
    Example 1:
    Input: [3, 2, 1]
    Output: 1
    Explanation: The third maximum is 1.
    Example 2:
    Input: [1, 2]
    Output: 2
    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
    Example 3:
    Input: [2, 2, 3, 1]
    Output: 1
    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.
    https://leetcode-cn.com/problems/third-maximum-number
* */
public class LC_414_Third_Maximum_Number {
    static int[] nums = {2, 2, 3, 1};
    public static void main(String[] args) {
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(); //asc
        for(int i=0;i<nums.length;++i) {
            set.add(nums[i]);
            if (set.size()>3) { // to remove fist
                set.pollFirst();
            }
        }
        if (set.size()==3) {
            return set.first();
        } else return set.last();
    }
}
