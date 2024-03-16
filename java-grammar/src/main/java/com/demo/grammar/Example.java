package com.demo.grammar;

import java.util.*;

public class Example {


    Integer integer = new Integer(1);    //8个基本类型的包装类作为方法入参是会变成值引用
    String str = new String("tarena"); //String作为方法入参是会变成值引用
    char[]ch = {'a','b','c'};                 //数组类型是内存地址引用
    List list = new ArrayList<>();            //其他对象类型是内存地址引用

    public Example() {
        list.add("list1");
    }


    public static void main(String args[]){
        Example ex = new Example();

        // 这里 ex.str 是值传递？？？ java只有值传递，引用也是一种值啊，这里ex.str 就是引用啊
        ex.change(ex.integer, ex.str, ex.ch, ex.list);
        //ex.str = "1111";

        System.out.println("ex.integer=" + ex.integer);
        System.out.println("ex.str=" + ex.str);
        System.out.println("ex.ch=" + Arrays.toString(ex.ch));
        System.out.println("ex.list=" + ex.list);
    }


    public void change(Integer integer, String str, char ch[], List list) {
        //引用类型变量，传递的是内存地址，属于引用传递。
        integer = 2;
        str = "test ok";
        ch[0] = 'g';
        list.add("list2");
    }


}
