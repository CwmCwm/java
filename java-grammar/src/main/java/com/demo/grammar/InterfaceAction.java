package com.demo.grammar;



/**
 java 中interface接口的语义理解是 行为，方法
 接口就是给任何类可以实现的
 实际工作中，定义接口就是定义规则/规范，规范的记忆量很大的，一般都是你要做，才去查相应的规范，还要知道规范的语义，不然规范中的字都看得懂，但连起来读就不懂

 通俗理解/比喻
 类 <=> 你
 类实现多个接口 <=> 你习得多个技能，   你想学几个技能都可以，问题是你学得来吗
 类只能继承一个父类 <=> 你爸就一个

 * */
public interface InterfaceAction {

    // 编译器就自动帮你加上  public final static  ，因为接口中的属性只能是 public final static
    // 作用相当于定义全局常量（好吧，java没有全局常量这个概念）
    public final static String MALE = "M";
    String FEMALE = "F";

    // java8之前版本接口是不能写默认实现的，所以java8之前版本的默认实现是通过 Abstract抽象类（骨架类）实现的
    // java8 加上 default 关键字就可以写方法的默认实现
    default void farming() {
        System.out.println("种地");
    }

    void weaving();

}
