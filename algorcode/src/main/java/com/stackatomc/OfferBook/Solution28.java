package com.stackatomc.OfferBook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @File: Solution28
 * @Description: 数组中出现次数超过一半的数字
 * 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author: MayerFang
 * @Date: 2018/8/29 19:34
 * @Version: 1.0
 */
public class Solution28 {

        public int MoreThanHalfNum_Solution(int [] array) {
            if(array.length==0)return -1;
            HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
            for(int i=0;i<array.length;++i){
                int val=array[i];
                int countval=0;
                for(int j=0;j<array.length;++j){
                    if(array[j]==val){
                        countval++;
                    }
                }
                hs.put(val,countval);
            }
            int result=-1;
            for(Map.Entry<Integer,Integer> vo:hs.entrySet()){
                if(array.length/2<vo.getValue())
                    result=vo.getKey();
            }
            return result;
        }
}
