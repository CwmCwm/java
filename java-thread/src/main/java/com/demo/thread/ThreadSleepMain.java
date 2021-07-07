package com.demo.thread;


/**
 java线程
 线程Thread调用sleep方法，线程Thread进入阻塞状态(Blocked)，所以线程不会释放锁
 * */
public class ThreadSleepMain {

    // 静态属性，就不用实例化ThreadSleepMain
    // lock对象就是下面 SleepThread线程和NotSleepThread线程要竞争的资源，既然要竞争就要对资源加锁
    // 如何理解锁，直接看java的锁实现就好理解啊
    private static Object lock = new Object();

    private static class SleepThread extends Thread{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + " 要拿lock变量对应的对象的锁 ");
            try {
                synchronized(lock) {
                    System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName()  + " 已经拿到lock对象的锁了");
                    // 调用 Thread.sleep 方法就要捕获 InterruptedException ，为什么？
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + " 释放lock对象的锁");
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    private static class NotSleepThread extends Thread{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + " 要拿lock变量对应的对象的锁 ");
            synchronized(lock) {
                System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + " 已经拿到lock对象的锁了");
                System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + " 释放lock对象的锁");
            }
        }
    }

    public static void main(String[] args) {
        Thread sleepThread = new SleepThread();
        sleepThread.setName("sleepThread");
        Thread notSleepThread = new NotSleepThread();
        notSleepThread.setName("notSleepThread");
        sleepThread.start();
        try {
            // 这里主线程sleep 1000ms，目的是确保 sleepThread先运行（先对lock对象加锁），notSleepThread后运行（后对lock对象加锁）
            // 那么notSleepThread 就只能等 sleepThread释放 lock对象的锁
            // 根据时间点打印，就能推断线程在 sleep 时有无释放锁
            System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + " 主线程sleep 1000ms ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notSleepThread.start();
    }



}
