package com.star.permanent.algorithm.leetcode;

/*
    岛屿的最大面积
    给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
    找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
    Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
    Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
    Example 1:
    [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
    Example 2:
    [[0,0,0,0,0,0,0,0]]
    Given the above grid, return 0.
    Note: The length of each dimension in the given grid does not exceed 50.
    https://leetcode-cn.com/problems/max-area-of-island
* */
public class LC_695_Max_Area_Of_Island {
    /*
    * dfs 采用备忘录方式记录已走过的点，防止重复遍历
    * 类似病毒扩散打发
    * */

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] back = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0;i<grid.length;++i) {
            for(int j = 0;j<grid[0].length;++j) {
                int area = maxAreaOfIsland(i,j,grid,back);
                if (area > max) max = area;
            }
        }
        return max;
    }

    /*
    * 当前点 (x,y)
    * */
    private static int maxAreaOfIsland(int x, int y, int[][] grid, boolean[][] back) {
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || back[x][y] || grid[x][y] == 0) {
            return 0;
        }
        back[x][y] = true;
        return maxAreaOfIsland(x+1,y,grid,back) + maxAreaOfIsland(x-1,y,grid,back) +
                maxAreaOfIsland(x,y-1,grid,back) + maxAreaOfIsland(x,y+1,grid,back) + 1;
    }
}
