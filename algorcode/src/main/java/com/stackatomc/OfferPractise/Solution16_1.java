package com.stackatomc.OfferPractise;

/**
 * @File: Solution16_1
 * @Description: 用O(logn)时间求斐波那契数列的递归公式求解n的m次方
 * @Author: MayerFang
 * @Date: 2018/9/1 23:48
 * @Version: 1.0
 */
public class Solution16_1 {

    public double PowerWithUnsignedExponent(double base,int exponent){
        //规律如下：
        // a^n={a^(2/n)*a^(2/n) 当n为偶数时
        // a^(2/n)*a^(2/n)^2 当n为奇数时
        if(base==0)return 0;
        if(exponent==0)return 1;
        if(exponent==1)return base;
        boolean isM=false;
        if(exponent<0){// 手动转换符号
            isM=true;//-3 11111101
            System.out.println(exponent);
            exponent=exponent-1;//-4 11111100
            System.out.println(exponent);
            exponent=~exponent;// 00000011
            System.out.println(exponent);
        }

        double result=1;
        if((exponent&1)==1){//判断奇数
            result=result*base;
        }
        // 用位运算代替/2的细节处理
        result=result*PowerWithUnsignedExponent(base,exponent>>1)*PowerWithUnsignedExponent(base,exponent>>1);

        if(isM){
            result=1.0/result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution16_1 s16_1= new Solution16_1();
        System.out.println(s16_1.PowerWithUnsignedExponent(2,-3));
    }
}
