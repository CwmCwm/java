package com.demo.thread;


/**
 java线程
 线程join方法

 示例就是只有一个窗口打饭，main排在前面，
 bThread来排队时，main主动给bThread插队，
 aThread来排队时，bThread主动给aThread插队，
 记住是主动哦
 * */
public class ThreadJoinMain {

    private static class AThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + "----" + getName() + "----" + " 排队打饭 ");
                Thread.sleep(2000);
                System.out.println(System.currentTimeMillis() + "----" + getName() + "----" + " 打完饭 ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class BThread extends Thread {
        // 直接用set方法
        private Thread joinThread;
        public void setThread(Thread thread) {
            this.joinThread = thread;
        }

        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + "----" + getName() + "----" + " 排队打饭 ");
                // bThread主动给aThread插队，
                joinThread.join();
                Thread.sleep(2000);
                System.out.println(System.currentTimeMillis() + "----" + getName() + "----" + " 打完饭 ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread aThread = new AThread();
        aThread.setName("aThread");

        BThread bThread = new BThread();
        bThread.setName("bThread");
        bThread.setThread(aThread);

        aThread.start();
        bThread.start();

        System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + "----" + " 排队打饭");
        // main主动给bThread插队
        bThread.join();
        Thread.sleep(2000);
        System.out.println(System.currentTimeMillis() + "----" + Thread.currentThread().getName() + "----" + " 打完饭");
    }

}
