package com.star.permanent.algorithm.leetcode;
// 最大子序和
/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
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
    static int[] c = {-11,-4,2,-5};
    public static void main(String[] args) {
//        int[] rs = maxSubArray2(a);
        /*for(int i = 0;i<rs.length;++i) {
            System.out.println(rs[i]);
        }*/
        System.out.println(maxSubArray(c));

    }

    /*
    * 使用动态规划的解
    * 寻找合并特征: 连续加和经过成员indexX时，无论经过多少次，总是仅保留最大值即可
    * 针对pSum[indexX], 考察递推公式： pSum[indexX] = Max(pSum[indexX-1] + nums[indexX], nums[indexX])
    * 时间复杂度 O(n) 空间复杂度O(n)
    * */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] pSum = new int[len];
        pSum[0] = nums[0];
        for(int i=1;i< len;++i) {
            pSum[i] = Math.max(pSum[i-1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int o=0;o<len;++o) {
            if (pSum[o] > max) {
                max = pSum[o];
            }
        }
        return max;
    }

    /*
    * 优化空间复杂度为O(1)
    * */
    public static int maxSubArrayOptimize(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i=1;i< len;++i) {
            if (sum > 0) {  // if (sum+nums[i]>nums[i])
                sum += nums[i];
            } else sum = nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /*
     * 带最大子串始末位置的解
     * 空间复杂度 O(1) 时间复杂度O(n)
     * declare s=0,e=-1,curr in[0,n),delta=0,deltaM=0  [s,e] is the sub section in which sum value deltaM(candidate) is max in p
     * */
    private static int[] maxSubArray2(int[] nums) {
        int len = nums.length;
        if(len == 0) return new int[] {-1,-1};
        int[] rs = new int[2];
        int deltaS = 0, deltaE = 0;
        int maxSum = nums[0];
        int deltaM = nums[0];
        for(int curr=1;curr<len;++curr) {
            if (nums[curr] >0 && nums[curr-1] <= 0) {  //  -  -> + 跳变
                if (deltaM > 0) {
                    deltaE = curr;
                } else {  // 丢弃 从 curr 重新开始
                    deltaS = deltaE = curr;
                    deltaM = 0;
                }
            } else if(nums[curr] <= 0 && nums[curr-1] > 0) {  // + -> - 跳变 记录可能的最大值
                if(deltaM > maxSum) {
                    maxSum = deltaM;
                    rs[1] = deltaE;
                    rs[0] = deltaS;
                }
            } else if (nums[curr] > 0) {
                deltaE = curr;
            } else if (nums[curr] <= 0) {
                // do nothing
            }
            deltaM += nums[curr];
        }
        if(deltaM > maxSum) {  // 额外做一次 满足以连续正数结束状态
            maxSum = deltaM;
            rs[1] = deltaE;
            rs[0] = deltaS;
        }
//        针对全部为负数场景 只要发现 maxSum < 0 需要返回min num
        if (maxSum <0) {
            for(int i=0;i<len;++i) {
                if (nums[i] > maxSum) {
                    maxSum = nums[i];
                    rs[1] = i;
                    rs[0] = i;
                }
            }
        }
        System.out.println(String.format("maxSum is %s",maxSum));
        return rs;
    }
}
