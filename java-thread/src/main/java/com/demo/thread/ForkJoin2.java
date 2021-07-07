package com.demo.thread;


import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 使用 ForkJoin框架 -- 将一堆数进行累加 （最一般的方法当然是一个个加嘛，当然ForkJoin就是分而治之）

  RecursiveTask 的示例
 下面代码就是 将4000个数进行相加

 * */
public class ForkJoin2 {

    // MakeArray 就是制造个 4000个数的数组，没啥好看的
    static class MakeArray {
        //数组长度
        public static final int ARRAY_LENGTH  = 4000;

        public static int[] makeArray() {
            Random r = new Random();
            int[] result = new int[ARRAY_LENGTH];
            for (int i=0; i<ARRAY_LENGTH; i++) {
                result[i] = r.nextInt(ARRAY_LENGTH * 3);
            }
            return result;
        }
    }


    static class SumTask extends RecursiveTask<Integer> {
        // THRESHOLD 就是拆分判断，这里拆到数组下标的距离小于400 就不再拆分了
        private final static int THRESHOLD = MakeArray.ARRAY_LENGTH/10;
        private int[] src;
        private int fromIndex;
        private int toIndex;

        public SumTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if (toIndex - fromIndex < THRESHOLD) {
                // 这个 if 就是最小任务的计算代码
                System.out.println(" from index = " + fromIndex + " toIndex=" + toIndex);
                int count = 0;
                for (int i=fromIndex; i<=toIndex; i++) {
                    count = count + src[i];
                }
                return count;
            } else {
                // 这个else 就是继续拆分 和 子任务的结果汇总
                int mid = (fromIndex+toIndex)/2;
                SumTask left = new SumTask(src,fromIndex,mid);
                SumTask right = new SumTask(src,mid+1,toIndex);
                invokeAll(left, right);
                return left.join() + right.join();
            }
        }
    }


    // 下面是使用ForkJoin对4000个数进行拆分-累加-汇总
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] src = MakeArray.makeArray();
        SumTask innerFind = new SumTask(src,0,src.length-1);
        long start = System.currentTimeMillis();
        pool.invoke(innerFind);
        System.out.println("The count is "+ innerFind.join() + " spend time:" + (System.currentTimeMillis()-start) + "ms");
    }

    // 下面是一个线程对4000个数进行累加
//    public static void main(String[] args) {
//        int count = 0;
//        int[] src = MakeArray.makeArray();
//        long start = System.currentTimeMillis();
//        for(int i= 0;i<src.length;i++){
//            count = count + src[i];
//        }
//        System.out.println("The count is "+ count +" spend time:" + (System.currentTimeMillis()-start) + "ms");
//    }


    // TODO  这个示例的结果是使用一个线程对4000个数进行累加  耗时更少，很正常啊，这里计算任务太简单，数据太少。 也说明实际上，多线程效率不一定高于单线程，具体问题具体分析，选择合适的解决方案。

}
