package com.demo.algorithm.牛客网.华为;

public class 面试2 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));

    }


    // 双指针
    public static boolean isLongPressedName(String name, String typed) {
        int typedIndex = 0;
        int count = 0;
        int nameIndex = 0;

        while (nameIndex < name.length() && typedIndex < typed.length() ) {
            if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                count++;
                nameIndex++;
            }
            typedIndex++;
        }

        if (count == name.length()) {
            return true;
        }

        return false;
    }




}
