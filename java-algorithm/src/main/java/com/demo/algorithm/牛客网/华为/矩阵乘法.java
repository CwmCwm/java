package com.demo.algorithm.牛客网.华为;

import java.util.*;


/**
 https://www.nowcoder.com/practice/ebe941260f8c4210aa8c17e99cbc663b?tpId=37&&tqId=21292&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking


 TODO 暴力解
 * */
public class 矩阵乘法 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            int[][] mat1 = new int[x][y];
            int[][] mat2 = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    mat1[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    mat2[i][j] = in.nextInt();
                }
            }
            int[][] res = mul(mat1, mat2);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    public static int[][] mul(int[][] mat1, int [][]mat2) {
        int x = mat1.length, y = mat2.length, z = mat2[0].length;
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }

}
