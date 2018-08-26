package com.stackatomc.OfferBook;

/**
 * @File: Solution8
 * @Description:
 * @Author: MayerFang
 * @Date: 2018/8/26 1:38
 * @Version: 1.0
 */
public class Solution8 {

    /*
     * 跳楼梯题目 找规律 以后应该是仿照来做
     * 斐波那契数列的变式
     *
     * （顺便提一提，如果生活习惯不好，饮食习惯糟糕，不认真品味吃进肚子的每一口，就会一如既往地毫无起色）
     *
     * */
    public int JumpFloor(int target) {

        int a1=1;
        int a2=2;
        int a3=a1+a2;

        if(target==0)return 0;
        else if(target==1) return 1;
        else if(target==2) return 2;

        //n-1和n-2指向的数组内容同时向后移动
        for(int i=3;i<=target;++i){
            a3=a2+a1;
            a1=a2;
            a2=a3;
        }

        return a3;
    }
}
