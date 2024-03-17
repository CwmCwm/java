package com.demo.algorithm.华为技术面;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

//字符串表示的四则运算符
//
//示例1
//输入"1+2/2"
//返回2
//
public class 面试20240317 {


    public static void main(String[] args) {
        //String biaoDaShi = "1+2/2";
        //String biaoDaShi = "1+2";
        //String biaoDaShi = "1+2+3";
        String biaoDaShi = "1+2/2*2";
        System.out.println(method1(biaoDaShi));

    }


    //用栈方式实现
    //第一步：解析分隔符 +，-，*，/，数字
    //第二步：运算符的优先级
    public static String method1(String biaoDaShi) {
        char[] chars = biaoDaShi.toCharArray();
        Stack<String> stack = new Stack<>();

        int index = 0;
        //先处理* /
        while (index < chars.length) {
            if (chars[index]=='*') {
                int a = Integer.parseInt(stack.pop()) * Integer.parseInt(String.valueOf(chars[index+1]));
                stack.add(String.valueOf(a));
                index = index + 2;
            }
            else if (chars[index]=='/') {
                int a = Integer.parseInt(stack.pop()) / Integer.parseInt(String.valueOf(chars[index+1]));
                stack.add(String.valueOf(a));
                index = index + 2;
            }
            else {
                stack.add(String.valueOf(chars[index]));
                index = index + 1;
            }
        }

        //后处理+ -，后遍历
        while (stack.size()>1) {
            int wei2 = Integer.parseInt(stack.pop());
            String yunsuanfu = stack.pop();
            int wei1 = Integer.parseInt(stack.pop());

            if (yunsuanfu.equals("+")) {
                int a = wei1 + wei2;
                stack.add(String.valueOf(a));
            }
            else if (yunsuanfu.equals("-")) {
                int a = wei1 - wei2;
                stack.add(String.valueOf(a));
            }
        }

        return stack.pop();
    }


}
