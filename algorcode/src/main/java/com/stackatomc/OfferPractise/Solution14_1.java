package com.stackatomc.OfferPractise;

/**
 * @File: Solution14_1
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/9/1 0:08
 * @Version: 1.0
 */
public class Solution14_1 {

    public int maxCut(int length){
        if(length<2)return 0;
        if(length==2)return 1;
        if(length==3)return 2;

        int[] lengthSt=new int[length+1];
        lengthSt[0]=0;
        lengthSt[1]=1;
        lengthSt[2]=2;
        lengthSt[3]=3;

        int max=0,le=0;
        for(int i=4;i<=length;++i){
            for(int j=1;j<=i/2;++j){
                //取中间两个较大
                le=lengthSt[j]*lengthSt[i-j];
                if(max<le)max=le;
            }
            lengthSt[i]=max;
        }
        return lengthSt[length];
    }

    public static void main(String[] args) {
        Solution14_1 s1=new Solution14_1();
        System.out.println(s1.maxCut(5));
    }
}
