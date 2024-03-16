package com.demo.grammar;

/**
 * 使用clone方法来创建对象
 */
public class CloneMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        //先clone
        CloneClass cloneClass1 = new CloneClass();
        CloneClass cloneClass2 = cloneClass1.clone();
        //后改值，选择操作list1是list1没有重新赋予新的内存地址，而只是在list1中新增数据
        //      重新赋值integer1和string1是直接修改内存地址
        cloneClass1.setInteger1(2);
//        cloneClass1.setString1("1");
//        cloneClass1.getList1().add("1");
        //进行比较
        System.out.println("cloneClass1的内存地址哈希=" + System.identityHashCode(cloneClass1));
        System.out.println("cloneClass2的内存地址哈希=" + System.identityHashCode(cloneClass2));
        System.out.println("cloneClass1的内部成员integer1的内存地址哈希=" + System.identityHashCode(cloneClass1.getInteger1()));
        System.out.println("cloneClass2的内部成员integer1的内存地址哈希=" + System.identityHashCode(cloneClass2.getInteger1()));
        System.out.println("cloneClass1的内部成员string1的内存地址哈希=" + System.identityHashCode(cloneClass1.getString1()));
        System.out.println("cloneClass2的内部成员string1的内存地址哈希=" + System.identityHashCode(cloneClass2.getString1()));
        System.out.println("cloneClass1的内部成员list1的内存地址哈希=" + System.identityHashCode(cloneClass1.getList1()));
        System.out.println("cloneClass2的内部成员list1的内存地址哈希=" + System.identityHashCode(cloneClass2.getList1()));
        System.out.println("cloneClass1的list1=" + cloneClass1.getList1());
        System.out.println("cloneClass2的list1=" + cloneClass2.getList1());

    }

}
