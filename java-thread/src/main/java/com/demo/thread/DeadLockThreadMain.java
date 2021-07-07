package com.demo.thread;


/**
 java 死锁演示
 情景假设（我也没想到合适例子）
 一个宿舍，两个人都有自己的主机，但这个宿舍就只有一个鼠标，一个键盘
 A现在要玩穿越火线，B现在要玩LOL，然而A先拿到鼠标，B先拿到键盘，然后互不相让，好吧，大家都没玩游戏，好好学习吧
 * */
public class DeadLockThreadMain {

    private final static Object mouth = new Object();
    private final static Object keyboard = new Object();

    private static class AThread extends Thread {
        @Override
        public void run () {
            synchronized (mouth) {
                System.out.println(getName() + "----拿到鼠标");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (keyboard) {
                    System.out.println(getName() + "----拿到键盘");
                    System.out.println(getName() + "----可以玩穿越火线了");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getName() + "----玩了10s穿越火线，释放键盘");
            }
            System.out.println(getName() + "----玩了10s穿越火线，释放鼠标");

        }
    }

    private static class BThread extends Thread {
        @Override
        public void run () {
            synchronized (keyboard) {
                System.out.println(getName() + "----拿到键盘");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mouth) {
                    System.out.println(getName() + "----拿到鼠标");
                    System.out.println(getName() + "----可以玩LOL了");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getName() + "----玩了10sLOL，释放鼠标");
            }
            System.out.println(getName() + "----玩了10sLOL，释放键盘");
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
