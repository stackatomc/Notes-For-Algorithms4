package com.stackatomc.OfferPractise;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @File: Solution34_2
 * @Description: 二叉树查找路径和
 * @Author: MayerFang
 * @Date: 2018/9/5 19:40
 * @Version: 1.0
 */
public class Solution34_2 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode head,int expectedSum){
        if(head==null)return null;
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayLists=FindPath(head,expectedSum,arrayLists,arrayList);
        if(arrayLists!=null)return arrayLists;
        return null;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode head,int expectedSum,ArrayList<ArrayList<Integer>> arrayLists,ArrayList<Integer> arrayList){
        if(head!=null){
            expectedSum=expectedSum-head.val;
            arrayList.add(head.val);
        }else{
            return arrayLists;
        }
        if(expectedSum==0&&head.left==null&&head.right==null){
            arrayLists.add(new ArrayList<Integer>(arrayList));
        }
        FindPath(head.left,expectedSum,arrayLists,arrayList);
        FindPath(head.right,expectedSum,arrayLists,arrayList);
        arrayList.remove(arrayList.size()-1);
        return arrayLists;
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
        Solution34_2 s34=new Solution34_2();
        System.out.println(s34.FindPath(t1,8));

        /*
        *      1
        *     2  3
        *   4 5 6 7
        *  8
        *
        * */
    }
}
