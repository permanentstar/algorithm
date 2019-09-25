package com.star.permanent.algorithm.leetcode;

/*
最短无序连续子数组
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.
Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
* */
public class LC_581_Shortest_Unsorted_Continuous_Subarray {
    static int[] nums = {2, 6, 4, 8, 10, 9, 15};
    static int[] nums2 = {3,2,1};
    static int[] nums3 = {1,3,2,2,2};
    static int[] nums4 = {2,2,4,3,6,9};
    static int[] nums5 = {2,3,3,2,4};
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(nums));
    }
    /*
    * 问题描述： 将数组p分为三段， 第一段与第三段为升序 第二段为波动段其最小值大于第一段最后值，其最大值小于等于第三段起始值
    * 推导：波动最小值不可能位于1、2段分界处，但波动最大值有可能出现在第2、3段交界处
    * 注意几种特殊场景：
    * 1. 波动最大值在开始连续出现
    * 2. 波动最大值在结尾连续出现（没有第三段）
    * 3. 波动最小值在结尾连续出现
    * */


    /*
    * 先找出所有问题点(p[n]<maxPre)，求出集合中min max 正序寻找单调递增中第一个大于min的索引i 倒序找出单调递减中第一个小于或等于max的索引j 返回 j-i+1
    * */
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) return 0;
        int probMin = Integer.MAX_VALUE;
        int probMax = Integer.MIN_VALUE;
        int max = nums[0];
        for(int i = 1;i<nums.length;++i) {
            if (nums[i] < max) {  // problem point
                if (nums[i] > probMax) {
                    probMax = nums[i];
                }
                if (nums[i] < probMin) {
                    probMin = nums[i];
                }
            } else {
                max = nums[i];
            }
        }
        if(probMin == Integer.MAX_VALUE || probMax == Integer.MIN_VALUE) {
            return 0;  // 单调递增
        }
        int first = 0;
        for (int i = 0;i<nums.length;++i) {
            if (nums[i] > probMin) {
                first = i;
                break;
            }
        }
        int last = nums.length-1;
        for (int j = nums.length-1;j>=0;--j) {
            if (nums[j] <= probMax) {
                last = j;
                break;
            }
        }
        return last - first + 1;
    }


}
