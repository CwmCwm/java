package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n>7) {
                System.out.println(-1);
                continue;
            }

            int count = -1;
            long start = (long) Math.pow(10, n-1);
            long end = (long) Math.pow(10, n);
            long last = 0;

            for (long i=start; i<end; i++) {
                long sum = 0;
                long tmp = i;
                while (tmp > 0) {
                    sum = (long) (sum + Math.pow(tmp%10, n));
                    tmp = tmp / 10;
                }
                if (sum == i) {
                    last = i;
                    count++;
                    if (count == m) {
                        System.out.println(i);
                    }
                }
            }

            if (count < m) {
                System.out.println(last*m);
            }

        }
    }


}
