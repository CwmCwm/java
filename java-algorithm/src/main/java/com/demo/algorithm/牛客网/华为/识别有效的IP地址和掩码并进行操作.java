package com.demo.algorithm.牛客网.华为;


import java.util.*;
import java.util.stream.Collectors;

/**

 题目描述
 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。

 所有的IP地址划分为 A,B,C,D,E五类
 A类地址1.0.0.0~126.255.255.255;
 B类地址128.0.0.0~191.255.255.255;
 C类地址192.0.0.0~223.255.255.255;
 D类地址224.0.0.0~239.255.255.255；
 E类地址240.0.0.0~255.255.255.255


 私网IP范围是：
 10.0.0.0～10.255.255.255
 172.16.0.0～172.31.255.255
 192.168.0.0～192.168.255.255


 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 注意二进制下全是1或者全是0均为非法

 注意：
 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 2. 私有IP地址和A,B,C,D,E类地址是不冲突的

 输入描述:
 多行字符串。每行一个IP地址和掩码，用~隔开。

 输出描述:
 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。

 示例1
 输入
 10.70.44.68~255.254.255.0
 1.0.0.1~255.0.0.0
 192.168.0.2~255.255.255.0
 19..0.~255.255.255.0
 输出
 1 0 1 0 0 2 1


 这里要求先合法性判断，后ip分类

 * */
public class 识别有效的IP地址和掩码并进行操作 {


    public static void main(String[] args) {
        //             A  B  C  D  E  illegal private
        int[] count = {0, 0, 0, 0, 0, 0, 0};

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split("~");
            String ipStr = strings[0];
            String codeStr = strings[1];

            String[] ipCharStr = ipStr.split("\\.");
            // 判断ip是否为空或者首字符是否等于0
            Boolean isTrue = true;
            if (ipCharStr[0].equals("0")) {
                // 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
                continue;
            } else {
                for (int i = 0; i < ipCharStr.length; i++) {
                    if (ipCharStr[i].length() <= 0) {
                        isTrue = false;
                    }
                }
            }

            //如果ip地址正确判断掩码是否正确
            if (isTrue) {
                //判断掩码是否正确
                int[] codeRange = {254, 252, 248, 240, 224, 192, 128, 0};
                List<Integer> list = Arrays.stream(codeRange).boxed().collect(Collectors.toList());//int数组转化为list
                String[] codeCharStr = codeStr.split("\\.");

                //判断是否前面全为1后面全为0
                if ("255".equals(codeCharStr[0])) {
                    if ("255".equals(codeCharStr[1])) {
                        if ("255".equals(codeCharStr[2])) {
                            if ("255".equals(codeCharStr[3])) {
                                isTrue = false;
                            } else if (list.contains(Integer.parseInt(codeCharStr[3]))) {
                                isTrue = true;
                            } else
                                isTrue = false;
                        } else if (list.contains(Integer.parseInt(codeCharStr[2]))) {
                            if (Integer.parseInt(codeCharStr[3]) == 0)
                                isTrue = true;
                            else
                                isTrue = false;
                        } else
                            isTrue = false;
                    } else if (list.contains(Integer.parseInt(codeCharStr[1]))) {
                        if (Integer.parseInt(codeCharStr[2]) == 0 && Integer.parseInt(codeCharStr[3]) == 0)
                            isTrue = true;
                        else
                            isTrue = false;
                    } else
                        isTrue = false;
                } else if (list.contains(Integer.parseInt(codeCharStr[0]))) {
                    if (Integer.parseInt(codeCharStr[0]) == 0) {
                        isTrue = false;
                    } else {
                        if (Integer.parseInt(codeCharStr[1]) == 0 && Integer.parseInt(codeCharStr[2]) == 0 && Integer.parseInt(codeCharStr[3]) == 0)
                            isTrue = true;
                        else
                            isTrue = false;
                    }

                } else
                    isTrue = false;
            }

            //调用方法判断地址范围和私网ip
            if (isTrue) {
                int first = Integer.parseInt(ipCharStr[0]);
                int second = Integer.parseInt(ipCharStr[1]);
                count = judgeIp(first, second, count);
            } else {
                count[5]++;
            }
        }

        System.out.println(count[0] + " " + count[1] + " " + count[2] + " " + count[3] + " " + count[4] + " " + count[5] + " " + count[6]);
    }


    //判断地址范围和私网ip
    public static int[] judgeIp(int first, int second, int[] count) {
        //判断地址范围
        if (first >= 1 && first <= 126)
            count[0]++;
        else if (first >= 128 && first <= 191)
            count[1]++;
        else if (first >= 192 && first <= 223)
            count[2]++;
        else if (first >= 224 && first <= 239)
            count[3]++;
        else if (first >= 240 && first <= 255)
            count[4]++;

        //判断私网ip
        if (first == 192 && second == 168)
            count[6]++;
        if (first == 10)
            count[6]++;
        if (first == 172) {
            if (second >= 16 && second <= 31)
                count[6]++;
        }
        return count;
    }



}
