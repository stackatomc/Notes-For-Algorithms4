package com.stackatomc.OfferPractise;

import sun.reflect.generics.tree.Tree;

/**
 * @File: Solution31_2
 * @Description: 树B是否为树A的子结构
 * @Author: MayerFang
 * @Date: 2018/9/5 16:43
 * @Version: 1.0
 */

class TreeNode1{
    double val;
    TreeNode1 left=null;
    TreeNode1 right=null;
    public TreeNode1(){
    }
    public TreeNode1(double val){
        this.val=val;
    }
}
public class Solution31_2 {

    public boolean HasSubtree(TreeNode1 root1,TreeNode1 root2){

        boolean result=false;
        if(root1!=null&&root2!=null){
        if(Equal(root1.val,root2.val)){
            result=compareTo(root1,root2);
        }
        if(!result){
            result=HasSubtree(root1.left,root2);
        }
        if(!result){
            result=HasSubtree(root1.right,root2);
        }}
        return result;
    }

    public boolean compareTo(TreeNode1 a,TreeNode1 b){
        if(b==null)return true;
        if(a==null)return false;
        if(!Equal(a.val,b.val))return false;
        return compareTo(a.left,b.left)&&compareTo(a.right,b.right);
    }

    // 判断小数（float或double）的方法，因为计算机表示小数存在午查，不能直接用等号判断是否相等
    public boolean Equal(double d1,double d2){
        if((d1-d2>-0.0000001)&&(d1-d2<0.0000001))
            return true;
        else return false;
    }

    //1. 无法判断root2初始传入为空判断为false的情况
    public boolean isChildTree2(TreeNode1 root1,TreeNode1 root2){
        if(root2==null)return true;
        if(root1==null)return false;
        boolean result=false;
        if(Equal(root1.val,root2.val)){
            result=(isChildTree2(root1.left,root2.left)&&(isChildTree2(root1.right,root2.right)))||
                   isChildTree2(root1.left,root2)||
                   isChildTree2(root1.right,root2);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode1 t8=new TreeNode1(8);
        TreeNode1 tt8=new TreeNode1(8);
        TreeNode1 t7=new TreeNode1(7);
        TreeNode1 t9=new TreeNode1(9);
        TreeNode1 t2=new TreeNode1(2);
        TreeNode1 t4=new TreeNode1(4);
        TreeNode1 tt7=new TreeNode1(77);
        t8.left=tt8;
        t8.right=t7;
        tt8.left=t9;
        tt8.right=t2;
        t2.left=t4;
        t2.right=tt7;

        TreeNode1 ttt8=new TreeNode1(8);
        TreeNode1 ttt9=new TreeNode1(9);
        TreeNode1 ttt2=new TreeNode1(3);
        ttt8.left=ttt9;
        ttt8.right=ttt2;

        Solution31_2 s13=new Solution31_2();
        System.out.println(s13.isChildTree2(t8,ttt8));
    }
}
