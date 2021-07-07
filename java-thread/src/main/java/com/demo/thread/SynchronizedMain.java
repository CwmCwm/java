package com.demo.thread;



//
public class SynchronizedMain {

    // 这个是测试 SynchronizedUtil 的
    // 从console可以看出 同一个类中所有synchronized静态方法是互斥的
//    public static void main(String[] args) {
//        // 解锁一种新写法，我想写lambada表达式，idea提示我可以这样写，又是一种语法糖
//        Thread aThread = new Thread(SynchronizedUtil::takeCola);
//        aThread.setName("aThread");
//        Thread bThread = new Thread(SynchronizedUtil::takeJuice);
//        bThread.setName("bThread");
//        Thread cThread = new Thread(SynchronizedUtil::takeSprite);
//        cThread.setName("cThread");
//        aThread.start();
//        bThread.start();
//        cThread.start();
//    }



    // 这个是测试 SynchronizedLockUtil 的
    // 对比上面测试 SynchronizedUtil 的, 从console可以看出效果
    public static void main(String[] args) {
        // 解锁一种新写法，我想写lambada表达式，idea提示我可以这样写，又是一种语法糖
        Thread aThread = new Thread(SynchronizedLockUtil::takeCola);
        aThread.setName("aThread");
        Thread bThread = new Thread(SynchronizedLockUtil::takeJuice);
        bThread.setName("bThread");
        Thread cThread = new Thread(SynchronizedLockUtil::takeSprite);
        cThread.setName("cThread");
        aThread.start();
        bThread.start();
        cThread.start();
    }

}
