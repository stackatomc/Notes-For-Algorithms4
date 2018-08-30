package com.stackatomc.OfferPractise;

/**
 * @File: Solution9
 * @Description: 变态跳台阶
 *
 * 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Author: MayerFang
 * @Date: 2018/8/26 2:53
 * @Version: 1.0
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        if(target==1) return 1;
        return 2*JumpFloorII(target-1);
    }

    /* 非递归 运行时间：17ms
占用内存：9180k*/
    public int JumpFloorII2(int target) {
        if(target==1) return 1;

        int result=1;

        for(int i=2;i<=target;++i){
            result=result*2;
        }
        return result;
    }

}