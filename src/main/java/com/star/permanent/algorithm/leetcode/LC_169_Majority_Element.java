package com.star.permanent.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    求众数
    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在众数。
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    You may assume that the array is non-empty and the majority element always exist in the array.
    Example 1:
    Input: [3,2,3]
    Output: 3
    Example 2:
    Input: [2,2,1,1,1,2,2]
    Output: 2
    https://leetcode-cn.com/problems/majority-element
* */
public class LC_169_Majority_Element {
    public static void main(String[] args) {

    }

    /*
    * 计数方式 时间复杂度O(n), 空间复杂度O(n)
    * */
    public static int majorityElement1(int[] nums) {
        int len = nums.length;
        int halfLen = (len >> 1);
        Map<Integer,Integer> map = new HashMap<>();
        int cnt;
        while (--len >=0) {
            cnt = map.getOrDefault(nums[len],0) + 1;
            map.put(nums[len], cnt);
        }
        for(Integer k : map.keySet()) {
            if (map.get(k) > halfLen) {
                return k;
            }
        }
        return -1;
    }

    /*
    * 众数只会存在一个, 投票算法 Top!Top!Top!
    * 抵消算法剩下最多的一定是众数
    * 时间复杂度O(n) 空间复杂度O(1)
    * */
    public static int majorityElement(int[] nums) {
        int cnt = 0;
        int target=-1;
        int len = nums.length;
        while (--len >= 0) {
            if (cnt == 0) {
                target = nums[len];
            }
            if (nums[len] == target){
                ++cnt;
            } else {
                --cnt;
            }
        }
        return target;
    }
}
