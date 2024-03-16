package com.demo.algorithm.牛客网.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 题目描述
 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 请实现下述接口，通过指定的密匙和明文得到密文。

 详细描述：
 接口说明
 原型：

 voidencrypt(char * key,char * data,char * encrypt);
 输入参数：
 char * key：密匙
 char * data：明文

 输出参数：
 char * encrypt：密文

 返回值：
 void

 本题有多组输入数据，请使用while(cin>>)读取

 输入描述:
 先输入key和要加密的字符串

 输出描述:
 返回加密后的字符串

 示例1
 输入
 nihao
 ni
 输出
 le


 思路是利用有序的LinkedHashSet集合，先把密钥添加进去，再把剩下的字符添加进去形成完整的密钥；
 再根据要加密的字符串字符一个个取出拼接输出，ps：不要忘了大小写和空格

 * */
public class 字符串加密 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String key = sc.nextLine();  //密钥
            String data = sc.nextLine(); //要加密的数据

            //listLow初始为升序的a至z的字母表，后面结合密钥的顺序，再改写成新的字母表
            String strUp  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String strLow = "abcdefghijklmnopqrstuvwxyz"; //原字母表（升序的a至z）
            List<String> listLow = new ArrayList<>();     //新字母表（密钥结合原字母表生成的新的字母表）
            for (int i=0; i<strLow.length(); i++) {
                listLow.add(String.valueOf(strLow.charAt(i)));
            }

            //keyStr中字母的去重，按原顺序排序
            String keyStr = "";
            for (int i=0; i<key.length(); i++) {
                if (!(keyStr.contains(String.valueOf(key.charAt(i))))) {
                    keyStr = keyStr + key.charAt(i);
                }
            }

            //结合密钥的顺序，改写listLow成新的字母表
            for (int i=0; i<keyStr.length(); i++) {
                listLow.remove(String.valueOf(keyStr.charAt(i)));
                listLow.add(i, String.valueOf(keyStr.charAt(i)));//会往后顶，而不是替换
            }

            //要加密的数据
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<data.length(); i++) {
                sb.append(listLow.get(strLow.indexOf(data.charAt(i))));
            }

            System.out.println(sb.toString());

        }
        sc.close();
    }


}
