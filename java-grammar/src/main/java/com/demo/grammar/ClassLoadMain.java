package com.demo.grammar;


/**
 类加载的顺序，就是类中代码的执行顺序，这涉及JVM加载类
 * */
public class ClassLoadMain {

    // 只执行一次，因为JVM就只需加载这一次类对象，然后放在JVM的方法区
    // 既然是JVM加载类，那这里的代码就是线程安全的
    static {
        System.out.println("这是类的静态代码块，JVM加载完类对象后，就会执行该代码块，相当于类对象的初始化。类加载器只加载一次。");
    }

    // 既然类实例化，那每次实例化都会执行该代码块
    {
        System.out.println("类实例化时会执行该代码，比构造方法先执行");
    }

    // 构造方法，与上面进行对比
    public ClassLoadMain() {
        System.out.println("类构造方法");
    }

    public static void main(String[] args) {
        ClassLoadMain classLoadMain1 = new ClassLoadMain();
        ClassLoadMain classLoadMain2 = new ClassLoadMain();
    }

}
