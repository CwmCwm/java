package com.demo.thread;


/**
 守护线程，百度咯
 * */
public class ThreadDaemonMain extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "线程没有中断，一直在循环中运行");
            }
            System.out.println(Thread.currentThread().getName() + " 接收到中断信号 " + isInterrupted());
        } finally {
            //守护线程中finally不一定起作用，因为主线程结束，守护进程会强制结束
            System.out.println(" .............finally");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadDaemonMain daemonThreadMain = new ThreadDaemonMain();
        // 设置为守护进程，主线程结束，守护进程无论怎样都会强制结束，所以java的守护进程场景是哈
        // daemonThreadMain.setDaemon(true);
        daemonThreadMain.start();
        Thread.sleep(5);
        daemonThreadMain.interrupt();
    }

}
