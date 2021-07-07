package com.demo.grammar;


import java.util.Arrays;

/**
 java数组的写法
 * */
public class ArrayMain {

    // new 的数组写法挺正常，容易记
//    public static void main(String[] args) {
//        int arrayLength = 3;
//        int[] ints = new int[arrayLength];
//        Integer[] integers = new Integer[arrayLength];
//        for (int i=0; i<arrayLength; i++) {
//            ints[i] = i;
//            integers[i] = i;
//        }
//        System.out.println("ints => " + Arrays.toString(ints));
//        System.out.println("integers => " + Arrays.toString(integers));
//    }


    // 这写法不经常写，有时候就会写成  int[] ints = [0, 1, 2];
    public static void main(String[] args) {
        int[] ints = {0, 1, 2};
        System.out.println("ints => " + Arrays.toString(ints));
    }

}
