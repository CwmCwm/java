package com.demo.thread;


/**
 java线程
 run方法是有当前线程执行 run方法
 start方法才是让线程开始运行，参考线程的状态图
 * */
public class ThreadStartAndRunMain {

    // 从运行的结果可以知道 run 和 start 的区别
    public static void main(String[] args) {
        ThreadStartAndRun threadStartAndRun = new ThreadStartAndRun();
        threadStartAndRun.run();
        threadStartAndRun.start();
    }

    private static class ThreadStartAndRun extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId() + "----" + "正在运行次代码块");
        }
    }

}
