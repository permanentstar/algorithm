package com.star.permanent.algorithm.leetcode;


/*
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.
    Example:
    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
    https://leetcode-cn.com/problems/pascals-triangle
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_118_Pascal_Triangle {
    static int n = 5;
    public static void main(String[] args) {
        List<List<Integer>> tri = generate(n);
        for(int i=0;i<n;++i) {
            for(int j=0;j<n-i;++j) {
                System.out.print(" ");
            }
            List<Integer> l = tri.get(i);
            for(int k=0;k<l.size();++k) {
                System.out.print(l.get(k) + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <=0) return Collections.emptyList();
        if (numRows == 1) {
            List<List<Integer>> tri = new ArrayList<>();
            tri.add(Collections.singletonList(1));
            return tri;
        }
        List<List<Integer>> tri = generate(numRows-1);
        List<Integer> last = tri.get(tri.size()-1);
        List<Integer> curr = new ArrayList<>(numRows);
        tri.add(curr);
        curr.add(1);
        for(int i = 1;i<numRows-1;++i) {
            curr.add(last.get(i-1)+last.get(i));
        }
        curr.add(1);
        return tri;
    }

}
