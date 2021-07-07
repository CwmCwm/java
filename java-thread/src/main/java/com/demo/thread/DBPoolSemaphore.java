package com.demo.thread;


import java.sql.Connection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 这个 SemaphoreMain 类就是数据库连接池类
 提供 getConnection获取数据库连接 和 returnConnection归还数据库连接
 使用 Semaphore信号量来管理数据库连接

 * */
public class DBPoolSemaphore {

    // POOL_SIZE 该数据库连接池的大小
    private final static int POOL_SIZE = 10;
    // POOL_SIZE 是10，那么这里 useful也是10
    private final Semaphore useful = new Semaphore(10);;
    // pool 存放数据库连接的容器
    private static LinkedList<Connection> pool = new LinkedList<>();
    //初始化池
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.addLast(new SqlConnectImpl());
        }
    }

    // 构造方法
    public DBPoolSemaphore() {
    }

    // getConnection获取数据库连接
    public Connection getConnection() throws InterruptedException {
        useful.acquire();
        Connection connection;
        synchronized (pool) {
            connection = pool.removeFirst();
        }
        return connection;
    }

    // returnConnection归还数据库连接
    public void returnConnection(Connection connection) throws InterruptedException {
        if(connection!=null) {
            System.out.println("当前有"+useful.getQueueLength()+"个线程等待数据库连接!!" +"可用连接数：" + useful.availablePermits());
            synchronized (pool) {
                pool.addLast(connection);
            }
            useful.release();
        }
    }

    private static DBPoolSemaphore dbPoolSemaphore = new DBPoolSemaphore();




    private static class BusiThread extends Thread{
        @Override
        public void run() {
            Random r = new Random();//让每个线程持有连接的时间不一样
            long start = System.currentTimeMillis();
            try {
                Connection connection = dbPoolSemaphore.getConnection();
                System.out.println("Thread_"+Thread.currentThread().getId() +"_获取数据库连接共耗时【"+(System.currentTimeMillis()-start)+"】ms." + connection.toString());
                Thread.sleep(100 + r.nextInt(100));//模拟业务操作，线程持有连接查询数据
                System.out.println("查询数据完成，归还连接！");
                dbPoolSemaphore.returnConnection(connection);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread thread = new BusiThread();
            thread.start();
        }
    }





}
