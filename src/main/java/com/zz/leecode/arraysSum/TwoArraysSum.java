package com.zz.leecode.arraysSum;

/**
 * @author zzj
 * @className TwoArraysSum
 * @description TODO
 * @date 2020/7/22
 * <p>
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class TwoArraysSum {

    /**
     *
     *可优化 认为是长度相等的两个链表，若为空则val = 0  省去冗余代码
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l2;
        }
        ListNode tempNode = ln;
        int temp = 0;
        while (l1 != null) {
            if (l2 == null) {
                int sum = l1.val + temp;
                temp = sum / 10;
                ListNode next = new ListNode(sum % 10);
                tempNode.next = next;
                tempNode = next;
                l1 = l1.next;
            } else {
                int sum = l1.val + l2.val + temp;
                temp = sum / 10;
                ListNode next = new ListNode(sum % 10);
                tempNode.next = next;
                tempNode = next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                int sum = l2.val + temp;
                temp = sum / 10;
                ListNode next = new ListNode(sum % 10);
                tempNode.next = next;
                tempNode = next;
                l2 = l2.next;
            }
        }
        if (temp == 0) {
            return ln.next;
        }
        tempNode.next = new ListNode(temp);
        return ln.next;
    }

    public static void main(String[] args) {

        ListNode l1 = integerToNode(250);
        ListNode l2 = integerToNode(55);
        ListNode listNode = TwoArraysSum.addTwoNumbers(l1, l2);
        System.out.println(nodeToInteger(listNode));
    }

    public static ListNode integerToNode(int a) {

        boolean flag = true;
        ListNode node = new ListNode(0);
        ListNode tempNode = node;
        while (flag) {
            ListNode next = new ListNode(a % 10);
            tempNode.next = next;
            tempNode = next;
            a = a / 10;
            if (a == 0 && (a % 10) == 0) {
                flag = false;
            }
        }
        return node.next;
    }

    public static Integer nodeToInteger(ListNode node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        int step = 1;
        while (node != null) {
            sum = node.val * step + sum;
            node = node.next;
            step = step * 10;
        }

        return sum;
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
