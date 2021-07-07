package com.demo.thread;



// 工具类，工具类中的方法用synchronized 修饰
// 这个工具类就相当于饮料机，就一台饮料机一个饮料出口
// synchronized 就是加锁，加锁的对象是 SynchronizedUtil的类对象，SynchronizedUtil的类对象就只有一个
// 下面三个方法要执行，要先获取SynchronizedUtil的类对象（加锁）才能执行
// 所以才说同一个类中所有synchronized静态方法是互斥的
// 其他情况同样的思考思路，都是需要加锁吗，加的是同一个锁吗，至于把加锁对象搞错了，多搞错几遍就不会错了
public class SynchronizedUtil {

    public synchronized static void takeCola() {
        System.out.println(Thread.currentThread().getName() + "----" + "乘可乐");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----" + "乘完可乐");
    }

    public synchronized static void takeJuice() {
        System.out.println(Thread.currentThread().getName() + "----" + "乘果汁");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----" + "乘完果汁");
    }

    public synchronized static void takeSprite() {
        System.out.println(Thread.currentThread().getName() + "----" + "乘雪碧");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----" + "乘完雪碧");
    }



}
