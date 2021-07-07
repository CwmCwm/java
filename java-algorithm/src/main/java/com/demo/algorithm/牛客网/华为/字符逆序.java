package com.demo.algorithm.牛客网.华为;

import java.io.*;

/**

 重复题目

 * */
public class 字符逆序 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuffer output = new StringBuffer();
        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }
        System.out.println(output.toString());
    }

}
