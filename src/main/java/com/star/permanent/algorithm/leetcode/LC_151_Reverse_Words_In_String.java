package com.star.permanent.algorithm.leetcode;

/*
     翻转字符串里的单词
     给定一个字符串，逐个翻转字符串中的每个单词。
     Given an input string, reverse the string word by word.
    Example 1:
    Input: "the sky is blue"
    Output: "blue is sky the"
    Example 2:
    Input: "  hello world!  "
    Output: "world! hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.
    Example 3:
    Input: "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
    Note:
    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.
    https://leetcode-cn.com/problems/reverse-words-in-a-string
* */
public class LC_151_Reverse_Words_In_String {
    public static void main(String[] args) {
        System.out.println(reverseWords(" hello world! "));
    }

    public static String reverseWords(String s) {
        if (s.length() == 0) return "";
        StringBuilder builder = new StringBuilder();
        int slow = s.length()-1;
        int fast = s.length()-1;
        while (fast >= 0 && s.charAt(fast) == ' ') {
            --fast;
            --slow;
        }
        if (fast < 0) {
            return "";
        }
        while (fast >=0) {
            if (s.charAt(fast) != ' ') {
                --fast;
            } else {
                builder.append(" ").append(s.substring(fast+1,slow+1));
                while (--fast >=0 && s.charAt(fast) == ' ');
                slow = fast;
            }
        }
        if (slow != fast) {
            builder.append(" ").append(s.substring(fast+1,slow+1));
        }

        return  builder.deleteCharAt(0).toString(); //0 一定为" "
    }
}
