package com.demo.grammar;


/**
 String  StringBuilder  StringBuffer
 * */
public class StringMain {

    // 面试经常看到，其实目的就是让你看源码
    public static void main(String[] args) {
        // 点进去看源码，数据存在哪里，方法有加锁吗
//        String string = new String("string");
//        StringBuilder stringBuilder = new StringBuilder("stringBuilder");
//        StringBuffer stringBuffer = new StringBuffer("stringBuffer");


        //其实就是JVM怎么对于语法实现，str1和str2指向的"i"是放在常量池中（同一个），str3的"i"是放在堆内存，str4的"i"是放在堆内存，但str3和str4不是同一个字符串String对象
        String str1 = "i";
        String str2 = "i";
        String str3 = new String("i");
        String str4 = new String("i");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str3 == str4);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str3.equals(str4));//true
    }

}
