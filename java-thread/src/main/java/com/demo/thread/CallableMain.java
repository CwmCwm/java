package com.demo.thread;


import java.util.concurrent.*;

/**
 java Callable
 Runnable 的接口定义中没有抛异常
 Callable 的接口定义中有抛异常
 这是因为Runnable不需要返回值，也就是说派发Runnable任务后，就无需关注Runnable任务  （猜测）
 Callable有返回值，也就是说派发Callable任务后，仍然关心Callable任务  （猜测）

 * */
public class CallableMain {

    // 两数相加
    private static class AddCallable implements Callable<Integer> {
        // 直接声明public，就少写set，实际工作当然不是这样
        public Integer integer1 = 0;
        public Integer integer2 = 0;

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + "----" + "正在计算");
            return integer1 + integer2;
        }
    }

    // Callable提交给线程运行后，返回的Future，关于Future接口，看Future接口上的注释，还是很好理解的，所以Future提供的功能很丰富嘛
    // 你想想，下面main线程提交AddCallable任务给线程池后，main线程再做其他事情，main线程做完后再去获取AddCallable任务的计算结果
    // 那就需要一个引用正是Future，不然我去哪里获取取，  对比单线程的方法层层调用/层层入栈，这里是多线程哦
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable，并set计算需要的值
        AddCallable addCallable = new AddCallable();
        addCallable.integer1 = 1;
        addCallable.integer2 = 2;

        // 线程Thread可以直接执行Callable吗？ =》 不可以，你看Thread类的方法根本就没有Callable入参
        // 需要将Callable包装成Runnable，你看下面线程池submit 跟进去看，就是用 FutureTask这个包装类
        // 单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(addCallable);
        System.out.println(Thread.currentThread().getName() + "----" + "提交完addCallable，我再做其他事情");
        Integer sum = future.get();
        System.out.println(sum);
    }




}
