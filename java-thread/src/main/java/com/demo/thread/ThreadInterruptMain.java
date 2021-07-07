package com.demo.thread;


/**
 java线程
 线程中断，线程间通信的一种形式，中断就是中断信号/标志，仅仅是一个信号/标志
 你要主动写代码去检测中断信号并做相应处理
 中断的使用场景：好吧，我实际工作中就没写过
 * */
public class ThreadInterruptMain {

    // 无限循环，但会主动检测 中断信号
    // 这就是中断的写法，主动检测中断信号
    private static class CheckInterruptThread extends Thread {
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " 无限循环中，中断信号是=> " + Thread.currentThread().isInterrupted());
            }
            System.out.println(Thread.currentThread().getName() + " 中断信号是=> "+ Thread.currentThread().isInterrupted());
        }
    }


    // 无限循环，但不会主动检测 中断信号
    // 所以中断信号仅仅是个信号，你要主动写代码去检测中断信号并做相应处理
    // 如果你需要其他线程给该线程发送中断信号，那该线程/任务Runnable 就应该主动检测中断信号啊，所以下面NotCheckInterruptThread 写法就不正确
    private static class NotCheckInterruptThread extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println(Thread.currentThread().getName() + " 中断信号是=> " + Thread.currentThread().isInterrupted());
            }
        }
    }


    // 无限循环，但不会主动检测 中断信号
    // 所以中断信号仅仅是个信号，你要主动写代码去检测中断信号并做相应处理
    // Object.wait方法 和 Thread.sleep方法 和 Thread.join方法 会导致InterruptedException异常
    private static class SleepInterruptThread extends Thread {
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " 中断信号是=> " + Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 线程在 sleep 时，其他线程给该线程发送中断信号，会变成抛InterruptedException异常的方式，但是该线程的中断信号仍为 false
                    // 所以上面写调用sleep方法，idea提示你需要处理 InterruptedException
                    // 常规写法就是这里自己给自己发送中断信号  interrupt();
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + "正在sleep， 中断信号是=> " + Thread.currentThread().isInterrupted());
                    interrupt();
                }
            }
        }
    }


    // 提示console控制台输出行数限制，你设置一下
    // 测试时一种一种情况测试
    public static void main(String[] args) {
//        CheckInterruptThread checkInterruptThread = new CheckInterruptThread();
//        checkInterruptThread.setName("checkInterruptThread");
//        checkInterruptThread.start();
//
//        NotCheckInterruptThread notCheckInterruptThread = new NotCheckInterruptThread();
//        notCheckInterruptThread.setName("notCheckInterruptThread");
//        notCheckInterruptThread.start();
//
        SleepInterruptThread sleepInterruptThread = new SleepInterruptThread();
        sleepInterruptThread.setName("sleepInterruptThread");
        sleepInterruptThread.start();
//
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        checkInterruptThread.interrupt();
//        notCheckInterruptThread.interrupt();
        sleepInterruptThread.interrupt();
    }










    // --------------------------------------------------------------------------------------------------------------------
    // 想想，写代码不会主动写sleep；那可能场景是该线程A 和 其他线程B 竞争同一个资源，线程A没竞争过，进入锁池队列，此时线程C给线程A发送中断信号，就会抛InterruptedException
    // 实验结果不会抛InterruptedException
//    private static Object lock = new Object();
//
//    private static class AThread extends Thread {
//        @Override
//        public void run() {
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println(Thread.currentThread().getName() + "在循环中，中断信号是=> " + Thread.currentThread().isInterrupted());
//                synchronized (lock) {
//                    System.out.println(Thread.currentThread().getName() + "已经拿到锁，中断信号是=> " + Thread.currentThread().isInterrupted());
//                }
//            }
//        }
//    }
//
//    private static class BThread extends Thread {
//        @Override
//        public void run() {
//            synchronized (lock) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Thread aThread = new AThread();
//        aThread.setName("aThread");
//        Thread bThread = new BThread();
//        bThread.setName("bThread");
//        bThread.start();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        aThread.start();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        aThread.interrupt();
//    }
//


}
