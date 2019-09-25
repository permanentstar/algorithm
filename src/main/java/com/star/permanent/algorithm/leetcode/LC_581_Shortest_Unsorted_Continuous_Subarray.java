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
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarrayDP(nums4));
    }
    /*
    * 问题描述： 将数组p分为三段， 第一段与第三段为升序 第二段为波动段其最小值大于等于第一段最后值，其最大值小于等于第三段起始值
    * */


    /*
    * 方法一: 贪心算法
    * 先找出所有问题点(p[n]<maxPre)，求出集合中min max 正序寻找单调递增中最后一个小于min的索引i(好点) 倒序找出单调递减中最后一个大于max的索引j(好点) 返回 (j-1)-(i+1)+1=j-i-1
    * min不会出现在第一二段交界处  max不会出现在第二三段交界处
    * */
    public static int findUnsortedSubarray(int[] nums) {
        int probMin = Integer.MAX_VALUE;
        int probMax = Integer.MIN_VALUE;
        int max = nums[0];
        boolean asc = true;
        boolean desc = true;
        for(int i = 1;i<nums.length;++i) {
            if (nums[i] < max) {  // problem point
                if (nums[i] > probMax) {
                    probMax = nums[i];
                }
                if (nums[i] < probMin) {
                    probMin = nums[i];
                }
                asc = false;
            } else {
                max = nums[i];
                desc = false;
            }
        }
        if (asc) return 0;
        if (desc) return nums.length;
        if (probMin == nums[nums.length-1] && probMax == nums[0]) return nums.length;
        int first = 0;
        for (int i = 1;i<nums.length-1;++i) {
            if (nums[i] >= nums[i-1] && nums[i] <= probMin) {
                first = i;
                break;
            }
        }
        int last = nums.length-1;
        for (int j = nums.length-1;j>=1;--j) {
            if (nums[j] >= nums[j-1]  && nums[j] >= probMax) {
                last = j;
                break;
            }
        }
        return last - first - 1;
    }


    public static int findUnsortedSubarrayDP(int[] nums) {
        if (nums.length == 1) return 0;
        int preStat = 0;
        int preEndIndex = 0;
        int max = nums[0];
        int probMax = Integer.MIN_VALUE;
        for(int i = 1;i<nums.length;++i) {
            if(nums[i] < max) {
                if (probMax < nums[i]) {
                    probMax = nums[i];
                }
                preStat += (i-preEndIndex);
                preEndIndex = i;
            } else {
                max = nums[i];
            }
        }
        return preStat;
    }
}
