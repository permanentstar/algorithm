package com.star.permanent.algorithm.leetcode;
//  加一
/*
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.
    Example 1:
    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Example 2:
    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    https://leetcode-cn.com/problems/plus-one
* */

public class LC_66_Plus_One {
    private static int[] digits = {1,2,3};
    public static void main(String[] args) {
        int[] rs = plusOne(digits);
        for(int i = 0; i< rs.length;++i) {
            System.out.println(rs[i]);
        }
    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return new int[] {1};
        }
        digits[len - 1] = digits[len - 1] + 1;
        boolean high = false;
        for(int i = len - 1;i>=0;--i) {
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 10;
                if (i > 0) {
                    digits[i - 1] = digits[i - 1] + 1;
                } else {
                    high = true;
                }
            }
        }
        if (!high) {
            return digits;
        } else {
            int [] nd = new int[len+1];
            nd[0] = 1;
            for(int i = 1;i<len+1;++i) {
                nd[i] = digits[i-1];
            }
            return nd;
        }
    }
}
