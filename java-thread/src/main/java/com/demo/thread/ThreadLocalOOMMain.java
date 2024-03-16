package com.demo.thread;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 关于 ThreadLocal 的demo示例
 用 jdk 提供的工具 jvisualvm.exe 查看内存使用（在 jdk安装目录/bin/jvisualvm.exe）
 jdk 提供各种工具，工具很多的，工具什么作用？ 我就留个印象，因为平时没有到啊

 注意：
 1. ThreadLocal 的内部类 ThreadLocalMap （ThreadLocalMap 是 ThreadLocal定义的），
    而实际是 Thread 实例化持有 ThreadLocal.ThreadLocalMap的实例 （Thread代码182行，"ThreadLocal.ThreadLocalMap threadLocals = null;" ）
 2. 各个线程拥有自己独立的ThreadLocalMap，往ThreadLocalMap中存入值也就是Entry中的value，
    但是如果各个线程中存入ThreadLocalMap 中的value是同一个实例，那就是共享，没有隔离啊，注意恰当使用

 * */
public class ThreadLocalOOMMain {

    // 创建这个示例会消耗 5M 内存（堆空间）
    static class LocalVariable {
        // 5M大小的字节数组，用于测试
        private byte[] a = new byte[1024*1024*5];
    }

    // 运行500次任务
    private static final int TASK_LOOP_SIZE = 500;

    // 创建一个大小为5的线程池
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    // 用来测试 ThreadLocal 了
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();


     /**
      没有使用 ThreadLocal
      理解 new LocalVariable(); 在业务上的生命周期，每个任务会创建 LocalVariable实例，任务结束后，该LocalVariable实例就没有用了（应该被回收了）

      执行了500次任务，每次任务都会创建 LocalVariable实例（消耗5M），但是LocalVariable实例 没有被引用（不可达性，GC会回收）
      所以我用 jvisualvm 工具查看堆空间的实时使用情况 维持在 50M左右
      如果不GC 就是 5M * 500个任务 = 2500M  （早就OOM了），但JVM有GC机制
     */
//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < TASK_LOOP_SIZE; ++i) {
//            poolExecutor.execute(new Runnable() {
//                public void run() {
//                    LocalVariable tmpLocalVariable = new LocalVariable();
//                    System.out.println("use local varaible");
//                    tmpLocalVariable = null;
//                }
//            });
//            Thread.sleep(100);
//        }
//        System.out.println("pool execute over");
//    }



    /**
     使用 ThreadLocal
     理解 new LocalVariable(); 在业务上的生命周期，每个任务会创建 LocalVariable实例，任务结束后，该LocalVariable实例就没有用了（应该被回收了）

     执行了500次任务，每次任务都会创建 LocalVariable实例（消耗5M），但是LocalVariable实例 没有被引用（不可达性，GC会回收）
     所以我用 jvisualvm 工具查看堆空间的实时使用情况 前期从150M到250M，后期维持在100M
     这个比上面写法占用更多内存（内存泄漏，实例对象从业务上无法被访问/不被需要时，仍然在内存中待着不走）
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < TASK_LOOP_SIZE; ++i) {
            poolExecutor.execute(new Runnable() {
                public void run() {
                    localVariable.set(new LocalVariable());
                    System.out.println("use local varaible");
                    LocalVariable localVariable1 = localVariable.get();
                    System.out.println(localVariable1.a);

                    // 使用 localVariable.remove(); 后，堆空间的情况就和上面的不使用ThreadLocal 的一样了
                    // 业务代码主动清除上面存在ThreadLocal内的 LocalVariable实例，业务代码也应该知道该LocalVariable实例的生命周期，所以推荐这样写
                    // remove方法会执行 expungeStaleEntry方法 去清除Entry，虽然调用 ThreadLocal.get和set方法也会执行 expungeStaleEntry方法，但是触发的时间点不同啊
                    localVariable.remove();
                }
            });
            Thread.sleep(100);
        }
        System.out.println("pool execute over");
    }

}
