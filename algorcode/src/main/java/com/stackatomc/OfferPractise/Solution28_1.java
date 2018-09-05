package com.stackatomc.OfferPractise;

/**
 * @File: Solution28_1
 * @Description: 判断是否为镜面二叉树
 * @Author: MayerFang
 * @Date: 2018/9/5 18:39
 * @Version: 1.0
 */
public class Solution28_1 {

    public boolean isMirror(TreeNode head){
        if(head==null)return true;
        if(head.left.val!=head.right.val)return false;
        return isMirror(head.left,head.right);
    }

    public boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null&&root2!=null)return false;
        if(root1!=null&&root2==null)return false;
        if(root1==null&&root2==null)return true;
        if(root1.val!=root2.val)return false;
        return isMirror(root1.left,root2.right)&&isMirror(root1.right, root2.left);
    }

    public static void main(String args[]){
        Solution28_1 s18=new Solution28_1();
        TreeNode t0=new TreeNode(0);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(1);
        TreeNode t6=new TreeNode(2);
        TreeNode t7=new TreeNode(3);
        TreeNode t8=new TreeNode(4);
        t0.left=t1;
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t0.right=t5;
        t5.left=t7;
        t5.right=t6;
        t6.right=t8;
        System.out.println(s18.isMirror(t0));
    }
}
