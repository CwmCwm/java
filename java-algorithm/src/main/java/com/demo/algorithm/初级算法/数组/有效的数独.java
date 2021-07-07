package com.demo.algorithm.初级算法.数组;


import java.util.*;

/**
 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

 上图是一个部分填充的有效的数独。
 数独部分空格内已填入了数字，空白格用 '.' 表示。

 示例 1:
 输入:
 [
     ['5','3','.','.','7','.','.','.','.'],
     ['6','.','.','1','9','5','.','.','.'],
     ['.','9','8','.','.','.','.','6','.'],
     ['8','.','.','.','6','.','.','.','3'],
     ['4','.','.','8','.','3','.','.','1'],
     ['7','.','.','.','2','.','.','.','6'],
     ['.','6','.','.','.','.','2','8','.'],
     ['.','.','.','4','1','9','.','.','5'],
     ['.','.','.','.','8','.','.','7','9']
 ]
 输出: true

 示例 2:
 输入:
 [
   ['8','3','.','.','7','.','.','.','.'],
   ['6','.','.','1','9','5','.','.','.'],
   ['.','9','8','.','.','.','.','6','.'],
   ['8','.','.','.','6','.','.','.','3'],
   ['4','.','.','8','.','3','.','.','1'],
   ['7','.','.','.','2','.','.','.','6'],
   ['.','6','.','.','.','.','2','8','.'],
   ['.','.','.','4','1','9','.','.','5'],
   ['.','.','.','.','8','.','.','7','9']
 ]
 输出: false
 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

 说明:
 一个有效的数独（部分已被填充）不一定是可解的。
 只需要根据以上规则，验证已经填入的数字是否有效即可。
 给定数独序列只包含数字 1-9 和字符 '.' 。
 给定数独永远是 9x9 形式的。


 * */
public class 有效的数独 {

    public static void main(String[] args) {
        char[][] nums1 = {
             {'5','3','.','.','7','.','.','.','.'},
             {'6','.','.','1','9','5','.','.','.'},
             {'.','9','8','.','.','.','.','6','.'},
             {'8','.','.','.','6','.','.','.','3'},
             {'4','.','.','8','.','3','.','.','1'},
             {'7','.','.','.','2','.','.','.','6'},
             {'.','6','.','.','.','.','2','8','.'},
             {'.','.','.','4','1','9','.','.','5'},
             {'.','.','.','.','8','.','.','7','9'}
        };


        System.out.println(isValidSudoku1(nums1));
    }


    // false表示不是数独
    public static boolean isValidSudoku(char[][] board) {
        // 数字 1-9 在每一行只能出现一次。
        for (int line=0; line<9; line++) {
            if (isRepeat(board[line])) {
                return false;
            }
        }

        // 数字 1-9 在每一列只能出现一次。
        for (int row=0; row<9; row++) {
            char[] aRow = new char[] {board[0][row], board[1][row], board[2][row], board[3][row], board[4][row], board[5][row], board[6][row], board[7][row], board[8][row]};
            if (isRepeat(aRow)) {
                return false;
            }
        }

        /**
         数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
         将数独分成九宫格
            0    1    2
            3    4    5
            6    7    8
         寻找上面与循环的关系，  基础行=(九宫格数/3)*3    基础列=九宫格数%3

        */
        for (int i=0; i<9; i++) {
            int line = i/3*3;
            int row = i%3*3;
            char[] threeAndThree = new char[] { board[line][row], board[line][row+1], board[line][row+2],
                                                board[line+1][row], board[line+1][row+1], board[line+1][row+2],
                                                board[line+2][row], board[line+2][row+1], board[line+2][row+2]};
            if (isRepeat(threeAndThree)) {
                return false;
            }
        }
        return true;
    }
    // 判断输入的数组中是否重复，有重复返回true
    public static boolean isRepeat(char[] nums) {
        Set<Character> set = new HashSet<>();
        for (char x : nums) {
            if ('.'!=x && set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }



    /**
     方法：一次迭代

     * */
    public static boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }



}
