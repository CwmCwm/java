package com.demo.grammar;

public class OuterMain {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        //OuterClass.InnerClass2，OuterClass.InnerClass3，OuterClass.InnerClass4都是非静态内部类，所以要先实例化OuterClass，后才能实例化这些内部类
        OuterClass.InnerClass2 innerClass2 = outerClass.new InnerClass2();

        OuterClass.InnerClass3 innerClass3 = outerClass.new InnerClass3();

        //OuterClass.InnerClass4是抽象类，所以要调用方自己继承实现
        OuterClass.InnerClass4 innerClass4 = outerClass.new InnerClass4() {
            @Override
            public float func() {
                return 0;
            }
        };



        //OuterClass.InnerClass5是静态内部类，不需要先实例化OuterClass，直接实例化OuterClass.InnerClass5就可以了
        OuterClass.InnerClass5 innerClass5 = new OuterClass.InnerClass5();



        outerClass.InnerClass6();

    }

}
