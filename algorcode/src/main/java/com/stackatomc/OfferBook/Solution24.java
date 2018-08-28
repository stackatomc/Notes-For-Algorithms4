package com.stackatomc.OfferBook;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @File: Solution24
 * @Description:
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
        if(target==0){
            listAll.add(list);
            System.out.println(target+"---"+list.size()+"---"+root.val);
            for(int i=0;i<listAll.size();++i){
                System.out.print("inner listAll=="+listAll.get(i));
            }
        }
        if(root.left!=null){
            FindPath(root.left,target);
        }
        if(root.right!=null){
            FindPath(root.right,target);
        }
        list.remove(list.size()-1);
        System.out.println(listAll.size());
        return listAll;
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
        //t10.right=t14;
        //t6.left=t4;
        //t6.right=t8;
        //t14.left=t12;
        //t12.left=t16;
        Solution24 s24=new Solution24();
        ArrayList<ArrayList<Integer>> arrayLists=s24.FindPath(t10,16);
        ArrayList<Integer> arrayList=arrayLists.get(0);

        ArrayList<ArrayList<Integer>> arrayList2=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ar=new ArrayList<Integer>();
        ar.add(1);
        ar.add(2);
        arrayList2.add(ar);

        System.out.println(arrayLists.size());
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
