package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

public class 整数和IP地址间的转换 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            long ip10 = scanner.nextLong();


            //下面的位移和位运算都是2进制的运算
            //用2进制去看下面的数据

            //IP地址 转换成 10进制的IP地址
            String[] ips = ip.split("\\.");
            //格式化为数字，直接进行位移，每个位置向左位移（24, 16, 8）,然后按位或
            System.out.println(Long.parseLong(ips[0]) << 24 | Long.parseLong(ips[1]) << 16 | Long.parseLong(ips[2]) << 8 | Long.parseLong(ips[3]));


            //10进制的IP地址 转换成 IP地址
            //每个位置向右位移（24, 16, 8）,然后和 255 进行与（这样能去掉高位的1，只保留最低的8位）
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((ip10 >> 24) & 255).append(".");
            stringBuilder.append((ip10 >> 16) & 255).append(".");
            stringBuilder.append((ip10 >> 8) & 255).append(".");
            stringBuilder.append(ip10 & 255);
            System.out.println(stringBuilder.toString());

        }
    }

}
