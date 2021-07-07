package com.demo.thread;




import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 https://www.liaoxuefeng.com/wiki/1252599548343744/1306580960149538
 java 5开始，引入了一个高级的处理并发的java.util.concurrent包，它提供了大量更高级的并发功能，能大大简化多线程程序的编写
 Java语言直接提供了synchronized关键字用于加锁，但这种锁一是很重，二是获取时必须一直等待，没有额外的尝试机制。
 java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁

 所以 java提供的Lock 和 synchronized关键字 从使用目的上一样，都是多线程的竞争/协作；区别后出来Lock肯定更高效安全咯，功能更多咯（不然呢？）
 先看Lock接口，大概了解方法语义，再用几个具体的实现类使用丰富Lock的理解，自己简单写一个自己的Lock（参照着java提供的Lock写嘛，抄都不会吗？=》不会）

 下面示例参照对比 DeadLockThreadMain ，在对比中比较 Lock 和 synchronized关键字 两种写法
 * */
public class ReentrantLockMain {

    // ReentrantLock 可重入锁，就是递归时同一个线程可以重复进入，锁里面有计算器，计数器+1
    private final static Lock mouthReentrantLock = new ReentrantLock();
    private final static Lock keyboardReentrantLock = new ReentrantLock();

    private static class AThread extends Thread {
        @Override
        public void run () {
            // 获取mouthReentrantLock锁，获取
            mouthReentrantLock.lock();
            try {
                System.out.println(getName() + "----拿到鼠标");
                Thread.sleep(1000);
                // 同理
                keyboardReentrantLock.lock();
                try {
                    System.out.println(getName() + "----拿到键盘");
                    System.out.println(getName() + "----可以玩穿越火线了");
                    Thread.sleep(10000);
                } finally {
                    // 同理
                    keyboardReentrantLock.unlock();
                    System.out.println(getName() + "----玩了10s穿越火线，释放键盘");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 必须释放mouthReentrantLock锁，这也是固定模板
                mouthReentrantLock.unlock();
                System.out.println(getName() + "----玩了10s穿越火线，释放鼠标");
            }
        }
    }

    private static class BThread extends Thread {
        @Override
        public void run () {
            keyboardReentrantLock.lock();
            try {
                System.out.println(getName() + "----拿到键盘");
                Thread.sleep(1000);
                mouthReentrantLock.lock();
                try {
                    System.out.println(getName() + "----拿到鼠标");
                    System.out.println(getName() + "----可以玩LOL了");
                    Thread.sleep(10000);
                } finally {
                    mouthReentrantLock.unlock();
                    System.out.println(getName() + "----玩了10sLOL，释放鼠标");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                keyboardReentrantLock.unlock();
                System.out.println(getName() + "----玩了10sLOL，释放键盘");
            }

        }
    }

    //
    public static void main(String[] args) {
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        aThread.setName("aThread");
        bThread.setName("bThread");
        aThread.start();
        bThread.start();
    }


}
