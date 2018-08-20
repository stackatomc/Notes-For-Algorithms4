package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex09
 * @Description
 * @date 2018/8/20
 */
public class Ex09 {

    /* n=7 s="1"
    *  n=3 s="1"+"1"
    *  n=1 s="1"+"1"+"1" */

    /* 将一个正整数 N 用二进制表示并转换为一个 String 类型的值 s */
    public static String toBinaryStr(int x){
        String s="";
        for(int n=x;n>0;n/=2)
            s=(n%2)+s;
        return s;
    }

    public static void main(String[] args) {
        System.out.println(toBinaryStr(7));
        /* Java 有一个内置方法 Integer.toBinaryString(N) */
        System.out.println(Integer.toBinaryString(5623));
    }
}
