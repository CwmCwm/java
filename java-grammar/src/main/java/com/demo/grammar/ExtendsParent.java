package com.demo.grammar;


/**
 父类
 * */
public class ExtendsParent {

    static {
        System.out.println("ExtendsParent类的static代码块，类初次加载时会执行一次");
    }

    {
        System.out.println("ExtendsParent类实例化时执行的代码块");
    }

    // 测试 private, default, protected, public  的作用域
    // 作用域确实简单，画个图表完事，但有时记不牢，百度看一下表格一目了然
    private String privateFiled = "private";
    String defaultFiled = "default";
    protected String protectedFiled = "protected";
    public String publicFiled = "public";

    public ExtendsParent() {
        System.out.println("ExtendsParent类构造方法");
    }



}
