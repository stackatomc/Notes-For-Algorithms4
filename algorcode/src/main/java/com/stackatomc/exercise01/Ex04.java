package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex04
 * @Description
 * @date 2018/8/20
 */
public class Ex04 {

    /* a. then不知
    *  b. 没括号
    *  c. 可以
    *  d. 可以(不可以，c=0后面要有分号隔开，不同三目运算符)*/

    public static void main(String[] args) {
        //a
        int a=1,b=2,c;
        //!if(a>b)then c=0;
        //!if(a>b) c=0 else b=0;
        if(a>b) c=0 ; else b=0;
    }

}
