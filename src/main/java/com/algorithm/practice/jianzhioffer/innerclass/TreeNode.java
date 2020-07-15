package com.algorithm.practice.jianzhioffer.innerclass;

import lombok.Data;

/**
 * Description
 * Date 2020/7/15 22:13
 * Created by kwz
 */
@Data
public class TreeNode {
    private int val = 0;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
