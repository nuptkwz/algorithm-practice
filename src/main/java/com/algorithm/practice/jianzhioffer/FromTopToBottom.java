package com.algorithm.practice.jianzhioffer;

import com.algorithm.practice.jianzhioffer.innerclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description
 * Date 2020/7/15 22:12
 * Created by kwz
 */
public class FromTopToBottom {
    public static void main(String[] args) {

    }

//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        ArrayList<Integer> lists = new ArrayList<Integer>();
//        if (root == null)
//            return lists;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode tree = queue.poll();
//            if (tree.getLeft() != null)
//                queue.offer(tree.getLeft());
//            if (tree.getRight() != null)
//                queue.offer(tree.getRight());
//            lists.add(tree.getVal());
//        }
//        return lists;
//    }
}
