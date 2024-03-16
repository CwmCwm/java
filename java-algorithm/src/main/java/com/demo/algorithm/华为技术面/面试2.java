package com.demo.algorithm.华为技术面;

public class 面试2 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
        System.out.println(isLongPressedName("abcde", "aabbccade"));
    }


    //算法1：name从左遍历（以name为主），typed也从左遍历，双指针
    public static boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0;     //name从左遍历的下标
        int typedIndex = 0;    //typed从左遍历的下标
        char tmp = ' ';        //临时存储上一个name中的字符


        while (nameIndex < name.length() && typedIndex < typed.length()) {
            if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                tmp = name.charAt(nameIndex);
                nameIndex++;
                typedIndex++;
            }
            else if (tmp == typed.charAt(typedIndex)) {
                typedIndex++;
            }
            else {
                return false;
            }
        }

        if (nameIndex == name.length()) {
            return true;
        }

        return false;
    }

}
