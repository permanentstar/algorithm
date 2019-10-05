package com.star.permanent.algorithm.leetcode;

/*
    反转字符串中的元音字母
    编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    Write a function that takes a string as input and reverse only the vowels of a string.
    Example 1:
    Input: "hello"
    Output: "holle"
    Example 2:
    Input: "leetcode"
    Output: "leotcede"
    Note:
    The vowels does not include the letter "y".
    https://leetcode-cn.com/problems/reverse-vowels-of-a-string
* */
public class LC_345_Reverse_Vowels_Of_A_String {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
    public static String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        char tmp;
        char[] cs = s.toCharArray();
        while (i<j) {
            while (i<j && !isVowel(cs[i])) ++i;
            if (i<j) {
                while (j>i && !isVowel(cs[j])) --j;
                if (i<j) {
                    tmp = cs[i];
                    cs[i] = cs[j];
                    cs[j] = tmp;
                }
            }
            ++i;
            --j;
        }
        return new String(cs);
    }

    private static boolean isVowel(char c) {
        return c=='a' || c=='A' || c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U';
    }
}
