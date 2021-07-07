package com.demo.thread;




import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 https://www.liaoxuefeng.com/wiki/1252599548343744/1306581033549858

 对比ThreadWaitAndNotifyMain 比较两种写法

 * */
public class LockAndConditionMain {

    // 下面使用 wait和notify写法，wait方法和notify方法是Object类的方法，需要实例化对象
    // 其实wait和notify是配合使用的哦，遵循模板写就好了
    private static class TaskQueue {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private Queue<String> queue = new LinkedList<>();

        public void addTask(String s) {
            lock.lock();
            try {
                this.queue.add(s);
                // 相当于 notifyAll
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }

        public String getTask() throws InterruptedException {
            lock.lock();
            try {
                while (this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "----1111");
                    // 相当于 wait
                    condition.await();
                }
                return this.queue.remove();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class AThread extends Thread {
        public TaskQueue taskQueue = null;
        @Override
        public void run() {
            String s = "任务" + String.valueOf(System.currentTimeMillis());
            taskQueue.addTask(s);
            System.out.println(getName() + "----经数据 " + s + " 放入队列");
        }
    }

    private static class BThread extends Thread {
        public TaskQueue taskQueue = null;
        @Override
        public void run() {
            String s = null;
            try {
                s = taskQueue.getTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "----从队列中拿出数据 " + s);
        }
    }

    /**

     * */
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        aThread.setName("aThread");
        aThread.taskQueue = taskQueue;
        bThread.setName("bThread");
        bThread.taskQueue = taskQueue;
        bThread.start();
        Thread.sleep(10000);
        aThread.start();
    }


}
