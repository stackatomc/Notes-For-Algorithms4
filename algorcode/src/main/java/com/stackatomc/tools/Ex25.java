package com.stackatomc.tools;

/**
 * @author MayerFang
 * @file Ex25
 * @Description
 * @date 2018/8/21
 */
public class Ex25 {

    /*
    * a b c 三个数字从小到大排序
    * a>b a和b对调 a<b
    * a>c b和c对调 a<c
    * b>c b和c对调 b<c
    * */

    public static void main(String[] args) {
        int a=4,b=2,c=5,t;
        if(a>b){t=a;a=b;b=t;}
        if(a>c){t=a;a=c;c=t;}
        if(b>c){t=a;b=c;c=t;}
        System.out.println("a b c："+a+" "+b+" "+c);
    }
}
