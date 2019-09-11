package com.star.permanent.algorithm.leetcode;
//  整数反转

/*
    Given a 32-bit signed integer, reverse digits of an integer.
    Example 1:
    Input: 123
    Output: 321
    Example 2:
    Input: -123
    Output: -321
    Example 3:
    Input: 120
    Output: 21
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
    https://leetcode-cn.com/problems/reverse-integer
* */

public class LC_2_Reverse_Integer {
    public static void main(String[] args) {
        System.out.println(reverse(1563847412));
    }

    public static int reverse(int x) {
        int[] nums = new int[31];
        boolean nagtive = x < 0;
        if (nagtive) {
            if (x == Integer.MIN_VALUE) return 0;
            x = -x;
        }
        int s = getSize(x);
        int l = getLevel(s);
        int i = 0; // valid index
        while (i < s) {
            nums[s-1-i] = x / l;
            ++i;
            x %= l;
            l /= 10;
        }
        if (i == 10 && nums[0] > 2) return 0;
        int j = i - 1;
        int nl = 1;
        int sum = 0;
        do {
            sum += nums[j] * nl;
            nl *= 10;
            if (sum < 0) return 0;
        }
        while (--j >= 0);
        return nagtive ? -sum : sum;
    }

//    12345 -> 5
    private static int getSize(int x) {
        int l = 1;
        while ((x/=10) > 0) {
            ++l;
        }
        return l;
    }

    private static int getLevel(int size) {
        int l = 1;
        while (--size > 0) {
            l *= 10;
        }
        return l;
    }

    /*
    * 官方答案 时间略优于 reverse
    * */
    public static int officialReverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /*
    * 速度最慢
    * */
    public static int reverseByCharArray(int x) {
        boolean nagtive = x < 0;
        if (nagtive) {
            if (x == Integer.MIN_VALUE) return 0;
            x = -x;
        }
        String str = String.valueOf(x);
        char[] cs = str.toCharArray();
        int i = 0, j = cs.length - 1;
        char tmp;
        while (i < j) {
            tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            ++i;
            --j;
        }
        int start = 0;
        while (cs[start] == '0'){
            if (++start == cs.length) {
                return 0;  // input is 0*
            }
        }
        Long rs = Long.valueOf(String.valueOf(cs, start, cs.length -1 - start + 1));
        if (rs - 1 > Integer.MAX_VALUE) return 0;
        return nagtive ? -rs.intValue() : rs.intValue();
    }

}
