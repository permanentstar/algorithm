package com.star.permanent.algorithm.execise;

/*
* 8*8 棋盘放置8个皇后，横竖斜均不相交
* */

public class EightQueens {
    static int nSize = 8;
    static int[] place = new int[nSize]; // 一行放一个 index为row [0,8) value 为column [0,8)
    static {
        for(int i = 0;i<nSize;++i) {
            place[i] = -1;   // 默认初始值均为 0 会和c=0 混淆
        }
    }
    public static void main(String[] args) {
        recurse(0);
        System.out.println(cnt);
    }

    private static void recurse(int currRow) {
        if (currRow == nSize) {
            print();
            return;
        }
        int c = 0;
        while (c < nSize) {  // c 为候选位置
            if(findOnePlace(currRow,c,0)) {
                place[currRow] = c;
                recurse(currRow + 1);//  currRow 当前栈内值不能变，递归结束后继续while遍历使用当前值
            }
            ++c;
        }
    }
    static int cnt = 0;
    private static void print() {
        ++cnt;
        /*for(int i = 0; i< nSize; ++i) {
            for (int j = 0; j< nSize; ++j) {
                if (place[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();*/
    }

    /*
    * 即使当前层遍历通过 但可能后续层无法找到合适位置
    * */
    private static boolean findOnePlace(int currR, int currC, int delta) {
        if (place[currR] == currC) return false;
        if (delta > 0) {
            int left = currC - delta;
            int right = currC + delta;
            if (left >= 0 && place[currR] == left) return false;
            if (right < nSize && place[currR] == right) return false;
        }
        if (currR == 0) return true;
        return findOnePlace(--currR, currC,++delta);
    }

}
