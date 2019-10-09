package com.star.permanent.algorithm.leetcode;

import java.util.*;

/*
    第k个排列
    给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
    按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    给定 n 和 k，返回第 k 个排列。
    说明：
    给定 n 的范围是 [1, 9]。
    给定 k 的范围是[1,  n!]。
    示例 1:
    输入: n = 3, k = 3
    输出: "213"
    示例 2:
    输入: n = 4, k = 9
    输出: "2314"
    https://leetcode-cn.com/problems/permutation-sequence
* */
public class LC_60_Permutation_Seq {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,4));
    }

    public static String getPermutation(int n, int k) {
        if (n==1) return "1";
        int currRank = 1;
        LinkedList<Integer> remain = new LinkedList<>();
        for(int i=1;i<=n;++i) {
            if (i < n) {   // k 一定 <= n! 起始currRank 要置为 (n-1)!
                currRank *= i;
            }
            remain.add(i);
        }
        int divid;
        int[] rs = new int[n];
        int i=0;
        int j=n-1;
        for (;i<rs.length;++i) {
            divid = k / currRank;
            if (divid > 0) {
                int rest = k % currRank;
                if (rest > 0) {
                    ++divid;
                }
                rs[i] = remain.get(divid - 1);  // 第 divid 个group 索引为 divid - 1
                k  = rest == 0 ? currRank : rest; // 如果整除 说明应该是前一个group的最后一个组合，此时将k置为该group最大值currRank(如 2!=2 进入下一次与1!=1做比较)
                remain.remove(divid - 1);
            } else { // rs 首位一定可以找到  之后如果往前一个rank找不到则说明目标行就在当前group的第一个子group内，直接赋值remain(0)
                rs[i] = remain.get(0);
                remain.remove(0);
            }
            currRank /= j;
            --j;
            if (j == 0) break;
        }
        while (!remain.isEmpty()) {
            rs[++i] = remain.remove(0);
        }
        StringBuilder builder = new StringBuilder();
        for(int l=0;l<rs.length;++l) {
            builder.append(rs[l]);
        }
        return builder.toString();
    }
}
