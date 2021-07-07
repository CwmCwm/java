package com.demo.thread;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 使用 ForkJoin框架 -- 遍历指定目录（含子目录）找寻指定类型文件

  RecursiveAction 的示例
 下面代码就是在 E:/test/  目录下，找出这个目录（含子目录）的 .txt文件
 * */
public class ForkJoin1 {

    // RecursiveAction 是ForkJoin框架中用于没有返回结果的任务
    static class FindFile extends RecursiveAction {

        // 当前路径
        private File path;

        public FindFile(File path) {
            this.path = path;
        }

        // 代码逻辑： 当前路径是目录就是创建子任务（如何拆分）， 当前路径是文件就检查文件后缀（运算结果）， 子任务的汇总（这里任务无返回，其实就是子任务交由ForkJoin统一调度）
        @Override
        protected void compute() {
            List<FindFile> subTasks = new ArrayList<>();
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // 对每个子目录都新建一个子任务。
                        subTasks.add(new FindFile(file));
                    } else {
                        // 遇到文件，检查。
                        if (file.getAbsolutePath().endsWith("txt")){
                            System.out.println("文件:" + file.getAbsolutePath());
                        }
                    }
                }
                if (!subTasks.isEmpty()) {
                    // 在当前的 ForkJoinPool 上调度所有的子任务。
                    for (FindFile subTask : invokeAll(subTasks)) {
                        subTask.join();
                    }
                }
            }
        }
    }

    public static void main(String [] args){
        try {
            // 用一个 ForkJoinPool 实例调度总任务
            ForkJoinPool pool = new ForkJoinPool();
            FindFile task = new FindFile(new File("E:/test/"));
            pool.execute(task);

            System.out.println("Task is Running......");
            Thread.sleep(1);
            int otherWork = 0;
            for (int i=0;i<100;i++) {
                otherWork = otherWork+i;
            }
            System.out.println("Main Thread done sth......,otherWork=" + otherWork);

            // task.join(); ForkJoin执行任务   task.get(); 也可以
            task.join();
            System.out.println("Task end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
