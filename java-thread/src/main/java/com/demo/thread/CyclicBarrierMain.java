package com.demo.thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 好像也啥好说的
 CyclicBarrier（重复利用） 和 CountDownLatch（一次性） ，就是最大的区别了

 CyclicBarrier 还提供一个更高级的构造函数 CyclicBarrie（r int parties，RunnablebarrierAction），用于在线程到达屏障时，优先执行 barrierAction，方便处理更复杂的业务场景。

 * */
public class CyclicBarrierMain {

    // 赛跑，运动员经过  1热身准备  2等待发令枪  3奔跑
    static class Race implements Runnable {
        // readyTime 热身准备时间，各个运动员准备时间不一致
        // cyclicBarrier 肯定要它，本期主角就是它
        private Long readyTime;
        private CyclicBarrier cyclicBarrier;
        public Race (Long readyTime, CyclicBarrier cyclicBarrier) {
            this.readyTime = readyTime;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(readyTime);
                System.out.println(Thread.currentThread().getName() + " 热身准备完毕 ");

                // 热身准备完毕后， cyclicBarrier.await();  告诉裁判我准备好了，并且等待发令枪
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " 奔跑 ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     这里场景是  一条3跑道的田径场，6个运动员热身准备，每3个一组赛跑，自然前3个准备好的一组赛跑，后3个准备好的一组赛跑
     这就是 CyclicBarrier 重复利用

     * */
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb1 = new CyclicBarrier(3);
        Thread threadA = new Thread(new CyclicBarrierMain.Race(1000L, cb1));
        Thread threadB = new Thread(new CyclicBarrierMain.Race(10000L, cb1));
        Thread threadC = new Thread(new CyclicBarrierMain.Race(20000L, cb1));
        Thread threadX = new Thread(new CyclicBarrierMain.Race(1000L, cb1));
        Thread threadY = new Thread(new CyclicBarrierMain.Race(10000L, cb1));
        Thread threadZ = new Thread(new CyclicBarrierMain.Race(20000L, cb1));
        threadA.setName("threadA");
        threadB.setName("threadB");
        threadC.setName("threadC");
        threadX.setName("threadX");
        threadY.setName("threadY");
        threadZ.setName("threadZ");
        threadA.start();
        threadB.start();
        threadC.start();
        threadX.start();
        threadY.start();
        threadZ.start();

    }


}
