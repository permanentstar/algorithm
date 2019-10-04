package com.star.permanent.algorithm.leetcode;

/*
    验证回文串
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    Note: For the purpose of this problem, we define empty string as valid palindrome.
    Example 1:
    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:
    Input: "race a car"
    Output: false
    https://leetcode-cn.com/problems/valid-palindrome
* */
public class LC_125_Valid_Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeRaw("0P"));
    }

    public static boolean isPalindrome(String s) {
        char[] ac = s.replaceAll("[^0-9a-zA-Z]","").toLowerCase().toCharArray();
        int i = 0;
        int j = ac.length-1;
        while (i<j) {
            if(ac[i++] != ac[j--]){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRaw(String s) {
        if(s == null) return false;
        if(s.length()<=1) return true;
        int i = 0;
        int j = s.length()-1;
        while (i<j) {
            while (i<=j && !validChar(s.charAt(i))) {
                ++i;
            }
            if (i>j) break; // 先找一侧 如果越界都没有找到说明就没有符合的字符 直接返回true
            while (j>=i && !validChar(s.charAt(j))) {
                --j;
            }
            if(!eqIgnoreCase(s.charAt(i),s.charAt(j))) {
                return false;
            }
            ++i;
            --j;  //奇数个字符时最终会重合
        }
        return true;
    }

    private static boolean validChar(char c) {
        return c >= '0' && c <= '9' || c>= 'a' && c<='z' || c>='A' && c<='Z';
    }
    private static boolean eqIgnoreCase(char c1, char c2) {
        return c1 == c2 || (c1>'9' && c2>'9' && (c1-c2 == 'A'-'a' || c1-c2 == 'a'-'A'));
    }
}
