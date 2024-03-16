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
        Scanner sc = new Scanner(System.in);
        int ANum = 0;
        int BNum = 0;
        int CNum = 0;
        int DNum = 0;
        int ENum = 0;
        int errorNum = 0;
        int privateNum = 0;

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strArr = str.split("~");

            //ip的第1段
            int ipFirst = getIpSeg(strArr[0], 0);
            //类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
            if (ipFirst == 0 || ipFirst == 127) {
                continue;
            }

            //ip错误
            if (!ipIsLegal(strArr[0])) {
                errorNum++;
                continue;
            }

            //子网掩码错误
            if (!maskIsLegal(strArr[1])) {
                errorNum++;
                continue;
            }

            //ip的第2段
            int ipSecond = getIpSeg(strArr[0], 1);

            //A,B,C,D,E类地址的计数，只需ip的第1段就可以判断
            if (ipFirst >= 1 && ipFirst <= 126) {
                ANum++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                BNum++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                CNum++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                DNum++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                ENum++;
            }

            //私网IP范围是：从10.0.0.0到10.255.255.255   从172.16.0.0到172.31.255.255   从192.168.0.0到192.168.255.255
            //需要ip的第1段和第2段才能判断私网IP
            if (ipFirst == 10 || (ipFirst == 172 && ipSecond >= 16 && ipSecond <=31) || (ipFirst == 192 && ipSecond == 168)) {
                privateNum++;
            }
        }
        System.out.println(ANum + " " + BNum + " " + CNum + " " + DNum + " " + ENum + " " + errorNum + " " + privateNum);
    }






    //ip是否合法，返回true表示合法，返回false表示非法
    public static boolean ipIsLegal(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return false;
        }
        if (Integer.valueOf(ipArr[0]) > 255 || Integer.valueOf(ipArr[1]) > 255 || Integer.valueOf(ipArr[2]) > 255 || Integer.valueOf(ipArr[3]) > 255) {
            return false;
        }
        return true;
    }

    //子网掩码是否合法，返回true表示合法，返回false表示非法
    public static boolean maskIsLegal(String mask) {
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return false;
        }
        String maskBinary = toBinary(maskArr[0]) + toBinary(maskArr[1]) + toBinary(maskArr[2]) + toBinary(maskArr[3]);
        if (!maskBinary.matches("[1]{1,}[0]{1,}")) {
            return false;
        }
        return true;
    }

    //将0-255转成二进制表示格式
    //输入"1"     返回"00000001"
    //输入"7"     返回"00000111"
    //输入"128"   返回"10000000"
    //输入"192"   返回"11000000"
    //输入"193"   返回"11000001"
    public static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.valueOf(num));
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    //获取ip的第index段
    //输入ip=128.64.32.16     index=0    返回128
    //输入ip=128.64.32.16     index=1    返回64
    //输入ip=128.64.32.16     index=2    返回32
    //输入ip=128.64.32.16     index=3    返回16
    public static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.valueOf(ipArr[index]);
    }

}
