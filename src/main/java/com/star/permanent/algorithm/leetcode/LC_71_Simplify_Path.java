package com.star.permanent.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    简化路径
    以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
    在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
    请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
    Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
    In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
    Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
    Example 1:
    Input: "/home/"
    Output: "/home"
    Explanation: Note that there is no trailing slash after the last directory name.
    Example 2:
    Input: "/../"
    Output: "/"
    Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
    Example 3:
    Input: "/home//foo/"
    Output: "/home/foo"
    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
    Example 4:
    Input: "/a/./b/../../c/"
    Output: "/c"
    Example 5:
    Input: "/a/../../b/../c//.//"
    Output: "/c"
    Example 6:
    Input: "/a//b////c/d//././/.."
    Output: "/a/b/c"
    https://leetcode-cn.com/problems/simplify-path
* */
public class LC_71_Simplify_Path {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

    public static String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        int i=0,j=0;
        while (i<path.length()) {
            while (i<path.length() && path.charAt(i) == '/') ++i;
            if(i == path.length()) break;
            j = i++;
            while (i<path.length() && path.charAt(i) != '/') ++i;
            String sec = path.substring(j,i);
            if (sec.equals("..")) {
                stack.pollLast();
            } else if(!sec.equals(".")) {
                stack.add(sec);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String s : stack) {
            builder.append("/").append(s);
        }
        return builder.length() == 0? "/" : builder.toString();
    }
}
