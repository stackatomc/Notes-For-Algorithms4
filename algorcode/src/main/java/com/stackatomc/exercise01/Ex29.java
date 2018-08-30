package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex29
 * @Description
 * @date 2018/8/22
 */
public class Ex29 {

    /*1. 返回数组中小于key的元素个数rank() 二分法
    * 2. 返回数组中等于key的个数count() */
    public static int rank(int key,int[] a){
        int index=rank(key,a,0,a.length-1);
        return index+1;//数组求长度index加1
    }

    public static int rank(int key,int[] a,int left,int right){
        if(left>right) return right;
        int mid=(left+right)/2;
        if(key<a[mid])
        {
            //主要是返回key a left right 给下一轮进行操作
            // return回的内容扔在这里就死了，return 没有具体用
            return rank(key,a,left,mid-1);
        }else if(key>a[mid]){
            return rank(key,a,mid+1,right);
        }else return mid-1;
    }

    public static int count(int key,int[] a){
        int count=0;
        for(int i=0;i<a.length;++i){
            // count++ 和count=count+1 前者是右值，没有左值给时下一轮用count加后的结果
            if(a[i]==key) count=count+1;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arrTest={3,4,4,5,7,11,11,11};//arrTest.length=8
        System.out.println(rank(11,arrTest));
        System.out.println(count(5,arrTest));
    }
}
