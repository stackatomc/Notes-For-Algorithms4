package com.stackatomc.OfferPractise;

/**
 * @File: Solution12
 * @Description: 数值的整数次方
 *
 * 题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @Author: MayerFang
 * @Date: 2018/8/26 14:45
 * @Version: 1.0
 */
public class Solution12 {

    public double Power(double base, int exponent) {

        if(base==0||base==1||exponent==1) return base;
        if(exponent==0) return 1;


        boolean isNeg=false;
        if(exponent<0)
        {isNeg=true;
            exponent=0-exponent;
        }

        double result=base;
        for(int i=2;i<=exponent;++i){
            result=result*base;
        }

        if(isNeg){
            result=1/result;
        }

        return result;

    }

}
