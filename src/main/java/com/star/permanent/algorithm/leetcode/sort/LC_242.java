package com.star.permanent.algorithm.leetcode.sort;

//      有效的字母异位词

/*      给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

        示例 1:
        输入: s = "anagram", t = "nagaram"
        输出: true
        示例 2:
        输入: s = "rat", t = "car"
        输出: false
        说明:
        你可以假设字符串只包含小写字母。

        进阶:
        如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/valid-anagram
*/
public class LC_242 {
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
