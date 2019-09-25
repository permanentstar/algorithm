package com.star.permanent.algorithm.leetcode;

/*
    斐波那契数列
    斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    给定 N，计算 F(N)。
    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), for N > 1.
    Given N, calculate F(N).
    Example 1:
    Input: 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    Example 2:
    Input: 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    Example 3:
    Input: 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
    Note:
    0 ≤ N ≤ 30.
    https://leetcode-cn.com/problems/fibonacci-number
* */
public class LC_509_Fibonacci_Number {
    public static void main(String[] args) {
        System.out.println(fibDP(3));
    }

    /*
    * 有重复计算 效率不高
    * */
    public static int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N-1) + fib(N-2);
    }

    /*
    * stat(n) = stat(n-1) + stat(n-2)
    * stat(0) = 0
    * stat(1) = 1
    *
    *
    * */
    public static int fibDP(int N) {
        if (N == 0) return 0;
        int stat2=0,stat1=1,tmp; // stat 表示 f(n) 而非 n
        for(int i=2;i<N;++i) {
            tmp = stat1+ stat2;
            stat2 = stat1;
            stat1 = tmp;
        }
        return stat1 + stat2;
    }
}
