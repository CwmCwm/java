package com.demo.thread;




import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 1. 先看  java.util.concurrent.locks.Lock 接口，大概理解语义，翻译一下先
 2. 再看  java.util.concurrent.locks.Condition 接口，大概理解语义

 * */
public class DiyLock implements Lock {


    @Override
    public void lock() {

    }

    // 不实现，我也不知道什么语义
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    // 不实现
    @Override
    public boolean tryLock() {
        return false;
    }

    // 不实现
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }


}
