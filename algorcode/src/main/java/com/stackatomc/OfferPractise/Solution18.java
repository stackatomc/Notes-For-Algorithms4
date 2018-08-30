package com.stackatomc.OfferPractise;

/**
 * @File: Solution18
 * @Description: 二叉树的镜像
 * 题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树
8
/  \
6   10
/ \  / \
5  7 9 11
镜像二叉树
8
/  \
10   6
/ \  / \
11 9 7  5
 * @Author: MayerFang
 * @Date: 2018/8/26 21:21
 * @Version: 1.0
 */

class Solution18 {

    public void Mirror(TreeNode root) {
        if(root==null)return ;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
    }
}
