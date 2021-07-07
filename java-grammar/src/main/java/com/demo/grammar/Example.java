package com.demo.grammar;
public class Example{


    //TODO  为什么？？？
    String str=new String("tarena");
    char[]ch={'a','b','c'};


    public static void main(String args[]){
        Example ex=new Example();

        // 这里 ex.str 是值传递？？？ java只有值传递，引用也是一种值啊，这里ex.str 就是引用啊
        ex.change(ex.str,ex.ch);
        //ex.str = "1111";

        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }


    public void change(String str, char ch[]){
        //引用类型变量，传递的是地址，属于引用传递。
        str="test ok";
        ch[0]='g';
    }


}
