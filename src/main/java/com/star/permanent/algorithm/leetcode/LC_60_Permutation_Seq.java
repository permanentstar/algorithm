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
        System.out.println(getPermutation(3,3));
    }

    public static String getPermutation(int n, int k) {
        Map<Integer,Integer> map = new HashMap<>(); // 预存阶乘 n! = rank[n-1]
        int multi = 1;
        for(int i=1;i<=n;++i) {
            multi *= i;
            map.put(i,multi);
        }
        int divid;
        int[] rs = new int[n];
        int i=0;
        int j=n;
        for (;i<rs.length;++i) {
            for(;j>0;--j) {
                divid = k / map.get(j);
                if (divid > 0) {
                    if (divid % map.get(j) > 0) {
                        ++divid;
                    }
                    rs[i] = divid;
                    k  %= map.get(j);
                    map.remove(j);
                    --j;
                    break;
                }
            }
            if (j == 0) {
                break;
            }
        }
        if (i < rs.length) {
            for(int l=0;l<n;++l) {
                if (map.containsKey(l+1)) {
                    rs[i++] = l+1;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int l=0;l<rs.length;++l) {
            builder.append(rs[l]);
        }
        return builder.toString();
    }
}
