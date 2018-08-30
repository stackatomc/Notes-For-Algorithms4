package com.stackatomc.OfferPractise;
import java.util.ArrayList;
/**
 * @File: Solution22
 * @Description: 从上往下打印二叉树
 * 题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author: MayerFang
 * @Date: 2018/8/28 21:14
 * @Version: 1.0
 */

public class Solution22 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
                ArrayList<TreeNode> treeNodes=new ArrayList<TreeNode>();
                ArrayList<Integer> records=new ArrayList<Integer>();
                if(root==null) return null;
                treeNodes.add(root);
                records.add(root.val);
                System.out.println(root.val);
                return PrintFromTopToBottom(treeNodes,records);

    }

    public static ArrayList<Integer> PrintFromTopToBottom(ArrayList<TreeNode> treeNodes,ArrayList records) {
        if(treeNodes.size()==0) return records;
        ArrayList<TreeNode> temp=new ArrayList<TreeNode>();
        for(int i=0;i<treeNodes.size();++i){
            TreeNode curNode=treeNodes.get(i);
            if(curNode.left!=null){
                System.out.println(curNode.left.val);
                temp.add(curNode.left);
                records.add(curNode.left.val);
            }
            if(curNode.right!=null){
                System.out.println(curNode.right.val);
                temp.add(curNode.right);
                records.add(curNode.right.val);
            }
        }

        return PrintFromTopToBottom(temp,records);
    }

    public static void main(String[] args) {
        TreeNode t10=new TreeNode(10);
        TreeNode t6=new TreeNode(6);
        TreeNode t14=new TreeNode(14);
        TreeNode t4=new TreeNode(4);
        TreeNode t8=new TreeNode(8);
        TreeNode t12=new TreeNode(12);
        TreeNode t16=new TreeNode(16);
        t10.left=t6;
        t10.right=t14;
        t6.left=t4;
        t6.right=t8;
        t14.left=t12;
        t12.left=t16;

        ArrayList<Integer> arr=PrintFromTopToBottom(t10);

        for(int i=0;i<arr.size();++i){
            System.out.print(arr.get(i)+"   ");
        }
    }
}