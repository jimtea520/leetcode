package com.fking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class Interview_20200501_合并两个有序链表 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(10);
        listNode2.next = new ListNode(12);
        listNode2.next.next = new ListNode(31);
        listNode2.next.next.next = new ListNode(14);
        listNode2.next.next.next.next = new ListNode(15);
        System.out.println(mergeTwoLists(listNode,listNode2));
    }

    /**
     *  递归法
     *  执行用时 :
     * 0 ms
     * 
     * 内存消耗 :
     * 39.7 MB
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

//    private  static void addToList(ListNode listNode, List<Integer> list){
//        if(null != listNode){
//            list.add(listNode.val);
//            ListNode curNode = listNode;
//            while(curNode.next != null){
//                //将所有的放在数组里
//                list.add(curNode.next.val);
//                curNode = curNode.next;
//            }
//        }
//    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

