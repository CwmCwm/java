package com.demo.grammar;


import java.util.Arrays;
import java.util.Random;

/**
java.lang.Math
 * */
public class MathMain {


    //
    public static void main(String[] args) {
        Random r = new Random();
//        while(true) {
//            int num = r.nextInt(2);
//            System.out.println(num);
//        }

        while(true) {
            System.out.println(String.valueOf(r.nextLong()).replace("-", ""));
        }
    }

}
