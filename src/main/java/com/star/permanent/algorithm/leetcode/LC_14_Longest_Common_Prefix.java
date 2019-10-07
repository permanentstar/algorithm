package com.star.permanent.algorithm.leetcode;

/*
    最长公共前缀
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
    Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    Note:
    All given inputs are in lowercase letters a-z.
    https://leetcode-cn.com/problems/longest-common-prefix
* */
public class LC_14_Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0) return "";
        if (strs.length == 1) return strs[0];
        int i;
        int len = Integer.MAX_VALUE;
        for(i=0;i<strs.length;++i) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
        }
        i = 0;
        char tmp;
        while (i<len) {
            tmp = strs[0].charAt(i);
            for(int j=1;j<strs.length;++j) {
                if (strs[j].charAt(i) != tmp) {
                    return i>0 ? strs[0].substring(0,i) : "";
                }
            }
            ++i;
        }
        return strs[0].substring(0,len);
    }
}
