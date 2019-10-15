package com.star.permanent.algorithm.leetcode;

/*
使用最小花费爬楼梯
数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
示例 1:
输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 示例 2:
输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
注意：
cost 的长度将会在 [2, 1000]。
每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
https://leetcode-cn.com/problems/min-cost-climbing-stairs
* */
public class LC_746_Min_Cost_Climbing_Stairs {

    public static void main(String[] args) {

    }

    /*
    * DP  踩到第k阶的最小消耗 S[k] = min(S[k-1],S[k-2]) + C[k]
    * S[0] = C[0]  S[1] = C[1]   C[n] = 0  最后顶端无消耗
    * 求 S[n]
    * */
    public static int minCostClimbingStairs(int[] cost) {
        int[] s = new int[2];
        s[0] = cost[0];
        s[1] = cost[1];
        if (cost.length != 2) {
            int temp;
            for(int i=2;i<cost.length;++i) {
                temp = s[1];
                s[1] = Math.min(s[0],s[1]) + cost[i];
                s[0] = temp;
            }
        }
        return Math.min(s[0],s[1]);
    }
}
