package com.stackatomc.tools;

import static java.lang.Math.pow;

/**
 * @File: Solution14_1
 * @Description: 动态规划解决解绳子的问题和用贪心算法解决
 * @Author: MayerFang
 * @Date: 2018/9/1 0:08
 * @Version: 1.0
 */
public class Solution14_1 {

    // 用动态选择法实现，将子问题的结果保存在数组种以便后续使用
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

    public int maxCut2(int length){
        //如果使用贪心算法，优先剪取长度为3的绳子，最后但是最后剩4的时候，不能再截取3和（剩下1）而是截取2和2
        if(length<2)return 0;
        if(length==2)return 1;
        if(length==3)return 2;
        int timeOf3=length/3;

        //如果剩下是4
        if(length%3==1){
            timeOf3=timeOf3-1;
            // 用位运算实现n^m次方，思路是将n化为以2为底，乘法结合律分配律进行处理
            //return power(3,timeOf3)*2*2;
            return (int)(pow(3,timeOf3))*2*2;
        }
        return (int)(pow(3,timeOf3))*(length-timeOf3*3);
    }

    public double power(int a,int k){
        if(k==0)return 1;
        if(a==0)return 0;
        boolean aisLeft=false;
        boolean kisLeft=false;
        if(k<0){
            k=-k;
            kisLeft=true;
        };
        if(a<0){
            a=-a;
            aisLeft=true;
        };
            double res=1;
            while(k!=0){
                if((k&1)==1)//检查末尾是否为1，如果是1则表示存在一个a,就是类似二进制，该为以a的x次方为底的1次方
                {
                    res=res*a;
                    System.out.println("res:"+res);
                }
                k=k>>1;
                a=a*a;//这里就是5（101）则（101）中间0位置是由a^a为底
            }

            if(kisLeft==true){
                res=1.00/res;

            }
            if(aisLeft==true){
            res=-res;
            }
            return res;
    }

    public static void main(String[] args) {
        Solution14_1 s1=new Solution14_1();
        System.out.println(s1.maxCut2(7));
        System.out.println(s1.power(3,-4));
    }
}
