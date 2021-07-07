package com.demo.thread;




import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 读写锁，如果熟悉数据库应该明白（面试经常问到的）

 * */
public class ReadWriteLockMain {

    private final static ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final static Lock readLock = reentrantReadWriteLock.readLock();
    private final static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static int sum = 0;

    private static class ReadThread extends Thread {
        @Override
        public void run () {
            readLock.lock();
            try {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "----" + System.currentTimeMillis() +  "----sum=" + sum);
            } finally {
                readLock.unlock();
            }
        }
    }

    private static class WriteThread extends Thread {
        @Override
        public void run () {
            writeLock.lock();
            try {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum = sum + 1;
                System.out.println(getName() + "----" + System.currentTimeMillis() + "----sum=" + sum);
            } finally {
                writeLock.unlock();
            }
        }
    }

    // 运行后从输出的结果，时间戳可以知道读写锁的作用
    public static void main(String[] args) {
        ReadThread readThread1 = new ReadThread();
        ReadThread readThread2 = new ReadThread();
        WriteThread writeThread1 = new WriteThread();
        WriteThread writeThread2 = new WriteThread();
        readThread1.setName("readThread1");
        readThread2.setName("readThread2");
        writeThread1.setName("writeThread1");
        writeThread2.setName("writeThread2");
        readThread1.start();
        readThread2.start();
        writeThread1.start();
        writeThread2.start();
    }
    

}
