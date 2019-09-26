package com.star.permanent.algorithm.leetcode;
/*
    种花问题
    假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
    给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
    Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
    Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: True
    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: False
    Note:
    The input array won't violate no-adjacent-flowers rule.
    The input array size is in the range of [1, 20000].
    n is a non-negative integer which won't exceed the input array size.
    https://leetcode-cn.com/problems/can-place-flowers
* */
public class LC_605_Can_Place_Flowers {

    static int[] flowerbed = {0,0,1,0,0};
    static int n = 2;
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(flowerbed,n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        } else if(flowerbed.length == 0) return false;
        int max = 0;
        int zeros = flowerbed[0]==0?1:0;
        for(int i = 0;i<flowerbed.length;++i) {
            if (flowerbed[i] == 0) {
                ++ zeros;
            } else {
                if (zeros > 0) {
                    max += (zeros-1)/2;
                }
                zeros = 0;
            }
        }
        if (zeros > 0) {
            max += (zeros+1-1)/2;  // 最后若还有0 说明以0结尾 需要类似开头做法补一个0
        }
        return max >= n;
    }
}
