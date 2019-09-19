package com.star.permanent.algorithm.execise;

/*
* 给定一个二维数组P[n][n] value为权值，从起点出发，每次只允许向右或向下移动一步，求左上角P[0][0] 到右下角P[n-1][n-1]的最短权值和
* */
public class MinWeightedGraphRoute {
    static int[][] P = {{0,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
    static int[][] stat = new int[4][4];

    public static void main(String[] args) {
        int rs = minRouteDP();
        System.out.println(rs);
    }

    /*
    * 分析：由于曼哈顿距离为 n-1 + n-1 = 2(n-1) 因此最终一定会移动2(n-1)步到达终点，类似广度遍历，每个"半径"上产生一个最优点，最终路径上产生n-2个最优点(不含起始和终点)
    * i层最优点 由 i-1 层最优点向右或向下移动一步构成，取其min值，最后一层以终点结束(不用选最优)，所以当i=n-1 且经过P[n-1][n-1]时为终止条件
    * 适合采用动态规划，正向计算&反向推导
    * 时间 & 空间 复杂度 O(n^2)
    * stat[i][j] = min(stat[i-1][j],stat[i][j-1])+P[i][j]
    * */

    private static int minRouteDP() {
        int len = P.length;
        stat[0][0] = P[0][0];
        for (int i=0;i<len;++i) {
            for(int j = 0;j<len;++j) {  // 内层循环的方向要看场景，一般stat折叠场景需要倒序(无后效性)。此处stat 二维数组不能折叠(left在后面可能成为top),而且stat[i][j]会依赖同层stat[i][j-1]，因此必须正序
                if (i == 0 && j==0) continue;
                stat[i][j] = Math.min(j-1<0?Integer.MAX_VALUE:stat[i][j-1], i-1<0?Integer.MAX_VALUE:stat[i-1][j]) + P[i][j];
                if (i == len-1 && j == len-1) {
                    return stat[i][j];
                }
            }
//            print();
        }
        print();
        return -1;
    }
    private static void print() {
        for (int i=0;i<stat.length;++i) {
            for (int j=0;j<stat.length;++j) {
                System.out.print(stat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
