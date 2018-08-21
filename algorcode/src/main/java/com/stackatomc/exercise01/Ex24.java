package com.stackatomc.exercise01;

/**
 * @author MayerFang
 * @file Ex24
 * @Description
 * @date 2018/8/21
 */
public class Ex24 {

    public static void Euclid(int p,int q){
        p=p%q;
        System.out.println("p："+p+" q："+q);
        if(p==0){
            System.out.println("maxN："+q);
            return;
        }
        Euclid(q,p);
    }

    public static void main(String[] args) {
        Euclid(1111111,1234567);
    }
}
