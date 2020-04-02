package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 * Date 2020/4/2 21:23
 * Created by kwz
 */
public class EntryNodeOfLoop {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     * Description
     * Param [pHead]
     * return com.algorithm.practice.jianzhioffer.EntryNodeOfLoop.ListNode
     */
    private ListNode getListNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p2 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
