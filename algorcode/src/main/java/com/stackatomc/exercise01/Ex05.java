package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex05
 * @Description
 * @date 2018/8/20
 */
public class Ex05 {

    /* 注意没有0<=x<=1 的写法 */
    public static void isZeroToOne(double x,double y){
        if(0<=x&&x<=1&&0<=y&&y<=1){
            System.out.println("true");
        }else{
            System.out.println(false);
        }
    }

    public static void main(String[] args) {
        isZeroToOne(1,2);

    }
}
