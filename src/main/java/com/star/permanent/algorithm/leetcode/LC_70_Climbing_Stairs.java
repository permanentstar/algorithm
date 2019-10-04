package com.star.permanent.algorithm.leetcode;

/*
    爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    Note: Given n will be a positive integer.
    Example 1:
    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:
    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
    https://leetcode-cn.com/problems/climbing-stairs
* */
public class LC_70_Climbing_Stairs {

    public static void main(String[] args ) {
        System.out.println(climbStairs(4));
    }

    /*
    * DP  s[n]=s[n-1]+s[n-2]
    * 说明: 登上N的方法由登上N-2的方法数(最后直接+2)与登上N-1的方法数(最后直接+1)加和得来，注意s[n-2]经过n-1台阶不能算在内否则和s[n-1]重复
    * */
    public static int climbStairs(int n) {
        if (n<=1)return 1;
        int[] states = new int[2];
        states[0] = 1;
        states[1] = 2;
        int temp;
        for(int i=3;i<=n;++i) {
            temp = states[0] + states[1];
            states[0] = states[1];
            states[1] = temp;
        }
        return states[1];
    }
}
