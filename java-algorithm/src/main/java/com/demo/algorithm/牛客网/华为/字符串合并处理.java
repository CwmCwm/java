package com.demo.algorithm.牛客网.华为;


import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.*;

/**


 * */
public class 字符串合并处理 {

    //可以这样写啊
    //字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）
    //直接整理成下面map，就不用计算了，查就行了
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

        while (scanner.hasNext()) {
            //第1步：合并后生成的字符串
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] ch = (s1 + s2).toCharArray();

            //第2步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
            //      这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。
            //这里奇数偶数指字符串中的下标（从下标0开始计数）
            char[] evens = new char[ch.length / 2];
            char[] odds = new char[ch.length - ch.length / 2];
            //偶数数组 和 奇数数组 分别放入数据，排序
            for (int i=0, j=0, k=0; i<ch.length; i++) {
                if (i % 2 == 0) {
                    odds[j] = ch[i];
                    j++;
                }
                else {
                    evens[k] = ch[i];
                    k++;
                }
            }
            //对偶数下标组成的数组进行排序，对奇数下标组成的数组进行排序
            Arrays.sort(evens);
            Arrays.sort(odds);


            //第3步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
            //转换规则如下：
            //对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
            //如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
            //如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
            //如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
            //根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
            //从偶数数组和奇数数组中按序取出，并用上面的map进行转义
            for (int i=0, j=0, k=0; i<ch.length; i++) {
                if (i % 2 == 0) {
                    //注意存在码表不包含的情况，使用原值
                    ch[i] = map.getOrDefault(odds[j], odds[j]);
                    j++;
                }
                else {
                    ch[i] = map.getOrDefault(evens[k], evens[k]);
                    k++;
                }
            }

            String s = new String(ch);
            System.out.println(s);
        }
    }


    //对字符串进行 1前后合并 2排序 3指定字符转换
    public static String mergeAndSortChange(String str1, String str2) {
        //1.合并
        String str = str1 + str2;

        //2.排序
        ArrayList<Character> list1 = new ArrayList<>();//存放偶数位字符
        ArrayList<Character> list2 = new ArrayList<>();//存放奇数位字符
        for (int i=0; i<str.length(); i++) {
            if (i % 2 == 0) {
                list1.add(str.charAt(i));
            }
            else {
                list2.add(str.charAt(i));
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        //重新拼接
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<list1.size(); i++) { //list1.size()>=list2.size()
            builder.append(list1.get(i));
            if (i <= list2.size()-1) { //防止越界
                builder.append(list2.get(i));
            }
        }

        //3.对字符进行转换操作
        for (int i=0; i<builder.length(); i++) {
            String s = builder.substring(i, i+1);
            if(s.matches("[0-9a-fA-F]")){
                //把16进制转成10进制，再转成2进制
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s,16)));
                int len = binary.length();
                for (int j=0; j<4-len ; j++) { //补零
                    binary.insert(0, "0");
                }
                binary = binary.reverse();//翻转
                //把2进制转成10进制，再转成16进制字符串，再大写
                String hexString = Integer.toHexString(Integer.parseInt(binary.toString(), 2)).toUpperCase();
                builder.replace(i,i+1, hexString);//替换
            }
        }

        return builder.toString();
    }




    //十六进制转二进制，然后对该二进制倒序，然后将该二进制转十六进制
    //如十六进字符 '4'，其二进制为 0100，则翻转后为 0010，然后再转十六进制为 '2'。
    //如十六进字符 ‘7’，其二进制为 0111，则翻转后为 1110，然后再转十六进制为 'E'。
    //如十六进字符 'C'，其二进制为 1100，则翻转后为 0011，然后再转十六进制为 '3'。
    public static String change(String hexString) {
        //十六进制转二进制，然后对该二进制倒序，然后将该二进制转十六进制
        StringBuilder sb = new StringBuilder(hexString2Binary(hexString));
        sb.reverse();
        return binary2HexString(sb.toString());
    }

    //二进制转十六进制
    public static String binary2HexString(String binary) {
        //利用已有的方法，先二进制转十进制，然后十进制转十六进制
        return Integer.toString(Integer.parseInt(binary, 2), 16);
    }

    //十六进制转二进制
    public static String hexString2Binary(String hexString) {
        //利用已有的方法，先十六进制转十进制，然后十进制转二进制
        return Integer.toString(Integer.parseInt(hexString, 16), 2);
    }

}
