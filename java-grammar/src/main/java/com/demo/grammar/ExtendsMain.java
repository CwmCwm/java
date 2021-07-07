package com.demo.grammar;


import java.util.Hashtable;

/**
 java 继承语法，调用顺序
 * */
public class ExtendsMain {

    // 这里只加载ExtendsParent 的类对象
//    public static void main(String[] args) {
//        ExtendsParent extendsParent = new ExtendsParent();
//    }


    // 这里实例化ExtendsChild， 但要先加载ExtendsChild类，而要加载ExtendsChild类，需要先加载ExtendsParent类，没错会层层套上去
    public static void main(String[] args) {
        ExtendsChild extendsChild = new ExtendsChild();
    }


    // 这里说明了类加载的时间点不同
//    public static void main(String[] args) {
//        ExtendsParent extendsParent = new ExtendsParent();
//        ExtendsChild extendsChild = new ExtendsChild();
//    }

}
