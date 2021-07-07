package com.demo.thread;


import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 java线程的写法
 因为线程资源的创建/销毁 消耗时间/资源
 所以常规做法是创建线程池，然后需要时从线程池中获取线程执行代码，代码执行后，回收线程到线程池中
 数据库连接池就是经典/非常常见的场景

 * */
public class RunnableMain {

    // 内部类的写法，这里要写成静态内部类，因为上面main方法是主进程进入，有实例化RunnableMain吗=》没有实例化RunnableMain。那只能定义为静态内部类。
    // 其实就是作用域的问题，百度搜一下表格就一目了然
    // 这就是要执行的代码块，等线程来执行
//    static class PrintRunnable implements Runnable {
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId());
//        }
//    }

    // 运行main方法后，进程就常驻内存，你要终断进程，进程才会停止
    // 因为线程池要常驻内存啊，等待任务的来临，然后拿出线程去执行
//    public static void main(String[] args) {
//        // Executors 是用于创建线程池的工具类，这些线程池类和工具类倒是不难记
//        // 这里线程池中只有3个线程，你看一下输出是不是就那3个线程来回执行  PrintRunnable 中的代码
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for (int i=0; i<100; i++) {
//            executorService.execute(new PrintRunnable());
//        }
//        // executorService.shutdown(); 主线程主动关闭线程池，这些方法具体语义，百度咯
//        executorService.shutdown();
//    }








    // ---------------------------------------------------------------------------------------------------------------
    // Runnable执行时抛异常
    static class ExceptionRunnable implements Runnable {
        // 定义成public只是方便不用写set
        public Map<String, String> map;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId() + "正在执行ExceptionRunnable");
            // 这里map不会赋值，所以下面一定会抛NullPointerException
            System.out.println(map.get("key1"));
        }
    }


    public static void main(String[] args) {
        // 与上面对比，这里因为ExceptionRunnable 会抛异常，而ExceptionRunnable 没有自己处理异常，就会导致线程停止
        // 所以从console上看到有新的线程名
        // 所以写Runnable 要注意可能抛异常的地方，自行处理异常；当然你能保证不会有异常，就不用写
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i<100; i++) {
            executorService.execute(new ExceptionRunnable());
        }

    }



}
