package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.lang.String;

/**

 题目描述
 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 输入：
 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 输出：
 完整的9X9盘面数组

 输入描述:
 包含已知数字的9X9盘面数组[空缺位以数字0表示]

 输出描述:
 完整的9X9盘面数组

 示例1
 输入
 0 9 2 4 8 1 7 6 3
 4 1 3 7 6 2 9 8 5
 8 6 7 3 5 9 4 1 2
 6 2 4 1 9 5 3 7 8
 7 5 9 8 4 3 1 2 6
 1 3 8 6 2 7 5 9 4
 2 7 1 5 3 8 6 4 9
 3 8 6 9 1 4 2 5 7
 0 4 5 2 7 6 8 3 1
 输出
 5 9 2 4 8 1 7 6 3
 4 1 3 7 6 2 9 8 5
 8 6 7 3 5 9 4 1 2
 6 2 4 1 9 5 3 7 8
 7 5 9 8 4 3 1 2 6
 1 3 8 6 2 7 5 9 4
 2 7 1 5 3 8 6 4 9
 3 8 6 9 1 4 2 5 7
 9 4 5 2 7 6 8 3 1

 就是解 9x9的数独题

 * */
public class Sudoku_Java {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            if (str.equals("")) continue;
            int[][] sudoku = new int[9][9];
            String[] params = str.split(" ");
            for (int j = 0; j < 9; j++) {
                sudoku[0][j] = Integer.parseInt(params[j]);
            }
            for (int i = 1; i < 9; i++){
                params = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(params[j]);
                }
            }

            dfs(sudoku);
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                ans.append(sudoku[i][0]);
                for (int j = 1; j < 9; j++)
                    ans.append(" ").append(sudoku[i][j]);
                ans.append("\n");
            }
            System.out.print(ans.toString());
        }
    }

    // TODO  ???
    public static boolean dfs(int[][] sudoku) {
        // 寻找第一个0数字，若无，返回true
        int i = 0, j = 0;
        search: for (; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    break search;
                }
            }
        }
        if (i < 9 && j < 9) {
            boolean[] have = new boolean[10];
            for (int k = 0; k < 9; k++) {
                have[sudoku[i][k]] = true;
                have[sudoku[k][j]] = true;
            }
            int r = (i / 3) * 3, c = (j / 3) * 3;
            for (int k = r; k < r + 3; k++) {
                for (int l = c; l < c + 3; l++){
                    have[sudoku[k][l]] = true;
                }
            }
            for (int k = 1; k <= 9; k++) {
                if (have[k]) {
                    continue;
                }
                sudoku[i][j] = k;
                if (dfs(sudoku)) {
                    return true;
                }
                sudoku[i][j] = 0;
            }
            return false;
        } else {
            return true;
        }
    }

}
