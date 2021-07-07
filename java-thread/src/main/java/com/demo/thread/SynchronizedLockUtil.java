package com.demo.thread;



// 工具类，对比SynchronizedUtil, 这里显式使用锁对象
// 这个工具类就相当于饮料机，但是这台饮料机有三个饮料出口（分别是Cola出口，Juice出口，Sprite出口），只要对应饮料的出口没人占，就不用等
// 其实就是锁的粒度可以有程序员自行控制
public class SynchronizedLockUtil {

    private static Object colaMouth = new Object();
    private static Object juiceMouth = new Object();
    private static Object spriteMouth = new Object();

    // 你要乘可乐就占可乐出口
    public static void takeCola() {
        synchronized (colaMouth) {
            System.out.println(Thread.currentThread().getName() + "----" + "乘可乐");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----" + "乘完可乐");
        }
    }

    // 同上
    public static void takeJuice() {
        synchronized (juiceMouth) {
            System.out.println(Thread.currentThread().getName() + "----" + "乘果汁");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----" + "乘完果汁");
        }
    }

    // 同上
    public static void takeSprite() {
        synchronized (spriteMouth) {
            System.out.println(Thread.currentThread().getName() + "----" + "乘雪碧");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----" + "乘完雪碧");
        }
    }
    


}
