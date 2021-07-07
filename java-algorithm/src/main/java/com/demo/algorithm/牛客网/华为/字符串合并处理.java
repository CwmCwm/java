package com.demo.algorithm.牛客网.华为;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**


 * */
public class 字符串合并处理 {

    // 可以这样写啊
    static Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('0', '0');
        put('1', '8');
        put('2', '4');
        put('3', 'C');
        put('4', '2');
        put('5', 'A');
        put('6', '6');
        put('7', 'E');
        put('8', '1');
        put('9', '9');
        put('a', '5');
        put('b', 'D');
        put('c', '3');
        put('d', 'B');
        put('e', '7');
        put('f', 'F');
        put('A', '5');
        put('B', 'D');
        put('C', '3');
        put('D', 'B');
        put('E', '7');
        put('F', 'F');
    }};

    public static void main(String[] str) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] ch = (s1 + s2).toCharArray();

            // 这里奇数偶数指字符串中的位置（从1开始计数）   不是数组下标（从0开始计数）  这样太容易混淆了
            char[] evens = new char[ch.length / 2];
            char[] odds = new char[ch.length - ch.length / 2];
            // 偶数数组 和 奇数数组 分别放入数据，排序
            for (int i = 0, j = 0, k = 0; i < ch.length; i++){
                if ( i % 2 == 0){
                    odds[j] = ch[i];
                    j++;
                }else {
                    evens[k] = ch[i];
                    k++;
                }
            }
            Arrays.sort(odds);
            Arrays.sort(evens);

            // 从 偶数数组 和 奇数数组中按序取出，并转义
            for (int i = 0, j = 0, k = 0; i < ch.length; i++){
                if (i % 2 == 0){
                    //注意存在码表不包含的情况，使用原值
                    ch[i] = map.getOrDefault(odds[j], odds[j]);
                    j++;
                }else {
                    ch[i] = map.getOrDefault(evens[k], evens[k]);
                    k++;
                }
            }

            s = new String(ch);
            System.out.println(s);

        }
    }




}
