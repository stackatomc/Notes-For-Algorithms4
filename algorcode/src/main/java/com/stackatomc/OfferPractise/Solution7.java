package com.stackatomc.OfferPractise;

/**
 * @File: Solution7
 * @Description: 斐波那契数列
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 * @Author: MayerFang
 * @Date: 2018/8/26 1:10
 * @Version: 1.0
 */
public class Solution7 {

    /* 递归
    * 运行时间：1668ms
    * 占用内存：9300k*/

    public int Fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /* 非递归
     * 运行时间：1668ms
     * 占用内存：9300k*/
    public int Fibonacci2(int n){
        int a0=0;
        int a1=1;
        int a2=a0+a1;

        if(n==a0)return 0;
        else if(n==a1) return 1;

        //n-1和n-2指向的数组内容同时向后移动
        for(int i=2;i<=n;++i){
            a2=a0+a1;
            a0=a1;
            a1=a2;
        }
        return a2;
    }
}