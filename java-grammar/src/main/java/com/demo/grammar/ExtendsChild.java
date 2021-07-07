package com.demo.grammar;


/**
 java数组的写法
 * */
public class ExtendsChild extends ExtendsParent {

    static {
        System.out.println("ExtendsChild类的static代码块");
    }

    {
        System.out.println("ExtendsChild类实例化时执行的代码块");
    }

    public ExtendsChild() {
        // super(); 调用父类的同名构造方法，父类有多个构造方法，那你想想java中方法是如何区分的
        // super(); 必须是第一行，原因想想，先执行父类构造方法，再执行子类构造方法，想想也合理
        // 编译器会自动为它加上一个默认的super()方法调用，即你没写super(); 编译器会自动帮你加上 super();
        // super();
        System.out.println("ExtendsChild类构造方法");

        // 测试作用域，当然这里没有给全测试用例
        // System.out.println(this.defaultFiled);
    }

}
