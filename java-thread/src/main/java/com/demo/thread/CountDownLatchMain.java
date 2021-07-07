package com.demo.thread;


import java.util.concurrent.CountDownLatch;

/**
 好像没啥好说的，理解起来很简单
 具体示例，就是spring的初始化（初始化都是一次性的）

 * */
public class CountDownLatchMain {

    // 赛跑，运动员经过  1热身准备  2等待发令枪  3奔跑
    static class Race implements Runnable {
        // readyTime 热身准备时间，各个运动员准备时间不一致
        // countDownLatch 肯定要它，本期主角就是它
        private Long readyTime;
        private CountDownLatch countDownLatch;
        public Race (Long readyTime, CountDownLatch countDownLatch) {
            this.readyTime = readyTime;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(readyTime);
                System.out.println(Thread.currentThread().getName() + " 热身准备完毕 ");

                // 热身准备完毕后， countDownLatch.countDown(); 告诉裁判我准备好了
                countDownLatch.countDown();

                // countDownLatch.await();  线程在这里等待，知道听到发令枪才继续往下运行
                countDownLatch.await();

                System.out.println(Thread.currentThread().getName() + " 奔跑 ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);
        Thread threadA = new Thread(new Race(1000L, cdl));
        Thread threadB = new Thread(new Race(10000L, cdl));
        Thread threadC = new Thread(new Race(20000L, cdl));
        threadA.setName("threadA");
        threadB.setName("threadB");
        threadC.setName("threadC");

        threadA.start();
        threadB.start();
        threadC.start();
    }


}
