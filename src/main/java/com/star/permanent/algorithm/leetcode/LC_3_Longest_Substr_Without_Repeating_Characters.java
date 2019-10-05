package com.star.permanent.algorithm.leetcode;

import java.util.*;

/*
    无重复字符的最长子串
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    Given a string, find the length of the longest substring without repeating characters.
    Example 1:
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
* */
public class LC_3_Longest_Substr_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    /*
    * 滑动窗口 维护当前最大串字符set 重复点出现后 滑动到上一个重复点index+1
    * */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedHashSet<Byte> exists = new LinkedHashSet<>(); // 有序set
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i<s.length()) {
            if (!exists.add((byte) s.charAt(i))) {
                if (exists.size() > max) {
                    max = exists.size();
                }
                Iterator<Byte> it = exists.iterator();
                while (it.hasNext()) {
                    Byte b = it.next();
                    it.remove();  // 移除无效元素从开头到重复元素(inclusive)
                    if (b == s.charAt(i)) {
                        break;
                    }
                }
                exists.add((byte) s.charAt(i)); // 将当前重复项加到末尾
            }
            ++i;
        }
        if (exists.size() > max) {
            max = exists.size(); // 针对连续不重复末尾 再补做一次判断
        }
        return max;
    }
}
