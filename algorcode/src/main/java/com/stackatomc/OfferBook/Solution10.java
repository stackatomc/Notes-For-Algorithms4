package com.stackatomc.OfferBook;

/**
 * @File: Solution10
 * @Description: 矩形覆盖
 * @Author: MayerFang
 * @Date: 2018/8/26 14:13
 * @Version: 1.0
 */
public class Solution10 {

    /*
    *   0 0 1
    *   0 0 2
    *   0 0 3 F(3)=F(2)+F(1)
    *   0 0
    * 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    * */
    public int RectCover(int target) {
        if(target==0) return 0;
        if(target==1) return 1;
        if(target==2) return 2;
        return RectCover(target-1)+RectCover(target-2);
    }




}
