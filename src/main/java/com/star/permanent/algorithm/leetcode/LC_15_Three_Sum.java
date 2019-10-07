package com.star.permanent.algorithm.leetcode;

import java.util.*;

/*
    三数之和
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    Note:
    The solution set must not contain duplicate triplets.
    Example:
    Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
    https://leetcode-cn.com/problems/3sum
* */
public class LC_15_Three_Sum {
    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> rs = new ArrayList<>();
        Map<Integer,Boolean> map = new HashMap<>();
        Set<Integer> handled = new HashSet<>();
        int third;
        for(int i=0;i<nums.length;++i) {
            if(handled.contains(nums[i])) {  // 前面已经处理过包含nums[i]的全部解
                continue;
            }
            map.clear();
            for(int j = i+1;j<nums.length;++j) {
                third = -nums[i]-nums[j];
                if (!handled.contains(third)){ // 如果 third 的解前面已经完整处理过则跳过
                    if (!map.getOrDefault(third, true)) {  // 存在且为false
                        rs.add(Arrays.asList(nums[i],third,nums[j]));
                        map.put(third, true);
                        map.put(nums[j], true);

                    } else if (!map.containsKey(nums[j])){  // 不存在
                        map.put(nums[j], false);
                    }
                }
            }
            handled.add(nums[i]);
        }
        return rs;  // 最后全部处理完第i轮 将num[i] 放入handled
    }

    public static List<List<Integer>> threeSumOptimize(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        int s,e;
        int sum;
        for(int i=0;i<nums.length;++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;  // 由于以排序 i后面的数均大于nums[i]
            s = i+1;
            e = nums.length-1;
            while (s<e) {
                sum = nums[i] + nums[s] + nums[e];
                if (sum == 0) {
                    rs.add(Arrays.asList(nums[i],nums[s],nums[e]));
                    while (s<e && nums[s] == nums[++s]);
                    while (s<e && nums[e] == nums[--e]);
                } else if(sum < 0) {
                    while (s<e && nums[s] == nums[++s]);
                } else {
                    while (s<e && nums[e] == nums[--e]);
                }
            }
        }
        return rs;
    }
}
