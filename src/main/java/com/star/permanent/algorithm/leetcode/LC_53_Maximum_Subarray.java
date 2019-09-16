package com.star.permanent.algorithm.leetcode;
// 最大子序和
/*
*   Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    Example:
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    https://leetcode-cn.com/problems/maximum-subarray
* */

public class LC_53_Maximum_Subarray {
    public static void main(String[] args) {

    }


    /*
     * P: Array[int] = int[n]
     * declare s=0,e=-1,curr in[0,n),delta=0,deltaM=0  [s,e] is the sub section in which sum value deltaM(candidate) is max in p
     * p[curr] > 0 || finish => if delta>0 => delta+=P[curr],deltaM+=P[curr],update e=curr
     *                          if delta<=0 => record(s,e,deltaM) as candidate, delta=deltaM=P[curr],s=e=curr
     * p[curr] <=0 => delta -= P[curr]
     * */
    public static int maxSubArray(int[] nums) {
        return 0;
    }
}
