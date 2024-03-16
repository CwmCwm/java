package com.demo.grammar;

public class OuterClass {

    public static int int1 = 1;
    private float f = 1.0f;

    public void setF(float f) {
        this.f = f;
    }








    //私有的内部类只能该外部类的代码中使用，外部无法直接使用（实例化）
    //如果外部要使用，需要该外部类提供get方法
    private final class InnerClass1 {}

    //公开的内部类外部可以直接使用（实例化）
    public class InnerClass2 {
        float func() {return f;}
    }

    //外部直接使用（实例化），没有访问权限修饰符的作用域是当前类和当前package
    class InnerClass3 {
        public float func() {return f;}
    }

    //抽象类不能实例化，需要继承
    abstract class InnerClass4 {
        public abstract float func();
    }

    //外部直接使用（实例化）
    //静态类（没有访问权限修饰符的作用域是当前类和当前package，即根据访问权限修饰符来确定作用域）
    static class InnerClass5 {
        protected static float func(){return int1;}
    }

    //局部部内部类：在方法和作用域内的内部类，称为局部内部类。
    public void InnerClass6() {
        class Inner {
            public void print() {
                System.out.println("局部内部类...");
            }
        }
    }


}