package com.star.permanent.algorithm.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
合并区间
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
https://leetcode-cn.com/problems/merge-intervals
* */
public class LC_56_Merge_Intervals {

    /*
    * 归并法  [[min1,max1],[min2,max2],..[mink,maxk]]
    * 新区间 [s,e], 如果s,e 跨区间则合并 否则扩展该区间
    * */
    public static int[][] merge(int[][] intervals) {
        List<int[]> rs = new LinkedList<>();
        int s,e;
        Iterator<int[]> it;
        for(int i=0;i<intervals.length;++i) {
            int[] iv = intervals[i];
            s = e = -1;
            it = rs.iterator();
            int idx = 0;
            while (it.hasNext()) {
                int[] sec = it.next();
                if (iv[0] < sec[0] && iv[1] > sec[1]) {  // iv区间更大
                    it.remove();
                } else {
                    if (iv[0] >= sec[0] && iv[0] <= sec[1]) {
                        s = idx;
                    }
                    if (iv[1] >= sec[0] && iv[1] <= sec[1]) {
                        e = idx;
                    }
                    ++idx;
                }
            }
            if (s == e && s == -1) {
                rs.add(iv);
            } else if (s != -1 && e == -1) {  //扩展 s 区间
                rs.get(s)[1] = iv[1];
            } else if (s == -1) {  // 扩展 e 区间
                rs.get(e)[0] = iv[0];
            } else if(s != e){  // 合并 s e 区间
                rs.get(s)[1] = rs.get(e)[1];
                rs.remove(e);
            }
        }
        int[][] ai = new int[rs.size()][2];
        for(int k=0;k<rs.size();++k) {
            ai[k] = rs.get(k);
        }
        return ai;
    }

    public static int[][] mergeOptimize(int[][] intervals) {
        int minus = 0;
        for(int i=0;i<intervals.length;++i) {
            int[] iv = intervals[i];  // 包含iv的区间可能会最后到来 j从i+1开始 所以每次循环的更新都必须更新 interval[j] 将状态带到下一轮
            for(int j=i+1;j<intervals.length;++j) {
                int[] sec = intervals[j];
                if (sec[0] < iv[0] && sec[1] > iv[1]) {  // sec区间更大
                    intervals[i] = null;
                    ++minus;
                    break;
                } else if (sec[0] >= iv[0] && sec[0] <= iv[1] && sec[1] >= iv[0] && sec[1] <= iv[1]){
                    intervals[j] = intervals[i];
                    intervals[i] = null;
                    ++minus;
                    break;
                } else if (sec[0] >= iv[0] && sec[0] <= iv[1]) {  // 更新 sec的左边界
                    intervals[j][0] = intervals[i][0];
                    intervals[i] = null;
                    ++minus;
                    break;
                } else if (sec[1] >= iv[0] && sec[1] <= iv[1]) {  // 更新 sec 右边界
                    intervals[j][1] = intervals[i][1];
                    intervals[i] = null;
                    ++minus;
                    break;
                }  // else 不相交 不处理
            }
        }
        int[][] rs = new int[intervals.length-minus][2];
        int idx = 0;
        for(int k=0;k<intervals.length;++k) {
            if (intervals[k] != null) {
                rs[idx++] = intervals[k];
            }
        }
        return rs;
    }

}
