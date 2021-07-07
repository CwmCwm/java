package com.demo.grammar;

import java.util.HashMap;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(Test22.a);
    }

}


class Test22{
    static {
        System.out.print("OK");
    }

    public static final String a=new String("JDK");
}