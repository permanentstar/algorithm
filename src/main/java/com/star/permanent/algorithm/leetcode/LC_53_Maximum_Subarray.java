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
    static int[] a = {-2,1,-3,4,-1,2,1,-5,4};
    static int[] b = {4,-1,2,1};
    public static void main(String[] args) {
        int[] rs = edge(b);
        for(int i = 0;i<rs.length;++i) {
            System.out.println(rs[i]);
        }
    }


    /*
     * P: Array[int] = int[n]
     * declare s=0,e=-1,curr in[0,n),delta=0,deltaM=0  [s,e] is the sub section in which sum value deltaM(candidate) is max in p
     * p[curr] > 0 || finish => if delta>0 => delta+=P[curr],deltaM+=P[curr],update e=curr
     *                          if delta<=0 => record(s,e,deltaM) as candidate, delta=deltaM=P[curr],s=e=curr
     * p[curr] <=0 => delta += P[curr]
     * */
    public static int maxSubArray(int[] nums) {

        return 0;
    }
    private static int[] edge(int[] nums) {
        int len = nums.length;
        if(len == 0) return new int[] {-1,-1};
        int[] rs = new int[2];
        int deltaS = 0, deltaE = 0;
        int maxSum = 0;
        int deltaM = nums[0];
        int delta = nums[0];
        for(int curr=1;curr<len;++curr) {
            delta += nums[curr];
            if (nums[curr] >0 && nums[curr-1] <= 0) {  //  -  -> + 跳变
                if (delta-nums[curr] > 0) {
                    deltaM += nums[curr];
                    deltaE = curr;
                } else {  // 丢弃 从 curr 重新开始
                    deltaS = deltaE = curr;
                    delta = deltaM = nums[curr];
                }
            } else if(nums[curr] <= 0 && nums[curr-1] > 0) {  // + -> - 跳变 记录可能的最大值
                if(deltaM > maxSum) {
                    maxSum = deltaM;
                    rs[1] = deltaE;
                    rs[0] = deltaS;
                }
            } else if (nums[curr] > 0) {
                deltaM += nums[curr];
                deltaE = curr;
            } else if (nums[curr] <= 0) {
              // do nothing
            }
        }
        if(deltaM > maxSum) {
            maxSum = deltaM;
            rs[1] = deltaE;
            rs[0] = deltaS;
        }
        System.out.println(maxSum);
        return rs;
    }
}
