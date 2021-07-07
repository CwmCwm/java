package com.demo.grammar;


import java.sql.Date;

/**
 String  StringBuilder  StringBuffer
 * */
public class TestMain {

    // 面试经常看到，其实目的就是让你看源码
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toString().substring(4, 10));
        date.hashCode();
    }

}
