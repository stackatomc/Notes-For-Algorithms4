package com.stackatomc.OfferPractise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @File: Solution48_1
 * @Description: 打印Z字形二叉树（借助两个栈）
 * @Author: MayerFang
 * @Date: 2018/9/5 19:17
 * @Version: 1.0
 */
public class Solution48_1 {

    public void printZTree(TreeNode head){
        if(head==null)return;
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();


        TreeNode node=head;
        s1.push(node);
        while(!(s1.empty()&&s2.empty())){
            while(!s1.empty()){
                System.out.print(s1.peek().val);
                TreeNode t=s1.pop();
                if(t.left!=null)
                    s2.push(t.left);
                if(t.right!=null)
                    s2.push(t.right);
            }
        System.out.println();
            while(!s2.empty()){
                System.out.print(s2.peek().val);
                TreeNode t=s2.pop();
                if(t.right!=null)
                    s1.push(t.right);
                if(t.left!=null)
                    s1.push(t.left);
            }
        System.out.println();}

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t4.left=t8;
        Solution48_1 s48=new Solution48_1();
        s48.printZTree(t1);
    }
}
