package com.demo.thread;

import java.util.concurrent.*;


//Java线程池
//java.util.concurrent.ExecutorService      线程池接口规范，规范线程池的方法
//java.util.concurrent.ThreadPoolExecutor   线程池实现类，用于配置生成具体的线程池，ThreadPoolExecutor共用一个队列
//java.util.concurrent.ForkJoinPool         线程池实现类，ForkJoinPool每个线程都有自己的队列，ForkJoinPool是ThreadPoolExecutor线程池的一种补充，是对计算密集型场景的加强。
public class ExecutorServiceMain {

    //可以按你的需求进行自定义配置线程池
    //ThreadPoolExecutor最全的配置参数是7个
    private static ExecutorService diyThreadPoolExecutor = new ThreadPoolExecutor(1,1,1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private static ExecutorService diyForkJoinPool = new ForkJoinPool();


    //也可以使用工具类Executors提供的几种线程池（预定义了一些已初步配置的线程池），见源码
    //以下这4种线程池都是基于ThreadPoolExecutor的不同配置或继承扩展
    private static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
    private static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    //工作窃取便是ForkJoinPool线程池的优势所在，在一般的线程池比如ThreadPoolExecutor中，如果一个线程正在执行的任务由于某种原因无法继续运行，那么该线程会处于等待状态
    //而在ForkJoinPool中，那么线程会主动寻找其他尚未被执行的任务然后窃取过来执行，减少线程等待时间。
    private static ExecutorService forkJoinPool = Executors.newWorkStealingPool();






}
