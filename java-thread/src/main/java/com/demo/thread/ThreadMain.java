package com.demo.thread;


/**
 java线程的写法
 这通过 new Thread 去创建线程的，因为线程属于重资源，创建过程很长很消耗时间，
 想想java中的创建线程资源要和操作系统的线程资源映射（我也不知道细节），反正多个资源映射都是消耗时间的
 如创建数据库连接，要网络连接（TCP），mysql协议，会话的内存创建，会话的信息状态 等等等
 * */
public class ThreadMain {


    public static void main(String[] args) {
        // lambada表达式这个写法，前端JavaScript进阶写法就会经常看到
        // lambada表达式的写法，其实就是语法糖，跟以前匿名类或具体类的没啥本质区别，对工作来说能完成任务就行
        System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId());
        for (int i=0; i<3; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId());
            });
            thread.start();
        }
    }

}
