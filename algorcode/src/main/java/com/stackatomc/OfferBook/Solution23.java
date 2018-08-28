package com.stackatomc.OfferBook;

/**
 * @File: Solution23
 * @Description: 二叉树的后序遍历序列
 * 题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @Author: MayerFang
 * @Date: 2018/8/28 22:54
 * @Version: 1.0
 */
public class Solution23 {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)return false;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public static boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
        if(start-1==end)return true;
        int i=end-1;
        while(i>=start&&sequence[i]>sequence[end]){
                i--;
        }

        for(int j=i-1;j>=start;--j)
        {
            if(sequence[j]>sequence[end])
                return false;
        }
        if(VerifySquenceOfBST(sequence,i+1,end-1)==false||VerifySquenceOfBST(sequence,start,i)==false)
            return false;


        return true;
    }

    public static void main(String[] args) {
        int[] sequence={1,3,2,4,7,28,33,30,15};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}
