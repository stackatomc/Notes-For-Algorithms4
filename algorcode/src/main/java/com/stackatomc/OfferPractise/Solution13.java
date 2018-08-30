package com.stackatomc.OfferPractise;

import java.util.ArrayList;

/**
 * @File: Solution13
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author: MayerFang
 * @Date: 2018/8/26 15:05
 * @Version: 1.0
 */
public class Solution13 {

    public class Solution {
        public void reOrderArray(int [] array) {
            if(array.length==1) return;
            // 应该用递归法
            ArrayList<Integer> leftarr=new ArrayList<Integer>();
            ArrayList<Integer> rightarr=new ArrayList<Integer>();
            for(int i=0;i<array.length;++i){
                if(array[i]%2==1){
                    leftarr.add(array[i]);
                }else{
                    rightarr.add(array[i]);
                }
            }
            for(int i=0;i<leftarr.size();++i){
                array[i]=leftarr.get(i);
            }
            for(int i=0;i<rightarr.size();++i) {
                array[leftarr.size()+i] = rightarr.get(i);
            }
        }
    }
}


