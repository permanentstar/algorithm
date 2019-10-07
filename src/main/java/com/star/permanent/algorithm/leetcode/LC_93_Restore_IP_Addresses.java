package com.star.permanent.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    复原IP地址
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    Example:
    Input: "25525511135"
    Output: ["255.255.11.135", "255.255.111.35"]
    https://leetcode-cn.com/problems/restore-ip-addresses
* */
public class LC_93_Restore_IP_Addresses {

    public static void main(String[] args) {
        List<String> rs = restoreIpAddresses("172162541");
        for(String s: rs) {
            System.out.println(s);
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return Collections.emptyList();
        List<String> rs = new ArrayList<>();
        String s1,s2,s3,s4;
        for(int i=0;i<3;++i) {
            s1 = s.substring(0,i+1);
            if (Integer.parseInt(s1) > 255 || s1.length() > 1 && s1.charAt(0)-'0'==0) break;
            for(int j=i+1;j<i+4 && j < s.length();++j) {
                s2 = s.substring(i+1,j+1);
                if (Integer.parseInt(s2) > 255 || s2.length() > 1 && s2.charAt(0)-'0'==0) break;
                for(int k=j+1;k<j+4 && k<s.length();++k) {
                    if (k == s.length() -1 || s.length()-1-k > 3) {  //最后一段长度不能大于3
                        continue;  // 当前k不合适 需要继续考察下一个k值
                    }
                    s3 = s.substring(j+1,k+1);
                    if (Integer.parseInt(s3) > 255 || s3.length() > 1 && s3.charAt(0)-'0'==0) break;
                    s4 = s.substring(k+1);
                    if (Integer.parseInt(s4) > 255 || s4.length() > 1 && s4.charAt(0)-'0'==0) continue;
                    rs.add(String.join(".",s1,s2,s3,s4));
                }
            }
        }
        return rs;
    }
}
