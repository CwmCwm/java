package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

public class 整数和IP地址间的转换 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String ip = scanner.next();
            long ip10 = scanner.nextLong();
            String[] ips = ip.split("\\.");

            //转10进制  每个位置向左位移（24, 16, 8） ,然后按位或
            System.out.println(Long.parseLong(ips[0]) << 24 | Long.parseLong(ips[1]) << 16 | Long.parseLong(ips[2]) << 8 | Long.parseLong(ips[3]));

            //转ip地址  每个位置向右位移（24, 16, 8） ,然后和 255 进行与（这样能去掉高位的1，只保留最低的8位）
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf((ip10 >> 24) & 255)).append(".");
            stringBuilder.append(String.valueOf((ip10 >> 16) & 255)).append(".");
            stringBuilder.append(String.valueOf((ip10 >> 8) & 255)).append(".");
            stringBuilder.append(String.valueOf(ip10 & 255));
            System.out.println(stringBuilder.toString());

        }
    }

}
