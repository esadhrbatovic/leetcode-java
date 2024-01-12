/*
 * Copyright (c) 2000 - 2024 by Raiffeisen Software GmbH.
 * All rights reserved.
 *
 */
package com.hrbatovic.leetcode;

/**
 * @author LRCUHRE
 * @since 1.0
 */
public class MergeTwoSortedLists {
    //both accepted
    //recursive: Runtime 0 ms Beats 100.00% of users with Java, Memory 42.76 MB Beats 8.26% of users with Java
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                  "val=" + val +
                  ", next=" + next +
                  '}';
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        System.out.println("recursive: " + mergeTwoListsRecursive(list1, list2));

        list1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        System.out.println("loop: " + mergeTwoListsLoop(list1, list2));

    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoListsLoop(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) current.next = l2;
        if (l2 == null) current.next = l1;
        return fakeHead.next;
    }
}
