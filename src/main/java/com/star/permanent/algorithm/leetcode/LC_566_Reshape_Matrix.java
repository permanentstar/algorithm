package com.star.permanent.algorithm.leetcode;

/*
    重塑矩阵
    在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
    给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
    重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
    如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
    In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
    You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
    The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
    If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
    Example 1:
    Input:
    nums =
    [[1,2],
     [3,4]]
    r = 1, c = 4
    Output:
    [[1,2,3,4]]
    Explanation:
    The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
    Example 2:
    Input:
    nums =
    [[1,2],
     [3,4]]
    r = 2, c = 4
    Output:
    [[1,2],
     [3,4]]
    Explanation:
    There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
    Note:
    The height and width of the given matrix is in range [1, 100].
    The given r and c are all positive.
    https://leetcode-cn.com/problems/reshape-the-matrix
* */
public class LC_566_Reshape_Matrix {

    public static void main(String[] args) {

    }

    /*
    * 考虑矩阵的所有数据从一维角度看是相同的 只不过根据不同shape的r,c 做整除和取余后落在不同行的不同列
    * */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int nr = nums.length;
        int nc = nums[0].length;
        int ntotal = nr * nc;
        if (ntotal != r * c) return nums;
        int[][] rs = new int[r][c];
        for (int i=0;i<nr;++i) {
            int lineBase = i * nc;
            for(int j=0;j<nc;++j) {
                int pos = lineBase + j;
                rs[pos/c][pos%c] = nums[i][j];
            }
        }
        return rs;
    }
}
