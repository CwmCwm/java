package com.demo.grammar;



// TODO
public class Test2 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("com.demo.grammar.A");
        System.out.println(clazz);
        System.out.print("Test");
        clazz.forName("com.demo.grammar.A");
    }
}

class A{
    static {
        System.out.print("A");
    }
}

