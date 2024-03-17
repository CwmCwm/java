package com.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {

    //Java提供基于CAS实现的多线程同步的Integer，
    //适用场景：多线程的计数，直接方便就能达成多线程的计数
    public static AtomicInteger atomicInteger1 = new AtomicInteger(0);
    //使用atomicInteger1来进行计数
    public static class AThread extends Thread {
        @Override
        public void run () {
            for (int i=0; i<500; i++) {
                atomicInteger1.incrementAndGet();
            }
        }
    }



    //用来做对照实验，这里integer就是多线程不安全的
    public static Integer integer = 0;
    public static class BThread extends Thread {
        @Override
        public void run () {
            for (int i=0; i<500; i++) {
                integer++;
            }
        }
    }



    //
    public static void main(String[] args) throws InterruptedException {
        //两个线程同时修改变量atomicInteger1（该类是多线程同步的），就不会出错
        //两个线程同时对一个变量进行操作500次+1，以数学视角应该计数到1000
        AThread aThread1 = new AThread();
        AThread aThread2 = new AThread();
        aThread1.start();
        aThread2.start();
        Thread.sleep(1000);
        System.out.println(atomicInteger1.get());


        //两个线程同时修改变量integer（且代码非多线程同步），就会导致计数错误
        //两个线程同时对一个变量进行操作500次+1，以数学视角应该计数到1000
//        BThread bThread1 = new BThread();
//        BThread bThread2 = new BThread();
//        bThread1.start();
//        bThread2.start();
//        Thread.sleep(1000);
//        System.out.println(integer);
    }

}
