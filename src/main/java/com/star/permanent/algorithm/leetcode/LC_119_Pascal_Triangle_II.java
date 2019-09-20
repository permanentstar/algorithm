package com.star.permanent.algorithm.leetcode;

/*
    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
    Note that the row index starts from 0.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.
    Example:
    Input: 3
    Output: [1,3,3,1]
    Follow up:
    Could you optimize your algorithm to use only O(k) extra space?
    https://leetcode-cn.com/problems/pascals-triangle-ii
* */

import java.util.ArrayList;
import java.util.List;

public class LC_119_Pascal_Triangle_II {
    static int n = 4;

    public static void main(String[] args) {
        List<Integer> rs = getRowFormular(n);
        for(int i=0;i<rs.size();++i) {
            System.out.print(rs.get(i) + " ");
        }
    }

    /*
     * 1 0 0 0 0
     * 1 1 0 0 0
     * 1 2 1 0 0
     * 1 3 3 1 0
     * 1 4 6 4 1
     *
     * P[K][K]  <-  stat[i][j] = stat[i-1][j] + stat[i-1][j-1]
     *           stat[0][0] = 1
     *
     *  折叠第一层K
     *  stat[j] = stat[j] + stat[j-1]
     *  stat[0] = 1
     *
     * */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> lk = new ArrayList<>(rowIndex+1);
        lk.add(1);
        if (rowIndex == 0) return lk;
        for(int i = 1;i<=rowIndex;++i) {
            lk.add(0);
            for(int j = i;j>0;--j) {
                lk.set(j, lk.get(j) + lk.get(j-1));
            }
        }
        return lk;
    }

    /*
    * 杨辉三角有公式每层数值为 Cn0~Cnn, 因此 要求的就是Cr0~Crr 长度为 r+1
    * 计算公式可以推导出 Cnk = Cn(k-1) * (n-k+1) / k
    *
    * */
    public static List<Integer> getRowFormular(int rowIndex) {
        List<Integer> lk = new ArrayList<>(rowIndex+1);
        lk.add(1);
        long pre = 1;
        for (int i=1;i<=rowIndex;++i) {
            long curr = pre * (rowIndex-i+1) / i;
            lk.add((int)curr);
            pre = curr;
        }
        return lk;
    }
}










