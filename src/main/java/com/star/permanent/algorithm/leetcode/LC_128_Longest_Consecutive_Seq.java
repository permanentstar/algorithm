package com.star.permanent.algorithm.leetcode;

import java.util.*;

/*
    最长连续序列
    给定一个未排序的整数数组，找出最长连续序列的长度。
    要求算法的时间复杂度为 O(n)。
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    Your algorithm should run in O(n) complexity.
    Example:
    Input: [100, 4, 200, 1, 3, 2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    https://leetcode-cn.com/problems/longest-consecutive-sequence
* */
public class LC_128_Longest_Consecutive_Seq {
    public static void main(String[] args) {
        int[] nums = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    /*
    * 没有任何规律的排列数组 想要达到更低的时间复杂度 可以考虑两种方式做预处理使数组有规律
    * 1. 排序  O(nlogn) 后连续可根据索引O(1)访问 空间复杂度O(1)
    * 2. hash  O(n)  后虽然不连续但可根据值O(1)访问 空间复杂度O(n)
    * */

    /*
    * 要求单调递增
    * 本质上每个数字只需参与一次计算，这与排序后算法一致，区别在于数据访问顺序是跳跃的
    * */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;++i) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int i = 0;i<nums.length;++i) {
            if (set.remove(nums[i])) { // nums[i] 之前未处理过 也可以使用Map<Integer,Boolean> 标记
                int v = nums[i];
                int tempLen = 1;
                while (set.remove(--v)) ++tempLen;   // 已经处理过得需要移除
                v = nums[i];
                while (set.remove(++v)) ++tempLen;
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                }
            }
        }
        return maxLen;
    }

}
