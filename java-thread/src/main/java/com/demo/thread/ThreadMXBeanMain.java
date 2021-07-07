package com.demo.thread;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 java线程 获取线程信息，用于debugger线程信息
 这关于JVM调试，看看还有哪些工具
 * */
public class ThreadMXBeanMain {

    /**
     见 http://ifeve.com/jvm-thread/ 说明java中各种线程的作用
     看官网，我不清楚怎么查找信息

     看到输出信息
     6----Monitor Ctrl-Break----RUNNABLE
     5----Attach Listener----RUNNABLE                通常我们会用一些命令去要求jvm给我们一些反 馈信息，如：java -version、jmap、jstack
     4----Signal Dispatcher----RUNNABLE              Attach Listener线程的职责是接收外部jvm命令，当命令接收成功后，会交给signal dispather线程去进行分发到各个不同的模块处理命令
     3----Finalizer----WAITING                       其优先级为10，主要用于在垃圾收集前，调用对象的finalize()方法，因为Finalizer是守护线程，所以说Object.finalize()方法不一定执行
     2----Reference Handler----WAITING               其优先级为10，它主要用于处理引用对象本身（软引用、弱引用、虚引用）的垃圾回收问题
     1----main----RUNNABLE                           这么明显的名称，肯定是主线程main

     * */
    public static void main(String[] args) {
        //Java 虚拟机线程系统的管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "----" + threadInfo.getThreadName() + "----" + threadInfo.getThreadState());
        }
    }

}
