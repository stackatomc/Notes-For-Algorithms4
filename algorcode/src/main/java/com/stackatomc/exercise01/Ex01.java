package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex01
 * @Description
 * @date 2018/8/20
 */
public class Ex01 {

    /* a. 7
    *  b. 2000.0000002 (2*10^-6*(10^9+0.1)=2*10^3+2*10^-6*0.1)
    *  c. true (&& (逻辑与) 优先级高于||（逻辑或）) */

    public static void main(String[] args) {
        System.out.println((0+15)/2);
        System.out.println(2.0e-6*1000000000.1);
        System.out.println(true&&false||true&&true);
    }
}
