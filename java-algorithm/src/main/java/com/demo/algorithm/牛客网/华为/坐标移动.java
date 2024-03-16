package com.demo.algorithm.牛客网.华为;



import java.util.*;

/**

 题目描述
 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。

 输入：
 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 坐标之间以;分隔。
 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 下面是一个简单的例子 如：
 A10;S20;W10;D30;X;A1A;B10A11;;A10;

 处理过程：
 起点（0,0）
 +   A10   =  （-10,0）
 +   S20   =  (-10,-20)
 +   W10  =  (-10,-10)
 +   D30  =  (20,-10)
 +   x    =  无效
 +   A1A   =  无效
 +   B10A11   =  无效
 +  一个空 不影响
 +   A10  =  (10,-10)
 结果 （10， -10）

 注意请处理多组输入输出

 输入描述:
 一行字符串

 输出描述:
 最终坐标，以,分隔

 示例1
 输入
 A10;S20;W10;D30;X;A1A;B10A11;;A10;
 输出
 10,-10



 * */
public class 坐标移动 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //对map进行初始化
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);map.put('D', 0);
        map.put('S', 0);map.put('W', 0);

        String s = scanner.nextLine();
        String[] sArray = s.split(";");
        // 使用正则表达式校验输入合法
        String res = "[ADWS]\\d{1}\\d?";
        for (int i=0; i<sArray.length; i++) {
            if (sArray[i].matches(res)) {
                map.put(sArray[i].charAt(0), map.get(sArray[i].charAt(0)) + Integer.valueOf(sArray[i].substring(1)));
            }
        }

        int x = 0 , y = 0;
        x = x - map.get('A') + map.get('D');
        y = y - map.get('S') + map.get('W');
        System.out.println(x + "," + y);

    }


}
