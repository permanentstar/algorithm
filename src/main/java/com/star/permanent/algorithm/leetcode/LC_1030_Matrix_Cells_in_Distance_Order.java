package com.star.permanent.algorithm.leetcode;
//   曼哈顿距离排序
/*
        We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.
        Additionally, we are given a cell in that matrix with coordinates (r0, c0).

        Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
        Example 1:
        Input: R = 1, C = 2, r0 = 0, c0 = 0
        Output: [[0,0],[0,1]]
        Explanation: The distances from (r0, c0) to other cells are: [0,1]
        Example 2:
        Input: R = 2, C = 2, r0 = 0, c0 = 1
        Output: [[0,1],[0,0],[1,1],[1,0]]
        Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
        The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
        Example 3:
        Input: R = 2, C = 3, r0 = 1, c0 = 2
        Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
        Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
        There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
        Note:
        1 <= R <= 100
        1 <= C <= 100
        0 <= r0 < R
        0 <= c0 < C
        https://leetcode-cn.com/problems/matrix-cells-in-distance-order
*/

public class LC_1030_Matrix_Cells_in_Distance_Order {
    public static void main(String[] args) {
        allCellsDistOrderOptimize(1,2,0,0);
    }
    /*
    * 曼哈顿距离升序，以 (r0,c0)为中心，正菱形经过的点为曼哈顿距离相同的点
    * */
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] rs = new int[R*C][2];
        int r = 0;
        int total = R * C;
        int curr = 0;
        while (curr < total) {
            for(int i=r0-r;i<=r0+r;++i) {
                for(int j=c0-r;j<=c0+r;++j) {
                    if (i >= 0 && i < R && j >= 0 && j< C  && (Math.abs(i - r0) + Math.abs(j - c0) == r)) {
                        int[] pos = {i, j};
                        rs[curr++] = pos;
                    }
                }
            }
            ++r;
        }
        return rs;
    }

    public static int[][] allCellsDistOrderOptimize(int R, int C, int r0, int c0) {
        int[][] rs = new int[R*C][2];
        int r = 0;
        int total = R * C;
        int curr = 0;
        while (curr < total) {
            int d = r;
            while (d >= 0) {
                int left = c0 - d;
                int right = c0 + d;
                if(left >=0) {
                    int top = r0-(r-d);
                    int bottom = r0+(r-d);
                    if(top >=0) {
                        int [] pos = {r0-r+d,c0-d};
                        rs[curr++] = pos;
                    }
                    if(top!=bottom && bottom <R) {
                        int [] pos = {r0+r-d,c0-d};
                        rs[curr++] = pos;
                    }
                }
                if(left != right && right < C) {
                    int top = r0-(r-d);
                    int bottom = r0+(r-d);
                    if(top >=0) {
                        int [] pos = {r0-r+d,c0+d};
                        rs[curr++] = pos;
                    }
                    if(top != bottom && bottom <R) {
                        int [] pos = {r0+r-d,c0+d};
                        rs[curr++] = pos;
                    }
                }
                --d;
            }
            ++r;
        }
        return rs;
    }
}
