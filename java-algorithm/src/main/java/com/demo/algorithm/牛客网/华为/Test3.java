package com.demo.algorithm.牛客网.华为;


import java.util.*;

public class Test3 {

    public static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 1);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[] nums = new int[5];
            String[] huases = new String[5];
            for (int i=0; i<5; i++) {
                String[] line = in.nextLine().split(" ");
                if (map.containsKey(line[0])) {
                    nums[i] = map.get(line[0]);
                } else {
                    nums[i] = Integer.parseInt(line[0]);
                }

                huases[i] = line[1];
            }
            Arrays.sort(nums);

            boolean shunzi = isShunzi(nums);
            boolean tonghua  = isTonghua(huases);

            if (tonghua && shunzi) {
                System.out.println(1);
                continue;
            }

            if (isSitiao(nums)) {
                System.out.println(2);
                continue;
            }

            if (isHulu(nums)) {
                System.out.println(3);
                continue;
            }

            if (tonghua) {
                System.out.println(4);
                continue;
            }

            if (shunzi) {
                System.out.println(5);
                continue;
            }

            if (isSantiao(nums)) {
                System.out.println(6);
                continue;
            }

            System.out.println(7);
        }
    }


    // 顺子
    public static boolean isShunzi(int[] nums) {
        if (nums[0] == 1) {
            if (nums[1]==2 || nums[1]==10) {
                for (int i=1; i<=3; i++) {
                    if (nums[i]+1 != nums[i+1]) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            for (int i=0; i<=3; i++) {
                if (nums[i]+1 != nums[i+1]) {
                    return false;
                }
            }
            return true;
        }
    }

    // 同花
    public static boolean isTonghua(String[] huases) {
        Set<String> set = new HashSet<>();
        for (String x : huases) {
            set.add(x);
        }
        if (set.size() == 1) {
            return true;
        }
        return false;
    }

    // 四条
    public static boolean isSitiao(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int x : nums) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for (Map.Entry<Integer, Integer> item : map1.entrySet()) {
            if (item.getValue() == 4) {
                return true;
            }
        }
        return false;
    }

    // 葫芦
    public static boolean isHulu(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int x : nums) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for (Map.Entry<Integer, Integer> item : map1.entrySet()) {
            if (item.getValue()==3 && map1.keySet().size()==2) {
                return true;
            }
        }
        return false;
    }

    // 三条
    public static boolean isSantiao(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int x : nums) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for (Map.Entry<Integer, Integer> item : map1.entrySet()) {
            if (item.getValue()==3 && map1.keySet().size()==3) {
                return true;
            }
        }
        return false;
    }

}
