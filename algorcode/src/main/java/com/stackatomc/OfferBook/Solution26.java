package com.stackatomc.OfferBook;

/**
 * @File: Solution26
 * @Description: 二叉搜索树与双向链表
 * 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Author: MayerFang
 * @Date: 2018/8/29 16:03
 * @Version: 1.0
 */
public class Solution26 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)return null;
        TreeNode old=pRootOfTree;
        while(old.left!=null){
            old=old.left;
        }
        TreeNode head=old;
        TreeNode pRootOfTreeLeft=Convert1(pRootOfTree.left);
        TreeNode pRootOfTreeRight=Convert2(pRootOfTree.right);
        //System.out.println(pRootOfTreeRight);
        pRootOfTree.right=pRootOfTreeRight;
        if(pRootOfTreeRight!=null)
            pRootOfTreeRight.left=pRootOfTree;
        pRootOfTree.left=pRootOfTreeLeft;
        if(pRootOfTreeLeft!=null)
            pRootOfTreeLeft.right=pRootOfTree;
        return head;
    }
    public TreeNode Convert1(TreeNode pRootOfTree){
        if(pRootOfTree==null)return pRootOfTree;
        Convert1(pRootOfTree.left);
        Convert1(pRootOfTree.right);
        if(pRootOfTree.left!=null)
            pRootOfTree.left.right=pRootOfTree;
        if(pRootOfTree.right!=null)
        {
            pRootOfTree.right.left=pRootOfTree;
            pRootOfTree= pRootOfTree.right;
        }
        return pRootOfTree;
    }
    public TreeNode Convert2(TreeNode pRootOfTree){
        if(pRootOfTree==null)return null;
        Convert2(pRootOfTree.right);
        Convert2(pRootOfTree.left);
        if(pRootOfTree.right!=null)
            pRootOfTree.right.left=pRootOfTree;
        if(pRootOfTree.left!=null) {
            pRootOfTree.left.right = pRootOfTree;
            pRootOfTree= pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public static void main(String[] args) {

        TreeNode t5=new TreeNode(5);
        TreeNode t4=new TreeNode(4);
        TreeNode t3=new TreeNode(3);
        TreeNode t2=new TreeNode(2);
        TreeNode t1=new TreeNode(1);
        t5.left=t4;
        t4.left=t3;
        t3.left=t2;
        t2.left=t1;
        Solution26 s26=new Solution26();
        TreeNode node1=s26.Convert(t5);
        while(node1!=null){
            System.out.print(node1.val+"    ");
            node1=node1.right;
        }
    }
}

