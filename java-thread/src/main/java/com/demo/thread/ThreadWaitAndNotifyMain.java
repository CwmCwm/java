package com.demo.thread;




import java.util.LinkedList;
import java.util.Queue;


/**
 前面用 synchronized关键字修饰方法 或者 synchronized(Object)加锁对象的场景是多个线程竞争相同资源，做相同的事
 比如10个线程竞争1个数据库连接，做数据库操作
 这里10个线程做相同的事是获取1一个数据库连接，
 这里用 synchronized关键字修饰方法 或者 synchronized(Object)加锁对象 不会出现死锁

 还有场景是线程间做互补的事
 比如有一个队列Queue，A线程负责扔数据到队列中，B线程负责从队列中拿出数据，虽然A和B线程是竞争这一个队列，
 但它们是互补的，这里互补的事是 A线程扔数据到队列，B线程从队列拿出数据
 这里用 synchronized关键字修饰方法 或者 synchronized(Object)加锁对象 可能出现死锁
 死锁场景：具体场景见 https://www.liaoxuefeng.com/wiki/1252599548343744/1306580911915042

 * */
public class ThreadWaitAndNotifyMain {


    // 在方法上加锁，这里加的锁是TaskQueue实例后的对象锁，下面addTask方法和getTask方法会竞争
//    private static class TaskQueue {
//        private Queue<String> queue = new LinkedList<>();
//
//        public synchronized void addTask(String s) {
//            this.queue.add(s);
//        }
//
//        public synchronized String getTask() {
//            while (this.queue.isEmpty()) {
//            }
//            return this.queue.remove();
//        }
//    }

    // 下面使用 wait和notify写法，wait方法和notify方法是Object类的方法，需要实例化对象
    // 其实wait和notify是配合使用的哦，遵循模板写就好了
    private static class TaskQueue {
        private Queue<String> queue = new LinkedList<>();

        public synchronized void addTask(String s) {
            this.queue.add(s);
            // 注意 notify和notifyAll方法写在加锁方法体的最后一行哦
            this.notifyAll();
        }

        public synchronized String getTask() throws InterruptedException {
            while (this.queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + "----1111");
                this.wait();
            }
            return this.queue.remove();
        }
    }

    private static class AThread extends Thread {
        public TaskQueue taskQueue = null;
        @Override
        public void run() {
            String s = "任务" + String.valueOf(System.currentTimeMillis());
            taskQueue.addTask(s);
            System.out.println(getName() + "----经数据 " + s + " 放入队列");
        }
    }

    private static class BThread extends Thread {
        public TaskQueue taskQueue = null;
        @Override
        public void run() {
            String s = null;
            try {
                s = taskQueue.getTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "----从队列中拿出数据 " + s);
        }
    }

    /**
     没有用 wait和notify写法，这里BThread线程先执行，结果锁住了taskQueue对象中的addTask和getTask方法，AThread后执行，就只能等待，可这一等就没有尽头

     用wait和notify写法
     这里BThread线程先执行，得到taskQueue对象锁，进入getTask方法，调用wait方法，BThread线程释放taskQueue对象锁，BThread进入关于这个taskQueue对象的等待队列
     AThread线程可以得到taskQueue对象锁，进入addTask方法，将数据放入队列，调用notifyAll方法，唤醒关于这个taskQueue对象的等待队列中的所有线程，释放taskQueue对象锁
     BThread线程得到taskQueue对象锁，从刚才wait方法处继续向下执行，这时队列有数据，跳出循环，拿到数据

     注意：这里流程说明时明确说了等待队列，你应该知道语义吧。

     当然现在不流行wait和notify写法，因为java提供了新的代替wait和notify 的写法，使用Lock和Condition
     你看 java.util.concurrent 包走的数据结构类都是使用Lock和Condition 来实现，原因肯定是更高效安全咯，
     底层的东西无非就是高效，安全，还有其他头等大事？
     * */
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        AThread aThread = new AThread();
        BThread bThread = new BThread();
        aThread.setName("aThread");
        aThread.taskQueue = taskQueue;
        bThread.setName("bThread");
        bThread.taskQueue = taskQueue;
        bThread.start();
        Thread.sleep(100);
        aThread.start();
    }


}
