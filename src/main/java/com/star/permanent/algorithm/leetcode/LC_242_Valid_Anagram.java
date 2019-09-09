package com.star.permanent.algorithm.leetcode;

//      有效的字母异位词: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词

/*
        Given two strings s and t , write a function to determine if t is an anagram of s.
        Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true
        Example 2:
        Input: s = "rat", t = "car"
        Output: false
        Note:
        You may assume the string contains only lowercase alphabets.
        Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case?

        https://leetcode-cn.com/problems/valid-anagram
*/
public class LC_242_Valid_Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        assert isAnagramOptimize(s,t);
    }

    public static boolean isAnagramPrim(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) return false;
        int[] sCharCnt = new int[26];
        int[] tCharCnt = new int[26];
        for(int i = 0;i<sl;++i) {
            ++ sCharCnt[s.charAt(i) - 'a'];
        }
        for(int i = 0;i<tl;++i) {
            ++ tCharCnt[t.charAt(i) - 'a'];
        }
        for (int i = 0;i<26;++i) {
            if (sCharCnt[i] != tCharCnt[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramOptimize(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) return false;
        int[] charCnt = new int[26];
        for(int i = 0;i<sl;++i) {
            ++ charCnt[s.charAt(i) - 'a'];
            -- charCnt[t.charAt(i) - 'a'];
        }
        for (int i = 0;i<26;++i) {
            if (charCnt[i] != 0){
                return false;
            }
        }
        return true;
    }

}
