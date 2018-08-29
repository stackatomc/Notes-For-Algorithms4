package com.stackatomc.OfferBook;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @File: Solution24
 * @Description: 二叉树中和为某一值的路径
 * 题目描述
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @Author: MayerFang
 * @Date: 2018/8/28 23:52
 * @Version: 1.0
 */
public class Solution24 {

    private ArrayList<ArrayList<Integer>> listAll=new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)return listAll;
        //这是一个好方法
        target=target-root.val;
        list.add(root.val);
        if(target==0&& root.left == null && root.right == null){
            //listAll.add(list);
            listAll.add(new ArrayList<Integer> (list));
        }
        if(root.left!=null)
            FindPath(root.left, target);
        if(root.right!=null)
            FindPath(root.right,target);

        list.remove(list.size()-1);
        return listAll;
    }


    public static void main(String[] args) {
        TreeNode t10=new TreeNode(10);
        TreeNode t5=new TreeNode(5);
        TreeNode t14=new TreeNode(14);
        TreeNode t4=new TreeNode(4);
        TreeNode t7=new TreeNode(7);
        TreeNode t12=new TreeNode(12);
        TreeNode t16=new TreeNode(16);
        t10.left=t5;
        t10.right=t12;
        t5.left=t4;
        t5.right=t7;
        //t14.left=t12;
        //t12.left=t16;
        Solution24 s24=new Solution24();
        ArrayList<ArrayList<Integer>> arrayLists=s24.FindPath(t10,15);
        //ArrayList<Integer> arrayList=arrayLists.get(0);

//        ArrayList<ArrayList<Integer>> arrayList2=new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> ar=new ArrayList<Integer>();
//        ar.add(1);
//        ar.add(2);
//        arrayList2.add(ar);
//
        //System.out.println(arrayLists.size());
        for(int j=0;j<arrayLists.size();++j){
            System.out.println(arrayLists.get(j));
        }

        //System.out.println(arrayLists.size());
//        for(int i=0;i<arrayLists.size();++i){
//            arrayList=arrayLists.get(i);
//            for(int j=0;j<arrayList.size();++j){
//                System.out.println(arrayList.get(j));
//            }
//        }
    }
}
