package com.stackatomc.OfferPractise;

/**
 * @File: Solution27_1
 * @Description: 镜面二叉树
 * @Author: MayerFang
 * @Date: 2018/9/5 18:37
 * @Version: 1.0
 */
public class Solution27_1 {

    public void mirror(TreeNode head){
        if(head==null)return ;
        if(head.left==null&&head.right==null)return;

        TreeNode t=head.left;
        head.left=head.right;
        head.right=t;
        mirror(head.left);
        mirror(head.right);
    }
}
