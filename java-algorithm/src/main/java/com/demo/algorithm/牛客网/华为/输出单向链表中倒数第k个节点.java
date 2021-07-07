package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。

 链表结点定义如下：

 输入描述:
 输入说明
 1 输入链表结点个数
 2 输入链表的值
 3 输入k的值

 输出描述:
 输出一个整数

 示例1
 输入
 8
 1 2 3 4 5 6 7 8
 4
 输出
 5

 * */
public class 输出单向链表中倒数第k个节点 {

    // 定义成static，这样方便写这个代码
    private static int size;
    private static ListNode head;

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode findKthToTail(int k) {
        // 题目没有指出，无法理解
        if (k == 0) return new ListNode(0);
        if (k < 0 || k > size) return null;
        // 将倒数变成正数
        k = size - k;
        ListNode p = head;
        while (k != 0) {
            p = p.next;
            k--;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(in.next());
            }
            int k = Integer.parseInt(in.next());

            head = new ListNode(array[0]);
            size = n;
            ListNode p = head;
            for (int i = 1; i < size; i++) {
                p.next = new ListNode(array[i]);
                p = p.next;
            }

            ListNode node = findKthToTail(k);
            if (node != null) {
                System.out.println(node.val);
            }
            else {
                System.out.println();
            }
        }
    }

}
