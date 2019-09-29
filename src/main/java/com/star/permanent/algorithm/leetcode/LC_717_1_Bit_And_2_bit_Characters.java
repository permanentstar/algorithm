package com.star.permanent.algorithm.leetcode;

/*
    1比特与2比特字符
    有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
    现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
    We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
    Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
    Example 1:
    Input:
    bits = [1, 0, 0]
    Output: True
    Explanation:
    The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
    Example 2:
    Input:
    bits = [1, 1, 1, 0]
    Output: False
    Explanation:
    The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
    Note:
    1 <= len(bits) <= 1000.
    bits[i] is always 0 or 1.
    https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
* */
public class LC_717_1_Bit_And_2_bit_Characters {

    public static void main(String[] args) {

    }


    /*
    * 推导: 正序遍历给出的表达式组合能唯一确定拆分策略，不存在多解的问题，倒序遍历如果遇到0会有二义性
    * */


    /*
    * 官方解法1: 一次遍历
    * */
    public static boolean isOneBitCharacter(int[] bits) {
        int i=0;
        for(i=0;i<bits.length;) {
            if (i == bits.length-1) return true;
            if (bits[i] == 0) {
                ++i;
            } else i += 2;
        }
        return false;
    }

    /*
    * 官方题解2: 倒序局部判断最近两个0的1个数
    * 最后一个是0 倒数第二个包括0的要么是0 要么是10 中间所有的1只能是11的多个组合
    * */
    public static boolean isOneBitCharacter2(int[] bits) {
        if (bits.length == 1) return true;
        int cnt = 0;
        for(int i = bits.length-2;i>=0;--i) {
            if (bits[i] == 1) {
                ++cnt;
            } else break;
        }
        return cnt % 2 == 0;
    }

}
