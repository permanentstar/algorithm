package com.star.permanent.algorithm.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
        给定两个数组，编写一个函数来计算它们的交集。
        示例 1:
        输入: nums1 = [1,2,2,1], nums2 = [2,2]
        输出: [2,2]
        示例 2:
        输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出: [4,9]
        说明：
        输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
        我们可以不考虑输出结果的顺序。
        进阶:
        如果给定的数组已经排好序呢？你将如何优化你的算法？
        如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
*/
public class LC_350 {
    private static int[] nums1 = {1,2,2,1};
    private static int[] nums2 = {2,2};
    public static void main(String[] args) {
        int[] is = intersect(nums1, nums2);
        for(int i = 0;i<is.length;++i) {
            System.out.println(is[i]);
        }
    }
    /*
    * 方法类似 349::2
    * */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n1,n2,i1 = 0,i2 = 0;
        List<Integer> rs = new ArrayList<>();
        while (i1 < l1 && i2< l2) {
            n1 = nums1[i1];
            n2 = nums2[i2];
            if(n1 == n2) {
                rs.add(n1);
                ++i1;
                ++i2;
            }else if (n1 > n2) {
                ++i2;
            } else {
                ++i1;
            }
        }
        int[] is = new int[rs.size()];
        for(int i = 0;i<rs.size();++i) {
            is[i] = rs.get(i);
        }
        return is;
    }
}
