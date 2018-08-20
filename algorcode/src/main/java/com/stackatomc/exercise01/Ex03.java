package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex03
 * @Description
 * @date 2018/8/20
 */
public class Ex03 {

    /* 注意用equal */

    public static void main(String[] args) {
        String str1=args[0];
        String str2=args[1];
        String str3=args[2];

        if(str1.equals(str2)&&str1.equals(str3)&&str2.equals(str3))
            System.out.println("equal");
        else System.out.println("not equal");
    }
}
