# java-thread  
jdk版本 1.8   
面试题中常用的语法和题型   
我经常记不住的才写demo记下来，那些很容易记的语法就不用写    

  

### 示例demo编码  
示例demo就是讲述某个知识点，所以设计尽可能简单   
如说明Thread的知识点，就直接写 extend Thread 去重写run放，不会用Runnable  
直接内部静态类，这样外部类不用实例化，main方法也能实例化内部静态类      
实际工作是怎样写的，都会有模板，照写就行了   
  


### 查看顺序
1. ThreadMain, ThreadStartAndRunMain, ThreadDaemonMain, ThreadInterruptMain, ThreadSleepMain, ThreadMXBeanMain  线程的基础使用示例
2. RunnableMain, CallableMain  线程任务的使用示例，实际工作一般不会new Thread，而是new Runnable/Callable
3. ThreadJoinMain, SynchronizedMain, DeadLockThreadMain, ThreadWaitAndNotifyMain  多个线程间的竞争，协作
4. ReentrantLockMain, ReadWriteLockMain, LockAndConditionMain  
  






