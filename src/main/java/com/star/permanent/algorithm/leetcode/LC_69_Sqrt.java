package com.star.permanent.algorithm.leetcode;

/*
*
*   Implement int sqrt(int x).
    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
    Example 1:
    Input: 4
    Output: 2
    Example 2:
    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since
                 the decimal part is truncated, 2 is returned.
    https://leetcode-cn.com/problems/sqrtx
* */

public class LC_69_Sqrt {
    static int a = 1;
    public static void main(String[] args) {
        System.out.println(mySqrt(a));
    }
    public static int mySqrt(int x) {
        return sqrtInner(x,0,x);
    }

    // [low, high]
    public static int sqrtInner(int x, int low, int high) {
        int half = low + ((high - low) >> 1);  // !!!  (a+b)/2 一定注意 可能会溢出int， 使用 a + (b-a)/2 确保不溢出  !!!
        long t = (long) half * (long) half;    // !!! int * int 会先溢出 因此必须运算之前显式转换  !!!
        if (t == x) {
            return half;
        }
        if (t < x) {  // half + 1 sqrt 后可能 > x 这样要取 half
            if (half == low) {  // high = low + 1 -> 后续再循环一定会形成死循环，此时low 或者 high 一定可以满足解
                return (half + 1) * (half + 1) > x ? half : half + 1;
            }
            return sqrtInner(x, half, high);
        } else { // half sqrt 已经> x 绝对不可能是half
            return sqrtInner(x, low, half - 1);
        }
    }
}
