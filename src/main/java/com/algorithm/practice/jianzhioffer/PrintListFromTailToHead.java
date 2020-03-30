package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Description
 * <p>
 * Date 2020/3/30 22:36
 * Created by kwz
 */
public class PrintListFromTailToHead {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ArrayList<Integer> handleWithStack(ListNode listNode) {
        ArrayList<Integer> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            lists.add(stack.pop());
        }
        return lists;
    }
}
