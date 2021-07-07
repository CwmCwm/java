package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            String[] peopleK = string.split(" ");
            int count7 = 0;
            for (String x : peopleK) {
                count7 = Integer.parseInt(x) + count7;
            }
            int k = min7(count7);

            int[] N = sort(k, peopleK.length);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i<N.length; i++) {
                stringBuilder.append(N[i] + " ");
            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length()-1));
        }
    }


    // 喊过次数最少的k
    public static int min7(int count7) {
        int count = 0;
        for (int k=1; k<=200; k++) {
            if (String.valueOf(k).contains("7") || k%7==0) {
                count++;
            }
            if (count == count7) {
                return k;
            }
        }
        return 200;
    }

    // 喊7排序
    public static int[] sort(int k, int n) {
        int[] N = new int[n];
        for (int i=1; i<=k; i++) {
            if (String.valueOf(i).contains("7") || i%7==0) {
                int index = i%n -1;
                if (index < 0) {
                    index = n-1;
                }
                N[index] = N[index] + 1;
            }
        }
        return N;
    }


}
