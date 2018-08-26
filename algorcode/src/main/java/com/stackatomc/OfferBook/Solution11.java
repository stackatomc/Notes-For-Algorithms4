//package com.stackatomc.OfferBook;
//
///**
// * @File: Solution11
// * @Description:
// * @Author: MayerFang
// * @Date: 2018/8/26 14:20
// * @Version: 1.0
// *
// *
// *  做个记号 关于二进制的不明 原码 反码 补码 还有是移动是什么数据类型移动之类的...
// * 一、正整数的原码、反码、补码完全一样，即符号位固定为0，数值位相同
//二、负整数的符号位固定为1，由原码变为补码时，规则如下：
//1、原码符号位1不变，整数的每一位二进制数位求反，得到反码
//2、反码符号位1不变，反码数值位最低位加1，得到补码
// */
//public class Solution11 {
//
//    public int NumberOf1(int n) {
//        //
//        boolean isZero=false;
//        //StringBuilder sb=new StringBuilder();
//        byte sb=0;
//        int smaPart=0;
//        while(!isZero){
//            n=n/2;  //n=5(101) n=n/2=2...1
//            //n=7(111) n=n/2=3 3/2=1 1/2=0
//            if(smaPart==0)
//                smaPart=n%2;
//            if(n==1){
//                isZero=true;
//                //sb.append(smaPart);
//                sb<<1;
//            }else{
//                sb.append(1);
//            }
//        }
//    }
//}
