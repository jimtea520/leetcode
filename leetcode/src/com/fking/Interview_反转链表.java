package com.fking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 反转链表
 *
 * 反转一个单链表。
 */
public class Interview_反转链表 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        reverseList(listNode);
    }

    /**
     * 迭代法
     * 执行用时 :
     * 0 ms
     * 内存消耗 :
     * 39.6 MB
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode prevListNode = null; //前指针节点
        ListNode curListNode = head;  //当前指针节点

        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (null != curListNode){
            ListNode nextListNode = curListNode.next; //临时节点，暂存当前节点的下一节点，用于后移
            curListNode.next = prevListNode; //将当前节点指向它前面的节点
            prevListNode =  curListNode;  //前指针后移
            curListNode = nextListNode; //当前指针后移
        }

        return prevListNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
