package com.demo.grammar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CloneClass implements Cloneable {

    private Integer integer1 = 1;
    private String string1 = new String("1");
    private List<String> list1 = new ArrayList<>();

    public CloneClass() {}

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public List<String> getList1() {
        return list1;
    }

    public void setList1(List<String> list1) {
        this.list1 = list1;
    }





    @Override
    protected CloneClass clone() throws CloneNotSupportedException {
        //使用Object的clone方法，这是浅拷贝，你可以打印bigDecimal1的内存地址哈希来看，使用System.identityHashCode
        //然后实验一下改了对象1的list1会不会影响对象2的list1
        CloneClass cloneClass = (CloneClass) super.clone();
        return cloneClass;

        //不仅对象的拷贝，该对象的内部属性也拷贝，这是深拷贝，你可以打印bigDecimal1的内存地址哈希来看，使用System.identityHashCode
        //然后实验一下改了对象1的list1会不会影响对象2的list1
//        CloneClass cloneClass = (CloneClass) super.clone();
//        cloneClass.integer1 = new Integer(this.integer1);
//        cloneClass.string1 = new String(this.string1);
//        cloneClass.list1 = this.list1.stream().collect(Collectors.toList());
//        return cloneClass;
    }

}
